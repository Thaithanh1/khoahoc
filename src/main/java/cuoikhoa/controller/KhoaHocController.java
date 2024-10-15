package cuoikhoa.controller;

import cuoikhoa.entity.KhoaHoc;
import cuoikhoa.payload.dto.KhoaHocDTO;
import cuoikhoa.payload.request.KhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaHocController {
    @Autowired
    private KhoaHocService khoaHocService;
    @RequestMapping(value = "themkhoahoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> themKhoaHoc(@RequestBody KhoaHocRequest request) {
        return khoaHocService.themKhoaHoc(request);
    }
    @RequestMapping(value = "suakhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> suaKhoaHoc(@RequestParam int khoaHocID, @RequestBody KhoaHocRequest request) {
        return khoaHocService.suaKhoaHoc(khoaHocID, request);
    }
    @RequestMapping(value = "xoakhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<KhoaHocDTO> xoaKhoaHoc(@RequestParam int khoaHocID) {
        return khoaHocService.xoaKhoaHoc(khoaHocID);
    }
    @RequestMapping(value = "laydanhsachkhoahoc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachKhoaHoc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(khoaHocService.layDanhSachKhoaHoc(pageable));
    }
    @RequestMapping(value = "timkiemkhoahoctheoten", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> timKiemKhoaHocTheoTen(@RequestParam String tenKhoaHoc, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(khoaHocService.timKiemKhoaHocTheoTen(tenKhoaHoc,pageable));
    }
}
