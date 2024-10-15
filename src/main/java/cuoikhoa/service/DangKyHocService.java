package cuoikhoa.service;

import cuoikhoa.entity.DangKyHoc;
import cuoikhoa.entity.KhoaHoc;
import cuoikhoa.payload.converter.DangKyHocConverter;
import cuoikhoa.payload.dto.DangKyHocDTO;
import cuoikhoa.payload.request.DangKyHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.repository.DangKyHocRepository;
import cuoikhoa.repository.KhoaHocRepository;
import cuoikhoa.service.interfaceservice.iDangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class DangKyHocService implements iDangKyHocService {
    @Autowired
    private DangKyHocRepository dangKyHocRepository;
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    public DangKyHocConverter _converter;
    public ResponseObject<DangKyHocDTO> _dangKyHocResponseObject;
    public DangKyHocService() {
        _converter = new DangKyHocConverter();
        _dangKyHocResponseObject = new ResponseObject<DangKyHocDTO>();
    }

//    long studentCount = dangKyHocRepository.countByKhoaHocIDAndTinhTrangHocIDIn(khoaHocID,2, 3, 4);
    public ResponseObject<DangKyHocDTO> themDangKyHoc(DangKyHocRequest request) {
//        DangKyHoc dkh = _converter.themDangKyHoc(request);
//        dangKyHocRepository.save(dkh);
        DangKyHoc dangKyHocNew = new DangKyHoc();
        dangKyHocNew.setNgayDangKy(request.getNgayDangKy());
        dangKyHocNew.setNgayBatDau(request.getNgayBatDau());
        dangKyHocNew.setNgayKetThuc(request.getNgayKetThuc());
        dangKyHocNew.setKhoaHocID(request.getKhoaHocID());
        dangKyHocNew.setHocVienID(request.getHocVienID());
        dangKyHocNew.setTinhTrangHocID(request.getTinhTrangHocID());
        dangKyHocNew.setTaiKhoanID(request.getTaiKhoanID());
        dangKyHocNew = dangKyHocRepository.save(dangKyHocNew);

        int studentCount = dangKyHocRepository.countByKhoaHocIDAndTinhTrangHocIDIn(request.getKhoaHocID(), Arrays.asList(2, 3, 4));
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID()).orElse(null);
        khoaHoc.setSoHocVien(studentCount);
        khoaHocRepository.save(khoaHoc);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(request.getNgayBatDau());
        calendar.add(Calendar.DATE, (khoaHoc.getThoiGianHoc() / 24));
        // Set ngày kết thúc
        dangKyHocNew.setNgayKetThuc(calendar.getTime());
        dangKyHocRepository.save(dangKyHocNew);

        return _dangKyHocResponseObject.responseSuccess("Them dang ky hoc thanh cong", _converter.entityToDangKyHocDTO(dangKyHocNew));
    }

    public ResponseObject<DangKyHocDTO> suaDangKyHoc(int dangKyHocID, DangKyHocRequest request) {
        var checkDangKyHoc = dangKyHocRepository.findById(dangKyHocID);
        if (checkDangKyHoc.isEmpty()) {
            return _dangKyHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Dang ky hoc khong ton tai", null);
        } else {
            int idKhoaHocCu = checkDangKyHoc.get().getKhoaHocID();
            DangKyHoc dkh = _converter.suaDangKyHoc(checkDangKyHoc.get(), request);
            dangKyHocRepository.save(dkh);

            int studentCount2 = dangKyHocRepository.countByKhoaHocIDAndTinhTrangHocIDIn(idKhoaHocCu, Arrays.asList(2, 3, 4));
            KhoaHoc khoaHoc2 = khoaHocRepository.findById(idKhoaHocCu).orElse(null);
            khoaHoc2.setSoHocVien(studentCount2);
            khoaHocRepository.save(khoaHoc2);

            int studentCount = dangKyHocRepository.countByKhoaHocIDAndTinhTrangHocIDIn(request.getKhoaHocID(), Arrays.asList(2, 3, 4));
            KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID()).orElse(null);
            khoaHoc.setSoHocVien(studentCount);
            khoaHocRepository.save(khoaHoc);

            return _dangKyHocResponseObject.responseSuccess("Sua Dang Ky Hoc Thanh Cong", _converter.entityToDangKyHocDTO(dkh));
        }
    }

    public ResponseObject<DangKyHocDTO> xoaDangKyHoc(int dangKyHocID) {
        var checkDangKyHoc = dangKyHocRepository.findById(dangKyHocID);
        if (checkDangKyHoc.isEmpty()) {
            return _dangKyHocResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Dang ky hoc khong ton tai", null);
        } else {
            int idKhoaHocCu = checkDangKyHoc.get().getKhoaHocID();
            dangKyHocRepository.delete(checkDangKyHoc.get());

            int studentCount = dangKyHocRepository.countByKhoaHocIDAndTinhTrangHocIDIn(idKhoaHocCu, Arrays.asList(2, 3, 4));
            KhoaHoc khoaHoc = khoaHocRepository.findById(idKhoaHocCu).orElse(null);
            khoaHoc.setSoHocVien(studentCount);
            khoaHocRepository.save(khoaHoc);
            return _dangKyHocResponseObject.responseSuccess("Xoa dang ky hoc thanh cong", null);
        }
    }

    public Page<DangKyHoc> layDanhSachDangKyHoc(Pageable pageable) {
        return dangKyHocRepository.findAll(pageable);
    }
}
