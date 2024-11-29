package QUANLLYDICHVU;

import java.time.LocalDateTime;
import java.util.Scanner;

public class mainQLDV {
    public void quanLy(){
        QUANLYDICHVU quanLy = new QUANLYDICHVU();
        DICHVUANUONG dvAU =  new DICHVUANUONG();
        DICHVUGIAITRI dvGT = new DICHVUGIAITRI();
        Scanner src = new Scanner(System.in);
        System.out.println("----- MENU QUẢN LÝ DỊCH VỤ -----");
        System.out.println("Chào mừng đến với hệ thống quản lý dịch vụ!");
        System.out.println("Bạn là: (1) Chủ, (2) Khách");
        int roleInput = src.nextInt();
        src.nextLine();
        String role = (roleInput == 1) ? "chu" : "khach";
        if ("chu".equals(role)) {
            System.out.println("Chế độ dành cho chủ:");
            while (true) {
                System.out.println("\nTùy chọn của bạn:");
                System.out.println("1. Xem danh sách dịch vụ");
                System.out.println("2. Xem thông tin dich vụ chi tiết ");
                System.out.println("3. Xem danh sách combo món ăn");
                System.out.println("4. Xem danh sách sự kiện giải trí");
                System.out.println("5. Xem lịch sử cập nhật dịch vụ");
                System.out.println("6. Thêm dịch vụ");
                System.out.println("7. Thêm combo món ăn");
                System.out.println("8. Thêm sự kiện giải trí");
                System.out.println("9. Sửa thông tin dịch vụ ");
                System.out.println("10. Xóa dịch vụ");
                System.out.println("0. Thoát");
                int choice = src.nextInt();
                src.nextLine();
                switch (choice) {
                    case 1:
                        quanLy.hienThiDanhSachDichVu();
                        break;
                    case 2: 
                        quanLy.xemThongTinChiTietDichVu();
                        break;
                    case 3:
                        dvAU.hienThiDanhSachCombo();
                        break;
                    case 4:
                        dvGT.xemSuKienGiaiTri();
                        break;
                    case 5:
                        quanLy.hienThiLichSuThayDoi();
                        break;
                    case 6: 
                        quanLy.themDichVu(role);
                        break;
                    case 7:
                        dvAU.taoComboMonAn();
                        break;
                    case 8: 
                        dvGT.taoSuKienGiaiTri(role, role, role);
                        break;
                    case 9: 
                        quanLy.suaThongTinDichVu(role);
                        break;
                    case 10:
                        quanLy.xoaDichVu(role);
                        break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                        return;
                    default:
                        System.out.println("Tùy chọn không hợp lệ.");
                }
            }
        } else 
            if ("khach".equals(role)) {
                System.out.println("Chế độ dành cho khách hàng:");

                while (true) {
                    System.out.println("\nTùy chọn của bạn:");
                    System.out.println("1. Xem danh sách dịch vụ");
                    System.out.println("2. Xem thông tin chi tiết dịch vụ");
                    System.out.println("3. Gọi dịch vụ");
                    System.out.println("4. Đặt trước món ăn ");
                    System.out.println("5. Xem combo ăn uống");
                    System.out.println("6. Đặt combo");
                    System.out.println("7. Xem sự kiện giải trí");
                    System.out.println("8. Đặt lịch tham gia sự kiện giải trí");
                    System.out.println("9. Khảo sát mức độ hài lòng");
                    System.out.println("0. Thoát");
                    int choice = src.nextInt();
                    src.nextLine();

                    switch (choice) {
                        case 1:
                            quanLy.hienThiDanhSachDichVu();
                            break;
                        case 2:
                            quanLy.xemThongTinChiTietDichVu();
                            break; 
                        case 3:
                            quanLy.chonDichVu(role);
                            break;
                        case 4:
                            System.out.print("Nhập tên món ăn muốn đặt trước: ");
                            String tenMonAn = src.nextLine();
                            dvAU.datMonAnTruoc(tenMonAn);
                            break;
                        case 5:
                            dvAU.hienThiDanhSachCombo();
                            break;
                        case 6 :
                            System.out.print("Nhập tên combo bạn muốn chọn: ");
                            String tenComBo = src.nextLine();
                            dvAU.datCombo(tenComBo);
                            break;
                        case 7:
                            dvGT.xemSuKienGiaiTri();
                            break;
                        case 8:
                            System.out.print("Nhập tên dịch vụ giải trí: ");
                            String tenDichVu = src.nextLine();
                            System.out.print("Nhập thời gian tham gia (yyyy-MM-dd HH:mm): ");
                            String thoiGianNhap = src.nextLine();
                            LocalDateTime thoiGianDat = LocalDateTime.parse(thoiGianNhap.replace(" ", "T"));
                            dvGT.datLichGiaiTri(tenDichVu, thoiGianDat);
                            break;
                        case 9:
                            quanLy.khaoSatHaiLong();
                            break;
                        case 0:
                            System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                            return; 
                        default:
                            System.out.println("Tùy chọn không hợp lệ.");
                    }
                }
            } else 
                System.out.println("Vai trò không hợp lệ!");
       }
}