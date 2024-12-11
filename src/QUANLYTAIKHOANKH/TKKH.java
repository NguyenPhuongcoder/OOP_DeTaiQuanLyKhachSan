package QUANLYTAIKHOANKH;

import QUANLYPHONG.DANHSACHPHONG;
import QUANLYPHONG.PHONG;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class TKKH {
    private String MaTK;
    private String tenDangNhap;
    private String maTkhau;
    private String SoDienThoai;
    private String CCCD;
    public int soDu;
    public ArrayList<PHONG> danhSachPhongThue = new ArrayList<>();

    public TKKH() {
    }
    public TKKH(String maTK, String tenDangNhap, String maTkhau, String soDienThoai, String CCCD) {
        MaTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.maTkhau = maTkhau;
        SoDienThoai = soDienThoai;
        this.CCCD = CCCD;
    }
    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        MaTK = maTK;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getMaTkhau() {
        return maTkhau;
    }

    public void setMaTkhau(String maTkhau) {
        this.maTkhau = maTkhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        KIEMTRA kt = new KIEMTRA();
        // Nhập mã tài khoản
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mã tài khoản: ");
            this.MaTK = scanner.nextLine();
            if (!this.MaTK.isEmpty()) { // Kiểm tra xem có nhập hay không
                break;
            } else {
                System.out.println("Mã tài khoản không được để trống!");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }

        // Nhập tên đăng nhập
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập tên đăng nhập: ");
            this.tenDangNhap = scanner.nextLine();
            if (kt.checkTenTK(this.tenDangNhap)) {
                break;
            } else {
                System.out.println("Tên đăng nhập không hợp lệ! (Không chứa số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }

        // Nhập mật khẩu
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập mật khẩu: ");
            this.maTkhau = scanner.nextLine();
            if (kt.kiemTraDoManhMatKhau(this.maTkhau)) {
                break;
            } else {
                System.out.println("Mật khẩu không hợp lệ! (Cần ít nhất 6 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }

        // Nhập số điện thoại
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số điện thoại: ");
            this.SoDienThoai = scanner.nextLine();
            if (kt.checkSdt(this.SoDienThoai)) {
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ! (Cần 10 hoặc 11 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }
        soDu = 0;
        // Nhập số CCCD
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập số CCCD: ");
            this.CCCD = scanner.nextLine();
            if (kt.checkCCCD(this.CCCD)) {
                break;
            } else {
                System.out.println("Số CCCD không hợp lệ! (Cần 12 chữ số)");
            }
            if (i == 2) {
                System.out.println("Bạn đã nhập sai 3 lần. Thoát khỏi hàm.");
                return;
            }
        }
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
        for (PHONG p : danhSachPhongThue) {
            p.Xuat2();
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
    }








