package cuoikhoa.payload.converter;

import cuoikhoa.entity.LoaiBaiViet;
import cuoikhoa.payload.dto.LoaiBaiVietDTO;
import cuoikhoa.payload.request.LoaiBaiVietRequest;

public class LoaiBaiVietConverter {
    public LoaiBaiVietDTO entityToLoaiBaiVietDTO(LoaiBaiViet loaiBaiViet) {
        LoaiBaiVietDTO dto = new LoaiBaiVietDTO();
        dto.setTenLoai(loaiBaiViet.getTenLoai());
        return dto;
    }

    public LoaiBaiViet themLoaiBaiViet(LoaiBaiVietRequest request) {
        LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
        loaiBaiViet.setTenLoai(request.getTenLoai());
        return loaiBaiViet;
    }

    public LoaiBaiViet suaLoaiBaiViet(LoaiBaiViet loaiBaiViet, LoaiBaiVietRequest request) {
        loaiBaiViet.setTenLoai(request.getTenLoai());
        return loaiBaiViet;
    }
}
