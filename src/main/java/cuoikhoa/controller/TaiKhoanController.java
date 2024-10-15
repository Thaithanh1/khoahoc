package cuoikhoa.controller;

import cuoikhoa.entity.TaiKhoan;
import cuoikhoa.payload.dto.TaiKhoanDTO;
import cuoikhoa.payload.dto.TinhTrangHocDTO;
import cuoikhoa.payload.request.TaiKhoanRequest;
import cuoikhoa.payload.request.TinhTrangHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @RequestMapping(value = "themtaikhoan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TaiKhoanDTO> themTaiKhoan(@RequestBody TaiKhoanRequest request) {
        return taiKhoanService.themTaiKhoan(request);
    }
    @RequestMapping(value = "suataikhoan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TaiKhoanDTO> suaTaiKhoan(@RequestParam int taiKhoanID, @RequestBody TaiKhoanRequest request) {
        return taiKhoanService.suaTaiKhoan(taiKhoanID, request);
    }
    @RequestMapping(value = "xoataikhoan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TaiKhoanDTO> xoaTaiKhoan(@RequestParam int taiKhoanID) {
        return taiKhoanService.xoaTaiKhoan(taiKhoanID);
    }
    @RequestMapping(value = "laydanhsachtaikhoan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachTaiKhoan(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(taiKhoanService.layDanhSachTaiKhoan(pageable));
    }
    @RequestMapping(value = "layTaiKhoanTheoTen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layTaiKhoanTheoTen(@RequestParam String username, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(taiKhoanService.layTaiKhoanTheoTen(username, pageable));
    }
}
