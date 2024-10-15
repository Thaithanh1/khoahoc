package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.QuyenHanDTO;
import cuoikhoa.payload.request.QuyenHanRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iQuyenHanService {
    public ResponseObject<QuyenHanDTO> themQuyenHan(QuyenHanRequest request);
    public ResponseObject<QuyenHanDTO> suaQuyenHan(int quyenHanID, QuyenHanRequest request);
    public ResponseObject<QuyenHanDTO> xoaQuyenHan(int quyenHanID);
}
