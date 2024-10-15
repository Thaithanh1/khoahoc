package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.HocVienDTO;
import cuoikhoa.payload.request.HocVienRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iHocVienService {
    public ResponseObject<HocVienDTO> themHocVien(HocVienRequest request);
    public ResponseObject<HocVienDTO> suaHocVien(int hocVienID, HocVienRequest request);
    public ResponseObject<HocVienDTO> xoaHocVien(int hocVienID);
}
