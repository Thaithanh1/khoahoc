package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int baiVietID;
    @Column(name = "tenbaiviet", length = 50)
    private String tenBaiViet;
    @Column(name = "tentacgia", length = 50)
    private String tenTacGia;
    @Column(name = "noidung", columnDefinition = "LONGTEXT")
    private String noiDung;
    @Column(name = "noidungngan", length = 1000)
    private String noiDungNgan;
    @Column(name = "thoigiantao")
    private Date thoiGianTao;
    @Column(name = "hinhanh", columnDefinition = "LONGTEXT")
    private String hinhAnh;
    @ManyToOne
    @JoinColumn(name = "chudeid", insertable = false, updatable = false)
    @JsonBackReference
    private ChuDe chuDe;
    @Column(name = "chudeid")
    private int chuDeID;
    @ManyToOne
    @JoinColumn(name = "taikhoanid", insertable = false, updatable = false)
    @JsonBackReference
    private TaiKhoan taiKhoan;
    @Column(name = "taikhoanid")
    private int taiKhoanID;

    public int getBaiVietID() {
        return baiVietID;
    }

    public void setBaiVietID(int baiVietID) {
        this.baiVietID = baiVietID;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungNgan() {
        return noiDungNgan;
    }

    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ChuDe getChuDe() {
        return chuDe;
    }

    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }

    public int getChuDeID() {
        return chuDeID;
    }

    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
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
