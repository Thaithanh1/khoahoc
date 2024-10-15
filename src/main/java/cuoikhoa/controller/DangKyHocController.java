package cuoikhoa.controller;

import cuoikhoa.entity.DangKyHoc;
import cuoikhoa.payload.dto.DangKyHocDTO;
import cuoikhoa.payload.request.DangKyHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.DangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DangKyHocController {
    @Autowired
    private DangKyHocService dangKyHocService;
    @RequestMapping(value = "themdangkyhoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DangKyHocDTO> themDangKyHoc(@RequestBody DangKyHocRequest request) {
        return dangKyHocService.themDangKyHoc(request);
    }
    @RequestMapping(value = "suadangkyhoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DangKyHocDTO> suaDangKyHoc(@RequestParam int dangKyHocID, @RequestBody DangKyHocRequest request) {
        return dangKyHocService.suaDangKyHoc(dangKyHocID, request);
    }
    @RequestMapping(value = "xoadangkyhoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DangKyHocDTO> xoaDangKyHoc(@RequestParam int dangKyHocID) {
        return dangKyHocService.xoaDangKyHoc(dangKyHocID);
    }
    @RequestMapping(value = "laydanhsachdangkyhoc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachDangKyHoc(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(dangKyHocService.layDanhSachDangKyHoc(pageable));
    }
}
