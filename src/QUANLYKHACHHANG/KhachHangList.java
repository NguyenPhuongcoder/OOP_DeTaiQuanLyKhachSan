package QUANLYKHACHHANG;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Lớp KhachHangList triển khai interface QuanLyKhachHang
public class KhachHangList implements IFILE {
    ArrayList<KhachHang> dsKhachHang = new ArrayList<>(); // Danh sách khách hàng

    public void In() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chưa có dữ liệu khách hàng nào.");
        } else {
            for (KhachHang kh : dsKhachHang) {
                kh.Xuat();
                System.out.println("--------------------------------");
            }
        }
    }

    public void khachHangMoi(KhachHang kh) {
        dsKhachHang.add(kh); // Thêm khách hàng mới vào danh sách
    }


    public void xoaKhachHang(String maKH) {
        boolean removed = dsKhachHang.removeIf(kh -> kh.maKH.equals(maKH)); // Xóa khách hàng theo mã

        // Kiểm tra xem có khách hàng nào bị xóa hay không
        if (removed) {
            System.out.println("Đã xóa khách hàng với mã: " + maKH);
        } else {
            System.out.println("Không tìm thấy khách hàng với mã: " + maKH);
        }
    }

    public void chinhSuaThongTin(String maKH) {
        Scanner scanner = new Scanner(System.in);
        KhachHang khachHangCanSua = null;

        // Tìm khách hàng cần chỉnh sửa
        for (KhachHang kh : dsKhachHang) {
            if (kh.maKH.equals(maKH)) {
                khachHangCanSua = kh;
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


    // Phương thức mới: Tìm kiếm khách hàng theo tên
    public void timKiemKhachHangTheoTen(String tenKH) {
        boolean khachHangTimThay = false;
        for (KhachHang kh : dsKhachHang) {
            if (kh.tenKH.equalsIgnoreCase(tenKH)) {
                khachHangTimThay = true;
                kh.Xuat(); // Hiển thị thông tin khách hàng tìm thấy
            }
        }
        if (!khachHangTimThay) {
            System.out.println("Không tìm thấy khách hàng với tên: " + tenKH);
        }
    }

    // Phương thức mới: Hiển thị danh sách khách hàng theo phòng
    public void hienThiKhachHangTheoPhong(String maPhong) {
        boolean khachHangTimThay = false;
        for (KhachHang kh : dsKhachHang) {
            if (kh.maPhong.equals(maPhong)) {
                khachHangTimThay = true;
                kh.Xuat();
                System.out.println("----------------------");// Hiển thị thông tin khách hàng trong phòng
            }
        }
        if (!khachHangTimThay) {
            System.out.println("Không tìm thấy khách hàng trong phòng: " + maPhong);
        }
    }

    // Phương thức mới: Hiển thị danh sách tất cả các khách hàng
    public void hienThiTatCaKhachHang() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chưa có dữ liệu khách hàng nào.");
        } else {
            for (KhachHang kh : dsKhachHang) {
                kh.Xuat(); // Hiển thị thông tin tất cả các khách hàng
            }
        }
    }

    // Phương thức ghi dữ liệu khách hàng vào file
    @Override
    public void GhiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("KhachHang.txt"))) {
            for (KhachHang kh : dsKhachHang) {
                writer.write(kh.maKH + "," + kh.tenKH + "," + kh.maPhong + "," + kh.tenPhong + ","
                        + kh.CCCD + "," + kh.SDT + "," + kh.diaChi + "," + kh.email);
                writer.newLine();
            }
            System.out.println("Ghi file thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Phương thức đọc dữ liệu khách hàng từ file
    @Override
    public void DocFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("KhachHang.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                KhachHang kh = new KhachHang();
                kh.maKH = parts[0];
                kh.tenKH = parts[1];
                kh.maPhong = parts[2];
                kh.tenPhong = parts[3];
                kh.CCCD = parts[4];
                kh.SDT = parts[5];
                kh.diaChi = parts[6];
                kh.email = parts[7];
                dsKhachHang.add(kh);
            }
            System.out.println("Đọc file thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
