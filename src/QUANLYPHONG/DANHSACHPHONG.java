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
                boolean tinhTrangPhong = Boolean.parseBoolean(parts[4]);
                LocalDateTime ngayNhanPhong = LocalDateTime.parse(parts[5]);
                double dienTichPhong = Double.parseDouble(parts[6]);


                if (loaiPhong.equals("PHONGVI")) {
                    double giaTienIch = Double.parseDouble(parts[7]);
                    String tienIchString = parts[8];
                    String[] tienIchArray;
                    tienIchArray = tienIchString.split("-");
                    double phanTramGiamGia = Double.parseDouble(parts[9]);
                    int thoiGianSuDungTienIch = Integer.parseInt(parts[10]);

                    // Tạo đối tượng PHONGVIP
                    PHONGVIP phongVi = new PHONGVIP(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong, dienTichPhong,tienIchArray, phanTramGiamGia, thoiGianSuDungTienIch);
                    list.add(phongVi);
                } else if (loaiPhong.equals("PHONGTHUONG")) {
                    double giaGiam = Double.parseDouble(parts[7]);
                    int thoiGianSudungGiamGia = Integer.parseInt(parts[8]);

                    // Tạo đối tượng PHONGTHUONG
                    PHONGTHUONG phongThuong = new PHONGTHUONG(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong, dienTichPhong, giaGiam, thoiGianSudungGiamGia);
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
    public void GhiFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
            for (PHONG phong : list) {
                if (phong instanceof PHONGVIP) {
                    PHONGVIP phongVi = (PHONGVIP) phong;
                    writer.write("PHONGVIP," +
                            phongVi.getMaPhong() + "," +
                            phongVi.getTenPhong() + "," +
                            phongVi.getGiaPhong() + "," +
                            phongVi.isTinhTrangPhong() + "," +
                            phongVi.getNgayNhanPhong() + "," +
                            phongVi.getThoiGianSuDungTienIch());
                    writer.newLine();
                } else if (phong instanceof PHONGTHUONG) {
                    PHONGTHUONG phongThuong = (PHONGTHUONG) phong;
                    writer.write("PHONGTHUONG," +
                            phongThuong.getMaPhong() + "," +
                            phongThuong.getTenPhong() + "," +
                            phongThuong.getGiaPhong() + "," +
                            phongThuong.isTinhTrangPhong() + "," +
                            phongThuong.getNgayNhanPhong() + "," +
                            phongThuong.getDienTichPhong() + "," +
                            phongThuong.getGiaGiam() + "," +
                            phongThuong.getThoiGianSudungGiamGia());
                    writer.newLine();
                }
            }
            System.out.println("Đã ghi danh sách phòng vào tệp!");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi tệp: " + e.getMessage());
        }
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
            sc.nextLine();
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
