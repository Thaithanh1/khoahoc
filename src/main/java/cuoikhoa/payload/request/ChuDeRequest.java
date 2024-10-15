package cuoikhoa.payload.request;

public class ChuDeRequest {
    private String tenChuDe;
    private String noiDung;
    private int loaiBaiVietID;

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

    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }

    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }
}
