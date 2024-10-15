package cuoikhoa.service;

import cuoikhoa.entity.DangKyHoc;
import cuoikhoa.entity.LoaiBaiViet;
import cuoikhoa.payload.converter.LoaiBaiVietConverter;
import cuoikhoa.payload.dto.LoaiBaiVietDTO;
import cuoikhoa.payload.request.LoaiBaiVietRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.LoaiBaiVietRepository;
import cuoikhoa.service.interfaceservice.iLoaiBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class LoaiBaiVietService implements iLoaiBaiVietService {
    @Autowired
    private LoaiBaiVietRepository loaiBaiVietRepository;
    public LoaiBaiVietConverter _converter;
    public ResponseObject<LoaiBaiVietDTO> _loaiBaiVietResponseObject;
    public LoaiBaiVietService() {
        _converter = new LoaiBaiVietConverter();
        _loaiBaiVietResponseObject = new ResponseObject<LoaiBaiVietDTO>();
    }

    public ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(LoaiBaiVietRequest request) {
        LoaiBaiViet lbv = _converter.themLoaiBaiViet(request);
        loaiBaiVietRepository.save(lbv);
        return _loaiBaiVietResponseObject.responseSuccess("Them loai bai viet thanh cong", _converter.entityToLoaiBaiVietDTO(lbv));
    }

    public ResponseObject<LoaiBaiVietDTO> suaLoaiBaiViet(int loaiBaiVietID, LoaiBaiVietRequest request) {
        var checkLoaiBaiViet = loaiBaiVietRepository.findById(loaiBaiVietID);
        if (checkLoaiBaiViet.isEmpty()) {
            return _loaiBaiVietResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Loai bai viet khong ton tai", null);
        } else {
            LoaiBaiViet lbv = _converter.suaLoaiBaiViet(checkLoaiBaiViet.get(), request);
            loaiBaiVietRepository.save(lbv);
            return _loaiBaiVietResponseObject.responseSuccess("Cap nhat loai bai viet thanh cong", _converter.entityToLoaiBaiVietDTO(lbv));
        }
    }

    public ResponseObject<LoaiBaiVietDTO> xoaLoaiBaiViet(int loaiBaiVietID) {
        var checkLoaiBaiViet = loaiBaiVietRepository.findById(loaiBaiVietID);
        if (checkLoaiBaiViet.isEmpty()) {
            return _loaiBaiVietResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Loai bai viet khong ton tai", null);
        } else {
            loaiBaiVietRepository.delete(checkLoaiBaiViet.get());
            return _loaiBaiVietResponseObject.responseSuccess("Xoa loai bai viet thanh cong", null);
        }
    }

    public Page<LoaiBaiViet> layDanhSachLoaiBaiViet(Pageable pageable) {
        return loaiBaiVietRepository.findAll(pageable);
    }
}
