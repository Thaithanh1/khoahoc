package cuoikhoa.payload.converter;

import cuoikhoa.entity.DangKyHoc;
import cuoikhoa.payload.dto.DangKyHocDTO;
import cuoikhoa.payload.request.DangKyHocRequest;

public class DangKyHocConverter {
    public DangKyHocDTO entityToDangKyHocDTO(DangKyHoc dangKyHoc) {
        DangKyHocDTO dto = new DangKyHocDTO();
        dto.setNgayDangKy(dangKyHoc.getNgayDangKy());
        dto.setNgayBatDau(dangKyHoc.getNgayBatDau());
        dto.setNgayKetThuc(dangKyHoc.getNgayKetThuc());
        dto.setKhoaHocID(dangKyHoc.getKhoaHocID());
        dto.setHocVienID(dangKyHoc.getHocVienID());
        dto.setTinhTrangHocID(dangKyHoc.getTinhTrangHocID());
        dto.setTaiKhoanID(dangKyHoc.getTaiKhoanID());
        return dto;
    }

    public DangKyHoc themDangKyHoc(DangKyHocRequest request) {
        DangKyHoc dangKyHoc = new DangKyHoc();
        dangKyHoc.setNgayDangKy(request.getNgayDangKy());
        dangKyHoc.setNgayBatDau(request.getNgayBatDau());
        dangKyHoc.setNgayKetThuc(request.getNgayKetThuc());
        dangKyHoc.setKhoaHocID(request.getKhoaHocID());
        dangKyHoc.setHocVienID(request.getHocVienID());
        dangKyHoc.setTinhTrangHocID(request.getTinhTrangHocID());
        dangKyHoc.setTaiKhoanID(request.getTaiKhoanID());
        return dangKyHoc;
    }

    public DangKyHoc suaDangKyHoc(DangKyHoc dangKyHoc, DangKyHocRequest request) {
        dangKyHoc.setNgayDangKy(request.getNgayDangKy());
        dangKyHoc.setNgayBatDau(request.getNgayBatDau());
        dangKyHoc.setNgayKetThuc(request.getNgayKetThuc());
        dangKyHoc.setKhoaHocID(request.getKhoaHocID());
        dangKyHoc.setHocVienID(request.getHocVienID());
        dangKyHoc.setTinhTrangHocID(request.getTinhTrangHocID());
        dangKyHoc.setTaiKhoanID(request.getTaiKhoanID());
        return dangKyHoc;
    }
}
