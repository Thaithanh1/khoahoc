package cuoikhoa.payload.converter;

import cuoikhoa.entity.ChuDe;
import cuoikhoa.payload.dto.ChuDeDTO;
import cuoikhoa.payload.request.ChuDeRequest;

public class ChuDeConverter {
    public ChuDeDTO entityToChuDeDTO(ChuDe chuDe) {
        ChuDeDTO dto = new ChuDeDTO();
        dto.setTenChuDe(chuDe.getTenChuDe());
        dto.setNoiDung(chuDe.getNoiDung());
        dto.setLoaiBaiVietID(chuDe.getLoaiBaiVietID());
        return dto;
    }

    public ChuDe themChuDe(ChuDeRequest request) {
        ChuDe chuDe = new ChuDe();
        chuDe.setTenChuDe(request.getTenChuDe());
        chuDe.setNoiDung(request.getNoiDung());
        chuDe.setLoaiBaiVietID(request.getLoaiBaiVietID());
        return chuDe;
    }

    public ChuDe suaChuDe(ChuDe chuDe, ChuDeRequest request) {
        chuDe.setTenChuDe(request.getTenChuDe());
        chuDe.setNoiDung(request.getNoiDung());
        chuDe.setLoaiBaiVietID(request.getLoaiBaiVietID());
        return chuDe;
    }
}
