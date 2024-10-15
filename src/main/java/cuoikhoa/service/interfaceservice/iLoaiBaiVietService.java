package cuoikhoa.service.interfaceservice;

import cuoikhoa.payload.dto.LoaiBaiVietDTO;
import cuoikhoa.payload.request.LoaiBaiVietRequest;
import cuoikhoa.payload.response.ResponseObject;

public interface iLoaiBaiVietService {
    public ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(LoaiBaiVietRequest request);
    public ResponseObject<LoaiBaiVietDTO> suaLoaiBaiViet(int loaiBaiVietID, LoaiBaiVietRequest request);
    public ResponseObject<LoaiBaiVietDTO> xoaLoaiBaiViet(int loaiBaiVietID);
}
