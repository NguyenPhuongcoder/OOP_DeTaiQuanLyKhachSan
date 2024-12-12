
package QUANLYDICHVU;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDichVu {
    private ArrayList<DICHVU> danhSachDichVu;
    private ArrayList<String> lichSuHD;
    public QuanLyDichVu() {
        danhSachDichVu = new ArrayList<>();
        lichSuHD = new ArrayList<>();
        themDichVuMacDinh();
    }
    
    private void ghiLichSu(String loaiThayDoi, String tenDichVu, String moTaThayDoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, moTaThayDoi);
        lichSuHD.add(lichSu);
    }
    private void ghiLichSuHoatDong(String loaiHD, String tenDichVu, double tong) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiHD, tenDichVu, tong);
        lichSuHD.add(lichSu);
        
    }
     private void themDichVuMacDinh() {
        danhSachDichVu.add(new DichVuGiaiTri("GT001", "Karaoke", "Âm nhạc", 150000));
        danhSachDichVu.add(new DichVuGiaiTri("GT002", "Xem phim", "Phim ảnh", 100000));
        danhSachDichVu.add(new DichVuGiaiTri("GT003", "Đánh Golf", "Vận động", 200000));
        danhSachDichVu.add(new DichVuAnUong("AU001", "Buffet", "Buffet tối", 300000));
        danhSachDichVu.add(new DichVuAnUong("AU002", "Rượu Champagne", "Rượu thưởng thức trong bữa tiệc ", 200000));
        danhSachDichVu.add(new DichVuAnUong("AU003", "Trái cây", "Tráng miệng", 100000));
    }
    public void hienThiDanhSachDichVu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn loại dịch vụ muốn xem:");
        System.out.println("1. Dịch vụ ăn uống");
        System.out.println("2. Dịch vụ giải trí");
        System.out.println("3. Xem tất cả dịch vụ");
        int luaChon = scanner.nextInt();
        scanner.nextLine();
        switch (luaChon) {
            case 1:
                System.out.println("\n--- Danh sách dịch vụ ăn uống ---");
                for (DICHVU dv : danhSachDichVu) 
                    if (dv instanceof DichVuAnUong) 
                        dv.hienThiThongTin();
                break;
            case 2:
                System.out.println("\n--- Danh sách dịch vụ giải trí ---");
                for (DICHVU dv : danhSachDichVu) 
                    if (dv instanceof DichVuGiaiTri) 
                        dv.hienThiThongTin();
                break;
            case 3:
                System.out.println("\n--- Danh sách tất cả dịch vụ ---");
                for (DICHVU dv : danhSachDichVu)
                    dv.hienThiThongTin();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
    // nhân viên quản lý
    public void themDichVu() {
        Scanner scanner = new Scanner(System.in);
        int loaiDichVu;
        while (true) {
            System.out.println("Nhập loại dịch vụ muốn thêm (1 - Ăn uống, 2 - Giải trí): ");
            loaiDichVu = scanner.nextInt();
            scanner.nextLine();
            if (loaiDichVu == 1 || loaiDichVu == 2) break;
            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
        }
        System.out.print("Nhập mã dịch vụ: ");
        String maDichVu = scanner.nextLine();
        for (DICHVU dv : danhSachDichVu) {
            if (dv.getMaDichVu().equalsIgnoreCase(maDichVu)) {
                System.out.println("Mã dịch vụ đã tồn tại. Vui lòng nhập mã khác.");
                return;
            }
        }
        System.out.print("Nhập tên dịch vụ: ");
        String tenDichVu = scanner.nextLine();

        double giaTien;
        while (true) {
            System.out.print("Nhập giá dịch vụ: ");
            try {
                giaTien = scanner.nextDouble();
                scanner.nextLine();
                if (giaTien > 0) break;
                System.out.println("Giá tiền phải lớn hơn 0. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Giá tiền không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine();
            }
        }
        System.out.print("Nhập mô tả dịch vụ: ");
        String gioiThieu = scanner.nextLine();
        if (loaiDichVu == 1) {
            danhSachDichVu.add(new DichVuAnUong(maDichVu, tenDichVu, gioiThieu, giaTien));
            System.out.println("Dịch vụ ăn uống mới đã được thêm: " + tenDichVu);
            ghiLichSu("Thêm", tenDichVu, "Thêm dịch vụ ăn uống mới");
        } else {
            danhSachDichVu.add(new DichVuGiaiTri(maDichVu, tenDichVu, gioiThieu, giaTien));
            System.out.println("Dịch vụ giải trí mới đã được thêm: " + tenDichVu);
            ghiLichSu("Thêm", tenDichVu, "Thêm dịch vụ giải trí mới");
        }
    }
    // nhân viên quản lý
    public void suaThongTinDichVu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã dịch vụ cần sửa: ");
        String maDichVu = scanner.nextLine();
        boolean timThay = false;
        for (DICHVU dv : danhSachDichVu) {
            if (dv.getMaDichVu().equalsIgnoreCase(maDichVu)) {
                timThay = true;
                System.out.println("Thông tin hiện tại của dịch vụ:");
                dv.hienThiThongTin();
                boolean tiepTuc = true;
                while (tiepTuc) {
                    System.out.println("\nChọn thông tin muốn sửa:");
                    System.out.println("1. Tên dịch vụ");
                    System.out.println("2. Giá tiền");
                    System.out.println("3. Mô tả");
                    System.out.println("0. Dừng chỉnh sửa");
                    System.out.print("Lựa chọn của bạn: ");
                    int luaChon = scanner.nextInt();
                    scanner.nextLine();

                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhập tên mới: ");
                            String tenMoi = scanner.nextLine();
                            if (!tenMoi.isEmpty()) {
                                dv.setTenDichVu(tenMoi); 
                                System.out.println("Tên dịch vụ đã được cập nhật thành: " + tenMoi);
                                ghiLichSu("Sửa", dv.getTenDichVu(), "Tên mới: "+ tenMoi);
                            } else 
                                System.out.println("Tên không hợp lệ!");
                            break;
                        case 2:
                            System.out.print("Nhập giá mới: ");
                            double giaMoi = scanner.nextDouble();
                            if (giaMoi > 0) {
                                dv.setGiaTien(giaMoi);
                                System.out.println("Giá dịch vụ đã được cập nhật.");
                                ghiLichSu("Sửa giá tiền", maDichVu, "Giá mới: " + giaMoi);
                            } else 
                                System.out.println("Giá tiền không hợp lệ!");
                            break;

                        case 3:
                            System.out.print("Nhập mô tả mới: ");
                            String moTaMoi = scanner.nextLine();
                            if (!moTaMoi.isEmpty()) {
                                if (dv instanceof DichVuAnUong) {
                                    ((DichVuAnUong) dv).setGioiThieu(moTaMoi);
                                } else if (dv instanceof DichVuGiaiTri) {
                                    ((DichVuGiaiTri) dv).setGioiThieu(moTaMoi);
                                }
                                System.out.println("Mô tả dịch vụ đã được cập nhật.");
                                ghiLichSu("Sửa giới thiệu", maDichVu, moTaMoi);
                            } else 
                                System.out.println("Mô tả không hợp lệ!");
                            break;
                        case 0:
                            tiepTuc = false;
                            System.out.println("Đã dừng chỉnh sửa dịch vụ.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                }
            }
        }
        if (!timThay)
            System.out.println("Không tìm thấy dịch vụ với mã: " + maDichVu);
    }
    // nhân viên quản lý
    public void xoaDichVu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã dịch vụ muốn xóa: ");
        String maDichVu = scanner.nextLine();

        boolean timThay = false;
        for (DICHVU dv : danhSachDichVu)
            if (maDichVu.equals(dv.getMaDichVu())) {
                System.out.println("\n--- Thông Tin dịch vụ ---");
                System.out.println("Mã dịch vụ: " + dv.getMaDichVu());
                System.out.println("Tên dịch vụ: " + dv.getTenDichVu());
                System.out.println("Giới thiệu: " + dv.getGioiThieu());
                System.out.println("Giá tiền: " + dv.getGiaTien() + " VND");
                System.out.println("-------------------------");

                System.out.print("Bạn có chắc chắn muốn xóa dịch vụ này (Y/N)? ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    danhSachDichVu.remove(dv);
                    ghiLichSu("Xóa", maDichVu, "Xóa dịch vụ");
                    System.out.println("Dịch vụ " + maDichVu + " đã được xóa.");
                } else 
                    System.out.println("Hủy thao tác xóa.");
                timThay = true;
                break;
            }
        if (!timThay) 
            System.out.println("Không tìm thấy dịch vụ với mã: " + maDichVu);
    }
    
     public void hienThiLichSuHD() {
        for (String lichSu : lichSuHD) {
            System.out.println(lichSu);
        }
    }
     // Khách hàng
    public void chonDichVu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DICHVU> dichVuDaChon = new ArrayList<>();
        String tiepTuc = "yes";

        while ("yes".equalsIgnoreCase(tiepTuc)) {
            System.out.print("Nhập mã dịch vụ bạn muốn chọn: ");
            String maDichVu = scanner.nextLine();
            boolean timThay = false;
            for (DICHVU dv : danhSachDichVu) {
                if (maDichVu.equals(dv.getMaDichVu())) {
                    dichVuDaChon.add((DICHVU) dv);
                    System.out.println("Đã chọn dịch vụ và lưu vào tiêu phí: " + maDichVu);
                    ghiLichSuHoatDong("Gọi dịch vụ", dv.getTenDichVu() + " - Giá tiền",dv.getGiaTien() );
                    timThay = true;
                    break;
                }
            }
            if (!timThay) 
                System.out.println("Không tìm thấy dịch vụ với mã: " + maDichVu); 
            System.out.print("Bạn có muốn gọi thêm dịch vụ không? (yes/no): ");
            tiepTuc = scanner.nextLine();
        }
        double tongTien = 0;
        System.out.println("Danh sách dịch vụ bạn đã chọn:");
        for (DICHVU dv : dichVuDaChon) {
            dv.hienThiThongTin();
            tongTien += dv.getGiaTien();
        }
        System.out.println("Tổng tiền cần thanh toán: " + tongTien + " VND");
        System.out.println("Bạn đã hoàn tất việc chọn dịch vụ.");
    }
    // khách hàng
     public void khaoSatHaiLong() {
         Scanner scanner = new Scanner(System.in);
         try {
            System.out.print("Vui lòng đánh giá dịch vụ của chúng tôi (1-5 sao): ");
            int danhGia = scanner.nextInt();
            scanner.nextLine();
            if (danhGia < 1 || danhGia > 5) 
                System.out.println("Đánh giá không hợp lệ!");
            else {
                System.out.println("Bình luận: ");
                String Evaluate = scanner.nextLine();
                if(danhGia <= 3){
                    System.out.println("Cảm ơn bạn đã đánh giá " + danhGia + " sao!\nChúng tôi rất vui lòng ghi nhận đánh giá của bạn, chúng tôi sẽ cố gắng khắc phục lỗi. \nXin cảm ơn bạn!" );
                    ghiLichSu("Khảo sát","Số sao:" +danhGia,"Bình Luận: " + Evaluate);
                }   
                else{
                    System.out.println("Cảm ơn bạn đã đánh giá " + danhGia + " sao!\nChúng tôi rất vui ghi nhận đánh giá của bạn. Chúc Bạn có một ngày tốt đẹp. \nXin cảm ơn!" );
                    ghiLichSu("Khảo sát","Số sao:" + danhGia, "Bình Luận: " + Evaluate);
                }
            }
         } catch (Exception e) {
            System.out.println("Đầu vào không hợp lệ. Vui lòng thử lại.");
            scanner.nextLine();
           }
     }
}
