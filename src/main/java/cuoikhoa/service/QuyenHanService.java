package cuoikhoa.service;

import cuoikhoa.entity.KhoaHoc;
import cuoikhoa.entity.QuyenHan;
import cuoikhoa.payload.converter.QuyenHanConverter;
import cuoikhoa.payload.dto.QuyenHanDTO;
import cuoikhoa.payload.request.QuyenHanRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.QuyenHanRepository;
import cuoikhoa.service.interfaceservice.iQuyenHanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class QuyenHanService implements iQuyenHanService {
    @Autowired
    private QuyenHanRepository quyenHanRepository;
    public QuyenHanConverter _converter;
    public ResponseObject<QuyenHanDTO> _quyenHanResponseObject;
    public QuyenHanService() {
        _converter = new QuyenHanConverter();
        _quyenHanResponseObject = new ResponseObject<QuyenHanDTO>();
    }

    public ResponseObject<QuyenHanDTO> themQuyenHan(QuyenHanRequest request) {
        QuyenHan qh = _converter.themQuyenHan(request);
        quyenHanRepository.save(qh);
        return _quyenHanResponseObject.responseSuccess("Them quyen han thanh cong", _converter.entityToQuyenHanDTO(qh));
    }

    public ResponseObject<QuyenHanDTO> suaQuyenHan(int quyenHanID, QuyenHanRequest request) {
        var checkQuyenHan = quyenHanRepository.findById(quyenHanID);
        if (checkQuyenHan.isEmpty()) {
            return _quyenHanResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Quyen han khong ton tai", null);
        } else {
            QuyenHan qh = _converter.suaQuyenHan(checkQuyenHan.get(), request);
            quyenHanRepository.save(qh);
            return _quyenHanResponseObject.responseSuccess("Cap nhat quyen han thanh cong", _converter.entityToQuyenHanDTO(qh));
        }
    }

    public ResponseObject<QuyenHanDTO> xoaQuyenHan(int quyenHanID) {
        var checkQuyenHan = quyenHanRepository.findById(quyenHanID);
        if (checkQuyenHan.isEmpty()) {
            return _quyenHanResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Quyen han khong ton tai", null);
        } else {
            quyenHanRepository.delete(checkQuyenHan.get());
            return _quyenHanResponseObject.responseSuccess("Xoa quyen han thanh cong", null);
        }
    }

    public Page<QuyenHan> layDanhSachQuyenHan(Pageable pageable) {
        return quyenHanRepository.findAll(pageable);
    }
}
