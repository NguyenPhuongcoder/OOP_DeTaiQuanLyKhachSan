
package QUANLYDICHVU;

public abstract class DICHVU {
    protected String maDichVu;
    protected String tenDichVu;
    protected String gioiThieu;
    protected double giaTien;

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }
     
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

    public DICHVU(String maDichVu, String tenDichVu, String gioiThieu, double giaTien) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.gioiThieu = gioiThieu;
        this.giaTien = giaTien;
    }
    public abstract void hienThiThongTin();;
}
