package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dangkyhoc")
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int dangKyHocID;
    @Column(name = "ngaydangky")
    private Date ngayDangKy;
    @Column(name = "ngaybatdau")
    private Date ngayBatDau;
    @Column(name = "ngayketthuc")
    private Date ngayKetThuc;
    @ManyToOne
    @JoinColumn(name = "khoahocid", insertable = false, updatable = false)
    @JsonBackReference
    private KhoaHoc khoaHoc;
    @Column(name = "khoahocid")
    private int khoaHocID;
    @ManyToOne
    @JoinColumn(name = "hocvienid", insertable = false, updatable = false)
    @JsonBackReference
    private HocVien hocVien;
    @Column(name = "hocvienid")
    private int hocVienID;
    @ManyToOne
    @JoinColumn(name = "tinhtranghocid", insertable = false, updatable = false)
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;
    @Column(name = "tinhtranghocid")
    private int tinhTrangHocID;
    @ManyToOne
    @JoinColumn(name = "taikhoanid", insertable = false, updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;
    @Column(name = "taikhoanid")
    private int taiKhoanID;

    public int getDangKyHocID() {
        return dangKyHocID;
    }

    public void setDangKyHocID(int dangKyHocID) {
        this.dangKyHocID = dangKyHocID;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public int getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public int getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }

    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }
}
