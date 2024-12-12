
package QUANLYDICHVU;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DichVuGiaiTri extends DICHVU implements IDICHVUGT {
    protected ArrayList<String> lichSuHD;
    protected List<SuKien> danhSachSuKien;

    public DichVuGiaiTri() {
        lichSuHD = new ArrayList<>();
        danhSachSuKien = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        danhSachSuKien.add(new SuKien("SK001", "Buổi Hòa Nhạc", LocalDate.parse("25/12/2024", formatter), "Nhà Hát Lớn", 200000));
        danhSachSuKien.add(new SuKien("SK002", "Triển Lãm Nghệ Thuật", LocalDate.parse("10/01/2025", formatter), "Bảo Tàng Mỹ Thuật", 100000));
        danhSachSuKien.add(new SuKien("SK003", "Hội Chợ Văn Hóa", LocalDate.parse("15/02/2025", formatter), "Công Viên Thành Phố",150000));
    }
    
    public DichVuGiaiTri(String maDichVu, String tenDichVu, String gioiThieu, double giaTien) {
        super(maDichVu, tenDichVu, gioiThieu, giaTien);
        lichSuHD = new ArrayList<>();
        danhSachSuKien = new ArrayList<>();
    }
    private static class SuKien {
        private String maSuKien;
        private String tenSuKien;
        private LocalDate thoiGian;
        private String diaDiem;
        private double giaVe;

        public SuKien(String maSuKien, String tenSuKien, LocalDate thoiGian, String diaDiem, double giaVe) {
            this.maSuKien = maSuKien;
            this.tenSuKien = tenSuKien;
            this.thoiGian = thoiGian;
            this.diaDiem = diaDiem;
            this.giaVe = giaVe;
        }

        public String getMaSuKien() {
            return maSuKien;
        }

        public String getTenSuKien() {
            return tenSuKien;
        }

        public LocalDate getThoiGian() {
            return thoiGian;
        }

        public String getDiaDiem() {
            return diaDiem;
        }

        public double getGiaVe() {
            return giaVe;
        }
    }

    private void ghiLichSu(String loaiThayDoi, String tenDichVu, String moTaThayDoi) {
        String thoiGian = LocalDate.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, moTaThayDoi);
        lichSuHD.add(lichSu);
    }
    private void ghiLichSuHoatDong(String loaiHD, String tenDichVu, double tong) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiHD, tenDichVu, tong);
        lichSuHD.add(lichSu);
    }
    
    // nhân viên quản lý
    @Override
    public void taoSuKienGiaiTri() {
        Scanner scanner = new Scanner(System.in);
        String maSuKien;
        while (true) {
            System.out.print("Nhập mã sự kiện: ");
            maSuKien = scanner.nextLine();
            boolean exists = false;
            for (SuKien suKien : danhSachSuKien) 
                if (suKien.getMaSuKien().equals(maSuKien)) {
                    exists = true;
                    break;
                }
            if (exists) 
                System.out.println("Mã sự kiện đã tồn tại! Vui lòng nhập mã khác.");
             else 
                break;
        }
        try {
            System.out.print("Nhập tên sự kiện: ");
            String tenSuKien = scanner.nextLine();
            System.out.print("Nhập ngày sự kiện (định dạng dd/MM/yyyy): ");
            String thoiGianString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate thoiGian;
            try {
                thoiGian = LocalDate.parse(thoiGianString, formatter);
            } catch (Exception e) {
                System.out.println("Ngày nhập không hợp lệ! Vui lòng nhập đúng định dạng dd/MM/yyyy.");
                return;
            }
            
            System.out.print("Nhập địa điểm sự kiện: ");
            String diaDiem = scanner.nextLine();
            System.out.println("Giá vé/ người:");
            int giaVe = scanner.nextInt();
            danhSachSuKien.add(new SuKien(maSuKien, tenSuKien, thoiGian, diaDiem, giaVe));
            System.out.println("Đã tạo sự kiện giải trí: " + tenSuKien);
            ghiLichSu("Tạo sự kiện: "+ maSuKien, "Ngày: " + thoiGian + ", Địa điểm: " + diaDiem, "Giá vé: "+ giaVe);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi nhập dữ liệu: " + e.getMessage());
        }
    }

    @Override
    public void xemSuKienGiaiTri() {
        System.out.println("\n--- Danh Sách Sự Kiện Giải Trí ---");
        for (SuKien suKien : danhSachSuKien) {
            System.out.println("| Mã sự kiện: " + suKien.getMaSuKien());
            System.out.println("| Tên sự kiện: " + suKien.getTenSuKien());
            System.out.println("| Ngày: " + suKien.getThoiGian());
            System.out.println("| Địa điểm: " + suKien.getDiaDiem());
            System.out.println("| Giá vé: " + suKien.getGiaVe() + " VND");
            System.out.println("|-----------------------------------");
        }
    }
    // nhân viên quản lý
    @Override
    public void xoaSuKienGiaiTri() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sự kiện cần xóa: ");
        String maSuKien = scanner.nextLine();
        boolean found = false;
        for (SuKien suKien : danhSachSuKien) 
            if (suKien.getMaSuKien().equals(maSuKien)) {
                System.out.println("\n--- Thông Tin Sự Kiện ---");
                System.out.println("Mã sự kiện: " + suKien.getMaSuKien());
                System.out.println("Tên sự kiện: " + suKien.getTenSuKien());
                System.out.println("Ngày: " + suKien.getThoiGian());
                System.out.println("Địa điểm: " + suKien.getDiaDiem());
                System.out.println("Giá vé: " + suKien.getGiaVe() + " VND");
                System.out.println("--------------------------");

                System.out.print("Bạn có chắc chắn muốn xóa sự kiện này (Y/N)? ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    danhSachSuKien.remove(suKien);
                    System.out.println("Sự kiện đã được xóa thành công.");
                    ghiLichSu("Xóa sự kiện", suKien.getTenSuKien(), "Đã xóa khỏi danh sách sự kiện.");
                } else 
                    System.out.println("Hủy thao tác xóa.");
                found = true;
                break;
            }
        if (!found)
            System.out.println("Không tìm thấy sự kiện với mã: " + maSuKien);
    }

    // Khách hàng
    @Override
    public void datLichGiaiTri() {
        Scanner src = new Scanner(System.in);
        System.out.print("Nhập mã sự kiện: ");
        String maSuKien = src.nextLine();
        for (SuKien suKien : danhSachSuKien) 
            if (maSuKien.equals(suKien.getMaSuKien())) {
                System.out.println("****Thông tin sự kiện:");
                System.out.println("Tên sự kiện: " + suKien.getTenSuKien());
                System.out.println("Ngày sự kiện: " + suKien.getThoiGian());
                System.out.println("Địa điểm: " + suKien.getDiaDiem());
                System.out.println("Giá vé/ người: " + suKien.getGiaVe() + " VND");
                System.out.println("--------------------");
                System.out.print("\nNhập ngày tham gia (yyyy-MM-dd): ");
                try {
                String thoiGianNhap = src.nextLine();
                LocalDate thoiGianDat = LocalDate.parse(thoiGianNhap);
                if (!thoiGianDat.isBefore(suKien.getThoiGian())) {
                    System.out.println("Ngày tham gia phải trước ngày sự kiện! Vui lòng nhập lại.");
                    return;
                }
                System.out.print("Số vé đặt: ");
                int soVe = src.nextInt();
                src.nextLine();
                double tongTien = soVe * suKien.getGiaVe();
                System.out.println("Đã đặt lịch tham gia sự kiện thành công!");
                System.out.println("Tổng tiền: " + tongTien + " VND");
                ghiLichSuHoatDong("Đặt lịch sự kiện",suKien.getTenSuKien() + " - Ngày đặt: " + thoiGianDat +" - Tổng tiền",tongTien);
                } catch (Exception e) {
                    System.out.println("Lỗi nhập liệu: " + e.getMessage());
                    System.out.println("Vui lòng kiểm tra định dạng ngày và thử lại!");
                }
                return;
            }
         System.out.println("Không tìm thấy sự kiện với mã: " + maSuKien);
    }

    public void hienThiLichSuHD() {
        for (String lichSu : lichSuHD) {
            System.out.println(lichSu);
        }
    }
    
    @Override
    public void hienThiThongTin() {
         System.out.println("|---------------------------------|");
         System.out.println("| Dịch vụ giải trí: " + getMaDichVu());
         System.out.println("| Tên dịch vụ: "+ getTenDichVu());
         System.out.println("| Giá: " + getGiaTien() + " VND");
         System.out.println("| Mô tả: " + getGioiThieu());
         System.out.println("|---------------------------------|");
   }
}
