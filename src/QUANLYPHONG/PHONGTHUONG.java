package QUANLYPHONG;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class PHONGTHUONG extends PHONG {

    private double PhanTramGiamGia; // Giảm giá
    private int thoiGianSudungGiamGia; // Thời gian sử dụng giảm giá (số ngày)

    public PHONGTHUONG() {
        super();
    }

    // Constructor
    public PHONGTHUONG(String maPhong, String tenPhong, double giaPhong, String tinhTrangPhong,
                       LocalDateTime ngayNhanPhong,LocalDateTime ngayDuKienTraPhong, double dienTichPhong, double giaGiam, int thoiGianSudungGiamGia) {
        super(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong,ngayDuKienTraPhong, dienTichPhong);
        this.PhanTramGiamGia = giaGiam;
        this.thoiGianSudungGiamGia = thoiGianSudungGiamGia;
    }


    public double getPhanTramGiamGia() {
        return PhanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        PhanTramGiamGia = phanTramGiamGia;
    }

    @Override
    public void Nhap() {
        super.Nhap(); // Nhập thông tin từ lớp cha
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá giảm(1%-100%): ");
        this.PhanTramGiamGia = scanner.nextDouble();

        System.out.print("Nhập thời gian sử dụng giảm giá (số ngày): ");
        this.thoiGianSudungGiamGia = scanner.nextInt();
    }

    @Override
    public void Xuat() {
        super.Xuat(); // Xuất thông tin từ lớp cha
        System.out.println("Phần trăm giảm giá: " + this.PhanTramGiamGia+"%");
        System.out.println("Thời gian sử dụng giảm giá: " + this.thoiGianSudungGiamGia + " ngày");
    }
    @Override
    public void Xuat2() {
        // Gọi phương thức Xuat() của lớp cha để xuất thông tin chung
        StringBuilder sb = new StringBuilder();
        // Xuất thông tin từ lớp cha
        super.Xuat();

        // Thêm thông tin giảm giá vào StringBuilder
        sb.append("Phần trăm giảm giá: ").append(this.PhanTramGiamGia).append("%, ");
        sb.append("Thời gian sử dụng giảm giá: ").append(this.thoiGianSudungGiamGia).append(" ngày");

        // In toàn bộ thông tin ra màn hình
        System.out.println(sb.toString());
    }
    @Override
    public double tinhGiaPhong() {
        long soNgayO = laySoNgayO(); // Sử dụng phương thức lấy số ngày ở từ lớp cha
        double giaPhong = getGiaPhong(); // Lấy giá phòng từ lớp cha

        // Kiểm tra xem có áp dụng giảm giá hay không
        if (soNgayO <= thoiGianSudungGiamGia) {
            return (1 - PhanTramGiamGia/100) * giaPhong*soNgayO; // Tính giá phòng với giảm giá
        } else {
            return giaPhong * soNgayO; // Tính giá phòng không có giảm giá
        }
    }

    @Override
    public double tinhGiaPhong2(LocalDateTime ngayTraPhong) {
        long soNgayO = ChronoUnit.DAYS.between(ngayNhanPhong.toLocalDate(), ngayTraPhong.toLocalDate());
        double giaPhong = getGiaPhong(); // Lấy giá phòng từ lớp cha

        // Kiểm tra xem có áp dụng giảm giá hay không
        if (soNgayO <= thoiGianSudungGiamGia) {
            return (1 - PhanTramGiamGia/100) * giaPhong*soNgayO; // Tính giá phòng với giảm giá
        } else {
            return giaPhong * soNgayO; // Tính giá phòng không có giảm giá
        }
    }


    // Getter và Setter nếu cần
    public double getGiaGiam() {
        return PhanTramGiamGia;
    }

    public void setGiaGiam(double giaGiam) {
        this.PhanTramGiamGia = giaGiam;
    }

    public int getThoiGianSudungGiamGia() {
        return thoiGianSudungGiamGia;
    }

    public void setThoiGianSudungGiamGia(int thoiGianSudungGiamGia) {
        this.thoiGianSudungGiamGia = thoiGianSudungGiamGia;
    }
}
