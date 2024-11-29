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
    protected boolean tinhTrangPhong;
    protected LocalDateTime ngayNhanPhong;
    protected double dienTichPhong;


    public PHONG() {
    }

    public PHONG(String maPhong, String tenPhong, double giaPhong, boolean tinhTrangPhong, LocalDateTime ngayNhanPhong, double dienTichPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
        this.tinhTrangPhong = tinhTrangPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.dienTichPhong = dienTichPhong;
    }

    public String getMaPhong() {
        return maPhong;
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

    public boolean isTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(boolean tinhTrangPhong) {
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
                scanner.next(); // Xóa giá trị không hợp lệ
            }
        }

        System.out.print("Nhập tình trạng phòng (true/false): ");
        tinhTrangPhong = scanner.nextBoolean();
        LocalDateTime ngayNhanPhong;
        scanner.nextLine();
        while (true) {
            System.out.print("Nhập ngày nhận phòng (yyyy-MM-dd HH:mm): ");
            String input = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                ngayNhanPhong = LocalDateTime.parse(input, formatter);
                this.ngayNhanPhong = ngayNhanPhong; // Lưu ngày nhận phòng vào thuộc tính
                break; // Thoát khỏi vòng lặp nếu nhập thành công
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập diện tích phòng: ");
                dienTichPhong = scanner.nextDouble();
                if (dienTichPhong < 0) {
                    System.out.println("Diện tích không được âm. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Diện tích phải là số. Vui lòng nhập lại.");
                scanner.next(); // Xóa giá trị không hợp lệ
            }
        }
    }


    public void Xuat() {
        System.out.println("Thông tin phòng:");
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Tên phòng: " + tenPhong);
        System.out.println("Giá phòng: " + giaPhong);
        System.out.println("Tình trạng phòng: " + (tinhTrangPhong ? "Có sẵn" : "Không có sẵn"));
        System.out.println("Ngày nhận phòng: " + ngayNhanPhong.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        System.out.println("Diện tích phòng: " + dienTichPhong + " m²");
    }

    public abstract double tinhGiaPhong();

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
        LocalDateTime ngayHienTai = LocalDateTime.now(); // Lấy ngày hiện tại
        return ChronoUnit.DAYS.between(ngayNhanPhong.toLocalDate(), ngayHienTai.toLocalDate());
    }

}
