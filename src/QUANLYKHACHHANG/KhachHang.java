package QUANLYKHACHHANG;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class KhachHang {
    Scanner scanner = new Scanner(System.in);
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    protected String maKH, tenKH, maPhong, tenPhong, CCCD, SDT, diaChi, email;
    protected LocalDateTime ngayNhanPhong, ngayTraPhong;
    static ArrayList<String> danhSachMaKH = new ArrayList<>();

    public void Nhap() {
        int attempts;

        // Nhập mã khách hàng
        attempts = 0;
        while (true) {
            System.out.print("Nhập mã khách hàng (định dạng KHxxxx): ");
            maKH = scanner.nextLine();

            if (!maKH.matches("KH\\d{4}")) {
                System.out.println("Lỗi: Mã khách hàng phải theo định dạng KHxxxx (ví dụ: KH0001).");
            } else if (danhSachMaKH.contains(maKH)) {
                System.out.println("Lỗi: Mã khách hàng đã tồn tại. Vui lòng nhập lại.");
            } else {
                danhSachMaKH.add(maKH);
                break;
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }

        // Nhập tên khách hàng
        System.out.print("Nhập tên khách hàng: ");
        tenKH = scanner.nextLine();

        // Nhập mã phòng
        System.out.print("Nhập mã phòng: ");
        maPhong = scanner.nextLine();

        // Nhập tên phòng
        System.out.print("Nhập tên phòng: ");
        tenPhong = scanner.nextLine();

        // Nhập CCCD
        attempts = 0;
        while (true) {
            System.out.print("Nhập CCCD (12 số): ");
            CCCD = scanner.nextLine();

            if (CCCD.matches("\\d{12}")) {
                break;
            } else {
                System.out.println("Lỗi: CCCD phải là 12 số. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }

        // Nhập số điện thoại
        attempts = 0;
        while (true) {
            System.out.print("Nhập số điện thoại (10 hoặc 11 số): ");
            SDT = scanner.nextLine();

            // Kiểm tra số điện thoại chỉ chứa 10 hoặc 11 chữ số
            if (SDT.matches("\\d{10,11}")) {
                break;
            } else {
                System.out.println("Lỗi: Số điện thoại phải chứa 10 hoặc 11 chữ số. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }

        // Nhập địa chỉ
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();

        // Nhập email
        attempts = 0;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();

            // Kiểm tra email bắt đầu bằng chữ hoa và chứa ký tự '@'
            if (!email.matches("[A-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}")) {
                System.out.println("Lỗi: Email phải bắt đầu bằng chữ hoa, chứa ký tự '@' và số.");
            } else {
                break;
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }

        // Nhập ngày nhận phòng
        attempts = 0;
        while (true) {
            try {
                System.out.print("Nhập ngày nhận phòng (định dạng yyyy-MM-dd HH:mm): ");
                String ngayNhanPhongStr = scanner.nextLine();
                ngayNhanPhong = LocalDateTime.parse(ngayNhanPhongStr, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày nhận phòng không hợp lệ. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }

        // Nhập ngày trả phòng
        attempts = 0;
        while (true) {
            try {
                System.out.print("Nhập ngày trả phòng (định dạng yyyy-MM-dd HH:mm): ");
                String ngayTraPhongStr = scanner.nextLine();
                ngayTraPhong = LocalDateTime.parse(ngayTraPhongStr, formatter);

                if (ngayTraPhong.isAfter(ngayNhanPhong)) {
                    break;
                } else {
                    System.out.println("Lỗi: Ngày trả phòng phải sau ngày nhận phòng. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày trả phòng không hợp lệ. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return;
            }
        }
    }

    public void Xuat() {
        System.out.println("\nMã KH: " + maKH);
        System.out.println("Tên KH: " + tenKH);
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Tên phòng: " + tenPhong);
        System.out.println("CCCD: " + CCCD);
        System.out.println("SĐT: " + SDT);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Email: " + email);
        System.out.println("Ngày nhận phòng: " + ngayNhanPhong);
        System.out.println("Ngày trả phòng: " + ngayTraPhong);
    }

    public void hienThiThongTinKhachHang() {
        Xuat();
    }
}