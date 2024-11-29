package QUANLY;

import QUANLLYDICHVU.mainQLDV;
import QUANLYKHACHHANG.Main;
import QUANLYNHANVIEN.MainMenu;
import QUANLYPHONG.main;

import java.util.Scanner;

public class Mainn {
    private static final String USERNAME = "admin"; // Tên người dùng mặc định
    private static final String PASSWORD = "123456"; // Mật khẩu mặc định

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainQLDV qldv = new mainQLDV();
        Main qlkh = new Main();
        main qlp = new main();
        MainMenu qlnv = new MainMenu();
        int choice;

        // Đăng nhập
        if (!attemptLogin(scanner)) {
            System.out.println("Đăng nhập không thành công. Thoát chương trình.");
            return;
        }

        // Menu chính
        while (true) {
            System.out.println("---- MENU QUẢN LÝ KHÁCH SẠN ----");
            System.out.println("1. Quản lý Phòng");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Quản lý dịch vụ");
            System.out.println("4. Quản lý khách hàng");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    qlp.QuanLyPhong();
                    break;
                case 2:
                    qlnv.displayMenu();
                    break;
                case 3:
                    qldv.quanLy();
                    break;
                case 4:
                    qlkh.MenuKhachHang();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return; // Kết thúc chương trình
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

            System.out.println();
        }
    }

    private static boolean attemptLogin(Scanner scanner) {
        int maxAttempts = 3;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            if (login(scanner)) {
                return true; // Nếu đăng nhập thành công, trả về true
            } else {
                System.out.println("Đăng nhập thất bại. Bạn còn " + (maxAttempts - attempt) + " lần thử.");
            }
        }
        return false; // Trả về false nếu đăng nhập không thành công sau 3 lần
    }

    private static boolean login(Scanner scanner) {
        System.out.print("Nhập tên đăng nhập: ");
        String usernameInput = scanner.nextLine();

        System.out.print("Nhập mật khẩu: ");
        String passwordInput = scanner.nextLine();

        // Kiểm tra thông tin đăng nhập
        return USERNAME.equals(usernameInput) && PASSWORD.equals(passwordInput);
    }
}
