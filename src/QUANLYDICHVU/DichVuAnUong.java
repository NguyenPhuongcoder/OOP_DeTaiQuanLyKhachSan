
package QUANLYDICHVU;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Scanner;

public class DichVuAnUong extends DICHVU implements IDichVuAU {
    protected ArrayList<String> lichSuHD;
    protected ArrayList<Combo> danhSachCombo;

    public DichVuAnUong( String maDichVu, String tenDichVu, String gioiThieu, double giaTien) {
        super(maDichVu, tenDichVu, gioiThieu, giaTien);
        lichSuHD = new ArrayList<>();
        danhSachCombo = new ArrayList<>();
    }
    
    public DichVuAnUong() {
        lichSuHD = new ArrayList<>();
        danhSachCombo = new ArrayList<>();
        DSComboAnUongMacDinh();
    }
    
    private static class Combo {
        private String maCombo;
        private String tenCombo;
        private double giaCombo;

        public Combo(String maCombo, String tenCombo, double giaCombo) {
        this.maCombo = maCombo;
        this.tenCombo = tenCombo;
        this.giaCombo = giaCombo;
        }
        public String getMaCombo() {
            return maCombo;
        }

        public void setMaCombo(String maCombo) {
            this.maCombo = maCombo;
        }
        
        public String getTenCombo() {
            return tenCombo;
        }
        public double getGiaCombo() {
            return giaCombo;
        }
    }
    
    private void DSComboAnUongMacDinh() {
        danhSachCombo.add(new Combo("C001", "Combo mâm cơm Gia Đình", 500000));
        danhSachCombo.add(new Combo("C002", "Combo trưa sân vườn", 300000));
        danhSachCombo.add(new Combo("C003", "Combo Tiệc Nhỏ", 350000));
    }

    private void ghiLichSu(String loaiThayDoi, String maComBo, String moTaThayDoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, maComBo, moTaThayDoi);
        lichSuHD.add(lichSu);
    }
     public void ghiLichSuHoatDong(String loaiHD, String tenDichVu, double tong) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %.2f", thoiGian, loaiHD, tenDichVu, tong);
        lichSuHD.add(lichSu);
    }
    // nhân viên quản lý
    @Override
    public void taoComboMonAn() {
        Scanner src = new Scanner(System.in);
        String maCombo;
        while (true) {
            System.out.print("Nhập mã combo: ");
            maCombo = src.nextLine();
            boolean exists = false;
            for (Combo combo : danhSachCombo) 
                if (combo.getMaCombo().equals(maCombo)) {
                    exists = true;
                    break;
                }   
            if (exists) 
                System.out.println("Mã combo đã tồn tại! Vui lòng nhập mã khác.");
            else 
                break; 
        }
        System.out.print("Nhập tên combo: ");
        String tenCombo = src.nextLine();
        System.out.print("Nhập giá combo: ");
        double giaCombo = src.nextDouble();
        danhSachCombo.add(new Combo(maCombo, tenCombo, giaCombo));
        System.out.println("\nCombo mới đã được tạo:");
        System.out.println("Mã Combo: " + maCombo);
        System.out.println("Tên Combo: " + tenCombo);
        System.out.println("Giá Combo: " + giaCombo + " VND");
        ghiLichSu("Tạo combo", maCombo, "Tạo thành công");
    }

    @Override
    public void hienThiDanhSachCombo() {
        System.out.println("\n--- Danh Sách Combo Ăn Uống ---");
        for (Combo combo : danhSachCombo) {
            System.out.println("Mã Combo: " + combo.getMaCombo());
            System.out.println("Tên Combo: " + combo.getTenCombo());
            System.out.println("Giá: " + combo.getGiaCombo() + " VND");
            System.out.println("-----------------------------------");
        }
    }
    // nhân viên quản lý
    @Override
    public void xoaCombo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã combo cần xóa: ");
        String maCombo = scanner.nextLine();
        boolean found = false;
        for (Combo combo : danhSachCombo)
            if (combo.getMaCombo().equals(maCombo)) {
                System.out.println("\n--- Thông Tin Combo ---");
                System.out.println("Mã Combo: " + combo.getMaCombo());
                System.out.println("Tên Combo: " + combo.getTenCombo());
                System.out.println("Giá: " + combo.getGiaCombo() + " VND");
                System.out.println("-------------------------");

                System.out.print("Bạn có chắc chắn muốn xóa combo này (Y/N)? ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    danhSachCombo.remove(combo);
                    System.out.println("Combo đã được xóa thành công.");
                    ghiLichSu("Xóa combo", combo.getMaCombo(), "Đã xóa khỏi danh sách combo.");
                } else 
                    System.out.println("Hủy thao tác xóa.");
                found = true;
                break;
            }
        if (!found) 
            System.out.println("Không tìm thấy combo với mã: " + maCombo);
    }
    // Khách hàng
    @Override
    public void datCombo(String maCombo) {
        for (Combo combo : danhSachCombo) {
            if (combo.getMaCombo().equalsIgnoreCase(maCombo)) {
                System.out.println("Bạn đã đặt thành công combo: " + combo.getTenCombo());
                System.out.println("Giá: " + combo.getGiaCombo() + " VND");
                ghiLichSuHoatDong("Đặt combo", maCombo + " Giá tiền: ",combo.getGiaCombo());
                return;
            }
        }
        System.out.println("Không tìm thấy combo với mã: " + maCombo);
    }
    public void hienThiLichSuHD() {
        for (String lichSu : lichSuHD) {
            System.out.println(lichSu);
        }
    }
    
    @Override
    public void hienThiThongTin() {
        System.out.println("|---------------------------------|");
        System.out.println("| Dịch vụ ăn uống: " + getMaDichVu());
        System.out.println("| Tên dịch vụ: "+getTenDichVu());
        System.out.println("| Giá: " + getGiaTien() + " VND");
        System.out.println("| Mô tả: " + getGioiThieu());
        System.out.println("|---------------------------------|");
    }
}

