package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.KhoaHocDTO;
import cuoikhoa.payload.request.KhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iKhoaHocService {
    public ResponseObject<KhoaHocDTO> themKhoaHoc(KhoaHocRequest request);
    public ResponseObject<KhoaHocDTO> suaKhoaHoc(int khoaHocID, KhoaHocRequest request);
    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(int khoaHocID);
}
