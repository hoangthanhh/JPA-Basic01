package QuanLyTrungTamIelts.Services;

import QuanLyTrungTamIelts.Models.HocSinh;
import QuanLyTrungTamIelts.repository.HocSinhRepo;

import java.util.List;

public interface IHocSinh {
    public HocSinh them1HocSinh(HocSinh hocSinh);

    public List<HocSinh> hienThiDSHocSinh(int namSinh, String hoTen);

    public List<HocSinh> hienThiDSHocSinhTheoNgayDangKy();

    public HocSinh capNhatThongTinHocSinh(HocSinh hocSinh);

    public String xoaHocSinh(int idHocSinhs);
}

