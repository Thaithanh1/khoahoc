package cuoikhoa.payload.converter;

import cuoikhoa.entity.QuyenHan;
import cuoikhoa.payload.dto.QuyenHanDTO;
import cuoikhoa.payload.request.QuyenHanRequest;

public class QuyenHanConverter {
    public QuyenHanDTO entityToQuyenHanDTO(QuyenHan quyenHan) {
        QuyenHanDTO dto = new QuyenHanDTO();
        dto.setTenQuyenHan(quyenHan.getTenQuyenHan());
        return dto;
    }

    public QuyenHan themQuyenHan(QuyenHanRequest request) {
        QuyenHan quyenHan = new QuyenHan();
        quyenHan.setTenQuyenHan(request.getTenQuyenHan());
        return quyenHan;
    }

    public QuyenHan suaQuyenHan(QuyenHan quyenHan, QuyenHanRequest request) {
        quyenHan.setTenQuyenHan(request.getTenQuyenHan());
        return quyenHan;
    }
}
