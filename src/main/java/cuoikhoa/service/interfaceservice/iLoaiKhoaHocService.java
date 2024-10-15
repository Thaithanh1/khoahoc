package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.LoaiKhoaHocDTO;
import cuoikhoa.payload.request.LoaiKhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iLoaiKhoaHocService {
    public ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(LoaiKhoaHocRequest request);
    public ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(int loaiKhoaHocID, LoaiKhoaHocRequest request);
    public ResponseObject<LoaiKhoaHocDTO> xoaLoaiKhoaHoc(int loaiKhoaHocID);
}
