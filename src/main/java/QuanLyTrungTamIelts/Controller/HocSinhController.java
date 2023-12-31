package QuanLyTrungTamIelts.Controller;

import QuanLyTrungTamIelts.Models.HocSinh;
import QuanLyTrungTamIelts.Services.HocSinhService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class HocSinhController {
    @Autowired
    HocSinhService hocSinhService;

    @RequestMapping(value = "them1hocsinh", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh them1HocSinh(@RequestBody String hocSinh) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        HocSinh hs = gson.fromJson(hocSinh, HocSinh.class);
        return hocSinhService.them1HocSinh(hs);
    }

    @RequestMapping(value = "hienthidshocsinh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HocSinh> hienThiDSHocSinh(@RequestParam int namSinh, @RequestParam String hoTen) {
        return hocSinhService.hienThiDSHocSinh(namSinh,hoTen);
    }

    @RequestMapping(value = "hienthidshocsinhtheongay", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HocSinh> hienThiDSHocSinhTheoNgayDangKy() {
        return hocSinhService.hienThiDSHocSinhTheoNgayDangKy();
    }

    @RequestMapping(value = "suahocsinh", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocSinh suaHocSinh(@RequestBody String hocSinhSua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                }
        ).create();
        HocSinh hs = gson.fromJson(hocSinhSua, HocSinh.class);
        return hocSinhService.capNhatThongTinHocSinh(hs);
    }

    @RequestMapping(value = "xoahocsinh", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaHocSinh(@RequestParam int idHocSinh) {
        return hocSinhService.xoaHocSinh(idHocSinh);
    }

}
