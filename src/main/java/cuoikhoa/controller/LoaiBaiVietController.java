package cuoikhoa.controller;

import cuoikhoa.payload.dto.LoaiBaiVietDTO;
import cuoikhoa.payload.request.LoaiBaiVietRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.LoaiBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiBaiVietController {
    @Autowired
    private LoaiBaiVietService loaiBaiVietService;

    @RequestMapping(value = "themloaibaiviet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiBaiVietDTO> themLoaiBaiViet(@RequestBody LoaiBaiVietRequest request) {
        return loaiBaiVietService.themLoaiBaiViet(request);
    }
    @RequestMapping(value = "sualoaibaiviet", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiBaiVietDTO> suaLoaiBaiViet(@RequestParam int loaiBaiVietID, @RequestBody LoaiBaiVietRequest request) {
        return loaiBaiVietService.suaLoaiBaiViet(loaiBaiVietID, request);
    }
    @RequestMapping(value = "xoaloaibaiviet", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiBaiVietDTO> suaLoaiBaiViet(@RequestParam int loaiBaiVietID) {
        return loaiBaiVietService.xoaLoaiBaiViet(loaiBaiVietID);
    }
    @RequestMapping(value = "laydanhsachloaibaiviet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachLoaiBaiViet(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(loaiBaiVietService.layDanhSachLoaiBaiViet(pageable));
    }

}
