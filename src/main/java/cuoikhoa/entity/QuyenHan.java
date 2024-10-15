package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "quyenhan")
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int quyenHanID;
    @Column(name = "tenquyenhan", length = 50)
    private String tenQuyenHan;
    @OneToMany(mappedBy = "quyenHan")
    @JsonManagedReference
    private List<TaiKhoan> taiKhoans;

    public int getQuyenHanID() {
        return quyenHanID;
    }

    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }

    public String getTenQuyenHan() {
        return tenQuyenHan;
    }

    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }

    public List<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }
}
