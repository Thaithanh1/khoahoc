package cuoikhoa.payload.converter;

import cuoikhoa.entity.TaiKhoan;
import cuoikhoa.payload.dto.TaiKhoanDTO;
import cuoikhoa.payload.request.TaiKhoanRequest;

public class TaiKhoanConverter {
    public TaiKhoanDTO entityToTaiKhoanDTO(TaiKhoan taiKhoan) {
        TaiKhoanDTO dto = new TaiKhoanDTO();
        dto.setTenNguoiDung(taiKhoan.getTenNguoiDung());
        dto.setTenDangNhap(taiKhoan.getTenDangNhap());
        dto.setMatKhau(taiKhoan.getMatKhau());
        dto.setQuyenHanID(taiKhoan.getQuyenHanID());
        return dto;
    }

    public TaiKhoan themTaiKhoan(TaiKhoanRequest request) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenNguoiDung(request.getTenNguoiDung());
        taiKhoan.setTenDangNhap(request.getTenDangNhap());
        taiKhoan.setMatKhau(request.getMatKhau());
        taiKhoan.setQuyenHanID(request.getQuyenHanID());
        return taiKhoan;
    }

    public TaiKhoan suaTaiKhoan(TaiKhoan taiKhoan, TaiKhoanRequest request) {
        taiKhoan.setTenNguoiDung(request.getTenNguoiDung());
        taiKhoan.setTenDangNhap(request.getTenDangNhap());
        taiKhoan.setMatKhau(request.getMatKhau());
        taiKhoan.setQuyenHanID(request.getQuyenHanID());
        return taiKhoan;
    }
}
