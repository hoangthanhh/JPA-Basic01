package QuanLyTrungTamIelts.Services;

import QuanLyTrungTamIelts.Models.HocSinh;
import QuanLyTrungTamIelts.Models.Lop;
import QuanLyTrungTamIelts.repository.HocSinhRepo;
import QuanLyTrungTamIelts.repository.LopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocSinhService implements IHocSinh {
    @Autowired
    HocSinhRepo hocSinhRepo;
    @Autowired
    LopRepo lopRepo;

    @Override
    public HocSinh them1HocSinh(HocSinh hocSinh) {
        Optional<Lop> lop = lopRepo.findById(hocSinh.getIdLop());
        if (lop.isEmpty()) {
            return null;
        }
        Lop lop1 = new Lop();
        lop1 = lop.get();
        lop1.setSiSo(lop1.getSiSo() + 1);
        lopRepo.save(lop1);

        hocSinhRepo.save(hocSinh);
        return hocSinh;
    }

    @Override
    public List<HocSinh> hienThiDSHocSinh(int namSinh, String hoTen) {
        List<HocSinh> list = hocSinhRepo.hienThiDSHocSinh(namSinh, hoTen);
        return list;
    }

    @Override
    public List<HocSinh> hienThiDSHocSinhTheoNgayDangKy() {
        List<HocSinh> list = hocSinhRepo.hienThiDSHocSinhTheoNgayDangKy();
        return list;
    }

    @Override
    public HocSinh capNhatThongTinHocSinh(HocSinh hocSinhSua) {
        Optional<HocSinh> hocSinh = hocSinhRepo.findById(hocSinhSua.getIdHocSinh());
        if (hocSinh.isEmpty()){
            return null;
        }
        HocSinh hs = hocSinh.get();
        hs.setDiaChi(hocSinhSua.getDiaChi());
        hs.setEmail(hocSinhSua.getEmail());
        hs.setPhoneNumber(hocSinhSua.getPhoneNumber());
        hs.setTrinhDoHienTai(hocSinhSua.getTrinhDoHienTai());
        hs.setIdLop(hocSinhSua.getIdLop());
        hs.setNgayDangKy(hocSinhSua.getNgayDangKy());
        hs.setNgaySinh(hocSinhSua.getNgaySinh());
        hocSinhRepo.save(hocSinhSua);
        return hocSinhSua;
    }

    @Override
    public String xoaHocSinh(int idHocSinh) {
        Optional<HocSinh> optionalHocSinh = hocSinhRepo.findById(idHocSinh);
        HocSinh hocSinh = optionalHocSinh.orElseThrow(() -> new RuntimeException("Không tìm thấy học sinh"));


        if (hocSinh != null) {
            // Lấy thông tin lớp của học viên
            Lop lop = hocSinh.getLop();

            // Cập nhật sĩ số của lớp
            if (lop != null) {
                lop.setSiSo(lop.getSiSo() - 1);
                lopRepo.save(lop);
            }

            // Xóa học viên
            hocSinhRepo.delete(hocSinh);
        }
        return "Xóa thành công";
    }
}