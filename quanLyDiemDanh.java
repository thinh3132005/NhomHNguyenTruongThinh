import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quanLyDiemDanh {
    private String maSinhVien;
    private String hoTen;
    private String trangThaiDiemDanh; // Có mặt, Vắng mặt, Muộn,...

    // Constructor
    public quanLyDiemDanh(String maSinhVien, String hoTen, String trangThaiDiemDanh) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.trangThaiDiemDanh = trangThaiDiemDanh;
    }

    // Getter và Setter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTrangThaiDiemDanh() {
        return trangThaiDiemDanh;
    }

    public void setTrangThaiDiemDanh(String trangThaiDiemDanh) {
        this.trangThaiDiemDanh = trangThaiDiemDanh;
    }

    // Phương thức toString để hiển thị thông tin
    @Override
    public String toString() {
        return "Mã SV: " + maSinhVien + ", Họ Tên: " + hoTen + ", Trạng Thái: " + trangThaiDiemDanh;
    }
}
