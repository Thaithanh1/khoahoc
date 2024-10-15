package cuoikhoa.service;

import cuoikhoa.entity.KhoaHoc;
import cuoikhoa.payload.converter.KhoaHocConverter;
import cuoikhoa.payload.dto.KhoaHocDTO;
import cuoikhoa.payload.request.KhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.KhoaHocRepository;
import cuoikhoa.service.interfaceservice.iKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;

@Service
public class KhoaHocService implements iKhoaHocService {
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    public KhoaHocConverter _converter;
    public ResponseObject<KhoaHocDTO> _khoaHocResponseObject;
    public KhoaHocService() {
        _converter = new KhoaHocConverter();
        _khoaHocResponseObject = new ResponseObject<KhoaHocDTO>();
    }
    public ResponseObject<KhoaHocDTO> themKhoaHoc(KhoaHocRequest request) {
        KhoaHoc kh = _converter.themKhoaHoc(request);
        khoaHocRepository.save(kh);
        return _khoaHocResponseObject.responseSuccess("Them khoa hoc thanh cong", _converter.entityToKhoaHocDTO(kh));
    }
    public ResponseObject<KhoaHocDTO> suaKhoaHoc(int khoaHocID, KhoaHocRequest request) {
        var checkKhoaHoc = khoaHocRepository.findById(khoaHocID);
        if (checkKhoaHoc.isEmpty()) {
            return _khoaHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Khoa hoc khong ton tai", null);
        } else {
            KhoaHoc khoaHoc = _converter.suaKhoaHoc(checkKhoaHoc.get(), request);
            khoaHocRepository.save(khoaHoc);
            return _khoaHocResponseObject.responseSuccess("Cap nhat khoa hoc thanh cong", _converter.entityToKhoaHocDTO(khoaHoc));
        }
    }
    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(int khoaHocID) {
        var checkKhoaHoc = khoaHocRepository.findById(khoaHocID);
        if (checkKhoaHoc.isEmpty()) {
            return _khoaHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Khoa hoc khong ton tai", null);
        } else {
            khoaHocRepository.delete(checkKhoaHoc.get());
            return _khoaHocResponseObject.responseSuccess("Xoa khoa hoc thanh cong", null);
        }
    }
    public Page<KhoaHoc> layDanhSachKhoaHoc(Pageable pageable) {
        return khoaHocRepository.findAll(pageable);
    }
    public Page<KhoaHoc> timKiemKhoaHocTheoTen(String tenKhoaHoc, Pageable pageable) {
        return khoaHocRepository.findByTenKhoaHocContaining(tenKhoaHoc, pageable);
    }
}
