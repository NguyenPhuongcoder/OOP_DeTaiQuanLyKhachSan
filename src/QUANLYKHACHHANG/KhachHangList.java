package QUANLYKHACHHANG;

import java.util.ArrayList;
import java.util.Scanner;

// Lớp KhachHangList triển khai interface QuanLyKhachHang
public class KhachHangList implements QuanLyKhachHang {
    ArrayList<KhachHang> dsKhachHang = new ArrayList<>(); // Danh sách khách hàng

    @Override
    public void In() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chưa có dữ liệu khách hàng nào.");
        } else {
            for (KhachHang kh : dsKhachHang) {
                kh.Xuat(); // Hiển thị thông tin khách hàng
            }
        }
    }

    @Override
    public void khachHangMoi(KhachHang kh) {
        dsKhachHang.add(kh); // Thêm khách hàng mới vào danh sách
    }

    @Override
    public void xoaKhachHang(String maKH) {
        dsKhachHang.removeIf(kh -> kh.maKH.equals(maKH)); // Xóa khách hàng theo mã
    }

    @Override
    public void chinhSuaThongTin(String maKH) {
        // Nội dung như đã có trong mã gốc
        Scanner scanner = new Scanner(System.in);
        KhachHang khachHangCanSua = null;

        // Tìm khách hàng cần chỉnh sửa
        for (int i = 0; i < dsKhachHang.size(); i++) {
            if (dsKhachHang.get(i).maKH.equals(maKH)) {
                khachHangCanSua = dsKhachHang.get(i);
                break;
            }
        }

        if (khachHangCanSua == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }

        boolean tiepTuc = true;

        while (tiepTuc) {
            System.out.println("\nThông tin khách hàng hiện tại:");
            khachHangCanSua.Xuat(); // Hiển thị thông tin khách hàng hiện tại

            System.out.println("\nChọn thông tin cần sửa:");
            System.out.println("1. Mã khách hàng");
            System.out.println("2. Tên khách hàng");
            System.out.println("3. Mã phòng");
            System.out.println("4. Tên phòng");
            System.out.println("5. CCCD");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Địa chỉ");
            System.out.println("8. Email");
            System.out.println("9. Thoát");
            System.out.print("\nNhập lựa chọn (1-9): ");
            int luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã khách hàng mới: ");
                    khachHangCanSua.maKH = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Nhập tên khách hàng mới: ");
                    khachHangCanSua.tenKH = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Nhập mã phòng mới: ");
                    khachHangCanSua.maPhong = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Nhập tên phòng mới: ");
                    khachHangCanSua.tenPhong = scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Nhập CCCD mới: ");
                    khachHangCanSua.CCCD = scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Nhập số điện thoại mới: ");
                    khachHangCanSua.SDT = scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Nhập địa chỉ mới: ");
                    khachHangCanSua.diaChi = scanner.nextLine();
                    break;
                case 8:
                    System.out.print("Nhập email mới: ");
                    khachHangCanSua.email = scanner.nextLine();
                    break;
                case 9:
                    tiepTuc = false; // Kết thúc chỉnh sửa
                    System.out.println("Kết thúc chỉnh sửa thông tin.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }

            if (luaChon != 9) {
                System.out.println("\nThông tin khách hàng sau khi sửa:");
                khachHangCanSua.Xuat(); // Hiển thị thông tin sau khi sửa
            }
        }
    }

    @Override
    public void tinhSoNgayThue(String maKH) {
        boolean khachHangTimThay = false;

        for (KhachHang kh : dsKhachHang) {
            if (kh.maKH.equals(maKH)) {
                khachHangTimThay = true;
                if (kh.ngayNhanPhong != null && kh.ngayTraPhong != null) {
                    long days = java.time.Duration.between(kh.ngayNhanPhong, kh.ngayTraPhong).toDays(); // Tính số ngày thuê
                    System.out.println("Số ngày thuê của khách hàng " + maKH + ": " + days);
                } else {
                    System.out.println("Khách hàng " + maKH + " chưa có đủ thông tin ngày nhận hoặc ngày trả.");
                }
                break;
            }
        }
        if (!khachHangTimThay) {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKH);
        }
    }
}