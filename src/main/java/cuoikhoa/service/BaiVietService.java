package cuoikhoa.service;

import cuoikhoa.entity.BaiViet;
import cuoikhoa.entity.TaiKhoan;
import cuoikhoa.payload.converter.BaiVietConverter;
import cuoikhoa.payload.dto.BaiVietDTO;
import cuoikhoa.payload.request.BaiVietRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.BaiVietRepository;
import cuoikhoa.service.interfaceservice.iBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class BaiVietService implements iBaiVietService {
    @Autowired
    private BaiVietRepository baiVietRepository;
    public BaiVietConverter _converter;
    public ResponseObject<BaiVietDTO> _baiVietResponseObject;
    public BaiVietService() {
        _converter = new BaiVietConverter();
        _baiVietResponseObject = new ResponseObject<BaiVietDTO>();
    }

    public ResponseObject<BaiVietDTO> themBaiViet(BaiVietRequest request) {
        BaiViet bv = _converter.themBaiViet(request);
        baiVietRepository.save(bv);
        return _baiVietResponseObject.responseSuccess("Them moi bai viet thanh cong", _converter.entityToBaiVietDTO(bv));
    }

    public ResponseObject<BaiVietDTO> suaBaiViet(int baiVietID, BaiVietRequest request) {
        var checkBaiViet = baiVietRepository.findById(baiVietID);
        if (checkBaiViet.isEmpty()) {
            return _baiVietResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Bai viet khong ton tai", null);
        } else {
            BaiViet bv = _converter.suaBaiViet(checkBaiViet.get(), request);
            baiVietRepository.save(bv);
            return _baiVietResponseObject.responseSuccess("Cap nhat bai viet thanh cong", _converter.entityToBaiVietDTO(bv));
        }
    }

    public ResponseObject<BaiVietDTO> xoaBaiViet(int baiVietID) {
        var checkBaiViet = baiVietRepository.findById(baiVietID);
        if (checkBaiViet.isEmpty()) {
            return _baiVietResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Bai viet khong ton tai", null);
        } else {
            baiVietRepository.delete(checkBaiViet.get());
            return _baiVietResponseObject.responseSuccess("Xoa bai viet thanh cong", null);
        }
    }

    public Page<BaiViet> layDanhSachBaiViet(Pageable pageable) {
        return baiVietRepository.findAll(pageable);
    }

    public Page<BaiViet> layBaiVietTheoTen(String name, Pageable pageable) {
        return baiVietRepository.findByTenBaiViet(name, pageable);
    }
}
