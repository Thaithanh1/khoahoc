package cuoikhoa.payload.converter;

import cuoikhoa.entity.BaiViet;
import cuoikhoa.payload.dto.BaiVietDTO;
import cuoikhoa.payload.request.BaiVietRequest;

import java.util.Date;

public class BaiVietConverter {
    public BaiVietDTO entityToBaiVietDTO(BaiViet baiViet) {
        BaiVietDTO dto = new BaiVietDTO();
        dto.setTenBaiViet(baiViet.getTenBaiViet());
        dto.setTenTacGia(baiViet.getTenTacGia());
        dto.setNoiDung(baiViet.getNoiDung());
        dto.setNoiDungNgan(baiViet.getNoiDungNgan());
        dto.setThoiGianTao(baiViet.getThoiGianTao());
        dto.setHinhAnh(baiViet.getHinhAnh());
        dto.setChuDeID(baiViet.getChuDeID());
        dto.setTaiKhoanID(baiViet.getTaiKhoanID());
        return dto;
    }

    public BaiViet themBaiViet(BaiVietRequest request) {
        BaiViet baiViet = new BaiViet();
        baiViet.setTenBaiViet(request.getTenBaiViet());
        baiViet.setTenTacGia(request.getTenTacGia());
        baiViet.setNoiDung(request.getNoiDung());
        baiViet.setNoiDungNgan(request.getNoiDungNgan());
        baiViet.setThoiGianTao(new Date());
        baiViet.setHinhAnh(request.getHinhAnh());
        baiViet.setChuDeID(request.getChuDeID());
        baiViet.setTaiKhoanID(request.getTaiKhoanID());
        return baiViet;
    }

    public BaiViet suaBaiViet(BaiViet baiViet, BaiVietRequest request) {
        baiViet.setTenBaiViet(request.getTenBaiViet());
        baiViet.setTenTacGia(request.getTenTacGia());
        baiViet.setNoiDung(request.getNoiDung());
        baiViet.setNoiDungNgan(request.getNoiDungNgan());
        baiViet.setThoiGianTao(request.getThoiGianTao());
        baiViet.setHinhAnh(request.getHinhAnh());
        baiViet.setChuDeID(request.getChuDeID());
        baiViet.setTaiKhoanID(request.getTaiKhoanID());
        return baiViet;
    }
}
