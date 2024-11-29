package QUANLLYDICHVU;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DICHVUGIAITRI extends DICHVU implements IDichVu {
    private ArrayList<String> lichSuThayDoi;
    private List<SuKien> danhSachSuKien;

    public DICHVUGIAITRI() {
        lichSuThayDoi = new ArrayList<>();
        danhSachSuKien = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        danhSachSuKien.add(new SuKien("Buổi Hòa Nhạc", LocalDateTime.parse("25/12/2024 19:00", formatter), "Nhà Hát Lớn"));
        danhSachSuKien.add(new SuKien("Triển Lãm Nghệ Thuật", LocalDateTime.parse("10/01/2025 09:00", formatter), "Bảo Tàng Mỹ Thuật"));
        danhSachSuKien.add(new SuKien("Hội Chợ Văn Hóa", LocalDateTime.parse("15/02/2025 14:00", formatter), "Công Viên Thành Phố"));
    }

    public DICHVUGIAITRI(String tenDichVu, String gioiThieu, double giaTien) {
        super(tenDichVu, gioiThieu, giaTien);
        lichSuThayDoi = new ArrayList<>();
        danhSachSuKien = new ArrayList<>();
    }

    private static class SuKien {
        private String tenSuKien;
        private LocalDateTime thoiGian;
        private String diaDiem;

        public SuKien(String tenSuKien, LocalDateTime thoiGian, String diaDiem) {
            this.tenSuKien = tenSuKien;
            this.thoiGian = thoiGian;
            this.diaDiem = diaDiem;
        }

        public String getTenSuKien() {
            return tenSuKien;
        }

        public LocalDateTime getThoiGian() {
            return thoiGian;
        }

        public String getDiaDiem() {
            return diaDiem;
        }
    }

    private void ghiLichSu(String loaiThayDoi, String tenDichVu, String moTaThayDoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, moTaThayDoi);
        lichSuThayDoi.add(lichSu);
    }
    @Override
    public void taoSuKienGiaiTri(String tenSuKien, String thoiGian, String diaDiem) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập tên sự kiện: ");
            tenSuKien = scanner.nextLine();
            System.out.print("Nhập thời gian sự kiện (định dạng dd/MM/yyyy HH:mm): ");
            String thoiGianString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime thoiGianParsed;
            try {
                thoiGianParsed = LocalDateTime.parse(thoiGianString, formatter);
            } catch (Exception e) {
                System.out.println("Thời gian nhập không hợp lệ! Vui lòng nhập đúng định dạng dd/MM/yyyy HH:mm.");
                return;
            }
            System.out.print("Nhập địa điểm sự kiện: ");
            diaDiem = scanner.nextLine();
            danhSachSuKien.add(new SuKien(tenSuKien, thoiGianParsed, diaDiem));
            System.out.println("Đã tạo sự kiện giải trí: " + tenSuKien);
            ghiLichSu("Tạo sự kiện", tenSuKien, "Thời gian: " + thoiGianParsed + ", Địa điểm: " + diaDiem);
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi khi nhập dữ liệu: " + e.getMessage());
        }
    }

    @Override
    public void datLichGiaiTri(String tenDichVu, LocalDateTime thoiGianDat) {
        for (SuKien suKien : danhSachSuKien) {
            if (suKien.getTenSuKien().equalsIgnoreCase(tenDichVu)) {
                System.out.println("Bạn đã đặt lịch sự kiện: " + tenDichVu);
                System.out.println("Thời gian: " + suKien.getThoiGian());
                System.out.println("Địa điểm: " + suKien.getDiaDiem());
                ghiLichSu("Đặt lịch", tenDichVu, "Thời gian: " + thoiGianDat.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy sự kiện: " + tenDichVu);
    }

    @Override
    public void xemSuKienGiaiTri() {
        System.out.println("\n--- Danh Sách Sự Kiện Giải Trí ---");
        for (SuKien suKien : danhSachSuKien) {
            System.out.println("Tên sự kiện: " + suKien.getTenSuKien());
            System.out.println("Thời gian: " + suKien.getThoiGian());
            System.out.println("Địa điểm: " + suKien.getDiaDiem());
            System.out.println("-----------------------------------");
        }
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("|---------------------------------|");
        System.out.println("| Dịch vụ giải trí: " + getTenDichVu());
        System.out.println("| Giá: " + getGiaTien() + " VND");
        System.out.println("| Mô tả: " + getGioiThieu());
        System.out.println("|---------------------------------|");
    }

    @Override
    public void datMonAnTruoc(String tenMonAn) {}
    @Override
    public void taoComboMonAn() {}
}

