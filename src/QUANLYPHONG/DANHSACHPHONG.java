package QUANLYPHONG;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class DANHSACHPHONG implements FILELISTPHONG{
    @Override
    public void DocFile() throws IOException {
        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String loaiPhong = parts[0]; // Loại phòng
                String maPhong = parts[1];
                String tenPhong = parts[2];
                double giaPhong = Double.parseDouble(parts[3]);
                String tinhTrangPhong = parts[4];
                LocalDateTime ngayNhanPhong = LocalDateTime.parse(parts[5]);
                LocalDateTime ngayTraPhongDukien = LocalDateTime.parse(parts[6]);
                double dienTichPhong = Double.parseDouble(parts[7]);


                if (loaiPhong.equals("PHONGVI")) {
                    double giaTienIch = Double.parseDouble(parts[8]);
                    String tienIchString = parts[9];
                    String[] tienIchArray;
                    tienIchArray = tienIchString.split("-");
                    double phanTramGiamGia = Double.parseDouble(parts[10]);
                    int thoiGianSuDungTienIch = Integer.parseInt(parts[11]);

                    // Tạo đối tượng PHONGVIP
                    PHONGVIP phongVi = new PHONGVIP(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong,ngayTraPhongDukien, dienTichPhong,tienIchArray, phanTramGiamGia, thoiGianSuDungTienIch);
                    list.add(phongVi);
                } else if (loaiPhong.equals("PHONGTHUONG")) {
                    double giaGiam = Double.parseDouble(parts[7]);
                    int thoiGianSudungGiamGia = Integer.parseInt(parts[8]);

                    // Tạo đối tượng PHONGTHUONG
                    PHONGTHUONG phongThuong = new PHONGTHUONG(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong,ngayTraPhongDukien, dienTichPhong, giaGiam, thoiGianSudungGiamGia);
                    list.add(phongThuong);
                }
            }
        } // BufferedReader sẽ tự động được đóng ở đây
    }


    public static String toString(Object[] a, String separator) {
        // Kiểm tra mảng
        if (a == null) return "null";

        int iMax = a.length - 1;  // Lấy chỉ số phần tử cuối cùng
        if (iMax == -1) return "";  // Nếu mảng rỗng, trả về chuỗi rỗng

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));  // Thêm phần tử vào StringBuilder
            if (i == iMax) return b.toString();  // Trả về chuỗi mà không có ngoặc vuông
            b.append(separator);  // Thêm ký tự phân tách
        }
    }

    @Override
    public void GhiFile() throws IOException {
        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
            for (PHONG phong : list) {
                StringBuilder sb = new StringBuilder();

                // Ghi loại phòng
                if (phong instanceof PHONGVIP) {
                    sb.append("PHONGVI").append(",");
                    PHONGVIP phongVi = (PHONGVIP) phong;
                    sb.append(phongVi.getMaPhong()).append(",")
                            .append(phongVi.getTenPhong()).append(",")
                            .append(phongVi.getGiaPhong()).append(",")
                            .append(phongVi.isTinhTrangPhong()).append(",")
                            .append(phongVi.getNgayNhanPhong()).append(",")
                            .append(phongVi.getNgayTraPhongDuKien()).append(",")
                            .append(phongVi.getDienTichPhong()).append(",")
                            .append(phongVi.getGiaTienIch()).append(",")
                            .append(String.join("-", phongVi.getTienich())).append(",")
                            .append(phongVi.getPhanTramGiamGia()).append(",")
                            .append(phongVi.getThoiGianSuDungTienIch());
                } else if (phong instanceof PHONGTHUONG) {
                    sb.append("PHONGTHUONG").append(",");
                    PHONGTHUONG phongThuong = (PHONGTHUONG) phong;
                    sb.append(phongThuong.getMaPhong()).append(",")
                            .append(phongThuong.getTenPhong()).append(",")
                            .append(phongThuong.getGiaPhong()).append(",")
                            .append(phongThuong.isTinhTrangPhong()).append(",")
                            .append(phongThuong.getNgayNhanPhong()).append(",")
                            .append(phongThuong.getNgayTraPhongDuKien()).append(",")
                            .append(phongThuong.getDienTichPhong()).append(",")
                            .append(phongThuong.getGiaGiam()).append(",")
                            .append(phongThuong.getThoiGianSudungGiamGia());
                }


                writer.write(sb.toString());
                writer.newLine();
            }
        } // BufferedWriter sẽ tự động được đóng ở đây
    }

private ArrayList<PHONG> list;

    public DANHSACHPHONG(){
         list = new ArrayList<>();
    }

    public void nhap() throws ParseException {
        Scanner sc = new Scanner(System.in);
        int i;
        char chon;
        do {
            System.out.println("Nhập 'v' để thêm phòng VIP / 't' để thêm phòng thường: ");
            chon = sc.nextLine().toLowerCase().charAt(0);
            PHONG p = null;
            String maPhong;

            switch (chon) {
                case 'v':
                    System.out.println("--> PHÒNG VIP");
                    p = new PHONGVIP();
                    p.Nhap();
                    maPhong = p.getMaPhong();
                    // Kiểm tra mã phòng có tồn tại không
                    if (isMaPhongExists(maPhong)) {
                        System.out.println("Mã phòng đã tồn tại! Vui lòng nhập mã phòng khác.");
                    } else {
                        list.add(p);
                        System.out.println("Đã thêm phòng VIP thành công!");
                    }
                    break;
                case 't':
                    System.out.println("--> PHÒNG THƯỜNG");
                    p = new PHONGTHUONG();
                    p.Nhap();
                    maPhong = p.getMaPhong();
                    // Kiểm tra mã phòng có tồn tại không
                    if (isMaPhongExists(maPhong)) {
                        System.out.println("Mã phòng đã tồn tại! Vui lòng nhập mã phòng khác.");
                    } else {
                        list.add(p);
                        System.out.println("Đã thêm phòng thường thành công!");
                    }
                    break;
                default:
                    System.out.println("DỮ LIỆU VÀO KHÔNG CHÍNH XÁC!");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục không? (1: Tiếp tục, khác 1: Dừng): ");
            i = sc.nextInt();
            sc.nextLine(); // Đọc và bỏ qua newline
        } while (i == 1);
    }

    // Phương thức kiểm tra mã phòng
    private boolean isMaPhongExists(String maPhong) {
        for (PHONG p : list) {
            if (p.getMaPhong().equals(maPhong)) {
                return true; // Mã phòng đã tồn tại
            }
        }
        return false; // Mã phòng không tồn tại
    }

    public void in() {
        for (PHONG p : list) {
            p.Xuat();
            System.out.println();
        }
    }
    public void in(String loaiPhong, double dienTich) {
        System.out.println("-- Danh sách phòng tìm kiếm --");
        for (PHONG p : list) {
            // Kiểm tra diện tích phòng
            if (p.dienTichPhong == dienTich) {
                // Kiểm tra loại phòng
                if ("Vip".equals(loaiPhong)) {
                    if (p instanceof PHONGVIP) {
                        p.Xuat2(); // Xuất thông tin phòng VIP
                    }
                } else {
                    p.Xuat2(); // Xuất thông tin phòng không phải VIP
                }
                System.out.println(); // In dòng trống để phân cách giữa các phòng
            }
        }
    }
    public PHONG timPhong(String maPhong) {
        for (PHONG p : list) {
            if (maPhong.equals(p.getMaPhong())) {
                return p;
            }
        }
        return null;
    }
    public void tim() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("Nhập mã phòng cần tìm: ");
        String maPhong = sc.nextLine();
        boolean check = false;
        for (PHONG p : list) {
            if (maPhong.equals(p.getMaPhong())) {
                check = true;
                p.Xuat(); // In thông tin phòng
                break;
            }
        }
        if (!check) {
            System.out.println("Không có phòng trong danh sách!");
        }
    }
    public PHONG tim2(String maPhong) {
        String[] validStatuses = {"Trống", "Đang dọn dẹp", "Đang sửa chữa", "Đang thuê"};

        for (PHONG p : list) {
            if (maPhong.equals(p.getMaPhong())) {
                // Kiểm tra trạng thái "Trống"
                if (validStatuses[0].equals(p.tinhTrangPhong)) {
                    return p; // Nếu phòng trống, trả về phòng
                }
                // Kiểm tra trạng thái "Đang dọn dẹp"
                if (validStatuses[1].equals(p.tinhTrangPhong)) {
                    System.out.println("Phòng đang dọn dẹp chưa thể phục vụ!");
                    return null; // Nếu đang dọn dẹp, thông báo và trả về null
                }
                // Kiểm tra trạng thái "Đang sửa chữa"
                if (validStatuses[2].equals(p.tinhTrangPhong)) {
                    System.out.println("Phòng đang sửa chữa, không thể phục vụ!");
                    return null; // Nếu đang sửa chữa, thông báo và trả về null
                }
                // Kiểm tra trạng thái "Đang thuê"
                if (validStatuses[3].equals(p.tinhTrangPhong)) {
                    System.out.println("Phòng đang thuê, không thể phục vụ!");
                    return null; // Nếu đang thuê, thông báo và trả về null
                }
            }
        }
        System.out.println("Không tìm thấy phòng trên !");
        return null; // Trả về null nếu không tìm thấy phòng
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phòng cần xóa: ");
        String maPhong = sc.nextLine();
        boolean check = false;
        Iterator<PHONG> iterator = list.iterator();
        while (iterator.hasNext()) {
            PHONG p = iterator.next();
            if (maPhong.equals(p.getMaPhong())) {
                iterator.remove(); // Xóa phòng
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Đã xóa phòng khỏi danh sách!");
        } else {
            System.out.println("Không có phòng trong danh sách!");
        }
    }

    public void sapXep() {
        Collections.sort(list, Comparator.comparingDouble(PHONG::getGiaPhong).reversed());
        System.out.println("Đã sắp xếp danh sách phòng theo giá!");
    }

    public void tinhTongTienTheoPhong() {
        double tienPhongVip = 0;
        double tienPhongThuong = 0;

        for (PHONG p : list) {
            if (p instanceof PHONGVIP) {
                tienPhongVip += p.tinhGiaPhong();
            } else if (p instanceof PHONGTHUONG) {
                tienPhongThuong += p.tinhGiaPhong();
            }
        }

        System.out.println("Tổng tiền phòng VIP: " + tienPhongVip + " VNĐ");
        System.out.println("Tổng tiền phòng Thường: " + tienPhongThuong + " VNĐ");
    }

}
