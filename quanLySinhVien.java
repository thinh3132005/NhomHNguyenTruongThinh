public class quanLySinhVien {
    private String hoTen;
    private String Lop;
    private String Khoa;
    private String soDienThoai;
    private String Gmail;
    private String maSinhVien;
    // Constructor
    public quanLySinhVien(String hoTen, String Lop, String Khoa, String soDienThoai, String Gmail, String maSinhVien) {
        this.hoTen = hoTen;
        this.Lop = Lop;
        this.Khoa = Khoa;
        this.soDienThoai = soDienThoai;
        this.Gmail = Gmail;
        this.maSinhVien = maSinhVien;
    }

    // Getters
    public String getHoTen() {
        return hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public String getKhoa() {
        return Khoa;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getGmail() {
        return Gmail;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    // Phương thức trả về thông tin sinh viên dưới dạng chuỗi
    @Override
    public String toString() {
        return "Họ tên: " + hoTen +
                ", Lớp: " + Lop +
                ", Khoa: " + Khoa +
                ", SĐT: " + soDienThoai +
                ", Gmail: " + Gmail +
                ", Mã sinh viên: " + maSinhVien;
    }

}
