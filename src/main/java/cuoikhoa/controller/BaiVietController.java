package cuoikhoa.controller;

import cuoikhoa.payload.dto.BaiVietDTO;
import cuoikhoa.payload.request.BaiVietRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaiVietController {
    @Autowired
    private BaiVietService baiVietService;

    @RequestMapping(value = "thembaiviet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<BaiVietDTO> themBaiViet(@RequestBody BaiVietRequest request) {
        return baiVietService.themBaiViet(request);
    }
    @RequestMapping(value = "suabaiviet", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<BaiVietDTO> suaBaiViet(@RequestParam int baiVietID, @RequestBody BaiVietRequest request) {
        return baiVietService.suaBaiViet(baiVietID, request);
    }
    @RequestMapping(value = "xoabaiviet", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<BaiVietDTO> xoaBaiViet(@RequestParam int baiVietID) {
        return baiVietService.xoaBaiViet(baiVietID);
    }
    @RequestMapping(value = "laydanhsachbaiviet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachBaiViet(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(baiVietService.layDanhSachBaiViet(pageable));
    }
    @RequestMapping(value = "laybaiviettheoten", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layBaiVietTheoTen(@RequestParam String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(baiVietService.layBaiVietTheoTen(name, pageable));
    }
}
