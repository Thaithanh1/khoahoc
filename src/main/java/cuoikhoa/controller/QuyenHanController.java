package cuoikhoa.controller;

import cuoikhoa.payload.dto.QuyenHanDTO;
import cuoikhoa.payload.request.QuyenHanRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.QuyenHanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuyenHanController {
    @Autowired
    private QuyenHanService quyenHanService;
    @RequestMapping(value = "themquyenhan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> themQuyenHan(@RequestBody QuyenHanRequest request) {
        return quyenHanService.themQuyenHan(request);
    }
    @RequestMapping(value = "suaquyenhan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> suaQuyenHan(@RequestParam int quyenHanID, @RequestBody QuyenHanRequest request) {
        return quyenHanService.suaQuyenHan(quyenHanID, request);
    }
    @RequestMapping(value = "xoaquyenhan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<QuyenHanDTO> xoaQuyenHan(@RequestParam int quyenHanID) {
        return quyenHanService.xoaQuyenHan(quyenHanID);
    }
    @RequestMapping(value = "laydanhsachquyenhan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachQuyenHan(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(quyenHanService.layDanhSachQuyenHan(pageable));
    }
}
