
package QUANLYDICHVU;

import java.util.Scanner;

public class mainQLDV {
    public static void main(String[] args) {
        QuanLyDichVu quanLy = new QuanLyDichVu();
        DichVuAnUong dvAU =  new DichVuAnUong();
        DichVuGiaiTri dvGT = new DichVuGiaiTri();
        Scanner src = new Scanner(System.in);
        System.out.println("Chào mừng đến với hệ thống quản lý dịch vụ!");
        System.out.println("Bạn là: (1) Quản Lý, (2) Khách Hàng");
        int roleInput = src.nextInt();
        src.nextLine();
        if (roleInput == 1) {
            System.out.println("Chế độ dành cho chủ:");
            while (true) {
                System.out.println("\nTùy chọn của bạn:");
                System.out.println("|-----------------------------------|");
                System.out.println("| 1. Xem danh sách dịch vụ");
                System.out.println("| 2. Thêm dịch vụ");
                System.out.println("| 3. Sửa thông tin dịch vụ");
                System.out.println("| 4. Xóa dịch vụ");
                System.out.println("| 5. Xem lịch sử cập nhật dịch vụ");
                System.out.println("| 0. Thoát");
                System.out.println("|-----------------------------------|");
                System.out.println("Chọn chức năng: ");
                int choice = src.nextInt();
                src.nextLine();
                switch (choice) {
                    case 1:
                        boolean t = true;
                        while(t){
                            System.out.println("|-------------------------------------|");
                            System.out.println("| 1. Xem danh sách dịch vụ thông dụng ");
                            System.out.println("| 2. Xem combo ăn uống");
                            System.out.println("| 3. Xem lịch sự kiện giải trí");
                            System.out.println("| 0. Thoát chức năng");
                            System.out.println("|-------------------------------------|");
                            int chon = src.nextInt();
                            switch(chon){
                                case 1: 
                                    quanLy.hienThiDanhSachDichVu();
                                    break;
                                case 2:
                                    dvAU.hienThiDanhSachCombo();
                                    break;
                                case 3: 
                                    dvGT.xemSuKienGiaiTri();
                                    break;
                                case 0:
                                    System.out.println("Thoát chức năng thành công");
                                    t = false;
                                    break;
                                default:
                                    System.out.println("Tùy chọn không hợp lệ. Hãy chọn lại");
                            }       
                        } break;
                    case 2: 
                        boolean tr = true;
                        while(tr){
                            System.out.println("|------------------------------|");
                            System.out.println("| 1. Thêm dịch vụ thông dụng ");
                            System.out.println("| 2. Thêm combo ăn uống");
                            System.out.println("| 3. Thêm lịch sự kiện giải trí");
                            System.out.println("| 0. Thoát chức năng thêm DV");
                            System.out.println("|------------------------------|");
                            int chon = src.nextInt();
                            switch(chon){
                                case 1: 
                                    quanLy.themDichVu();
                                    break;
                                case 2:
                                    dvAU.taoComboMonAn();
                                    break;
                                case 3: 
                                    dvGT.taoSuKienGiaiTri();
                                    break;
                                case 0:
                                    System.out.println("Thoát chức năng thành công");
                                    tr = false;
                                    break;
                                default:
                                    System.out.println("Tùy chọn không hợp lệ. Hãy chọn lại");
                            }
                                
                        }
                        break;
                    case 3:
                        quanLy.suaThongTinDichVu();
                        break;
                    case 4: 
                        boolean ds = true;
                        while(ds){
                            System.out.println("|------------------------------|");
                            System.out.println("| 1. Xóa dịch vụ ");
                            System.out.println("| 2. Xóa combo ăn uống");
                            System.out.println("| 3. Xóa lịch sự kiện giải trí");
                            System.out.println("| 0. Thoát chức năng xóa");
                            System.out.println("|------------------------------|");
                            int chon = src.nextInt();
                            switch(chon){
                                case 1: 
                                    quanLy.xoaDichVu();
                                    break;
                                case 2:
                                    dvAU.xoaCombo();
                                    break;
                                case 3: 
                                    dvGT.xoaSuKienGiaiTri();
                                    break;
                                case 0:
                                    System.out.println("Thoát chức năng thành công");
                                    ds = false;
                                    break;
                                default:
                                    System.out.println("Tùy chọn không hợp lệ. Hãy chọn lại");
                            }
                                
                        }
                        break;
                    case 5:
                        System.out.println("\n----- Lịch sử thay đổi dịch vụ -----");
                        quanLy.hienThiLichSuHD();
                        dvAU.hienThiLichSuHD();
                        dvGT.hienThiLichSuHD();
                        break;
                    case 0:
                        System.out.println("Cảm ơn bạn đã sử dụng hệ thống!");
                        return;
                    default:
                        System.out.println("Tùy chọn không hợp lệ.");
                }
            }
        } else 
            if (roleInput == 2) {
                System.out.println("Chế độ dành cho khách hàng:");

                while (true) {
                    System.out.println("\nTùy chọn của bạn:");
                    System.out.println("|--------------------------------------|");
                    System.out.println("| 1. Xem danh sách dịch vụ");
                    System.out.println("| 2. Chọn gói dịch vụ");
                    System.out.println("| 3. Khảo sát mức độ hài lòng");
                    System.out.println("| 4. Lịch sử hoạt động của khách hàng");
                    System.out.println("| 0. Thoát");
                    System.out.println("|--------------------------------------|");
                    System.out.println("Chọn chức năng: ");
                    int choice = src.nextInt();
                    src.nextLine();
                    switch (choice) {
                        case 1:
                            boolean t = true;
                            while(t){
                                System.out.println("|------------------------------|");
                                System.out.println("| 1. Xem danh sách dịch vụ thông dụng ");
                                System.out.println("| 2. Xem combo ăn uống");
                                System.out.println("| 3. Xem lịch sự kiện giải trí");
                                System.out.println("| 0. Thoát chức năng");
                                System.out.println("|------------------------------|");
                                int chon = src.nextInt();
                                switch(chon){
                                    case 1: 
                                        quanLy.hienThiDanhSachDichVu();
                                        break;
                                    case 2:
                                        dvAU.hienThiDanhSachCombo();
                                        break;
                                    case 3: 
                                        dvGT.xemSuKienGiaiTri();
                                        break;
                                    case 0:
                                        System.out.println("Thoát chức năng thành công");
                                        t = false;
                                        break;
                                    default:
                                        System.out.println("Tùy chọn không hợp lệ. Hãy chọn lại");
                                }       
                            } break;
                        case 2:
                            boolean tr = true;
                            while(tr){
                                System.out.println("\n|------------------------------|");
                                System.out.println("| 1. Gọi dịch vụ ");
                                System.out.println("| 2. Đặt combo ăn uống");
                                System.out.println("| 3. Đặt lịch sự kiện giải trí");
                                System.out.println("| 0. Thoát chức năng");
                                System.out.println("|------------------------------|");
                                int chon = src.nextInt();
                                switch(chon){
                                    case 1: 
                                        quanLy.chonDichVu();
                                        break;
                                    case 2:
                                        src.nextLine();
                                        System.out.print("Nhập mã combo bạn muốn chọn: ");
                                        String maComBo = src.nextLine();
                                        dvAU.datCombo(maComBo);
                                        break;
                                    case 3:
                                        dvGT.datLichGiaiTri();
                                        break;
                                    case 0:
                                        System.out.println("Thoát chức năng thành công");
                                        tr = false;
                                        break;
                                    default:
                                        System.out.println("Tùy chọn không hợp lệ. Hãy chọn lại");
                                }       
                            } break;
                        case 3:
                            quanLy.khaoSatHaiLong();
                            break;
                        case 4:
                            System.out.println("\n----- Lịch sử hoạt động của bạn -----");
                            quanLy.hienThiLichSuHD();
                            dvAU.hienThiLichSuHD();
                            dvGT.hienThiLichSuHD();
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