package cuoikhoa.controller;

import cuoikhoa.payload.dto.TinhTrangHocDTO;
import cuoikhoa.payload.request.TinhTrangHocRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.TinhTrangHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TinhTrangHocController {
    @Autowired
    private TinhTrangHocService tinhTrangHocService;

    @RequestMapping(value = "themtinhtranghoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TinhTrangHocDTO> themTinhTrangHoc(@RequestBody TinhTrangHocRequest request) {
        return tinhTrangHocService.themTinhTrangHoc(request);
    }
    @RequestMapping(value = "suatinhtranghoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TinhTrangHocDTO> suaTinhTrangHoc(@RequestParam int tinhTrangHocID, @RequestBody TinhTrangHocRequest request) {
        return tinhTrangHocService.suaTinhTrangHoc(tinhTrangHocID, request);
    }
    @RequestMapping(value = "xoatinhtranghoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<TinhTrangHocDTO> xoaTinhTrangHoc(@RequestParam int tinhTrangHocID) {
        return tinhTrangHocService.xoaTinhTrangHoc(tinhTrangHocID);
    }
}
