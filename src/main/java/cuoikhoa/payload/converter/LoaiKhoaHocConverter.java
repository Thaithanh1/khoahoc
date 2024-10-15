package cuoikhoa.payload.converter;

import cuoikhoa.entity.LoaiKhoaHoc;
import cuoikhoa.payload.dto.LoaiKhoaHocDTO;
import cuoikhoa.payload.request.LoaiKhoaHocRequest;

public class LoaiKhoaHocConverter {
    public LoaiKhoaHocDTO entityToLoaiKhoaHocDTO(LoaiKhoaHoc loaiKhoaHoc) {
        LoaiKhoaHocDTO dto = new LoaiKhoaHocDTO();
        dto.setTenLoai(loaiKhoaHoc.getTenLoai());
        return dto;
    }

    public LoaiKhoaHoc themLoaiKhoaHoc(LoaiKhoaHocRequest request) {
        LoaiKhoaHoc loaiKhoaHoc = new LoaiKhoaHoc();
        loaiKhoaHoc.setTenLoai(request.getTenLoai());
        return loaiKhoaHoc;
    }

    public LoaiKhoaHoc suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc, LoaiKhoaHocRequest request) {
        loaiKhoaHoc.setTenLoai(request.getTenLoai());
        return loaiKhoaHoc;
    }
}
