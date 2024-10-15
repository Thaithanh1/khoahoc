package cuoikhoa.payload.converter;

import cuoikhoa.entity.KhoaHoc;
import cuoikhoa.payload.dto.KhoaHocDTO;
import cuoikhoa.payload.request.KhoaHocRequest;

public class KhoaHocConverter {
    public KhoaHocDTO entityToKhoaHocDTO(KhoaHoc khoaHoc) {
        KhoaHocDTO dto = new KhoaHocDTO();
        dto.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
        dto.setThoiGianHoc(khoaHoc.getThoiGianHoc());
        dto.setGioiThieu(khoaHoc.getGioiThieu());
        dto.setNoiDung(khoaHoc.getNoiDung());
        dto.setHocPhi(khoaHoc.getHocPhi());
        dto.setSoHocVien(khoaHoc.getSoHocVien());
        dto.setSoLuongMon(khoaHoc.getSoLuongMon());
        dto.setHinhAnh(khoaHoc.getHinhAnh());
        dto.setLoaiKhoaHocID(khoaHoc.getLoaiKhoaHocID());
        return dto;
    }

    public KhoaHoc themKhoaHoc(KhoaHocRequest request) {
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setTenKhoaHoc(request.getTenKhoaHoc());
        khoaHoc.setThoiGianHoc(request.getThoiGianHoc());
        khoaHoc.setGioiThieu(request.getGioiThieu());
        khoaHoc.setNoiDung(request.getNoiDung());
        khoaHoc.setHocPhi(request.getHocPhi());
        khoaHoc.setSoHocVien(request.getSoHocVien());
        khoaHoc.setSoLuongMon(request.getSoLuongMon());
        khoaHoc.setHinhAnh(request.getHinhAnh());
        khoaHoc.setLoaiKhoaHocID(request.getLoaiKhoaHocID());
        return khoaHoc;
    }

    public KhoaHoc suaKhoaHoc(KhoaHoc khoaHoc, KhoaHocRequest request) {
        khoaHoc.setTenKhoaHoc(request.getTenKhoaHoc());
        khoaHoc.setThoiGianHoc(request.getThoiGianHoc());
        khoaHoc.setGioiThieu(request.getGioiThieu());
        khoaHoc.setNoiDung(request.getNoiDung());
        khoaHoc.setHocPhi(request.getHocPhi());
        khoaHoc.setSoHocVien(request.getSoHocVien());
        khoaHoc.setSoLuongMon(request.getSoLuongMon());
        khoaHoc.setHinhAnh(request.getHinhAnh());
        khoaHoc.setLoaiKhoaHocID(request.getLoaiKhoaHocID());
        return khoaHoc;
    }
}
