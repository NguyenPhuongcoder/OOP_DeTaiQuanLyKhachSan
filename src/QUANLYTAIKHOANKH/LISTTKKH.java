package QUANLYTAIKHOANKH;

import java.util.ArrayList;
import java.util.Scanner;

public class LISTTKKH {
    private static ArrayList<TKKH> list;
    private Scanner scanner;

    // Constructor
    public LISTTKKH() {
        this.list = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Hàm thêm tài khoản
    public static void themTKKH() {
        TKKH tk = new TKKH(); // Giả sử có constructor mặc định
        System.out.println("Nhập thông tin tài khoản mới:");
        tk.nhapThongTin(); // Nhập thông tin tài khoản
        list.add(tk); // Thêm tài khoản vào danh sách
        System.out.println("Thêm tài khoản thành công!");
    }

    public TKKH kiemTraDangNhap(String username, String password) {
        for (TKKH user : list ) {
            if (user.getTenDangNhap().equals(username) && user.getMaTkhau().equals(password)) {
                return user; // Nếu tìm thấy tài khoản với mật khẩu đúng
            }
        }
        return null; // Không tìm thấy tài khoản
    }
    // Hàm sửa thông tin tài khoản
    public static void suaTKKH() {
        Scanner scanner = new Scanner(System.in);
        KIEMTRA kt = new KIEMTRA();
        System.out.print("Nhập mã tài khoản cần sửa: ");
        String maTK = scanner.nextLine();
        TKKH tk = timTaiKhoan(maTK);

        if (tk != null) {
            System.out.println("Chọn thông tin cần cập nhật:");
            System.out.println("1. Tên đăng nhập");
            System.out.println("2. Mật khẩu");
            System.out.println("3. Số điện thoại");
            System.out.println("4. CCCD");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Để bỏ qua ký tự newline

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập tên đăng nhập mới: ");
                    String tenDangNhap = scanner.nextLine();
                    tk.setTenDangNhap(tenDangNhap); // Giả sử có phương thức setTenDangNhap()
                    System.out.println("Cập nhật tên đăng nhập thành công!");
                    break;
                case 2:
                    System.out.print("Nhập mật khẩu mới: ");
                    String matKhau = scanner.nextLine();
                    tk.setMaTkhau(matKhau); // Giả sử có phương thức setMatKhau()
                    System.out.println("Cập nhật mật khẩu thành công!");
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại mới: ");
                    String soDienThoai = scanner.nextLine();
                    if (kt.checkSdt(soDienThoai)) { // Giả sử có phương thức checkSoDienThoai()
                        tk.setSoDienThoai(soDienThoai); // Giả sử có phương thức setSoDienThoai()
                        System.out.println("Cập nhật số điện thoại thành công!");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập CCCD mới: ");
                    String cccd = scanner.nextLine();
                    if (kt.checkCCCD(cccd)) { // Giả sử có phương thức checkCCCD()
                        tk.setCCCD(cccd); // Giả sử có phương thức setCCCD()
                        System.out.println("Cập nhật CCCD thành công!");
                    } else {
                        System.out.println("CCCD không hợp lệ.");
                    }
                    break;
                case 0:
                    System.out.println("Thoát không cập nhật!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } else {
            System.out.println("Tài khoản không tồn tại!");
        }
    }

    // Hàm xóa tài khoản
    public static void xoaTKKH() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã tài khoản cần xóa: ");
        String maTK = scanner.nextLine();
        TKKH tk = timTaiKhoan(maTK);

        if (tk != null) {
            list.remove(tk); // Xóa tài khoản khỏi danh sách
            System.out.println("Xóa tài khoản thành công!");
        } else {
            System.out.println("Tài khoản không tồn tại!");
        }
    }

    // Hàm in danh sách tài khoản
    public static void inDanhSach() {
        if (list.isEmpty()) {
            System.out.println("Danh sách tài khoản rỗng!");
            return;
        }
        System.out.println("Danh sách tài khoản:");
        for (TKKH tk : list) {
            tk.inThongTin(); // In thông tin từng tài khoản
        }
    }

    // Hàm kiểm tra danh sách rỗng
    public static boolean isEmpty() {
        return list.isEmpty();
    }

    // Hàm tìm tài khoản theo mã tài khoản
    public static TKKH timTaiKhoan(String maTK) {
        for (TKKH tk : list) {
            if (tk.getMaTK().equals(maTK)) { // so sánh mã tài khoản
                return tk; // Trả về tài khoản nếu tìm thấy
            }
        }
        return null; // Không tìm thấy
    }

    // Hàm chính để tương tác với người dùng
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n--- MENU QUẢN LÝ TÀI KHOẢN ---");
            System.out.println("1. Thêm tài khoản");
            System.out.println("2. Sửa thông tin tài khoản");
            System.out.println("3. Xóa tài khoản");
            System.out.println("4. In danh sách tài khoản");
            System.out.println("5. Kiểm tra danh sách rỗng");
            System.out.println("6. Tìm tài khoản");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Để bỏ qua ký tự newline

            switch (luaChon) {
                case 1:
                    themTKKH();
                    break;
                case 2:
                    suaTKKH();
                    break;
                case 3:
                    xoaTKKH();
                    break;
                case 4:
                    inDanhSach();
                    break;
                case 5:
                    if (isEmpty()) {
                        System.out.println("Danh sách tài khoản rỗng!");
                    } else {
                        System.out.println("Danh sách tài khoản không rỗng.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập mã tài khoản cần tìm: ");
                    String maTim = scanner.nextLine();
                    TKKH tkTim = timTaiKhoan(maTim);
                    if (tkTim != null) {
                        System.out.println("Tài khoản tìm thấy:");
                        tkTim.inThongTin(); // In thông tin tài khoản
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;
                case 0:
                    System.out.println("Thoát khỏi quản lý tài khoản!");
                    break;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }
    // Hàm đăng ký tài khoản
    public void dangKyTaiKhoan() {
        TKKH tk = new TKKH(); // Khởi tạo đối tượng TKKH mới
        System.out.println("Nhập thông tin tài khoản mới:");
        tk.nhapThongTin(); // Nhập thông tin tài khoản

        // Kiểm tra xem tài khoản đã tồn tại chưa
        if (timTaiKhoan(tk.getMaTK()) != null) {
            System.out.println("Tài khoản đã tồn tại! Vui lòng chọn mã tài khoản khác.");
        } else {
            list.add(tk); // Thêm tài khoản vào danh sách
            System.out.println("Đăng ký tài khoản thành công!");
        }
    }
    // Hàm quên mật khẩu
    public void quenMatKhau() {
        KIEMTRA kt = new KIEMTRA();
        System.out.print("Nhập mã tài khoản để lấy lại mật khẩu: ");
        String maTK = scanner.nextLine();
        TKKH tk = timTaiKhoan(maTK);

        if (tk != null) {
            int attempts = 0; // Biến đếm số lần nhập sai
            boolean isAuthenticated = false; // Biến xác nhận

            while (attempts < 3 && !isAuthenticated) {
                System.out.print("Nhập CCCD: ");
                String cccd = scanner.nextLine();
                System.out.print("Nhập số điện thoại: ");
                String soDienThoai = scanner.nextLine();

                // Kiểm tra thông tin xác thực
                if (tk.getCCCD().equals(cccd) && tk.getSoDienThoai().equals(soDienThoai)) {
                    isAuthenticated = true; // Nếu thông tin đúng, xác nhận
                } else {
                    attempts++;
                    System.out.println("Thông tin không hợp lệ. Bạn đã nhập sai " + attempts + " lần.");
                }
            }

            if (isAuthenticated) {
                String matKhauCu = tk.getMaTkhau(); // Lấy mật khẩu cũ
                String matKhauMoi = "";
                boolean validNewPassword = false; // Biến xác nhận mật khẩu mới hợp lệ

                while (!validNewPassword) {
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Nhập mật khẩu: ");
                        matKhauMoi = scanner.nextLine();
                        if (kt.kiemTraDoManhMatKhau(matKhauMoi)) {
                            break;
                        } else {
                            System.out.println("Mật khẩu không hợp lệ! (Cần ít nhất 6 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt)");
                        }
                        if (i == 2) {
                            System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi chức năng.");
                            return;
                        }
                    }
                    if (matKhauMoi.equals(matKhauCu)) {
                        System.out.println("Mật khẩu mới không được trùng với mật khẩu cũ. Vui lòng nhập lại.");
                    } else {
                        tk.setMaTkhau(matKhauMoi); // Cập nhật mật khẩu mới
                        validNewPassword = true; // Nếu mật khẩu hợp lệ, thoát khỏi vòng lặp
                        System.out.println("Đã cập nhật mật khẩu thành công!");
                    }
                }
            } else {
                System.out.println("Bạn đã nhập sai quá 3 lần. Không thể đổi mật khẩu.");
            }
        } else {
            System.out.println("Mã tài khoản không tồn tại.");
        }
    }

}
