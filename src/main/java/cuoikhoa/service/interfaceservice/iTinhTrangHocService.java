package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.TinhTrangHocDTO;
import cuoikhoa.payload.request.TinhTrangHocRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iTinhTrangHocService {
    public ResponseObject<TinhTrangHocDTO> themTinhTrangHoc(TinhTrangHocRequest request);
    public ResponseObject<TinhTrangHocDTO> suaTinhTrangHoc(int tinhTrangHocID, TinhTrangHocRequest request);
    public ResponseObject<TinhTrangHocDTO> xoaTinhTrangHoc(int tinhTrangHocID);
}
