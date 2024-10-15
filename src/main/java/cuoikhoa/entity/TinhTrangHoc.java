package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tinhtranghoc")
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int tinhTrangHocID;
    @Column(name = "tentinhtrang", length = 40)
    private String tenTinhTrang;
    @OneToMany(mappedBy = "tinhTrangHoc")
    @JsonManagedReference
    private List<DangKyHoc> dangKyHocs;

    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }

    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }

    public String getTenTinhTrang() {
        return tenTinhTrang;
    }

    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }

    public List<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
}
