package QUANLYNHANVIEN;


import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    public void displayMenu() {
         LISTNHANVIEN listNhanVien = new LISTNHANVIEN();
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


}