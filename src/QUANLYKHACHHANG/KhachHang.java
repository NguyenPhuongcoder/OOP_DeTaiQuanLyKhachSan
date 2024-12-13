package QUANLYKHACHHANG;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class KhachHang {
    Scanner scanner = new Scanner(System.in);
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    protected String maKH, tenKH, maPhong, tenPhong, CCCD, SDT, diaChi, email;
    static ArrayList<String> danhSachMaKH = new ArrayList<>();
    static HashSet<String> danhSachCCCD = new HashSet<>();
    static HashSet<String> danhSachSDT = new HashSet<>();
    static HashSet<String> danhSachEmail = new HashSet<>();

    public boolean Nhap() {
        // Nhập mã khách hàng
        if (!nhapMaKhachHang()) return false;

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
        if (!nhapCCCD()) return false;

        // Nhập số điện thoại
        if (!nhapSDT()) return false;

        // Nhập địa chỉ
        System.out.print("Nhập địa chỉ: ");
        diaChi = scanner.nextLine();

        // Nhập email
        if (!nhapEmail()) return false;

        return true; // Nếu tất cả thông tin hợp lệ, trả về true
    }

    private boolean nhapMaKhachHang() {
        int attempts = 0;
        while (true) {
            System.out.print("Nhập mã khách hàng (định dạng KHxxxx): ");
            maKH = scanner.nextLine();

            if (!maKH.matches("KH\\d{4}")) {
                System.out.println("Lỗi: Mã khách hàng phải theo định dạng KHxxxx (ví dụ: KH0001).");
            } else if (danhSachMaKH.contains(maKH)) {
                System.out.println("Lỗi: Mã khách hàng đã tồn tại. Vui lòng nhập lại.");
            } else {
                danhSachMaKH.add(maKH);
                return true; // Nhập thành công
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return false; // Kết thúc quá trình nhập
            }
        }
    }

    private boolean nhapCCCD() {
        int attempts = 0;
        while (true) {
            System.out.print("Nhập CCCD (12 số): ");
            CCCD = scanner.nextLine();

            if (CCCD.matches("\\d{12}")) {
                if (danhSachCCCD.contains(CCCD)) {
                    System.out.println("Lỗi: CCCD đã tồn tại. Vui lòng nhập lại.");
                } else {
                    danhSachCCCD.add(CCCD);
                    return true; // Nhập thành công
                }
            } else {
                System.out.println("Lỗi: CCCD phải là 12 số. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return false; // Kết thúc quá trình nhập
            }
        }
    }

    private boolean nhapSDT() {
        int attempts = 0;
        while (true) {
            System.out.print("Nhập số điện thoại (10 hoặc 11 số): ");
            SDT = scanner.nextLine();

            // Kiểm tra số điện thoại chỉ chứa 10 hoặc 11 chữ số
            if (SDT.matches("\\d{10,11}")) {
                if (danhSachSDT.contains(SDT)) {
                    System.out.println("Lỗi: Số điện thoại đã tồn tại. Vui lòng nhập lại.");
                } else {
                    danhSachSDT.add(SDT);
                    return true; // Nhập thành công
                }
            } else {
                System.out.println("Lỗi: Số điện thoại phải chứa 10 hoặc 11 chữ số. Vui lòng thử lại.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return false; // Kết thúc quá trình nhập
            }
        }
    }

    private boolean nhapEmail() {
        int attempts = 0;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();

            // Kiểm tra email bắt đầu bằng chữ hoa và chứa ký tự '@'
            if (email.matches("[A-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}")) {
                if (danhSachEmail.contains(email)) {
                    System.out.println("Lỗi: Email đã tồn tại. Vui lòng nhập lại.");
                } else {
                    danhSachEmail.add(email);
                    return true; // Nhập thành công
                }
            } else {
                System.out.println("Lỗi: Email phải bắt đầu bằng chữ hoa, chứa ký tự '@' và số.");
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Bạn đã nhập sai quá 3 lần. Kết thúc quá trình nhập.");
                return false; // Kết thúc quá trình nhập
            }
        }
    }

    public void Xuat() {
        System.out.println("Mã KH: " + maKH);
        System.out.println("Tên KH: " + tenKH);
        System.out.println("Mã phòng: " + maPhong);
        System.out.println("Tên phòng: " + tenPhong);
        System.out.println("CCCD: " + CCCD);
        System.out.println("SĐT: " + SDT);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Email: " + email);
    }

    public void hienThiThongTinKhachHang() {
        Xuat();
    }
}