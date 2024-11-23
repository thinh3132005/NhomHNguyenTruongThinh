import java.util.ArrayList;
import java.util.List;

public class quanLyLopHoc {
    private String lichHoc;
    private String khoa;
    private String maLop;
    private String tenLop;
    private List<lichHoc> danhSachLichHoc;

    public quanLyLopHoc(String lichHoc, String khoa, String maLop, String tenLop) {
        this.lichHoc = lichHoc;
        this.khoa = khoa;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.danhSachLichHoc = new ArrayList<>();
    }

    public void themLichHoc(lichHoc lich) {
        danhSachLichHoc.add(lich);
    }

    public List<lichHoc> getLichHoc() {
        return danhSachLichHoc;
    }

    public static void xoaLopHoc(List<quanLyLopHoc> danhSachLopHoc, String maLop) {
        boolean daXoa = false;

        for (int i = 0; i < danhSachLopHoc.size(); i++) {
            if (danhSachLopHoc.get(i).getMaLop().equals(maLop)) {
                danhSachLopHoc.remove(i);
                System.out.println("Đã xóa lớp học có mã: " + maLop);
                daXoa = true;
                break;
            }
        }

        if (!daXoa) {
            System.out.println("Không tìm thấy lớp học có mã: " + maLop);
        }
    }

    public String getMaLop() {
        return maLop;
    }

    @Override
    public String toString() {
        return "Lớp học: " + tenLop + ", Lịch học: " + lichHoc + ", Khoa: " + khoa + ", Mã lớp: " + maLop;
    }

    public void setLichHoc(String s) {
    }

    public void setKhoa(String s) {

    }

    public void setTenLop(String s) {
    }
}

class lichHoc {
    private String ngay;
    private String buoiHoc;

    public lichHoc(String ngay, String buoiHoc) {
        this.ngay = ngay;
        this.buoiHoc = buoiHoc;
    }

    @Override
    public String toString() {
        return "Ngày: " + ngay + ", Buổi học: " + buoiHoc;
    }
}