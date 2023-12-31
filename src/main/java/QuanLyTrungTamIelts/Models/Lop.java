package QuanLyTrungTamIelts.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLop;

    @Column(name = "tenlop")
    private String tenLop;

    @Column(name = "siso")
    private int siSo;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lop")
    @JsonManagedReference
    private Set<HocSinh> hocSinhs;

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public Set<HocSinh> getHocSinhs() {
        return hocSinhs;
    }

    public void setHocSinhs(Set<HocSinh> hocSinhs) {
        this.hocSinhs = hocSinhs;
    }
}
