package QUANLYPHONG;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class PHONGVIP extends PHONG {
    private String[] tienich;
    private double phanTramGiamGia;
    private int thoiGianSuDungTienIch; // Thời gian sử dụng tiện ích (tính bằng ngày)
    private int giaTienIch = 100;
    public PHONGVIP() {
        super();
    }

    public String[] getTienich() {
        return tienich;
    }

    public void setTienich(String[] tienich) {
        this.tienich = tienich;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public int getThoiGianSuDungTienIch() {
        return thoiGianSuDungTienIch;
    }

    public void setThoiGianSuDungTienIch(int thoiGianSuDungTienIch) {
        this.thoiGianSuDungTienIch = thoiGianSuDungTienIch;
    }

    public int getGiaTienIch() {
        return giaTienIch;
    }



    public void setGiaTienIch(int giaTienIch) {
        this.giaTienIch = giaTienIch;
    }

    public PHONGVIP(String maPhong, String tenPhong, double giaPhong, String tinhTrangPhong,
                    LocalDateTime ngayNhanPhong,LocalDateTime ngayDuKienTraPhong, double dienTichPhong, String[] tienich,
                    double phanTramGiamGia, int thoiGianSuDungTienIch) {
        super(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong,ngayDuKienTraPhong, dienTichPhong);
        this.tienich = tienich;
        this.phanTramGiamGia = phanTramGiamGia;
        this.thoiGianSuDungTienIch = thoiGianSuDungTienIch;
    }

    @Override
    public void Nhap() {
        super.Nhap();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập phần giảm giá (1%-100%): ");
            phanTramGiamGia = scanner.nextDouble();
            if (phanTramGiamGia >= 1 && phanTramGiamGia <= 100) {
                break; // Thoát khỏi vòng lặp nếu giá trị hợp lệ
            } else {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại (1%-100%).");
            }
        }
        System.out.print("Nhập số lượng tiện ích: ");
        int soLuongTienIch = scanner.nextInt();
        this.tienich = new String[soLuongTienIch];
        scanner.nextLine(); // Đọc ký tự newline còn lại
        for (int i = 0; i < soLuongTienIch; i++) {
            System.out.print("Nhập tiện ích thứ " + (i + 1) + ": ");
            tienich[i] = scanner.nextLine();
        }

        System.out.print("Nhập thời gian sử dụng tiện ích (Ngày): ");
        thoiGianSuDungTienIch = scanner.nextInt();
    }

    @Override
    public void Xuat() {
        super.Xuat();

        System.out.println("Phần trăm giảm giá " + phanTramGiamGia+"%");
        System.out.println("Tiện ích:");
        if (tienich != null) {
            for (String t : tienich) {
                if (t != null) {
                    System.out.println(" - " + t);
                }
            }
        }
        System.out.println("Thời gian sử dụng tiện ích: " + thoiGianSuDungTienIch + " ngày");
    }
    @Override
    public void Xuat2() {
        // Gọi phương thức Xuat() của lớp cha
        super.Xuat2();

        StringBuilder sb = new StringBuilder();
        sb.append("Phần trăm giảm giá: ").append(phanTramGiamGia).append("%, ");

        // Xử lý tiện ích
        sb.append("Tiện ích: ");
        if (tienich != null && tienich.length > 0) {
            for (int i = 0; i < tienich.length; i++) {
                if (tienich[i] != null) {
                    sb.append(tienich[i]);
                    if (i < tienich.length - 1) {
                        sb.append(", "); // Thêm dấu phẩy nếu không phải là tiện ích cuối cùng
                    }
                }
            }
        } else {
            sb.append("Không có tiện ích.");
        }

        // Thời gian sử dụng tiện ích
        sb.append(", Thời gian sử dụng tiện ích: ").append(thoiGianSuDungTienIch).append(" ngày");

        // In toàn bộ thông tin ra màn hình
        System.out.println(sb.toString());
    }

    public  double tinhGiaPhong() {
        return giaPhong*laySoNgayO()*(1-phanTramGiamGia/100) + tienich.length*giaTienIch*thoiGianSuDungTienIch;
    }

    @Override
    public double tinhGiaPhong2(LocalDateTime ngayTraPhong) {
        long soNgayO = ChronoUnit.DAYS.between(ngayNhanPhong.toLocalDate(), ngayTraPhong.toLocalDate());
        return giaPhong*soNgayO*(1-phanTramGiamGia/100) + tienich.length*giaTienIch*thoiGianSuDungTienIch;

    }
}
