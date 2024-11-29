package QUANLLYDICHVU;

public abstract class DICHVU {
    protected String tenDichVu;
    protected String gioiThieu;
    protected double giaTien;

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public DICHVU() {
    }
    public DICHVU(String tenDichVu, String gioiThieu, double giaTien) {
        this.tenDichVu = tenDichVu;
        this.gioiThieu = gioiThieu;
        this.giaTien = giaTien;
    }
    public abstract void hienThiThongTin();
}
