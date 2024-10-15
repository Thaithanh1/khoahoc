package cuoikhoa.payload.converter;

import cuoikhoa.entity.HocVien;
import cuoikhoa.payload.dto.HocVienDTO;
import cuoikhoa.payload.request.HocVienRequest;

public class HocVienConverter {
    public HocVienDTO entityToHocVienDTO(HocVien hocVien) {
        HocVienDTO dto = new HocVienDTO();
        dto.setHinhAnh(hocVien.getHinhAnh());
        dto.setHoTen(hocVien.getHoTen());
        dto.setNgaySinh(hocVien.getNgaySinh());
        dto.setSoDienThoai(hocVien.getSoDienThoai());
        dto.setEmail(hocVien.getEmail());
        dto.setTinhThanh(hocVien.getTinhThanh());
        dto.setQuanHuyen(hocVien.getQuanHuyen());
        dto.setPhuongXa(hocVien.getPhuongXa());
        dto.setSoNha(hocVien.getSoNha());
        return dto;
    }

    public HocVien themHocVien(HocVienRequest request) {
        HocVien hocVien = new HocVien();
        hocVien.setHinhAnh(request.getHinhAnh());
        hocVien.setHoTen(request.getHoTen());
        hocVien.setNgaySinh(request.getNgaySinh());
        hocVien.setSoDienThoai(request.getSoDienThoai());
        hocVien.setEmail(request.getEmail());
        hocVien.setTinhThanh(request.getTinhThanh());
        hocVien.setQuanHuyen(request.getQuanHuyen());
        hocVien.setPhuongXa(request.getPhuongXa());
        hocVien.setSoNha(request.getSoNha());
        return hocVien;
    }

    public HocVien suaHocVien(HocVien hocVien, HocVienRequest request) {
        hocVien.setHinhAnh(request.getHinhAnh());
        hocVien.setHoTen(request.getHoTen());
        hocVien.setNgaySinh(request.getNgaySinh());
        hocVien.setSoDienThoai(request.getSoDienThoai());
        hocVien.setEmail(request.getEmail());
        hocVien.setTinhThanh(request.getTinhThanh());
        hocVien.setQuanHuyen(request.getQuanHuyen());
        hocVien.setPhuongXa(request.getPhuongXa());
        hocVien.setSoNha(request.getSoNha());
        return hocVien;
    }
}
