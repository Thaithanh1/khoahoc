package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.TaiKhoanDTO;
import cuoikhoa.payload.request.TaiKhoanRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iTaiKhoanService {
    public ResponseObject<TaiKhoanDTO> themTaiKhoan(TaiKhoanRequest request);

    public ResponseObject<TaiKhoanDTO> suaTaiKhoan(int taiKhoanID, TaiKhoanRequest request);

    public ResponseObject<TaiKhoanDTO> xoaTaiKhoan(int taiKhoanID);

}