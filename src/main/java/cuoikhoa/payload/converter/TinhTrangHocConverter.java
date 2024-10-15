package cuoikhoa.payload.converter;

import cuoikhoa.entity.TinhTrangHoc;
import cuoikhoa.payload.dto.TinhTrangHocDTO;
import cuoikhoa.payload.request.TinhTrangHocRequest;

public class TinhTrangHocConverter {
    public TinhTrangHocDTO entityToTinhTrangHocDTO(TinhTrangHoc tinhTrangHoc) {
        TinhTrangHocDTO dto = new TinhTrangHocDTO();
        dto.setTenTinhTrang(tinhTrangHoc.getTenTinhTrang());
        return dto;
    }

    public TinhTrangHoc themTinhTrangHoc(TinhTrangHocRequest request) {
        TinhTrangHoc tinhTrangHoc = new TinhTrangHoc();
        tinhTrangHoc.setTenTinhTrang(request.getTenTinhTrang());
        return tinhTrangHoc;
    }

    public TinhTrangHoc suaTinhTrangHoc(TinhTrangHoc tinhTrangHoc, TinhTrangHocRequest request) {
        tinhTrangHoc.setTenTinhTrang(request.getTenTinhTrang());
        return tinhTrangHoc;
    }
}
