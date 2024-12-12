package QUANLYPHONG;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class DANHSACHPHONG implements FILELISTPHONG{
    @Override
    public void DocFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 10) {
                    System.out.println("Dòng không hợp lệ: " + line);
                    continue; // Bỏ qua dòng này
                }

                String loaiPhong = parts[0]; // Loại phòng (PHONGTHUONG hoặc PHONGVI)
                String maPhong = parts[1];
                String tenPhong = parts[2];
                double giaPhong;
                String tinhTrangPhong = parts[4];
                LocalDateTime ngayNhanPhong = null; // Khởi tạo với null
                LocalDateTime ngayTraPhongDukien = null; // Khởi tạo với null
                double dienTichPhong;

                try {
                    giaPhong = Double.parseDouble(parts[3]);

                    // Xử lý trường hợp có giá trị "null"
                    if (!parts[5].equalsIgnoreCase("null")) {
                        ngayNhanPhong = LocalDateTime.parse(parts[5]);
                    }

                    // Xử lý trường hợp có giá trị "null"
                    if (!parts[6].equalsIgnoreCase("null")) {
                        ngayTraPhongDukien = LocalDateTime.parse(parts[6]);
                    }

                    dienTichPhong = Double.parseDouble(parts[7]);
                } catch (NumberFormatException | DateTimeParseException e) {
                    System.out.println("Lỗi khi phân tích dòng: " + line + " - " + e.getMessage());
                    continue; // Bỏ qua dòng này
                }

                if (loaiPhong.equals("PHONGVI")) {
                    double giaTienIch;
                    String[] tienIchArray;
                    double phanTramGiamGia;
                    int thoiGianSuDungTienIch;

                    try {
                        giaTienIch = Double.parseDouble(parts[8]);
                        String tienIchString = parts[9];
                        tienIchArray = tienIchString.split("-");
                        phanTramGiamGia = Double.parseDouble(parts[10]);
                        thoiGianSuDungTienIch = Integer.parseInt(parts[11]);

                        // Tạo đối tượng PHONGVIP
                        PHONGVIP phongVi = new PHONGVIP(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong, ngayTraPhongDukien, dienTichPhong, tienIchArray, phanTramGiamGia, thoiGianSuDungTienIch);
                        list.add(phongVi);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi khi phân tích thông tin phòng VIP: " + e.getMessage());
                    }
                } else if (loaiPhong.equals("PHONGTHUONG")) {
                    double giaGiam;
                    int thoiGianSudungGiamGia;

                    try {
                        giaGiam = Double.parseDouble(parts[8]); // Chỉ số này có thể không đúng
                        thoiGianSudungGiamGia = Integer.parseInt(parts[9]); // Chỉ số này có thể không đúng

                        // Tạo đối tượng PHONGTHUONG
                        PHONGTHUONG phongThuong = new PHONGTHUONG(maPhong, tenPhong, giaPhong, tinhTrangPhong, ngayNhanPhong, ngayTraPhongDukien, dienTichPhong, giaGiam, thoiGianSudungGiamGia);
                        list.add(phongThuong);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi khi phân tích thông tin phòng thường: " + e.getMessage());
                    }
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
    public void in(String loaiPhong, double dienTich, int tuGia, int denGia) {
        System.out.println("-- Danh sách phòng tìm kiếm --");

        boolean found = false; // Biến cờ để theo dõi xem có phòng nào được tìm thấy hay không

        for (PHONG p : list) {
            // Kiểm tra diện tích phòng
            if (p.dienTichPhong == dienTich && tuGia <= p.giaPhong && denGia >= p.giaPhong) {
                // Kiểm tra loại phòng
                if ("Vip".equals(loaiPhong)) {
                    if (p instanceof PHONGVIP) {
                        p.Xuat2(); // Xuất thông tin phòng VIP
                        found = true; // Đánh dấu là đã tìm thấy ít nhất một phòng
                    }
                } else {
                    p.Xuat2(); // Xuất thông tin phòng không phải VIP
                    found = true; // Đánh dấu là đã tìm thấy ít nhất một phòng
                }
                System.out.println(); // In dòng trống để phân cách giữa các phòng
            }
        }

        // Nếu không tìm thấy phòng nào, in ra thông báo
        if (!found) {
            System.out.println("Không tìm thấy phòng nào phù hợp với tiêu chí tìm kiếm.");
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
        sc.nextLine();
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
    public void chinhSuaTrangThaiPhong() {
        String[] validStatuses = {"Trống", "Đang dọn dẹp", "Đang sửa chữa", "Đang thuê"};
        System.out.println("-- CHỈNH SỬA TRẠNG THÁI PHÒNG --");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã phòng bạn muốn chỉnh sửa:");
        String maPhong = sc.nextLine();


        if (timPhong(maPhong) != null) {
            System.out.println("Danh sách trạng thái hợp lệ:");
            for (int i = 0; i < validStatuses.length; i++) {
                System.out.println((i + 1) + ". " + validStatuses[i]);
            }

            System.out.println("Chọn trạng thái mới (1-" + validStatuses.length + "):");
            int choice;

            // Kiểm tra đầu vào cho đến khi nhận được lựa chọn hợp lệ
            while (true) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= validStatuses.length) {
                    break; // Lặp cho đến khi nhận được lựa chọn hợp lệ
                } else {
                    System.out.println("Vui lòng nhập số từ " + 1 + " đến " + validStatuses.length);
                }
            }

            // Sử dụng switch-case để cập nhật trạng thái phòng
            switch (choice) {
                case 1:
                    timPhong(maPhong).setTinhTrangPhong(validStatuses[0]);
                    break;
                case 2:
                    timPhong(maPhong).setTinhTrangPhong(validStatuses[1]);
                    break;
                case 3:
                    timPhong(maPhong).setTinhTrangPhong(validStatuses[2]);
                    break;
                case 4:
                    timPhong(maPhong).setTinhTrangPhong(validStatuses[3]);
                    break;
                default:
                    // Thực tế không bao giờ đạt đến đây vì đã kiểm tra đầu vào trước đó
                    System.out.println("Lựa chọn không hợp lệ.");
                    return;
            }

            System.out.println("Cập nhật trạng thái phòng thành công! ");
        } else {
            System.out.println("Không tìm thấy phòng với mã: " + maPhong);
        }
    }
    public void chinhSuaThongTinPhong() {
        System.out.println("-- CHỈNH SỬA THÔNG TIN PHÒNG --");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã phòng bạn muốn chỉnh sửa:");
        String maPhong = sc.nextLine();


        if ( timPhong(maPhong)!= null) {
            if(timPhong(maPhong) instanceof PHONGVIP) {
                System.out.println("Danh sách thông tin bạn muốn chỉnh sửa");
                System.out.println("1.Tên phòng");
                System.out.println("2.Giá phòng");
                System.out.println("3.Diện tích phòng (25, 40, 60)");
                System.out.println("4.Phần trăm giảm giá");
                System.out.println("5.Thời gian sử dụng tiện ích");
                System.out.println("6.Thoát");
            } else if (timPhong(maPhong) instanceof PHONGTHUONG) {
                System.out.println("Danh sách thông tin bạn muốn chỉnh sửa");
                System.out.println("1.Tên phòng");
                System.out.println("2.Giá phòng");
                System.out.println("3.Diện tích phòng (25, 40, 60)");
                System.out.println("4.Phần trăm giảm giá");
                System.out.println("5.Thời gian sử dụng giảm giá");
                System.out.println("6.Thoát");
            }

            int choice;

            while (true) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Vui lòng nhập số từ " + 1 + " đến " + 6);
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Nhập tên phòng:");
                    String tenPhong = sc.next();
                    timPhong(maPhong).setTenPhong(tenPhong);
                    break;
                case 2:
                    System.out.println("Nhập giá phòng:");
                    int giaPhong = sc.nextInt();
                    timPhong(maPhong).setGiaPhong(giaPhong);
                    break;
                case 3:
                    System.out.println("Nhập diện tích phòng (25, 40, 60):");
                    int dienTichPhong = sc.nextInt();
                    // Ràng buộc giá trị diện tích
                    while (dienTichPhong != 25 && dienTichPhong != 40 && dienTichPhong != 60) {
                        System.out.println("Giá trị diện tích không hợp lệ. Vui lòng nhập lại (25, 40, 60):");
                        dienTichPhong = sc.nextInt();
                    }
                    timPhong(maPhong).setDienTichPhong(dienTichPhong);
                    break;
                case 4:
                    double phanTramGiamGia;
                    while (true) {
                        System.out.print("Nhập phần giảm giá (1%-100%): ");
                        phanTramGiamGia = sc.nextDouble();
                        if (phanTramGiamGia >= 1 && phanTramGiamGia <= 100) {
                            break; // Thoát khỏi vòng lặp nếu giá trị hợp lệ
                        } else {
                            System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại (1%-100%).");
                        }
                    }
                    if (timPhong(maPhong) instanceof PHONGVIP) {
                        ((PHONGVIP) timPhong(maPhong)).setPhanTramGiamGia(phanTramGiamGia);
                    }
                    if (timPhong(maPhong) instanceof PHONGTHUONG) {
                        ((PHONGTHUONG) timPhong(maPhong)).setPhanTramGiamGia(phanTramGiamGia);
                    }
                    break;
                case 5:
                    int thoiGianSuDungTienIch;
                    if (timPhong(maPhong) instanceof PHONGVIP) {
                        System.out.print("Nhập thời gian sử dụng tiện ích (Ngày): ");
                        thoiGianSuDungTienIch = sc.nextInt();
                        ((PHONGVIP) timPhong(maPhong)).setThoiGianSuDungTienIch(thoiGianSuDungTienIch);
                    } else if (timPhong(maPhong) instanceof PHONGTHUONG) {
                        System.out.print("Nhập thời gian sử dụng (Ngày): ");
                        thoiGianSuDungTienIch = sc.nextInt();
                        ((PHONGTHUONG) timPhong(maPhong)).setThoiGianSudungGiamGia(thoiGianSuDungTienIch);
                    } else {
                        System.out.println("Phòng không hỗ trợ thời gian sử dụng tiện ích.");
                    }
                    break;
                case 6:
                    System.out.println("Đang thoát...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    return;
            }

            System.out.println("Cập nhật thông tin phòng thành công!");
        } else {
            System.out.println("Không tìm thấy phòng với mã: " + maPhong);
        }
    }


    public void tinhTongTienTheoPhong() {
        double tienPhongVip = 0;
        double tienPhongThuong = 0;

        for (PHONG p : list) {
            if (p instanceof PHONGVIP) {
                // Kiểm tra xem các ngày có giá trị không
                if (p.getNgayNhanPhong() != null && p.getNgayTraPhongDuKien() != null) {
                    tienPhongVip += p.tinhGiaPhong(); // Tính tổng tiền
                }
            } else if (p instanceof PHONGTHUONG) {
                // Kiểm tra xem các ngày có giá trị không
                if (p.getNgayNhanPhong() != null && p.getNgayTraPhongDuKien() != null) {
                    tienPhongThuong += p.tinhGiaPhong(); // Tính tổng tiền
                }
            }
        }

        // Kiểm tra để đảm bảo rằng tổng tiền không ra 0 không mong muốn
        if (tienPhongVip > 0) {
            System.out.println("Tổng tiền phòng VIP: " + tienPhongVip + " VNĐ");
        } else {
            System.out.println("Không có phòng VIP nào được tính tiền.");
        }

        if (tienPhongThuong > 0) {
            System.out.println("Tổng tiền phòng Thường: " + tienPhongThuong + " VNĐ");
        } else {
            System.out.println("Không có phòng Thường nào được tính tiền.");
        }
    }

}
