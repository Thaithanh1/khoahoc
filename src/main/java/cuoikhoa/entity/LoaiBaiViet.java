package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loaibaiviet")
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int loaiBaiVietID;
    @Column(name = "tenloai", length = 50)
    private String tenLoai;
    @OneToMany(mappedBy = "loaiBaiViet")
    @JsonManagedReference
    private List<ChuDe> chuDes;

    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }

    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<ChuDe> getChuDes() {
        return chuDes;
    }

    public void setChuDes(List<ChuDe> chuDes) {
        this.chuDes = chuDes;
    }
}
