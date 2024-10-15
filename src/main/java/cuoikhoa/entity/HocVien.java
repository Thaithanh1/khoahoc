package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hocVienID;
    @Column(name = "hinhanh", columnDefinition = "LONGTEXT")
    private String hinhAnh;
    @Column(name = "hoten", length = 50)
    private String hoTen;
    @Column(name = "ngaysinh")
    private Date ngaySinh;
    @Column(name = "sodienthoai", length = 11)
    private String soDienThoai;
    @Column(name = "email", length = 40)
    private String email;
    @Column(name = "tinhthanh", length = 50)
    private String tinhThanh;
    @Column(name = "quanhuyen", length = 50)
    private String quanHuyen;
    @Column(name = "phuongxa", length = 50)
    private String phuongXa;
    @Column(name = "sonha", length = 50)
    private String soNha;
    @OneToMany(mappedBy = "hocVien")
    @JsonManagedReference
    private List<DangKyHoc> dangKyHocs;

    public int getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
