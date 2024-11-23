public class dangNhap {
    private String taiKhoan;
    private String matKhau;

    // Constructor
    public dangNhap(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    // Getters
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    // Phương thức kiểm tra đăng nhập
    public boolean kiemTradangNhap(String taiKhoanNhap, String matKhauNhap) {
        return this.taiKhoan.equals(taiKhoanNhap) && this.matKhau.equals(matKhauNhap);
    }
}
