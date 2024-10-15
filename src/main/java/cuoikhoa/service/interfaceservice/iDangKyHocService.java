package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.DangKyHocDTO;
import cuoikhoa.payload.request.DangKyHocRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iDangKyHocService {
    public ResponseObject<DangKyHocDTO> themDangKyHoc(DangKyHocRequest request);
    public ResponseObject<DangKyHocDTO> suaDangKyHoc(int dangKyHocID, DangKyHocRequest request);
    public ResponseObject<DangKyHocDTO> xoaDangKyHoc(int dangKyHocID);
}
