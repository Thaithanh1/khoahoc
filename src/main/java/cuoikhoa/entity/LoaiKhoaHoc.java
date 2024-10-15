package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loaikhoahoc")
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int loaiKhoaHocID;
    @Column(name = "tenloai", length = 50)
    private String tenLoai;
    @OneToMany(mappedBy = "loaiKhoaHoc")
    @JsonManagedReference
    private List<KhoaHoc> khoaHocs;

    public int getLoaiKhoaHocID() {
        return loaiKhoaHocID;
    }

    public void setLoaiKhoaHocID(int loaiKhoaHocID) {
        this.loaiKhoaHocID = loaiKhoaHocID;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<KhoaHoc> getKhoaHocs() {
        return khoaHocs;
    }

    public void setKhoaHocs(List<KhoaHoc> khoaHocs) {
        this.khoaHocs = khoaHocs;
    }
}
