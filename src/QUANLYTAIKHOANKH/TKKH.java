package QUANLYTAIKHOANKH;

import QUANLYPHONG.DANHSACHPHONG;
import QUANLYPHONG.PHONG;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class TKKH {
    private String MaTK;
    private String tenDangNhap;
    private String maTkhau;
    private String SoDienThoai;
    private String CCCD;
    public int soDu;
    public ArrayList<PHONG> danhSachPhongThue = new ArrayList<>();
    List<String> danhSachMaTK = new ArrayList<>();
    List<String> danhSachCCCD = new ArrayList<>();
    List<String> danhSachSDT = new ArrayList<>();
    List<String> lichSuGiaoDich = new ArrayList<>();

    public TKKH() {
    }
    public TKKH(String maTK, String tenDangNhap, String maTkhau, String soDienThoai, String cccd, int soDu) {
        MaTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.maTkhau = maTkhau;
        SoDienThoai = soDienThoai;
        CCCD = cccd;
        this.soDu = soDu;
    }
    public String getMaTK() {
        return this.MaTK;
    }

    public void setMaTK(String maTK) {
        this.MaTK = maTK;
    }

    public String getCCCD() {
        return this.CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoDienThoai() {
        return this.SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.SoDienThoai = soDienThoai;
    }

    public String getMaTkhau() {
        return this.maTkhau;
    }

    public void setMaTkhau(String maTkhau) {
        this.maTkhau = maTkhau;
    }

    public String getTenDangNhap() {
        return this.tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public boolean nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        KIEMTRA kt = new KIEMTRA();

        // Nhập mã tài khoản
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mã tài khoản: ");
            this.MaTK = scanner.nextLine();
            if (!this.MaTK.isEmpty()) {
                if (danhSachMaTK.contains(this.MaTK)) {
                    System.out.println("Mã tài khoản đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachMaTK.add(this.MaTK); // Thêm vào danh sách
                    break; // Mã tài khoản hợp lệ
                }
            } else {
                System.out.println("Mã tài khoản không được để trống!");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập tên đăng nhập
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập tên đăng nhập: ");
            this.tenDangNhap = scanner.nextLine();
            if (kt.checkTenTK(this.tenDangNhap)) {
                break; // Tên đăng nhập hợp lệ
            } else {
                System.out.println("Tên đăng nhập không hợp lệ! (Không chứa số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập mật khẩu
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mật khẩu: ");
            this.maTkhau = scanner.nextLine();
            if (kt.kiemTraDoManhMatKhau(this.maTkhau)) {
                break; // Mật khẩu hợp lệ
            } else {
                System.out.println("Mật khẩu không hợp lệ! (Cần ít nhất 6 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập số điện thoại
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số điện thoại: ");
            this.SoDienThoai = scanner.nextLine();
            if (kt.checkSdt(this.SoDienThoai)) {
                if (danhSachSDT.contains(this.SoDienThoai)) {
                    System.out.println("Số điện thoại đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachSDT.add(this.SoDienThoai); // Thêm vào danh sách
                    break; // Số điện thoại hợp lệ
                }
            } else {
                System.out.println("Số điện thoại không hợp lệ! (Cần 10 hoặc 11 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số CCCD: ");
            this.CCCD = scanner.nextLine();
            if (kt.checkCCCD(this.CCCD)) {
                if (danhSachCCCD.contains(this.CCCD)) {
                    System.out.println("Số CCCD đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachCCCD.add(this.CCCD); // Thêm vào danh sách
                    break; // CCCD hợp lệ
                }
            } else {
                System.out.println("Số CCCD không hợp lệ! (Cần 12 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }
        // Nhập số dư
        while (true) {
            System.out.print("Nhập số dư (phải lớn hơn 0): ");
            soDu = scanner.nextInt();
            if (soDu > 0) {
                break; // Số dư hợp lệ
            } else {
                System.out.println("Số dư phải lớn hơn 0! Vui lòng nhập lại.");
            }
        }
        // Nhập số CCCD


        return true; // Trả về true nếu tất cả thông tin hợp lệ
    }

    public boolean nhapThongTin2() {
        Scanner scanner = new Scanner(System.in);
        KIEMTRA kt = new KIEMTRA();

        // Nhập mã tài khoản
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mã tài khoản: ");
            this.MaTK = scanner.nextLine();
            if (!this.MaTK.isEmpty()) {
                if (danhSachMaTK.contains(this.MaTK)) {
                    System.out.println("Mã tài khoản đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachMaTK.add(this.MaTK); // Thêm vào danh sách
                    break; // Mã tài khoản hợp lệ
                }
            } else {
                System.out.println("Mã tài khoản không được để trống!");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập tên đăng nhập
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập tên đăng nhập: ");
            this.tenDangNhap = scanner.nextLine();
            if (kt.checkTenTK(this.tenDangNhap)) {
                break; // Tên đăng nhập hợp lệ
            } else {
                System.out.println("Tên đăng nhập không hợp lệ! (Không chứa số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập mật khẩu
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mật khẩu: ");
            this.maTkhau = scanner.nextLine();
            if (kt.kiemTraDoManhMatKhau(this.maTkhau)) {
                break; // Mật khẩu hợp lệ
            } else {
                System.out.println("Mật khẩu không hợp lệ! (Cần ít nhất 6 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }

        // Nhập số điện thoại
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số điện thoại: ");
            this.SoDienThoai = scanner.nextLine();
            if (kt.checkSdt(this.SoDienThoai)) {
                if (danhSachSDT.contains(this.SoDienThoai)) {
                    System.out.println("Số điện thoại đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachSDT.add(this.SoDienThoai); // Thêm vào danh sách
                    break; // Số điện thoại hợp lệ
                }
            } else {
                System.out.println("Số điện thoại không hợp lệ! (Cần 10 hoặc 11 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số CCCD: ");
            this.CCCD = scanner.nextLine();
            if (kt.checkCCCD(this.CCCD)) {
                if (danhSachCCCD.contains(this.CCCD)) {
                    System.out.println("Số CCCD đã tồn tại! Vui lòng nhập lại.");
                } else {
                    danhSachCCCD.add(this.CCCD); // Thêm vào danh sách
                    break; // CCCD hợp lệ
                }
            } else {
                System.out.println("Số CCCD không hợp lệ! (Cần 12 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return false; // Trả về false khi nhập sai quá 3 lần
            }
        }
        // Nhập số dư
        soDu = 0;
        // Nhập số CCCD


        return true; // Trả về true nếu tất cả thông tin hợp lệ
    }


    // Hàm in thông tin tài khoản
    public void inThongTin() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Mã tài khoản : " + this.MaTK);
        System.out.println("Tên đăng nhập : " + this.tenDangNhap);
        System.out.println("Mật khẩu : " + this.maTkhau);
        System.out.println("Số điện thoại: " + this.SoDienThoai);
        System.out.println("Số Dư: " + this.soDu);
        System.out.println("CCCD: " + this.CCCD);
    }
    public void in() {
        int i = 0;
        for (PHONG p : danhSachPhongThue) {
            System.out.print(++i); p.Xuat2();
        }
    }

    public void rutTien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- RÚT TIỀN KHỎI TÀI KHOẢN KHACH SAN --");

        // Nhập thông tin tài khoản
        System.out.print("Nhập số tài khoản: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhập tên ngân hàng: ");
        String tenNganHang = scanner.nextLine();

        System.out.println("======== THÔNG TIN TÀI KHOẢN ========");
        System.out.println("||  Tên ngân hàng : " + tenNganHang);
        System.out.println("||  Số tài khoản  : " + soTaiKhoan);
        System.out.println("||  Số dư của tài khoản phần mềm         : " + this.soDu);
        System.out.println("||==================================||");

        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số tiền bạn muốn rút: ");
            int soTienRut = scanner.nextInt();

            try {
                if (soTienRut > 0 && soTienRut <= this.soDu) { // Kiểm tra số tiền rút hợp lệ
                    this.soDu -= soTienRut; // Giảm số tiền rút từ số dư
                    String giaoDich = "Rút tiền: " + soTienRut + " VNĐ, Số dư hiện tại: " + this.soDu;
                    lichSuGiaoDich.add(giaoDich);
                    System.out.println("Rút tiền thành công! Số dư hiện tại: " + this.soDu);
                    return; // Thoát khỏi phương thức sau khi rút thành công
                } else if (soTienRut <= 0) {
                    System.out.println("Số tiền rút không hợp lệ, phải lớn hơn 0!");
                } else {
                    System.out.println("Số tiền rút không hợp lệ, số dư không đủ!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Đầu vào không hợp lệ, vui lòng nhập một số nguyên hợp lệ!");
                scanner.next(); // Xóa bỏ đầu vào không hợp lệ
            }

            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }
    }
    public void napTien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-- NẠP TIỀN VÀO TÀI KHOẢN KHACH SAN--");
        System.out.println("======== THÔNG TIN TÀI KHOẢN ========");
        System.out.println("||  Tên tài khoản : KHACHSANTHREE   ||");
        System.out.println("||  Số tài khoản  : 0866835863      ||");
        System.out.println("||  Ngân hàng     : MBBANK          ||");
        System.out.println("||==================================||");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số tiền bạn muốn nạp: ");
            int soTienNap = scanner.nextInt();

            try {
                if (soTienNap > 0) {
                    this.soDu += soTienNap; // Cộng số tiền nạp vào số dư
                    String giaoDich = "Nạp tiền: " + soTienNap + " VNĐ, Số dư hiện tại: " + this.soDu;
                    lichSuGiaoDich.add(giaoDich); // Thêm vào lịch sử giao dịch
                    System.out.println("Nạp tiền thành công! Số dư hiện tại: " + this.soDu);
                    return; // Thoát khỏi phương thức sau khi nạp thành công
                } else {
                    System.out.println("Số tiền nạp không hợp lệ, phải lớn hơn 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ, vui lòng nhập một số nguyên hợp lệ!");
            }

            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }
    }
    public void hienThiLichSuGiaoDich() {
        System.out.println("======== LỊCH SỬ GIAO DỊCH ========");
        for (String giaoDich : lichSuGiaoDich) {
            System.out.println(giaoDich);
        }
        System.out.println("||==================================||");
    }
    public PHONG timPhongDaDat(String maPhong) {
        for (PHONG p : danhSachPhongThue) {
            if (maPhong.equals(p.getMaPhong())) {
                return p;
            }
        }
        return null;
    }
    public void xoaPhong(String maPhong) {
        danhSachPhongThue.removeIf(phong -> phong.getMaPhong().equals(maPhong));
        }
    @Override
    public String toString() {
        return MaTK + "," + tenDangNhap + "," + maTkhau + "," + SoDienThoai + "," + CCCD + "," + soDu;
    }
}








