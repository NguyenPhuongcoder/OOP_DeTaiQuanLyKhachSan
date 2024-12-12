package QUANLYPHONG;


import com.sun.security.jgss.GSSUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class PHONG implements tinhGiaPhong {
    protected String maPhong;
    protected String tenPhong;
    protected double giaPhong;
    protected String tinhTrangPhong;
    protected LocalDateTime ngayNhanPhong;
    protected LocalDateTime ngayTraPhongDuKien;
    protected double dienTichPhong;
    public int phiPhuThu = 100;


    public PHONG() {
    }

    public PHONG(String maPhong, String tenPhong, double giaPhong, String tinhTrangPhong, LocalDateTime ngayNhanPhong,LocalDateTime ngayTraPhongDuKien, double dienTichPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
        this.tinhTrangPhong = tinhTrangPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.dienTichPhong = dienTichPhong;
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
    }

    public String getMaPhong() {
        return this.maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String isTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    public LocalDateTime getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(LocalDateTime ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public double getDienTichPhong() {
        return dienTichPhong;
    }

    public void setDienTichPhong(double dienTichPhong) {
        this.dienTichPhong = dienTichPhong;
    }

    public LocalDateTime getNgayTraPhongDuKien() {
        return ngayTraPhongDuKien;
    }

    public void setNgayTraPhongDuKien(LocalDateTime ngayTraPhongDuKien) {
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã phòng: ");
        maPhong = scanner.nextLine();

        System.out.print("Nhập tên phòng: ");
        tenPhong = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Nhập giá phòng: ");
                giaPhong = scanner.nextDouble();
                if (giaPhong < 0) {
                    System.out.println("Giá phòng không được âm. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Giá phòng phải là số. Vui lòng nhập lại.");
            }
        }
        String[] validStatuses = {"Trống", "Đang dọn dẹp", "Đang sửa chữa", "Đang thuê"};
        boolean isValidStatus = false;
        scanner.nextLine();
        while (true) {
            System.out.print("Nhập tình trạng phòng (Trống/Đang dọn dẹp/Đang sửa chữa/Đang thuê): ");
            tinhTrangPhong = scanner.nextLine();

            // Kiểm tra xem tình trạng phòng có hợp lệ hay không
            for (String status : validStatuses) {
                if (tinhTrangPhong.equalsIgnoreCase(status)) {
                    isValidStatus = true;
                    break; // Ngắt vòng lặp khi tìm thấy tình trạng hợp lệ
                }
            }

            if (!isValidStatus) {
                System.out.println("Tình trạng phòng không hợp lệ. Vui lòng nhập lại.");
            } else {
                break; // Thoát khỏi vòng lặp nếu trạng thái hợp lệ
            }

            isValidStatus = false; // Đặt lại trạng thái kiểm tra cho lần nhập tiếp theo
        }
        this.ngayNhanPhong = null;
        this.ngayTraPhongDuKien = null;
        while (true) {
            try {
                System.out.print("Nhập diện tích phòng (25 m² - 40 m² - 60 m²): ");
                dienTichPhong = scanner.nextDouble();


                if (dienTichPhong < 0 || (dienTichPhong != 25 && dienTichPhong != 40 && dienTichPhong != 60)) {
                    System.out.println("Diện tích không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Diện tích phải là số. Vui lòng nhập lại.");
                scanner.next();
            }
        }
    }
    public void Xuat() {
        System.out.println("Thông tin phòng:");
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Tên phòng: " + tenPhong);
        System.out.println("Giá phòng: " + giaPhong);
        System.out.println("Tình trạng phòng: " + tinhTrangPhong );
        if (ngayNhanPhong != null) {
            System.out.println("Ngày nhận phòng: " + ngayNhanPhong.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        } else {
            System.out.println("Ngày nhận phòng: không có");
        }

        if (ngayTraPhongDuKien != null) {
            System.out.println("Ngày trả phòng dự kiến: " + ngayTraPhongDuKien.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        } else {
            System.out.println("Ngày trả phòng dự kiến: không có");
        }
        System.out.println("Diện tích phòng: " + dienTichPhong + " m²");
    }

    public void Xuat2() {
        System.out.print("Thông tin phòng: " +
                "Mã phòng: " + maPhong + ", " +
                "Tên phòng: " + tenPhong + ", " +
                "Giá phòng: " + giaPhong + ", " +
                "Tình trạng phòng: " + tinhTrangPhong + ", " +
                "Diện tích phòng: " + dienTichPhong + " m²"+",");
    }
    public abstract double tinhGiaPhong();
    public abstract double tinhGiaPhong2(LocalDateTime ngayTraPhong);
    public void dieuChinhGiaPhong() {
        Scanner sc = new Scanner(System.in);
        int luaChon;
        double giaTri;

        do {
            System.out.println("----------MENU LUA CHON----------");
            System.out.println("1. Giảm giá phòng");
            System.out.println("2. Tăng giá phòng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số tiền để giảm: ");
                    giaTri = sc.nextDouble();
                    if (giaTri > this.giaPhong) {
                        System.out.println("Giá trị không hợp lệ. Giá phòng hiện tại là: " + this.giaPhong + " VNĐ");
                    } else if (giaTri < 0) {
                        System.out.println("Số tiền không được âm!");
                    } else {
                        this.giaPhong -= giaTri;
                        System.out.println("Giá Phòng " + this.tenPhong + " giảm " + giaTri + " VNĐ");
                        System.out.println("Giá Phòng " + this.tenPhong + " hiện tại: " + this.giaPhong + " VNĐ");
                    }
                    break;
                case 2:
                    System.out.print("Nhập số tiền để tăng: ");
                    giaTri = sc.nextDouble();
                    if (giaTri < 0) {
                        System.out.println("Số tiền không được âm!");
                    } else {
                        this.giaPhong += giaTri;
                        System.out.println("Giá Phòng " + this.tenPhong + " tăng " + giaTri + " VNĐ");
                        System.out.println("Giá Phòng " + this.tenPhong + " hiện tại: " + this.giaPhong + " VNĐ");
                    }
                    break;
                case 0:
                    System.out.println("Bạn đã thoát khỏi menu điều chỉnh giá phòng.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (luaChon != 0);
    }

    public long laySoNgayO() {
        return ChronoUnit.DAYS.between(ngayNhanPhong.toLocalDate(), ngayTraPhongDuKien.toLocalDate());
    }

}
