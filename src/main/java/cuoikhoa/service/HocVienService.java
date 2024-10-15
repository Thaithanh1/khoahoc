package cuoikhoa.service;

import cuoikhoa.entity.HocVien;
import cuoikhoa.payload.converter.HocVienConverter;
import cuoikhoa.payload.dto.HocVienDTO;
import cuoikhoa.payload.request.HocVienRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.HocVienRepository;
import cuoikhoa.service.interfaceservice.iHocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.List;

@Service
public class HocVienService implements iHocVienService {
    @Autowired
    private HocVienRepository hocVienRepository;
    public HocVienConverter _converter;
    public ResponseObject<HocVienDTO> _hocVienResponseObject;
    public HocVienService() {
        _converter = new HocVienConverter();
        _hocVienResponseObject = new ResponseObject<HocVienDTO>();
    }

    public ResponseObject<HocVienDTO> themHocVien(HocVienRequest request) {
        // Check if email or phone number already exists
        if (hocVienRepository.findByEmail(request.getEmail()).isPresent()) {
            return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Email da ton tai", null);
        }
        if (hocVienRepository.findBySoDienThoai(request.getSoDienThoai()).isPresent()) {
            return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "So dien thoai da ton tai", null);
        }
        HocVien hv = _converter.themHocVien(request);
        hocVienRepository.save(hv);
        return _hocVienResponseObject.responseSuccess("Them hoc vien thanh cong", _converter.entityToHocVienDTO(hv));
    }

    public ResponseObject<HocVienDTO> suaHocVien(int hocVienID, HocVienRequest request) {
        var checkHocVien = hocVienRepository.findById(hocVienID);
        if (checkHocVien.isEmpty()) {
            return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Hoc vien khong ton tai", null);
        } else {
            HocVien existingStudent = checkHocVien.get();
            // Kiểm tra xem email mới đã tồn tại chưa (trừ trường hợp email đã tồn tại và thuộc về học viên đang cập nhật)
            if (!existingStudent.getEmail().equals(request.getEmail()) && hocVienRepository.findByEmail(request.getEmail()).isPresent()) {
                return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Email da ton tai", null);
            }
            // Kiểm tra xem số điện thoại mới đã tồn tại chưa (trừ trường hợp số điện thoại đã tồn tại và thuộc về học viên đang cập nhật)
            if (!existingStudent.getSoDienThoai().equals(request.getSoDienThoai()) && hocVienRepository.findBySoDienThoai(request.getSoDienThoai()).isPresent()) {
                return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "So dien thoai da ton tai", null);
            }
            HocVien hv = _converter.suaHocVien(checkHocVien.get(), request);
            hocVienRepository.save(hv);
            return _hocVienResponseObject.responseSuccess("Sua hoc vien thanh cong", _converter.entityToHocVienDTO(hv));
        }
    }

    public ResponseObject<HocVienDTO> xoaHocVien(int hocVienID) {
        var checkHocVien = hocVienRepository.findById(hocVienID);
        if (checkHocVien.isEmpty()) {
            return _hocVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Hoc vien khong ton tai", null);
        } else {
            hocVienRepository.delete(checkHocVien.get());
            return _hocVienResponseObject.responseSuccess("Xoa hoc vien thanh cong", null);
        }
    }

    public Page<HocVien> layDanhSachHocVien(Pageable pageable) {
        return hocVienRepository.findAll(pageable);
    }

    public Page<HocVien> searchStudents(String name, String email, Pageable pageable) {
        return hocVienRepository.findByHoTenContainingAndEmailContaining(name, email, pageable);
    }
}
