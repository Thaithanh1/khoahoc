package cuoikhoa.service;

import cuoikhoa.entity.TinhTrangHoc;
import cuoikhoa.payload.converter.TinhTrangHocConverter;
import cuoikhoa.payload.dto.TinhTrangHocDTO;
import cuoikhoa.payload.request.TinhTrangHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.TinhTrangHocRepository;
import cuoikhoa.service.interfaceservice.iTinhTrangHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class TinhTrangHocService implements iTinhTrangHocService {
    @Autowired
    private TinhTrangHocRepository tinhTrangHocRepository;
    public TinhTrangHocConverter _converter;
    public ResponseObject<TinhTrangHocDTO> _tinhTrangHocResponseObject;
    public TinhTrangHocService() {
        _converter = new TinhTrangHocConverter();
        _tinhTrangHocResponseObject = new ResponseObject<TinhTrangHocDTO>();
    }

    public ResponseObject<TinhTrangHocDTO> themTinhTrangHoc(TinhTrangHocRequest request) {
        TinhTrangHoc tth = _converter.themTinhTrangHoc(request);
        tinhTrangHocRepository.save(tth);
        return _tinhTrangHocResponseObject.responseSuccess("Them tinh trang hoc thanh cong", _converter.entityToTinhTrangHocDTO(tth));
    }

    public ResponseObject<TinhTrangHocDTO> suaTinhTrangHoc(int tinhTrangHocID, TinhTrangHocRequest request) {
        var checkTinhTrangHoc = tinhTrangHocRepository.findById(tinhTrangHocID);
        if (checkTinhTrangHoc.isEmpty()) {
            return _tinhTrangHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Tinh trang hoc khong ton tai", null);
        } else {
            TinhTrangHoc tth = _converter.suaTinhTrangHoc(checkTinhTrangHoc.get(), request);
            tinhTrangHocRepository.save(tth);
            return _tinhTrangHocResponseObject.responseSuccess("Sua tinh trang hoc thanh cong", _converter.entityToTinhTrangHocDTO(tth));
        }
    }

    public ResponseObject<TinhTrangHocDTO> xoaTinhTrangHoc(int tinhTrangHocID) {
        var checkTinhTrangHoc = tinhTrangHocRepository.findById(tinhTrangHocID);
        if (checkTinhTrangHoc.isEmpty()) {
            return _tinhTrangHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Tinh trang hoc khong ton tai", null);
        } else {
            tinhTrangHocRepository.delete(checkTinhTrangHoc.get());
            return _tinhTrangHocResponseObject.responseSuccess("Xoa tinh trang hoc thanh cong", null);
        }
    }
}
