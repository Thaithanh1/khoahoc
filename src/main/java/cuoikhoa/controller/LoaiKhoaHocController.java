package cuoikhoa.controller;

import cuoikhoa.payload.dto.LoaiKhoaHocDTO;
import cuoikhoa.payload.request.LoaiKhoaHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.LoaiKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "loaikhoahocapi")
public class LoaiKhoaHocController {
    @Autowired
    private LoaiKhoaHocService loaiKhoaHocService;
    @RequestMapping(value = "themloaikhoahoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiKhoaHocDTO> themLoaiKhoaHoc(@RequestBody LoaiKhoaHocRequest request) {
        return loaiKhoaHocService.themLoaiKhoaHoc(request);
    }
    @RequestMapping(value = "sualoaikhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiKhoaHocDTO> suaLoaiKhoaHoc(@RequestParam int loaiKhoaHocID, @RequestBody LoaiKhoaHocRequest request) {
        return loaiKhoaHocService.suaLoaiKhoaHoc(loaiKhoaHocID, request);
    }
    @RequestMapping(value = "xoaloaikhoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<LoaiKhoaHocDTO> xoaLoaiKhoaHoc(@RequestParam int loaiKhoaHocID) {
        return loaiKhoaHocService.xoaLoaiKhoaHoc(loaiKhoaHocID);
    }
}
