package QUANLLYDICHVU;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class QUANLYDICHVU {
    private ArrayList<DICHVU> danhSachDichVu;
    private ArrayList<String> lichSuThayDoi;
    public QUANLYDICHVU() {
        danhSachDichVu = new ArrayList<>();
        lichSuThayDoi = new ArrayList<>();
        themDichVuMacDinh();
    }

    private void ghiLichSu(String loaiThayDoi, String tenDichVu, String moTaThayDoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, moTaThayDoi);
        lichSuThayDoi.add(lichSu);
    }

    private void ghiLichSuGIA(String loaiThayDoi, String tenDichVu, double giaMoi) {
        String thoiGian = LocalDateTime.now().toString();
        String lichSu = String.format("[%s] - %s: %s - %s", thoiGian, loaiThayDoi, tenDichVu, giaMoi);
        lichSuThayDoi.add(lichSu);
    }

    private void themDichVuMacDinh() {
        danhSachDichVu.add(new DICHVUGIAITRI("Karaoke", "Âm nhạc", 150000));
        danhSachDichVu.add(new DICHVUGIAITRI("Xem phim", "Phim ảnh", 100000));
        danhSachDichVu.add(new DICHVUANUONG("Buffet", "Buffet tối", 300000));
        danhSachDichVu.add(new DICHVUANUONG("Gọi món", "Món ăn theo yêu cầu", 200000));
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
                System.out.println("\nDanh sách dịch vụ ăn uống:");
                for (DICHVU dv : danhSachDichVu) {
                    if (dv instanceof DICHVUANUONG) {
                        System.out.println("Tên dịch vụ: " + dv.getTenDichVu() + "     Mô tả: " + ((DICHVUANUONG) dv).getGioiThieu());
                        System.out.println("-----------------------------------------");
                    }
                }
                break;

            case 2:
                System.out.println("\nDanh sách dịch vụ giải trí:");
                for (DICHVU dv : danhSachDichVu) {
                    if (dv instanceof DICHVUGIAITRI) {
                        System.out.println("Tên dịch vụ: " + dv.getTenDichVu() + "     Mô tả: " + ((DICHVUGIAITRI) dv).getGioiThieu());
                        System.out.println("-----------------------------------------");
                    }
                }
                break;

            case 3:
                System.out.println("\nDanh sách tất cả các dịch vụ:");
                for (DICHVU dv : danhSachDichVu) {
                    System.out.println("Tên dịch vụ: " + dv.getTenDichVu());
                    if (dv instanceof DICHVUANUONG)
                        System.out.println("Mô tả: " + ((DICHVUANUONG) dv).getGioiThieu());
                    else
                    if(dv instanceof DICHVUGIAITRI)
                        System.out.println("Mô tả: " + ((DICHVUGIAITRI) dv).getGioiThieu());
                    System.out.println("--------------------------");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    public void themDichVu(String role) {
        if (!"chu".equalsIgnoreCase(role)) {
            System.out.println("Chỉ chủ mới có quyền thêm dịch vụ!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập loại dịch vụ muốn thêm (1 - Ăn uống, 2 - Giải trí): ");
        int loaiDichVu = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên dịch vụ: ");
        String tenDichVu = scanner.nextLine();

        System.out.print("Nhập giá dịch vụ: ");
        double giaTien = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập mô tả dịch vụ: ");
        String gioiThieu = scanner.nextLine();

        if (loaiDichVu == 1) {
            danhSachDichVu.add(new DICHVUANUONG(tenDichVu, gioiThieu, giaTien));
            System.out.println("Dịch vụ ăn uống mới đã được thêm: " + tenDichVu);
            ghiLichSu("Thêm", tenDichVu, "Thêm dịch vụ mới");
        }
        else if (loaiDichVu == 2) {
            danhSachDichVu.add(new DICHVUGIAITRI(tenDichVu, gioiThieu, giaTien));
            System.out.println("Dịch vụ giải trí mới đã được thêm: " + tenDichVu);
            ghiLichSu("Thêm", tenDichVu, "Thêm dịch vụ mới");
        }
        else
            System.out.println("Loại dịch vụ không hợp lệ!");
    }

    public void suaThongTinDichVu(String role) {
        if (!"chu".equalsIgnoreCase(role)) {
            System.out.println("Chỉ chủ mới có quyền sửa thông tin dịch vụ!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên dịch vụ cần sửa: ");
        String tenDichVu = scanner.nextLine();

        for (DICHVU dv : danhSachDichVu) {
            if (dv.getTenDichVu().equalsIgnoreCase(tenDichVu)) {
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
                                ghiLichSu("Sửa", dv.getTenDichVu(), tenMoi);
                            } else
                                System.out.println("Tên không hợp lệ!");
                            break;
                        case 2:
                            System.out.print("Nhập giá mới: ");
                            double giaMoi = scanner.nextDouble();
                            if (giaMoi > 0) {
                                dv.setGiaTien(giaMoi);
                                System.out.println("Giá dịch vụ đã được cập nhật.");
                                ghiLichSuGIA("Sửa giá tiền", tenDichVu, giaMoi);
                            } else
                                System.out.println("Giá tiền không hợp lệ!");
                            break;

                        case 3:
                            System.out.print("Nhập mô tả mới: ");
                            String moTaMoi = scanner.nextLine();
                            if (!moTaMoi.isEmpty()) {
                                if (dv instanceof DICHVUANUONG) {
                                    ((DICHVUANUONG) dv).setGioiThieu(moTaMoi);
                                } else if (dv instanceof DICHVUGIAITRI) {
                                    ((DICHVUGIAITRI) dv).setGioiThieu(moTaMoi);
                                }
                                System.out.println("Mô tả dịch vụ đã được cập nhật.");
                                ghiLichSu("Sửa giới thiệu", tenDichVu, moTaMoi);
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
        System.out.println("Không tìm thấy dịch vụ có tên: " + tenDichVu);
    }

    public void xoaDichVu(String role) {
        if (!"chu".equalsIgnoreCase(role)) {
            System.out.println("Chỉ chủ mới có quyền xóa dịch vụ!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên dịch vụ muốn xóa: ");
        String tenDichVu = scanner.nextLine();

        boolean timThay = false;
        for (DICHVU dv : danhSachDichVu) {
            if (dv.getTenDichVu().equalsIgnoreCase(tenDichVu)) {
                danhSachDichVu.remove(dv);
                timThay = true;
                ghiLichSu("Xóa", tenDichVu, "Xóa dịch vụ");
                System.out.println("Dịch vụ " + tenDichVu + " đã được xóa.");
                break;
            }
        }
        if (!timThay)
            System.out.println("Không tìm thấy dịch vụ với tên: " + tenDichVu);
    }
    public void hienThiLichSuThayDoi() {
        System.out.println("\n--- Lịch sử thay đổi dịch vụ ---");
        for (String lichSu : lichSuThayDoi) {
            System.out.println(lichSu);
        }
    }
//    public void capNhatUuDaiGiaiTri(String tenDichVu, double giamGia) {
//        for (DICHVU dv : danhSachDichVu) {
//            if (dv instanceof DichVuGiaiTri && dv.getTenDichVu().equalsIgnoreCase(tenDichVu)) {
//                double giaCu = dv.getGiaTien();
//                dv.setGiaTien(giaCu - giamGia);
//                System.out.println("Dịch vụ " + tenDichVu + " đã được áp dụng ưu đãi giảm giá " + giamGia + " VND.");
//                ghiLichSuGIA("Ưu đãi", tenDichVu, dv.getGiaTien());
//                return;
//            }
//        }
//        System.out.println("Không tìm thấy dịch vụ giải trí: " + tenDichVu);
//    }

    public void chonDichVu(String role) {
        if (!"khach".equalsIgnoreCase(role)) {
            System.out.println("Chỉ khách mới có quyền chọn dịch vụ!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        ArrayList<DICHVU> dichVuDaChon = new ArrayList<>();
        String tiepTuc = "yes";

        while ("yes".equalsIgnoreCase(tiepTuc)) {
            hienThiDanhSachDichVu();

            System.out.print("Nhập tên dịch vụ bạn muốn chọn: ");
            String tenDichVu = scanner.nextLine();
            boolean timThay = false;

            for (DICHVU dv : danhSachDichVu) {
                if (dv.getTenDichVu().equalsIgnoreCase(tenDichVu)) {
                    dichVuDaChon.add((DICHVU) dv);
                    System.out.println("Đã chọn dịch vụ và lưu vào tiêu phí: " + tenDichVu);
                    timThay = true;
                    break;
                }
            }
            if (!timThay)
                System.out.println("Không tìm thấy dịch vụ với tên: " + tenDichVu);
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

    public void xemThongTinChiTietDichVu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên dịch vụ bạn muốn xem chi tiết: ");
        String tenDichVu = scanner.nextLine();

        boolean timThay = false;
        for (DICHVU dv : danhSachDichVu) {
            if (dv.getTenDichVu().equalsIgnoreCase(tenDichVu)) {
                System.out.println("\nThông tin chi tiết dịch vụ " + tenDichVu + ":");
                dv.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay)
            System.out.println("Không tìm thấy dịch vụ với tên: " + tenDichVu);
    }

    public void khaoSatHaiLong() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vui lòng đánh giá dịch vụ của chúng tôi (1-5 sao): ");
        int danhGia = scanner.nextInt();
        scanner.nextLine();

        if (danhGia < 1 || danhGia > 5) {
            System.out.println("Đánh giá không hợp lệ!");
        } else {
            System.out.println("Cảm ơn bạn đã đánh giá " + danhGia + " sao!");
            ghiLichSu("Khảo sát", "Đánh giá sao", "Số sao: " + danhGia);
        }
    }
}

