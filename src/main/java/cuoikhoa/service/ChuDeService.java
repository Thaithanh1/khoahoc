package cuoikhoa.service;

import cuoikhoa.entity.ChuDe;
import cuoikhoa.entity.DangKyHoc;
import cuoikhoa.payload.converter.ChuDeConverter;
import cuoikhoa.payload.dto.ChuDeDTO;
import cuoikhoa.payload.request.ChuDeRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.ChuDeRepository;
import cuoikhoa.service.interfaceservice.iChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class ChuDeService implements iChuDeService {
    @Autowired
    private ChuDeRepository chuDeRepository;
    public ChuDeConverter _converter;
    public ResponseObject<ChuDeDTO> _chuDeResponseObject;
    public ChuDeService() {
        _converter = new ChuDeConverter();
        _chuDeResponseObject = new ResponseObject<ChuDeDTO>();
    }

    public ResponseObject<ChuDeDTO> themChuDe(ChuDeRequest request) {
        ChuDe cd = _converter.themChuDe(request);
        chuDeRepository.save(cd);
        return _chuDeResponseObject.responseSuccess("Them chu de thanh cong", _converter.entityToChuDeDTO(cd));
    }

    public ResponseObject<ChuDeDTO> suaChuDe(int chuDeID, ChuDeRequest request) {
        var checkChuDe = chuDeRepository.findById(chuDeID);
        if (checkChuDe.isEmpty()) {
            return _chuDeResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Chu de khong ton tai", null);
        } else {
            ChuDe cd = _converter.suaChuDe(checkChuDe.get(), request);
            chuDeRepository.save(cd);
            return _chuDeResponseObject.responseSuccess("Cap nhat chu de thanh cong", _converter.entityToChuDeDTO(cd));
        }
    }

    public ResponseObject<ChuDeDTO> xoaChuDe(int chuDeID) {
        var checkChuDe = chuDeRepository.findById(chuDeID);
        if (checkChuDe.isEmpty()) {
            return _chuDeResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Chu de khong ton tai", null);
        } else {
            chuDeRepository.delete(checkChuDe.get());
            return _chuDeResponseObject.responseSuccess("Xoa chu de thanh cong", null);
        }
    }

    public Page<ChuDe> layDanhSachChuDe(Pageable pageable) {
        return chuDeRepository.findAll(pageable);
    }
}
