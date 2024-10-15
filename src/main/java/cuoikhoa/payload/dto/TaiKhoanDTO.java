package cuoikhoa.payload.dto;

public class TaiKhoanDTO {
    private String tenNguoiDung;
    private String tenDangNhap;
    private String matKhau;
    private int quyenHanID;

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getQuyenHanID() {
        return quyenHanID;
    }

    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }
}
