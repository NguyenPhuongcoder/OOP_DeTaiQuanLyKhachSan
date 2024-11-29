package QUANLLYDICHVU;

import java.time.LocalDateTime;


public interface IDichVu {
    void datMonAnTruoc(String tenMonAn);
    void taoComboMonAn();
    void datLichGiaiTri(String tenDichVu, LocalDateTime thoiGianDat);
    void taoSuKienGiaiTri(String tenSuKien, String thoiGian, String diaDiem);
    void xemSuKienGiaiTri();
    void hienThiThongTin();
}
