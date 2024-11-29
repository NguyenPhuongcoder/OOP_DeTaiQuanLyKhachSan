package QUANLYPHONG;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class main {

    public  void QuanLyPhong() {

            DANHSACHPHONG danhSachPhong = new DANHSACHPHONG();
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
