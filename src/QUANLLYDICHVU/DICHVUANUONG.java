package QUANLLYDICHVU;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DICHVUANUONG extends DICHVU implements IDichVu {
    protected ArrayList<String> lichSuThayDoi;
    private List<Combo> danhSachCombo;

    public DICHVUANUONG(String tenDichVu, String gioiThieu, double giaTien) {
        super(tenDichVu, gioiThieu, giaTien);
        lichSuThayDoi = new ArrayList<>();
        danhSachCombo = new ArrayList<>();
    }
    public DICHVUANUONG() {
        lichSuThayDoi = new ArrayList<>();
        danhSachCombo = new ArrayList<>();
        DSComboAnUongMacDinh();
    }

    private static class Combo {
        private String tenCombo;
        private List<String> danhSachMon;
        private double giaCombo;

        public Combo(String tenCombo, List<String> danhSachMon, double giaCombo) {
            this.tenCombo = tenCombo;
            this.danhSachMon = danhSachMon;
            this.giaCombo = giaCombo;
        }

        public String getTenCombo() {
            return tenCombo;
        }

        public List<String> getDanhSachMon() {
            return danhSachMon;
        }

        public double getGiaCombo() {
            return giaCombo;
        }
    }

    private void DSComboAnUongMacDinh() {
        danhSachCombo.add(new Combo("Combo Gia Đình",
                Arrays.asList("Cơm Tấm", "Canh Chua", "Gà Nướng"), 500000));
        danhSachCombo.add(new Combo("Combo Trưa Văn Phòng",
                Arrays.asList("Phở", "Nước Chanh", "Bánh Flan"), 300000));
        danhSachCombo.add(new Combo("Combo Tiệc Nhỏ",
                Arrays.asList("Pizza", "Nước Ngọt", "Salad"), 450000));
    }

    public void datCombo(String tenCombo) {
        for (Combo combo : danhSachCombo) {
            if (combo.getTenCombo().equalsIgnoreCase(tenCombo)) {
                System.out.println("Bạn đã đặt thành công combo: " + combo.getTenCombo());
                System.out.println("Bao gồm: " + String.join(", ", combo.getDanhSachMon()));
                System.out.println("Giá: " + combo.getGiaCombo() + " VND");
                ghiLichSu("Đặt combo", tenCombo, "Đã đặt combo thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy combo: " + tenCombo);
    }

    public void hienThiDanhSachCombo() {
        System.out.println("\n--- Danh Sách Combo Ăn Uống ---");
        for (Combo combo : danhSachCombo) {
            System.out.println("Tên Combo: " + combo.getTenCombo());
            System.out.println("Danh sách món: " + String.join(", ", combo.getDanhSachMon()));
            System.out.println("Giá: " + combo.getGiaCombo() + " VND");
            System.out.println("-----------------------------------");
        }
    }

    private void ghiLichSu(String loaiThayDoi, String tenDichVu, String moTaThayDoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, moTaThayDoi);
        lichSuThayDoi.add(lichSu);
    }

    @Override
    public void datMonAnTruoc(String tenMonAn) {
        System.out.println("Bạn đã đặt món " + tenMonAn + " thành công. Vui lòng chờ phục vụ.");
        ghiLichSu("Đặt món", tenMonAn, "Món đã đặt trước");
    }

    @Override
    public void taoComboMonAn() {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập tên combo: ");
        String tenCombo = src.nextLine();
        System.out.print("Nhập số lượng món ăn trong combo: ");
        int soLuongMon = src.nextInt();
        src.nextLine();
        String[] danhSachMon = new String[soLuongMon];
        for (int i = 0; i < soLuongMon; i++) {
            System.out.print("Nhập tên món ăn thứ " + (i + 1) + ": ");
            danhSachMon[i] = src.nextLine();
        }
        System.out.print("Nhập giá combo: ");
        double giaCombo = src.nextDouble();
        System.out.println("\nCombo món ăn: " + tenCombo);
        System.out.println("Bao gồm:");
        for (String mon : danhSachMon) {
            System.out.println("- " + mon);
        }
        System.out.println("Giá combo: " + giaCombo + " VND");
        ghiLichSu("Tạo combo", tenCombo, "Số món: " + danhSachMon.length);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("|---------------------------------|");
        System.out.println("| Dịch vụ ăn uống: " + getTenDichVu());
        System.out.println("| Giá: " + getGiaTien() + " VND");
        System.out.println("| Mô tả: " + getGioiThieu());
        System.out.println("|---------------------------------|");
    }

    @Override
    public void datLichGiaiTri(String tenDichVu, LocalDateTime thoiGianDat) {}
    @Override
    public void taoSuKienGiaiTri(String tenSuKien, String thoiGian, String diaDiem) {}
    @Override
    public void xemSuKienGiaiTri() {}
}

