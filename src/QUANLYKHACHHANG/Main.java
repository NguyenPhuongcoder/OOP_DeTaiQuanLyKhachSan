package QUANLYKHACHHANG;

import java.util.Scanner;

public class Main {
    public void MenuKhachHang() {
        Scanner scanner = new Scanner(System.in);
        KhachHangList khachHangList = new KhachHangList();

        while (true) {
            showMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            // Kiểm tra nếu người dùng chọn mục thoát
            if (choice == 6) {
                System.out.println("Thoát chương trình. Tạm biệt!");
                break;
            }

            // Xử lý lựa chọn của người dùng
            while (choice < 1 || choice > 6) {  // Kiểm tra nếu lựa chọn không hợp lệ
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                showMenu();  // Hiển thị lại menu
                choice = scanner.nextInt();  // Nhập lại lựa chọn
                scanner.nextLine(); // Đọc dòng trống
            }

            handleChoice(choice, khachHangList, scanner);
        }
    }

    public static void showMenu() {
        System.out.println("\n------ MENU QUẢN LÝ KHÁCH HÀNG -----");
        System.out.println("1. Thêm khách hàng mới");
        System.out.println("2. Xóa khách hàng");
        System.out.println("3. Chỉnh sửa thông tin khách hàng");
        System.out.println("4. Hiển thị danh sách khách hàng");
        System.out.println("5. Tính số ngày thuê của khách hàng");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng (1-6): ");
    }

    public static void handleChoice(int choice, KhachHangList khachHangList, Scanner scanner) {
        switch (choice) {
            case 1 -> themKhachHang(khachHangList, scanner);
            case 2 -> xoaKhachHang(khachHangList, scanner);
            case 3 -> chinhSuaKhachHang(khachHangList, scanner);
            case 4 -> khachHangList.In();
            case 5 -> tinhSoNgayThue(khachHangList, scanner);
            default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
        }
    }

    public static void themKhachHang(KhachHangList khachHangList, Scanner scanner) {
        System.out.println("\n1. Khách hàng Online");
        System.out.println("2. Khách hàng tại quầy");
        System.out.print("Chọn kiểu đặt phòng (1-2): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống

        KhachHang kh = switch (type) {
            case 1 -> new KhachHangOnline();
            case 2 -> new KhachHangTaiQuay();
            default -> {
                System.out.println("Lựa chọn không hợp lệ!");
                yield null;
            }
        };

        if (kh == null) return;

        kh.Nhap();
        khachHangList.khachHangMoi(kh);
        System.out.println("Thêm khách hàng thành công!");
    }

    public static void xoaKhachHang(KhachHangList khachHangList, Scanner scanner) {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = scanner.nextLine();
        khachHangList.xoaKhachHang(maKH);
        System.out.println("Xóa khách hàng thành công (nếu mã tồn tại).");
    }

    public static void chinhSuaKhachHang(KhachHangList khachHangList, Scanner scanner) {
        System.out.print("Nhập mã khách hàng cần chỉnh sửa: ");
        String maKH = scanner.nextLine();
        khachHangList.chinhSuaThongTin(maKH);
    }

    public static void tinhSoNgayThue(KhachHangList khachHangList, Scanner scanner) {
        System.out.print("Nhập mã khách hàng để tính số ngày thuê: ");
        String maKH = scanner.nextLine();
        khachHangList.tinhSoNgayThue(maKH);
    }
}