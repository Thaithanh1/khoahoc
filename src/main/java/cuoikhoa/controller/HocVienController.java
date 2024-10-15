package cuoikhoa.controller;

import cuoikhoa.entity.HocVien;
import cuoikhoa.payload.dto.HocVienDTO;
import cuoikhoa.payload.request.HocVienRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.HocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HocVienController {
    @Autowired
    private HocVienService hocVienService;

    @RequestMapping(value = "themhocvien", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> themHocVien(@RequestBody HocVienRequest request) {
        return hocVienService.themHocVien(request);
    }
    @RequestMapping(value = "suahocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> suaHocVien(@RequestParam int hocVienID, @RequestBody HocVienRequest request) {
        return hocVienService.suaHocVien(hocVienID, request);
    }
    @RequestMapping(value = "xoahocvien", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocVienDTO> xoaHocVien(@RequestParam int hocVienID) {
        return hocVienService.xoaHocVien(hocVienID);
    }
    @RequestMapping(value = "laydanhsachhocvien", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachHocVien(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(hocVienService.layDanhSachHocVien(pageable));
    }
    @RequestMapping(value = "laydanhsachhocvientheo-ten-email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchStudents(@RequestParam String name, @RequestParam String email, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(hocVienService.searchStudents(name, email, pageable));
    }
}
