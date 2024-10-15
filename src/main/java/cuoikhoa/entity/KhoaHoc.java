package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int khoaHocID;
    @Column(name = "tenkhoahoc", length = 50)
    private String tenKhoaHoc;
    @Column(name = "thoigianhoc")
    private int thoiGianHoc;
    @Column(name = "gioithieu", columnDefinition = "LONGTEXT")
    private String gioiThieu;
    @Column(name = "noidung", columnDefinition = "LONGTEXT")
    private String noiDung;
    @Column(name = "hocphi")
    private float hocPhi;
    @Column(name = "sohocvien")
    private int soHocVien;
    @Column(name = "soluongmon")
    private int soLuongMon;
    @Column(name = "hinhanh", columnDefinition = "LONGTEXT")
    private String hinhAnh;
    @ManyToOne
    @JoinColumn(name = "loaikhoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiKhoaHoc loaiKhoaHoc;
    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocID;
    @OneToMany(mappedBy = "khoaHoc")
    @JsonManagedReference
    private List<DangKyHoc> dangKyHocs;

    public int getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public int getThoiGianHoc() {
        return thoiGianHoc;
    }

    public void setThoiGianHoc(int thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getSoHocVien() {
        return soHocVien;
    }

    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }

    public int getSoLuongMon() {
        return soLuongMon;
    }

    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public LoaiKhoaHoc getLoaiKhoaHoc() {
        return loaiKhoaHoc;
    }

    public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        this.loaiKhoaHoc = loaiKhoaHoc;
    }

    public int getLoaiKhoaHocID() {
        return loaiKhoaHocID;
    }

    public void setLoaiKhoaHocID(int loaiKhoaHocID) {
        this.loaiKhoaHocID = loaiKhoaHocID;
    }

    public List<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
