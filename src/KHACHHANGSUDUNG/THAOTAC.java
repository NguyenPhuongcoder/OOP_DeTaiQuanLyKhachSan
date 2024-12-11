package KHACHHANGSUDUNG;

import QUANLLYDICHVU.mainQLDV;
import QUANLYKHACHHANG.*;
import QUANLYNHANVIEN.LISTNHANVIEN;

import QUANLYPHONG.DANHSACHPHONG;
import QUANLYPHONG.PHONG;
import QUANLYPHONG.PHONGTHUONG;
import QUANLYPHONG.PHONGVIP;
import QUANLYTAIKHOANKH.LISTTKKH;
import QUANLYTAIKHOANKH.TKKH;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public  class THAOTAC {
    private static final String USERNAME = "admin"; // Tên người dùng mặc định
    private static final String PASSWORD = "123456"; // Mật khẩu mặc định
    static KhachHangList  khachHangList = new KhachHangList();
    static LISTNHANVIEN listNhanVien = new LISTNHANVIEN();
    static LISTTKKH  menu = new LISTTKKH();
    static DANHSACHPHONG danhSachPhong = new DANHSACHPHONG();
    static mainQLDV me = new mainQLDV();
    private static List<String> danhSachfb = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("===== MENU =====");
            System.out.println("1. Đăng nhập với tư cách QUẢN LÝ");
            System.out.println("2. Đăng nhập với tư cách NGƯỜI SỬ DỤNG");
            System.out.println("3. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn (1/2/3): ");

            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn đăng nhập với tư cách QUẢN LÝ.");
                    QUANLY();
                    break;
                case 2:
                    System.out.println("Bạn đã chọn đăng nhập với tư cách NGƯỜI SỬ DỤNG.");
                    menu();
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Cảm ơn bạn!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }

            System.out.println(); // In một dòng trống cho dễ đọc giữa các lần chọn

        } while (choice != 3); // Tiếp tục hiển thị menu cho đến khi người dùng chọn thoát

        scanner.close(); // Đóng Scanner
    }


    // MENU KHACH HANG SU DUNG
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n--- MENU KHÁCH HÀNG ---");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký tài khoản");
            System.out.println("3. Quên mật khẩu");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Để bỏ qua ký tự newline

            switch (luaChon) {
                case 1:
                    dangNhap();
                    break;
                case 2:
                    menu.dangKyTaiKhoan();
                    break;
                case 3:
                    menu.quenMatKhau();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void dangNhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên đăng nhập: ");
        String username = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();
        // Kiểm tra đăng nhập ở đây (giả sử có phương thức kiểm tra)
        TKKH tk = menu.kiemTraDangNhap(username, password);
        if (tk != null) {
            System.out.println("Đăng nhập thành công!");
            menuKhachHang(tk); // Gọi menu cho khách hàng
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng.");
        }
    }

    public static void menuKhachHang(TKKH tk) {
        Scanner scanner = new Scanner(System.in);
        tk = new TKKH();
        int luaChonKH;
        do {
            System.out.println("\n--- MENU KHÁCH HÀNG ---");
            System.out.println("1. Đặt phòng");
            System.out.println("2. Hủy phòng");
            System.out.println("3. Xem thông tin phòng");
            System.out.println("4. Xem thông tin đặt phòng");
            System.out.println("5. Thanh toán tiền phòng");
            System.out.println("6. Nạp tiền vào tài khoản");
            System.out.println("7. Đánh giá khách hàng");
            System.out.println("0. Đăng xuất");
            System.out.print("Chọn chức năng: ");
            luaChonKH = scanner.nextInt();
            scanner.nextLine(); // Để bỏ qua ký tự newline

            switch (luaChonKH) {
                case 1:
                    datPhong(tk);
                    break;
                case 2:
                    huyPhong(tk);
                    break;
                case 3:
                    xemThongTinPhong();
                    break;
                case 4:
                    xemThongTinDatPhong(tk);
                    break;
                case 5:
                    thanhToan(tk);
                    break;
                case 6:
                    tk.napTien();
                    break;
                case 7:
                    danhGiaKhachHang();
                    break;
                case 0:
                    System.out.println("Đăng xuất thành công.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChonKH != 0);
    }

    private static void datPhong(TKKH tk) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ĐẶT PHÒNG ---");
        while (true) {
            System.out.println("Chọn một lựa chọn:");
            System.out.println("1. Tìm kiếm");
            System.out.println("2. Xác nhận đặt phòng");
            System.out.println("3. Thoát");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc phần xuống dòng còn lại

                switch (choice) {
                    case 1:
                        String[] validRoomTypes = {"Vip", "Thường"};
                        boolean isValidRoomType = false;
                        String chonLPhong;

                        // Nhập loại phòng
                        while (true) {
                            System.out.println("Chọn loại phòng (Vip/Thường):");
                            chonLPhong = scanner.nextLine();

                            // Kiểm tra xem loại phòng có hợp lệ hay không
                            for (String roomType : validRoomTypes) {
                                if (chonLPhong.equalsIgnoreCase(roomType)) {
                                    isValidRoomType = true;
                                    break; // Ngắt vòng lặp khi tìm thấy loại phòng hợp lệ
                                }
                            }

                            if (!isValidRoomType) {
                                System.out.println("Loại phòng không hợp lệ. Vui lòng nhập lại.");
                            } else {
                                break; // Thoát khỏi vòng lặp nếu loại phòng hợp lệ
                            }

                            isValidRoomType = false; // Đặt lại trạng thái kiểm tra cho lần nhập tiếp theo
                        }

                        double dienTichPhong;
                        // Nhập diện tích phòng
                        while (true) try {
                            System.out.print("Chọn diện tích phòng (25 m² - 40 m² - 60 m²): ");
                            dienTichPhong = scanner.nextDouble();
                            scanner.nextLine(); // Đọc phần xuống dòng còn lại

                            if (dienTichPhong < 0 || (dienTichPhong != 25 && dienTichPhong != 40 && dienTichPhong != 60)) {
                                System.out.println("Diện tích không hợp lệ. Vui lòng nhập lại.");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Diện tích phải là số. Vui lòng nhập lại.");
                            scanner.next(); // Làm sạch bộ đệm đầu vào
                        }

                        // In thông tin phòng đã chọn
                        danhSachPhong.in(chonLPhong, dienTichPhong);
                        break;

                    case 2:
                        System.out.print("Chọn mã phòng để đặt: ");
                        String maPhong = scanner.nextLine();
                        PHONG p = danhSachPhong.tim2(maPhong);
                        if (p == null) {
                            System.out.println("Vui lòng tìm kiếm lại ! ");
                            continue; // Quay lại vòng lặp nếu không tìm thấy phòng
                        }

                        // Nhập ngày đến
                        LocalDateTime ngayDen = null;
                        while (true) {
                            System.out.print("Nhập ngày đến (yyyy-MM-dd HH:mm): ");
                            String inputNgayDen = scanner.nextLine();
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                ngayDen = LocalDateTime.parse(inputNgayDen, formatter);
                                p.setNgayNhanPhong(ngayDen); // Giả định phương thức này có sẵn
                                break; // Thoát vòng lặp nếu nhập ngày hợp lệ
                            } catch (DateTimeParseException e) {
                                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                            }
                        }

                        // Nhập ngày đi
                        LocalDateTime ngayDi = null;
                        while (true) {
                            System.out.print("Nhập ngày đi (yyyy-MM-dd HH:mm): ");
                            String inputNgayDi = scanner.nextLine();
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                ngayDi = LocalDateTime.parse(inputNgayDi, formatter);
                                // Kiểm tra nếu ngày đi không sớm hơn ngày đến
                                if (ngayDi.isBefore(ngayDen)) {
                                    System.out.println("Ngày đi không thể sớm hơn ngày đến. Vui lòng nhập lại.");
                                    continue;
                                }
                                break; // Thoát vòng lặp nếu nhập ngày hợp lệ
                            } catch (DateTimeParseException e) {
                                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                            }
                        }
                        p.setTinhTrangPhong("Đang thuê");
                        tk.danhSachPhongThue.add(p);
                        System.out.println("Đặt phòng thành công với mã phòng: " + maPhong);
                        break;

                    case 3:
                        System.out.println("Đang thoát...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn phải là số. Vui lòng nhập lại.");
                scanner.next(); // Làm sạch bộ đệm đầu vào
            }
        }

    }



        private static void huyPhong(TKKH tk) {
            Scanner scanner = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            System.out.println("-- HỦY PHÒNG --");
            System.out.print("Nhập mã phòng: ");
            String maPhong = scanner.nextLine();

            // Kiểm tra xem phòng đã đặt hay chưa
            if (tk.timPhongDaDat(maPhong) != null) {
                LocalDateTime ngayHuy = null;
                boolean validDate = false;

                // Nhập ngày hủy
                while (!validDate) {
                    try {
                        System.out.print("Nhập ngày hủy (yyyy/MM/dd HH:mm): ");
                        String ngayHuyStr = scanner.nextLine();

                        // Chuyển đổi chuỗi ngày hủy thành LocalDateTime
                        ngayHuy = LocalDateTime.parse(ngayHuyStr, formatter);
                        validDate = true; // Đánh dấu là ngày hợp lệ
                    } catch (DateTimeParseException e) {
                        System.out.println("Ngày hủy không hợp lệ! Vui lòng nhập lại.");
                    }
                }

                // So sánh ngày hủy với ngày nhận phòng
                LocalDateTime ngayNhanPhong = tk.timPhongDaDat(maPhong).getNgayNhanPhong(); // Lấy ngày nhận phòng
                if (ngayHuy.isBefore(ngayNhanPhong)) {
                    System.out.println("Bạn đã hủy phòng.");
                    tk.xoaPhong(maPhong);
                    danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Trống");
                } else {
                    System.out.println("Không thể hủy đặt phòng vì ngày hủy đã qua ngày nhận phòng.");
                    System.out.println("Nếu bạn hủy thì bạn sẽ đền bù phí tổn thất đền cho khách sạn là 1.000.000 VNĐ");
                    System.out.print("Bạn có chắc chắn muốn hủy không? (CÓ/ KHÔNG): ");
                    String question = scanner.nextLine();

                    if (question.equalsIgnoreCase("CÓ")) {
                        // Kiểm tra số dư trước khi trừ
                        if (tk.soDu >= 1000000) {
                            tk.soDu -= 1000000; // Trừ phí tổn thất từ số dư
                            System.out.println("Hủy đặt phòng thành công.");
                            System.out.println("Số dư hiện tại của bạn là: " + tk.soDu + " VNĐ.");
                            tk.xoaPhong(maPhong);
                            danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Trống");
                        } else {
                            System.out.println("Số dư không đủ để thanh toán phí tổn thất.");
                        }
                    } else {
                        System.out.println("Bạn đã chọn không hủy đặt phòng.");
                    }
                }
            } else {
                System.out.println("Không tìm thấy phòng trên!");
            }
        }


    private static void xemThongTinPhong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- XEM THÔNG TIN PHÒNG CỦA KHÁCH SẠN --");
        while (true) {
            System.out.println("Chọn một lựa chọn:");
            System.out.println("1. Tìm kiếm");
            System.out.println("2. Thoát");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc phần xuống dòng còn lại

                switch (choice) {
                    case 1:
                        String[] validRoomTypes = {"Vip", "Thường"};
                        boolean isValidRoomType = false;
                        String chonLPhong;

                        // Nhập loại phòng
                        while (true) {
                            System.out.println("Chọn loại phòng (Vip/Thường):");
                            chonLPhong = scanner.nextLine();

                            // Kiểm tra xem loại phòng có hợp lệ hay không
                            for (String roomType : validRoomTypes) {
                                if (chonLPhong.equalsIgnoreCase(roomType)) {
                                    isValidRoomType = true;
                                    break; // Ngắt vòng lặp khi tìm thấy loại phòng hợp lệ
                                }
                            }

                            if (!isValidRoomType) {
                                System.out.println("Loại phòng không hợp lệ. Vui lòng nhập lại.");
                            } else {
                                break; // Thoát khỏi vòng lặp nếu loại phòng hợp lệ
                            }

                            isValidRoomType = false; // Đặt lại trạng thái kiểm tra cho lần nhập tiếp theo
                        }

                        double dienTichPhong;
                        // Nhập diện tích phòng
                        while (true) try {
                            System.out.print("Chọn diện tích phòng (25 m² - 40 m² - 60 m²): ");
                            dienTichPhong = scanner.nextDouble();
                            scanner.nextLine(); // Đọc phần xuống dòng còn lại

                            if (dienTichPhong < 0 || (dienTichPhong != 25 && dienTichPhong != 40 && dienTichPhong != 60)) {
                                System.out.println("Diện tích không hợp lệ. Vui lòng nhập lại.");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Diện tích phải là số. Vui lòng nhập lại.");
                            scanner.next(); // Làm sạch bộ đệm đầu vào
                        }

                        // In thông tin phòng đã chọn
                        danhSachPhong.in(chonLPhong, dienTichPhong);
                        break;
                    case 2:
                        System.out.println("Đang thoát...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn phải là số. Vui lòng nhập lại.");
                scanner.next(); // Làm sạch bộ đệm đầu vào
            }
        }
    }

    private static void xemThongTinDatPhong(TKKH tk) {
        System.out.println("-- THÔNG TIN PHÒNG ĐÃ ĐẶT --");
        tk.in();
    }


    private static void thanhToan(TKKH tk) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- THANH TOÁN --");
        System.out.print("Nhập mã phòng cần thanh toán: ");
        String maPhong = scanner.nextLine();

        if (tk.timPhongDaDat(maPhong) != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime ngayThanhToan = null;
            boolean validDate = false;


            while (!validDate) {
                try {
                    System.out.print("Nhập ngày thanh toán (yyyy/MM/dd HH:mm): ");
                    String ngayThanhToanStr = scanner.nextLine();
                    ngayThanhToan = LocalDateTime.parse(ngayThanhToanStr, formatter);
                    validDate = true; // Ngày hợp lệ
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày thanh toán không hợp lệ! Vui lòng nhập lại.");
                }
            }
            if(ngayThanhToan.isAfter(danhSachPhong.timPhong(maPhong).getNgayTraPhongDuKien()))
            {
                if (danhSachPhong.timPhong(maPhong) instanceof PHONGTHUONG){
                System.out.println("========== HÓA ĐƠN PHÒNG THƯỜNG ==========");
                System.out.println("||  Mã Phòng                :"+danhSachPhong.timPhong(maPhong).getMaPhong() );
                System.out.println("||  Ngày nhận phòng         :"+danhSachPhong.timPhong(maPhong).getNgayNhanPhong().format(formatter));
                System.out.println("||  Ngày trả phòng          :"+ngayThanhToan.format(formatter));
                System.out.println("||  Phí phụ thu             :"+"100 VNĐ");
                System.out.println("||  Giảm giá                :"+((PHONGTHUONG) danhSachPhong.timPhong(maPhong)).getPhanTramGiamGia()+"%");
                System.out.println("||  Số ngày sử dụng giảm giá:"+((PHONGTHUONG) danhSachPhong.timPhong(maPhong)).getThoiGianSudungGiamGia()+"Ngày");
                System.out.println("||  Số tiền phải trả        :"+danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)+100+"VNĐ");
                System.out.println("||=====================================||");
                System.out.println("LÝ DO: VÌ QUÝ KHÁCH CHECK OUT MUỘN NÊN THU THÊM PHÍ PHỤ THU LÀ 100 VNĐ");
                System.out.println("===== THANH TOÁN =====");
                System.out.println("Chọn 1 để thanh toán / số bất kì để hủy:");
                    int maxAttempts = 3;
                    boolean validChoice = false;

                    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                        System.out.println("Nhập lựa chọn của bạn (1: Thanh toán, 2: Hủy thao tác): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Đọc dòng thừa

                        if (choice == 1) {
                            if (tk.soDu < danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan) + 100) {
                                System.out.println("Số dư của bạn không đủ, cần nạp tiền thêm !");
                            } else {
                                tk.soDu -= danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan) + 100;
                                System.out.println("Bạn đã thanh toán thành công!");
                                System.out.println("Số dư hiện tại của bạn là: " + tk.soDu + " VNĐ");
                                tk.xoaPhong(maPhong);
                                danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Đang dọn dẹp");
                                validChoice = true; // Đánh dấu rằng thanh toán đã thành công
                                break; // Thoát vòng lặp nếu thanh toán thành công
                            }
                        } else if (choice == 2) {
                            System.out.println("Bạn đã hủy thao tác thanh toán!");
                            validChoice = true; // Đánh dấu hợp lệ trong trường hợp hủy
                            break; // Thoát vòng lặp nếu hủy
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }

                        // Nếu người dùng đã cố gắng 3 lần mà vẫn không đúng
                        if (attempt == maxAttempts) {
                            System.out.println("Bạn đã nhập sai quá nhiều lần. Vui lòng thử lại sau.");
                        }
                    }

// Xử lý cho trường hợp khi người dùng không thực hiện thành công thanh toán hoặc hủy thao tác
                    if (!validChoice) {
                        System.out.println("Thanh toán không thành công. Vui lòng thử lại!");
                    }
                }else{
                    if (danhSachPhong.timPhong(maPhong) instanceof PHONGVIP){
                        System.out.println("========== HÓA ĐƠN PHÒNG THƯỜNG ==========");
                        System.out.println("||  Mã Phòng                :"+danhSachPhong.timPhong(maPhong).getMaPhong() );
                        System.out.println("||  Ngày nhận phòng         :"+danhSachPhong.timPhong(maPhong).getNgayNhanPhong().format(formatter));
                        System.out.println("||  Ngày trả phòng          :"+ngayThanhToan.format(formatter));
                        System.out.println("||  Phí phụ thu             :"+"100 VNĐ");
                        System.out.println("||  Giảm giá                :"+((PHONGVIP) danhSachPhong.timPhong(maPhong)).getPhanTramGiamGia()+"%");
                        System.out.println("||  Số tiện ích             :"+((PHONGVIP) danhSachPhong.timPhong(maPhong)).getTienich().length);
                        System.out.println("||  Giá mỗi tiện ích        :100 VNĐ");
                        System.out.println("||  Số tiền phải trả        :"+danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)+100+"VNĐ");
                        System.out.println("||=====================================||");
                        System.out.println("LÝ DO: VÌ QUÝ KHÁCH CHECK OUT MUỘN NÊN THU THÊM PHÍ PHỤ THU LÀ 100 VNĐ");
                        int maxAttempts = 3;
                        boolean validChoice = false;

                        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                            System.out.println("Nhập lựa chọn của bạn (1: Thanh toán, 2: Hủy thao tác): ");
                            int choice = scanner.nextInt();
                            scanner.nextLine(); // Đọc dòng thừa

                            if (choice == 1) {
                                if (tk.soDu < danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan) + 100) {
                                    System.out.println("Số dư của bạn không đủ, cần nạp tiền thêm !");
                                } else {
                                    tk.soDu -= danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan) + 100;
                                    System.out.println("Bạn đã thanh toán thành công!");
                                    System.out.println("Số dư hiện tại của bạn là: " + tk.soDu + " VNĐ");
                                    tk.xoaPhong(maPhong);
                                    danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Đang dọn dẹp");
                                    validChoice = true; // Đánh dấu rằng thanh toán đã thành công
                                    break; // Thoát vòng lặp nếu thanh toán thành công
                                }
                            } else if (choice == 2) {
                                System.out.println("Bạn đã hủy thao tác thanh toán!");
                                validChoice = true; // Đánh dấu hợp lệ trong trường hợp hủy
                                break; // Thoát vòng lặp nếu hủy
                            } else {
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                            }

                            // Nếu người dùng đã cố gắng 3 lần mà vẫn không đúng
                            if (attempt == maxAttempts) {
                                System.out.println("Bạn đã nhập sai quá nhiều lần. Vui lòng thử lại sau.");
                            }
                        }

// Xử lý cho trường hợp khi người dùng không thực hiện thành công thanh toán hoặc hủy thao tác
                        if (!validChoice) {
                            System.out.println("Thanh toán không thành công. Vui lòng thử lại!");
                        }
                    }
                }
            }else{
                if (danhSachPhong.timPhong(maPhong) instanceof PHONGTHUONG){
                    System.out.println("========== HÓA ĐƠN PHÒNG THƯỜNG ==========");
                    System.out.println("||  Mã Phòng                :"+danhSachPhong.timPhong(maPhong).getMaPhong() );
                    System.out.println("||  Ngày nhận phòng         :"+danhSachPhong.timPhong(maPhong).getNgayNhanPhong().format(formatter));
                    System.out.println("||  Ngày trả phòng          :"+ngayThanhToan.format(formatter));
                    System.out.println("||  Giảm giá                :"+((PHONGTHUONG) danhSachPhong.timPhong(maPhong)).getPhanTramGiamGia()+"%");
                    System.out.println("||  Số ngày sử dụng giảm giá:"+((PHONGTHUONG) danhSachPhong.timPhong(maPhong)).getThoiGianSudungGiamGia()+"Ngày");
                    System.out.println("||  Số tiền phải trả        :"+danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)+"VNĐ");
                    System.out.println("||=====================================||");
                    int maxAttempts = 3;
                    boolean validChoice = false;

                    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                        System.out.println("Nhập lựa chọn của bạn (1: Thanh toán, 2: Hủy thao tác): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Đọc dòng thừa

                        if (choice == 1) {
                            if (tk.soDu < danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)) {
                                System.out.println("Số dư của bạn không đủ, cần nạp tiền thêm !");
                            } else {
                                tk.soDu -= danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan);
                                System.out.println("Bạn đã thanh toán thành công!");
                                System.out.println("Số dư hiện tại của bạn là: " + tk.soDu + " VNĐ");
                                tk.xoaPhong(maPhong);
                                danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Đang dọn dẹp");
                                validChoice = true; // Đánh dấu rằng thanh toán đã thành công
                                break; // Thoát vòng lặp nếu thanh toán thành công
                            }
                        } else if (choice == 2) {
                            System.out.println("Bạn đã hủy thao tác thanh toán!");
                            validChoice = true; // Đánh dấu hợp lệ trong trường hợp hủy
                            break; // Thoát vòng lặp nếu hủy
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }

                        // Nếu người dùng đã cố gắng 3 lần mà vẫn không đúng
                        if (attempt == maxAttempts) {
                            System.out.println("Bạn đã nhập sai quá nhiều lần. Vui lòng thử lại sau.");
                        }
                    }

// Xử lý cho trường hợp khi người dùng không thực hiện thành công thanh toán hoặc hủy thao tác
                    if (!validChoice) {
                        System.out.println("Thanh toán không thành công. Vui lòng thử lại!");
                    }
                }else{
                    if (danhSachPhong.timPhong(maPhong) instanceof PHONGVIP){
                        System.out.println("========== HÓA ĐƠN PHÒNG THƯỜNG ==========");
                        System.out.println("||  Mã Phòng                :"+danhSachPhong.timPhong(maPhong).getMaPhong() );
                        System.out.println("||  Ngày nhận phòng         :"+danhSachPhong.timPhong(maPhong).getNgayNhanPhong().format(formatter));
                        System.out.println("||  Ngày trả phòng          :"+ngayThanhToan.format(formatter));
                        System.out.println("||  Giảm giá                :"+((PHONGVIP) danhSachPhong.timPhong(maPhong)).getPhanTramGiamGia()+"%");
                        System.out.println("||  Số tiện ích             :"+((PHONGVIP) danhSachPhong.timPhong(maPhong)).getTienich().length);
                        System.out.println("||  Giá mỗi tiện ích        :100 VNĐ");
                        System.out.println("||  Số tiền phải trả        :"+danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)+"VNĐ");
                        System.out.println("||=====================================||");
                    }
                    int maxAttempts = 3;
                    boolean validChoice = false;

                    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                        System.out.println("Nhập lựa chọn của bạn (1: Thanh toán, 2: Hủy thao tác): ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Đọc dòng thừa

                        if (choice == 1) {
                            if (tk.soDu < danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan)) {
                                System.out.println("Số dư của bạn không đủ, cần nạp tiền thêm !");
                            } else {
                                tk.soDu -= danhSachPhong.timPhong(maPhong).tinhGiaPhong2(ngayThanhToan);
                                System.out.println("Bạn đã thanh toán thành công!");
                                System.out.println("Số dư hiện tại của bạn là: " + tk.soDu + " VNĐ");
                                tk.xoaPhong(maPhong);
                                danhSachPhong.timPhong(maPhong).setTinhTrangPhong("Đang dọn dẹp");
                                validChoice = true; // Đánh dấu rằng thanh toán đã thành công
                                break; // Thoát vòng lặp nếu thanh toán thành công
                            }
                        } else if (choice == 2) {
                            System.out.println("Bạn đã hủy thao tác thanh toán!");
                            validChoice = true; // Đánh dấu hợp lệ trong trường hợp hủy
                            break; // Thoát vòng lặp nếu hủy
                        } else {
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }

                        // Nếu người dùng đã cố gắng 3 lần mà vẫn không đúng
                        if (attempt == maxAttempts) {
                            System.out.println("Bạn đã nhập sai quá nhiều lần. Vui lòng thử lại sau.");
                        }
                    }

// Xử lý cho trường hợp khi người dùng không thực hiện thành công thanh toán hoặc hủy thao tác
                    if (!validChoice) {
                        System.out.println("Thanh toán không thành công. Vui lòng thử lại!");
                    }
                }

            }
        } else {
            System.out.println("Không tìm thấy phòng trên!");
        }
    }

    private static void danhGiaKhachHang() {
        Scanner scanner = new Scanner(System.in);
        int sao = 0;
        boolean validInput = false;

        // Kiểm tra giá trị nhập vào
        while (!validInput) {
            System.out.print("Đánh giá số sao (1-5): ");
            try {
                sao = scanner.nextInt();
                if (sao >= 1 && sao <= 5) {
                    validInput = true; // Giá trị hợp lệ, thoát vòng lặp
                } else {
                    System.out.println("Vui lòng nhập số sao hợp lệ (1-5).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập một số nguyên!");
                scanner.next(); // Xóa bỏ đầu vào không hợp lệ
            }
        }

        scanner.nextLine(); // Đọc dòng ký tự còn lại
        System.out.print("Đánh giá: ");
        String danhGia = scanner.nextLine();

        // Lưu vào danh sách
        danhSachfb.add(sao + "|" + danhGia);
        System.out.println("Cảm ơn bạn đã đánh giá!");
    }





    // MENU QUAN LY
    public static  void QUANLY() throws IOException {

            Scanner scanner = new Scanner(System.in);
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
                System.out.println("3. Quản lý khách hàng");
                System.out.println("4. Quản lý Tài khoản khách hàng");
                System.out.println("5. Quản lý dịch vụ");
                System.out.println("6. Thoát");
                System.out.print("Nhập lựa chọn của bạn: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        QuanLyPhong();
                        break;
                    case 2:
                        displayMenu();
                        break;
                    case 3:
                        MenuKhachHang();
                        break;
                    case 4:
                        menu.menu();
                        break;
                    case 5:
                        me.quanLy();
                        break;
                    case 6:
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
    // MENUQUANLY
    // MENU QUNALYKHACHHANG
    public static void MenuKhachHang() {
        Scanner scanner = new Scanner(System.in);

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
    // MENU QUAN LY KHACH HANG
    // MENU QUAN LY NHAN VIEN
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("------QUẢN LÝ NHÂN VIÊN-------");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Sửa thông tin nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Hiển thị danh sách nhân viên");
            System.out.println("5. Tìm nhân viên theo mã");
            System.out.println("6. Sắp xếp nhân viên theo mức lương");
            System.out.println("7. Tính tổng lương theo loại nhân viên");
            System.out.println("8. Thoát");
            System.out.print("Mời bạn chọn: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Đọc và bỏ qua newline
                switch (choice) {
                    case 1:
                        listNhanVien.themNhanVien();
                        break;
                    case 2:
                        System.out.print("Nhập mã nhân viên cần sửa: ");
                        String maNV = sc.nextLine();
                        listNhanVien.capNhapNhanVien(maNV);
                        break;
                    case 3:
                        System.out.print("Nhập mã nhân viên cần xóa: ");
                        String maXoa = sc.nextLine();
                        listNhanVien.xoaNhanVien(maXoa);
                        break;
                    case 4:
                        listNhanVien.hienThiDanhSach();
                        break;
                    case 5:
                        System.out.print("Nhập mã nhân viên cần tìm: ");
                        String maTim = sc.nextLine();
                        listNhanVien.timNhanVien(maTim);
                        break;
                    case 6:
                        listNhanVien.sapXepTheoLuong();
                        break;
                    case 7:
                        listNhanVien.tinhTongTienTheoTongLoaiNhanVien();
                        break;
                    case 8:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("DỮ LIỆU VÀO KHÔNG CHÍNH XÁC! Vui lòng chọn lại.");
                }
            } catch (InputMismatchException | ParseException e) {
                System.out.println("Dữ liệu nhập không hợp lệ. Vui lòng nhập số.");
                sc.next(); // Clear the invalid input
            }
        } while (choice != 8);
    }
    // MENU QUANLYNHANVIEN
    // MENUQUANLYPHONG
     public static   void QuanLyPhong() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- MENU QUẢN LÝ PHÒNG -----");
            System.out.println("1. Thêm danh sách phòng");
            System.out.println("2. Đọc danh sách phòng từ file");
            System.out.println("3. Ghi danh sách phòng vào file");
            System.out.println("4. In danh sách phòng");
            System.out.println("5. Tìm phòng theo mã");
            System.out.println("6. Xóa phòng theo mã");
            System.out.println("7. Sắp xếp phòng theo giá");
            System.out.println("8. Tính tổng tiền theo phòng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        danhSachPhong.nhap();
                    } catch (ParseException e) {
                        System.out.println("Lỗi khi nhập dữ liệu: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        danhSachPhong.DocFile();
                        System.out.println("Đọc danh sách phòng thành công!");
                    } catch (IOException e) {
                        System.out.println("Lỗi khi đọc file: " + e.getMessage());
                    }
                    break;
                case 3:
                    danhSachPhong.GhiFile();
                    System.out.println("Ghi danh sách phòng thành công!");
                    break;
                case 4:
                    danhSachPhong.in();
                    break;
                case 5:
                    System.out.print("Nhập mã phòng để tìm: ");
                    danhSachPhong.tim();
                    break;
                case 6:
                    System.out.print("Nhập mã phòng để xóa: ");
                    danhSachPhong.xoa();
                    break;
                case 7:
                    danhSachPhong.sapXep();
                    System.out.println("Sắp xếp phòng theo giá thành công!");
                    break;
                case 8:
                    danhSachPhong.tinhTongTienTheoPhong();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                    break;
            }
            System.out.println(); // In dòng trống để dễ đọc
        } while (choice != 0);

        scanner.close();

    }
}
