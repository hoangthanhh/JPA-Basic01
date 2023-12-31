package QuanLyTrungTamIelts.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "hocsinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHocSinh;

    @Column(name = "hoten")
    @NotNull(message = "Họ và tên không được để trống")
    @Size(min = 6, max = 50, message = "Họ và tên từ 6 đến 50 ký tự")
    private String hoTen;

    @Column(name = "ngaysinh")
    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate ngaySinh;

    @Column(name = "gioitinh")
    @NotNull(message = "Giới tính không được để trống")
    private String gioiTinh;

    @Column(name = "email")
    @NotNull(message = "Email không được để trống")
    @Size(min = 10,max = 100, message = "Email từ 10 đến 100 ký tự")
    private String email;

    @Column(name = "phonenumber")
    @NotNull(message = "Số điện thoại không được để trống")
    @Size(min = 10,max = 15, message = "Số điện thoại từ 10 đến 15 ký tự")
    private String phoneNumber;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "trinhdohientai")
    private String trinhDoHienTai;

    @Column(name = "idlop")
    private int idLop;

    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;

    @ManyToOne()
    @JoinColumn(name = "idlop",insertable = false,updatable = false)
    @JsonBackReference
    private Lop lop;

    public int getIdHocSinh() {
        return idHocSinh;
    }

    public void setIdHocSinh(int idHocSinh) {
        this.idHocSinh = idHocSinh;
    }

    public String getHoten() {
        return hoTen;
    }

    public void setHoten(String hoten) {
        this.hoTen = hoten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrinhDoHienTai() {
        return trinhDoHienTai;
    }

    public void setTrinhDoHienTai(String trinhDoHienTai) {
        this.trinhDoHienTai = trinhDoHienTai;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}
