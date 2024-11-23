import java.util.Scanner;

public class quanLyGiangVien {
    private String tenGiangVien;
    private String soDienThoai;
    private String email;

    // Constructor
    public quanLyGiangVien(String tenGiangVien, String soDienThoai, String email) {
        this.tenGiangVien = tenGiangVien;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    // Getter và Setter
    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Giảng viên: " + tenGiangVien +
                "\nSố điện thoại: " + soDienThoai +
                "\nEmail: " + email;
    }

}
