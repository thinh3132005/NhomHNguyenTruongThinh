import java.util.List;
import java.util.Scanner;
public class quanLyKhoa {
    private String maKhoa;
    private String tenKhoa;

    // Constructor
    public quanLyKhoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public static void luuDanhSachKhoaVaoFile(String file) {
    }

    public static void themKhoa(Scanner scanner) {
    }

    // Getters and Setters
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    static void hienThiDanhSachKhoa() {
    }
    // Method to display Khoa information
    public void hienThiThongTinKhoa() {
        System.out.println("Mã Khoa: " + maKhoa);
        System.out.println("Tên Khoa: " + tenKhoa);
    }
    public static void themKhoa(List<quanLyKhoa> danhSachKhoa, quanLyKhoa khoa) {
        danhSachKhoa.add(khoa);
    }
}