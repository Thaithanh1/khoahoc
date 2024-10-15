package cuoikhoa.controller;

import cuoikhoa.payload.dto.ChuDeDTO;
import cuoikhoa.payload.request.ChuDeRequest;
import cuoikhoa.payload.response.ResponseObject;
import cuoikhoa.service.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChuDeController {
    @Autowired
    private ChuDeService chuDeService;
    @RequestMapping(value = "themchude", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChuDeDTO> themChuDe(@RequestBody ChuDeRequest request) {
        return chuDeService.themChuDe(request);
    }
    @RequestMapping(value = "suachude", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChuDeDTO> suaChuDe(@RequestParam int chuDeID, @RequestBody ChuDeRequest request) {
        return chuDeService.suaChuDe(chuDeID, request);
    }
    @RequestMapping(value = "xoachude", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChuDeDTO> xoaChuDe(@RequestParam int chuDeID) {
        return chuDeService.xoaChuDe(chuDeID);
    }
    @RequestMapping(value = "laydanhsachchude", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> layDanhSachChuDe(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(chuDeService.layDanhSachChuDe(pageable));
    }
}
