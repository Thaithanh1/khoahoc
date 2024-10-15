package cuoikhoa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int chuDeID;
    @Column(name = "tenchude", length = 50)
    private String tenChuDe;
    @Column(name = "noidung", columnDefinition = "LONGTEXT")
    private String noiDung;
    @ManyToOne
    @JoinColumn(name = "loaibaivietid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;
    @Column(name = "loaibaivietid")
    private int loaiBaiVietID;
    @OneToMany(mappedBy = "chuDe")
    @JsonManagedReference
    private List<BaiViet> baiViets;

    public int getChuDeID() {
        return chuDeID;
    }

    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }

    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }

    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }

    public List<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(List<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }
}
