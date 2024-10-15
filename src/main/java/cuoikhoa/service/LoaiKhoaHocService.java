package cuoikhoa.service;

import cuoikhoa.entity.LoaiKhoaHoc;
import cuoikhoa.payload.converter.LoaiKhoaHocConverter;
import cuoikhoa.payload.dto.LoaiKhoaHocDTO;
import cuoikhoa.payload.request.LoaiKhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.LoaiKhoaHocRepository;
import cuoikhoa.service.interfaceservice.iLoaiKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class LoaiKhoaHocService implements iLoaiKhoaHocService {
    @Autowired
    private LoaiKhoaHocRepository loaiKhoaHocRepository;
    public LoaiKhoaHocConverter _converter;
    public ResponseObject<LoaiKhoaHocDTO> _loaiKhoaHocResponseObject;
    public LoaiKhoaHocService() {
        _converter = new LoaiKhoaHocConverter();
        _loaiKhoaHocResponseObject = new ResponseObject<LoaiKhoaHocDTO>();
    }

    public ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(LoaiKhoaHocRequest request) {
        LoaiKhoaHoc lkh = _converter.themLoaiKhoaHoc(request);
        loaiKhoaHocRepository.save(lkh);
        return _loaiKhoaHocResponseObject.responseSuccess("Them loai khoa hoc thanh cong", _converter.entityToLoaiKhoaHocDTO(lkh));
    }

    public ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(int loaiKhoaHocID, LoaiKhoaHocRequest request) {
        var checkLoaiKhoaHoc = loaiKhoaHocRepository.findById(loaiKhoaHocID);
        if (checkLoaiKhoaHoc.isEmpty()) {
            return _loaiKhoaHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Loai khoa hoc khong ton tai", null);
        } else {
            LoaiKhoaHoc loaiKhoaHoc = _converter.suaLoaiKhoaHoc(checkLoaiKhoaHoc.get(), request);
            loaiKhoaHocRepository.save(loaiKhoaHoc);
            return _loaiKhoaHocResponseObject.responseSuccess("Cap nhat loai khoa hoc thanh cong", _converter.entityToLoaiKhoaHocDTO(loaiKhoaHoc));
        }
    }

    public ResponseObject<LoaiKhoaHocDTO> xoaLoaiKhoaHoc(int loaiKhoaHocID) {
        var checkLoaiKhoaHoc = loaiKhoaHocRepository.findById(loaiKhoaHocID);
        if (checkLoaiKhoaHoc.isEmpty()) {
            return _loaiKhoaHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Loai khoa hoc khong ton tai", null);
        } else {
            loaiKhoaHocRepository.delete(checkLoaiKhoaHoc.get());
            return _loaiKhoaHocResponseObject.responseSuccess("Xoa loai khoa hoc thanh cong", null);
        }
    }
}
