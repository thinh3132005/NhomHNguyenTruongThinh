import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    private static int i;
    private static quanLyKhoa[] danhSachKhoa;
    private static List<quanLyKhoa> danhSachKhoa1;

    public static void main(String[] args) {
        List<dangNhap> danhSachNguoiDung = new ArrayList<>();
        danhSachNguoiDung.add(new dangNhap("admin", "1"));
        danhSachNguoiDung.add(new dangNhap("thinh", "1"));
        danhSachNguoiDung.add(new dangNhap("giang", "1"));
        danhSachNguoiDung.add(new dangNhap("huy", "1"));

        Scanner scanner = new Scanner(System.in);
        boolean dangNhapThanhCong = false;

        while (!dangNhapThanhCong) {
            System.out.print("Nhập tài khoản: ");
            String taiKhoanNhap = scanner.nextLine();

            System.out.print("Nhập mật khẩu: ");
            String matKhauNhap = scanner.nextLine();

            for (dangNhap nguoiDung : danhSachNguoiDung) {
                if (nguoiDung.kiemTradangNhap(taiKhoanNhap, matKhauNhap)) {
                    dangNhapThanhCong = true;
                    System.out.println("Đăng nhập thành công!");
                    hienThiMenu(scanner, nguoiDung.getTaiKhoan());
                    break;
                }
            }

            if (!dangNhapThanhCong) {
                System.out.println("Sai tài khoản hoặc mật khẩu! Vui lòng thử lại.");
            }
        }

        scanner.close();
    }


    public static void quanLySinhVienMenu(Scanner scanner, List<quanLySinhVien> danhSachSinhVien) {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Lớp: ");
            String lop = scanner.nextLine();

            System.out.print("Khoa: ");
            String khoa = scanner.nextLine();

            System.out.print("Số điện thoại: ");
            String soDienThoai = scanner.nextLine();

            System.out.print("Gmail: ");
            String gmail = scanner.nextLine();

            System.out.print("Mã sinh viên: ");
            String maSinhVien = scanner.nextLine();

            danhSachSinhVien.add(new quanLySinhVien(hoTen, lop, khoa, soDienThoai, gmail, maSinhVien));
        }

        ghiDanhSachSinhVienVaoFile(danhSachSinhVien, "E:\\BTL HDT\\data\\danhsachsinhvien.txt");
        System.out.println("Cập nhật danh sách sinh viên thành công!");
    }

    public static void ghiDanhSachSinhVienVaoFile(List<quanLySinhVien> danhSach, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (quanLySinhVien sinhVien : danhSach) {
                writer.write(sinhVien.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
    public static void quanLyLopHocMenu(Scanner scanner, List<quanLyLopHoc> danhSachLopHoc) {
        int luaChonLopHoc;

        do {
            System.out.println("1. Thêm lớp học");
            System.out.println("2. Sửa lớp học");
            System.out.println("3. Xóa lớp học");
            System.out.println("4. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChonLopHoc = scanner.nextInt();
            scanner.nextLine();

            switch (luaChonLopHoc) {
                case 1:
                    themLopHoc(scanner, danhSachLopHoc);
                    break;
                case 2:
                    chinhSuaLopHoc(scanner, danhSachLopHoc);
                    break;
                case 3:
                    xoaLopHoc(scanner, danhSachLopHoc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChonLopHoc != 4);
    }

    public static void themLopHoc(Scanner scanner, List<quanLyLopHoc> danhSachLopHoc) {
        System.out.print("Nhập số lượng lớp học cần thêm: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhập thông tin lớp học thứ " + (i + 1) + ":");

            System.out.print("Lịch học: ");
            String lichHoc = scanner.nextLine();

            System.out.print("Khoa: ");
            String khoa = scanner.nextLine();

            System.out.print("Mã lớp: ");
            String maLop = scanner.nextLine();

            System.out.print("Tên lớp: ");
            String tenLop = scanner.nextLine();

            quanLyLopHoc lopHoc = new quanLyLopHoc(lichHoc, khoa, maLop, tenLop);
            danhSachLopHoc.add(lopHoc);

            System.out.print("Nhập số lượng lịch học: ");
            int soLuonglichHoc = scanner.nextInt();
            scanner.nextLine();  
            for (int j = 0; j < soLuonglichHoc; j++) {
                System.out.println("\nNhập thông tin lịch học thứ " + (j + 1) + ":");

                System.out.print("Ngày: ");
                String ngay = scanner.nextLine();

                System.out.print("Buổi học: ");
                String buoiHoc = scanner.nextLine();

                lopHoc.themLichHoc(new lichHoc(ngay, buoiHoc));
            }
        }

        ghiDanhSachLopHocVaoFile(danhSachLopHoc, "E:\\BTL HDT\\data\\quanlylophoc.txt");
        System.out.println("Cập nhật danh sách lớp học thành công!");
    }

    public static void xoaLopHoc(Scanner scanner, List<quanLyLopHoc> danhSachLopHoc) {
        System.out.print("Nhập mã lớp học cần xóa: ");
        String maLopHoc = scanner.nextLine();

        for (int i = 0; i < danhSachLopHoc.size(); i++) {
            if (danhSachLopHoc.get(i).getMaLop().equals(maLopHoc)) {
                danhSachLopHoc.remove(i);
                System.out.println("Xóa lớp học thành công!");
                ghiDanhSachLopHocVaoFile(danhSachLopHoc, "E:\\BTL HDT\\data\\quanlylophoc.txt");
                return;
            }
        }

        System.out.println("Mã lớp học không tồn tại!");
    }

    public static void chinhSuaLopHoc(Scanner scanner, List<quanLyLopHoc> danhSachLopHoc) {
        System.out.print("Nhập mã lớp học cần chỉnh sửa: ");
        String maLopHoc = scanner.nextLine();

        for (quanLyLopHoc lopHoc : danhSachLopHoc) {
            if (lopHoc.getMaLop().equals(maLopHoc)) {
                System.out.println("Lớp học tìm thấy: " + lopHoc);
                System.out.println("Chọn thông tin muốn sửa:");
                System.out.println("1. Lịch học");
                System.out.println("2. Khoa");
                System.out.println("3. Tên lớp");
                System.out.print("Nhập lựa chọn của bạn: ");
                int luaChon = scanner.nextInt();
                scanner.nextLine();  

                switch (luaChon) {
                    case 1:
                        System.out.print("Nhập lịch học mới: ");
                        lopHoc.setLichHoc(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập khoa mới: ");
                        lopHoc.setKhoa(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập tên lớp mới: ");
                        lopHoc.setTenLop(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        return;
                }

                ghiDanhSachLopHocVaoFile(danhSachLopHoc, "E:\\BTL HDT\\data\\quanlylophoc.txt");
                System.out.println("Cập nhật thông tin lớp học thành công!");
                return;
            }
        }

        System.out.println("Mã lớp học không tồn tại!");
    }

    public static void ghiDanhSachLopHocVaoFile(List<quanLyLopHoc> danhSach, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (quanLyLopHoc lopHoc : danhSach) {
                writer.write(lopHoc.toString() + "\n");

                for (lichHoc lich : lopHoc.getLichHoc()) {
                    writer.write("\t" + lich.toString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
public static void quanLyDiemDanhMenu(Scanner scanner, List<quanLyDiemDanh> danhSachDiemDanh) {
    int luaChon;
    do {
        System.out.println("\n=== QUẢN LÝ ĐIỂM DANH ===");
        System.out.println("1. Thêm điểm danh");
        System.out.println("2. Hiển thị danh sách điểm danh");
        System.out.println("3. Sửa điểm danh");
        System.out.println("4. Xóa điểm danh");
        System.out.println("5. Lưu danh sách vào file");
        System.out.println("0. Quay lại menu chính");
        System.out.print("Nhập lựa chọn của bạn: ");
        luaChon = scanner.nextInt();
        scanner.nextLine(); 

        switch (luaChon) {
            case 1:
                themDiemDanh(scanner, danhSachDiemDanh);
                break;
            case 2:
                hienThiDanhSachDiemDanh(danhSachDiemDanh);
                break;
            case 3:
                suaDiemDanh(scanner, danhSachDiemDanh);
                break;
            case 4:
                xoaDiemDanh(scanner, danhSachDiemDanh);
                break;
            case 5:
                luuDiemDanhVaoFile(danhSachDiemDanh, "E:\\BTL HDT\\data\\diemdanh.txt");
                break;
            case 0:
                System.out.println("Quay lại menu chính.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    } while (luaChon != 0);
}

    public static void themDiemDanh(Scanner scanner, List<quanLyDiemDanh> danhSachDiemDanh) {
        System.out.print("Nhập mã sinh viên: ");
        String maSinhVien = scanner.nextLine();

        System.out.print("Nhập họ tên sinh viên: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập trạng thái điểm danh (Có mặt/Vắng mặt/Muộn): ");
        String trangThai = scanner.nextLine();

        quanLyDiemDanh diemDanh = new quanLyDiemDanh(maSinhVien, hoTen, trangThai);
        danhSachDiemDanh.add(diemDanh);
        System.out.println("Thêm điểm danh thành công!");
    }

    public static void hienThiDanhSachDiemDanh(List<quanLyDiemDanh> danhSachDiemDanh) {
        System.out.println("\n=== DANH SÁCH ĐIỂM DANH ===");
        if (danhSachDiemDanh.isEmpty()) {
            System.out.println("Danh sách điểm danh trống.");
        } else {
            for (quanLyDiemDanh diemDanh : danhSachDiemDanh) {
                System.out.println(diemDanh);
            }
        }
    }

    public static void suaDiemDanh(Scanner scanner, List<quanLyDiemDanh> danhSachDiemDanh) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String maSinhVien = scanner.nextLine();

        for (quanLyDiemDanh diemDanh : danhSachDiemDanh) {
            if (diemDanh.getMaSinhVien().equals(maSinhVien)) {
                System.out.print("Nhập trạng thái mới (Có mặt/Vắng mặt/Muộn): ");
                String trangThaiMoi = scanner.nextLine();
                diemDanh.setTrangThaiDiemDanh(trangThaiMoi);
                System.out.println("Cập nhật trạng thái điểm danh thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã: " + maSinhVien);
    }

    public static void xoaDiemDanh(Scanner scanner, List<quanLyDiemDanh> danhSachDiemDanh) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String maSinhVien = scanner.nextLine();

        for (int i = 0; i < danhSachDiemDanh.size(); i++) {
            if (danhSachDiemDanh.get(i).getMaSinhVien().equals(maSinhVien)) {
                danhSachDiemDanh.remove(i);
                System.out.println("Xóa điểm danh thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với mã: " + maSinhVien);
    }

    public static void luuDiemDanhVaoFile(List<quanLyDiemDanh> danhSach, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (quanLyDiemDanh diemDanh : danhSach) {
                writer.write(diemDanh.toString() + "\n");
            }
            System.out.println("Lưu danh sách điểm danh vào tệp thành công!");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi tệp: " + e.getMessage());
        }
    }
    public static void quanLyKhoaMenu(Scanner scanner, List<quanLyKhoa> danhSachKhoa) {
        danhSachKhoa1 = danhSachKhoa;
        int luaChon;
        do {
            System.out.println("\n=== QUẢN LÝ KHOA ===");
            System.out.println("1. Thêm khoa");
            System.out.println("2. Hiển thị danh sách khoa");
            System.out.println("3. Lưu danh sách khoa vào file diemdanh.txt");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            switch (luaChon) {
                case 1:
                    themKhoa(scanner);
                    break;
                case 2:
                    hienThiDanhSachKhoa();
                    break;
                case 3:
                    luuDanhSachKhoaVaoFile("diemdanh.txt");
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        } while (luaChon != 0);
    }
    public static void themKhoa(Scanner scanner) {
        System.out.print("Nhập mã khoa: ");
        String maKhoa = scanner.nextLine();

        System.out.print("Nhập tên khoa: ");
        String tenKhoa = scanner.nextLine();

        quanLyKhoa khoa = new quanLyKhoa(maKhoa, tenKhoa);
        List<quanLyKhoa> danhSachKhoa = new ArrayList<>();
        quanLyKhoa.themKhoa(danhSachKhoa, khoa);

        System.out.println("Thêm khoa thành công!");
    }

    public static void hienThiDanhSachKhoa() {
        quanLyKhoa[] danhSachKhoa = new quanLyKhoa[0];
        if (danhSachKhoa()) {
            System.out.println("Danh sách khoa trống!");
        } else {
            System.out.println("\nDanh sách các khoa:");
            for (quanLyKhoa khoa : danhSachKhoa) {
                khoa.hienThiThongTinKhoa();
                System.out.println("----------------------");
            }
        }
    }

    private static boolean danhSachKhoa() {
        return false;
    }

    public static void luuDanhSachKhoaVaoFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (quanLyKhoa khoa : danhSachKhoa) {
                writer.write("Mã Khoa: " + khoa.getMaKhoa() + "\n");
                writer.write("Tên Khoa: " + khoa.getTenKhoa() + "\n");
                writer.write("----------------------\n");
            }
            System.out.println("Ghi danh sách khoa vào file thành công!");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
    public static void quanLyGiangVienMenu(Scanner scanner, List<quanLyGiangVien> danhSachGiangVien) {
        int luaChon;
        do {
            System.out.println("\n=== QUẢN LÝ GIẢNG VIÊN ===");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Hiển thị danh sách giảng viên");
            System.out.println("3. Sửa thông tin giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    themGiangVien(scanner, danhSachGiangVien);
                    break;
                case 2:
                    hienThiDanhSachGiangVien(danhSachGiangVien);
                    break;
                case 3:
                    suaGiangVien(scanner, danhSachGiangVien);
                    break;
                case 4:
                    xoaGiangVien(scanner, danhSachGiangVien);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 0);
    }

    public static void themGiangVien(Scanner scanner, List<quanLyGiangVien> danhSachGiangVien) {
        System.out.print("Nhập tên giảng viên: ");
        String tenGiangVien = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        quanLyGiangVien giangVien = new quanLyGiangVien(tenGiangVien, soDienThoai, email);
        danhSachGiangVien.add(giangVien);
        System.out.println("Thêm giảng viên thành công!");
        luuDanhSachGiangVienVaoFile(danhSachGiangVien, "E:\\BTL HDT\\data\\quanlygiangvien.txt");
    }

    public static void hienThiDanhSachGiangVien(List<quanLyGiangVien> danhSachGiangVien) {
        System.out.println("\n=== DANH SÁCH GIẢNG VIÊN ===");
        if (danhSachGiangVien.isEmpty()) {
            System.out.println("Danh sách giảng viên trống.");
        } else {
            for (quanLyGiangVien giangVien : danhSachGiangVien) {
                System.out.println(giangVien);
                System.out.println("-------------------------");
            }
        }
    }

    public static void suaGiangVien(Scanner scanner, List<quanLyGiangVien> danhSachGiangVien) {
        System.out.print("Nhập tên giảng viên cần sửa: ");
        String tenGiangVien = scanner.nextLine();

        for (quanLyGiangVien giangVien : danhSachGiangVien) {
            if (giangVien.getTenGiangVien().equalsIgnoreCase(tenGiangVien)) {
                System.out.print("Nhập tên mới: ");
                String tenMoi = scanner.nextLine();
                giangVien.setTenGiangVien(tenMoi);

                System.out.print("Nhập số điện thoại mới: ");
                String soDienThoaiMoi = scanner.nextLine();
                giangVien.setSoDienThoai(soDienThoaiMoi);

                System.out.print("Nhập email mới: ");
                String emailMoi = scanner.nextLine();
                giangVien.setEmail(emailMoi);

                System.out.println("Sửa thông tin giảng viên thành công!");
                luuDanhSachGiangVienVaoFile(danhSachGiangVien, "E:\\BTL HDT\\quanlygiangvien.txt");
                return;
            }
        }

        System.out.println("Không tìm thấy giảng viên với tên: " + tenGiangVien);
    }

    public static void xoaGiangVien(Scanner scanner, List<quanLyGiangVien> danhSachGiangVien) {
        System.out.print("Nhập tên giảng viên cần xóa: ");
        String tenGiangVien = scanner.nextLine();

        for (int i = 0; i < danhSachGiangVien.size(); i++) {
            if (danhSachGiangVien.get(i).getTenGiangVien().equalsIgnoreCase(tenGiangVien)) {
                danhSachGiangVien.remove(i);
                System.out.println("Xóa giảng viên thành công!");
                luuDanhSachGiangVienVaoFile(danhSachGiangVien, "E:\\BTL HDT\\quanlygiangvien.txt");
                return;
            }
        }

        System.out.println("Không tìm thấy giảng viên với tên: " + tenGiangVien);
    }

    public static void luuDanhSachGiangVienVaoFile(List<quanLyGiangVien> danhSachGiangVien, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (quanLyGiangVien giangVien : danhSachGiangVien) {
                writer.write(giangVien.toString() + "\n");
            }
            System.out.println("Lưu danh sách giảng viên vào tệp thành công!");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi tệp: " + e.getMessage());
        }
    }


    public static void hienThiDanhSach(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            System.out.println("Danh sách sinh viên:");
            System.out.println("----------------------------");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + filePath);
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
    }
    public static void hienThiMenu(Scanner scanner, String taiKhoan) {
        int luaChon;

        do {
            System.out.println("\n=== QUẢN LÝ ĐIỂM DANH SINH VIÊN ===");
            System.out.println("Xin chào, " + taiKhoan + "!");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý lớp học ");
            System.out.println("3. Quản lý điểm danh ");
            System.out.println("4. Quản lý khoa ");
            System.out.println("5. Quản lý giảng viên ");
            System.out.println("6. Hiển thị danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    quanLySinhVienMenu(scanner, new ArrayList<>());
                    break;
                case 2:
                    quanLyLopHocMenu(scanner, new ArrayList<>());
                    break;
                case 3:
                    quanLyDiemDanhMenu(scanner, new ArrayList<>());
                    break;
                case 4:
                    quanLyKhoaMenu(scanner, new ArrayList<>());
                case 5:
                    quanLyGiangVienMenu(scanner, new ArrayList<>());
                case 6:
                    hienThiDanhSach("E:\\BTL HDT\\data\\danhsachsinhvien.txt");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 6);
    }

}