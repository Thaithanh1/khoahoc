package cuoikhoa.service;

import cuoikhoa.entity.TaiKhoan;
import cuoikhoa.payload.converter.TaiKhoanConverter;
import cuoikhoa.payload.dto.TaiKhoanDTO;
import cuoikhoa.payload.request.TaiKhoanRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.TaiKhoanRepository;
import cuoikhoa.service.interfaceservice.iTaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;

@Service
public class TaiKhoanService implements iTaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    public TaiKhoanConverter _converter;
    public ResponseObject<TaiKhoanDTO> _taiKhoanResponseObject;
    public TaiKhoanService() {
        _converter = new TaiKhoanConverter();
        _taiKhoanResponseObject = new ResponseObject<TaiKhoanDTO>();
    }

    public ResponseObject<TaiKhoanDTO> themTaiKhoan(TaiKhoanRequest request) {
        TaiKhoan tk = _converter.themTaiKhoan(request);
        taiKhoanRepository.save(tk);
        return _taiKhoanResponseObject.responseSuccess("Them tai khoan thanh cong", _converter.entityToTaiKhoanDTO(tk));
    }

    public ResponseObject<TaiKhoanDTO> suaTaiKhoan(int taiKhoanID, TaiKhoanRequest request) {
        var checkTaiKhoan = taiKhoanRepository.findById(taiKhoanID);
        if (checkTaiKhoan.isEmpty()) {
            return _taiKhoanResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Tai khoan khong ton tai", null);
        } else {
            TaiKhoan tk = _converter.suaTaiKhoan(checkTaiKhoan.get(), request);
            taiKhoanRepository.save(tk);
            return _taiKhoanResponseObject.responseSuccess("Cap nhat tai khoan thanh cong", _converter.entityToTaiKhoanDTO(tk));
        }
    }

    public ResponseObject<TaiKhoanDTO> xoaTaiKhoan(int taiKhoanID) {
        var checkTaiKhoan = taiKhoanRepository.findById(taiKhoanID);
        if (checkTaiKhoan.isEmpty()) {
            return _taiKhoanResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Tai khoan khong ton tai", null);
        } else {
            taiKhoanRepository.delete(checkTaiKhoan.get());
            return _taiKhoanResponseObject.responseSuccess("xoa tai khoan thanh cong", null);
        }
    }

    public Page<TaiKhoan> layDanhSachTaiKhoan(Pageable pageable) {
        return taiKhoanRepository.findAll(pageable);
    }
    public Page<TaiKhoan> layTaiKhoanTheoTen(String username, Pageable pageable) {
        return taiKhoanRepository.findByTenDangNhap(username, pageable);
    }
}
