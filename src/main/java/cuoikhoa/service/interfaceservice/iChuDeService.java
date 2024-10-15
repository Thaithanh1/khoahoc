package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.ChuDeDTO;
import cuoikhoa.payload.request.ChuDeRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iChuDeService {
    public ResponseObject<ChuDeDTO> themChuDe(ChuDeRequest request);
    public ResponseObject<ChuDeDTO> suaChuDe(int chuDeID, ChuDeRequest request);
    public ResponseObject<ChuDeDTO> xoaChuDe(int chuDeID);
}
