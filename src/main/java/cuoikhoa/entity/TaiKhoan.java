package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int taiKhoanID;
    @Column(name = "tennguoidung", length = 50)
    private String tenNguoiDung;
    @Column(name = "tendangnhap", length = 50)
    private String tenDangNhap;
    @Column(name = "matkhau", length = 50)
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "quyenhanid", insertable = false, updatable = false)
    @JsonBackReference
    private QuyenHan quyenHan;
    @Column(name = "quyenhanid")
    private int quyenHanID;
    @OneToMany(mappedBy = "taiKhoan")
    @JsonManagedReference
    private List<BaiViet> baiViets;
    @OneToMany(mappedBy = "taiKhoan")
    @JsonManagedReference
    private List<DangKyHoc> dangKyHocs;

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }

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

    public QuyenHan getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }

    public int getQuyenHanID() {
        return quyenHanID;
    }

    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }

    public List<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(List<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }

    public List<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
