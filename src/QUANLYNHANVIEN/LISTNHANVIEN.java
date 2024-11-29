package QUANLYNHANVIEN;

import QUANLYPHONG.PHONG;
import QUANLYPHONG.PHONGTHUONG;
import QUANLYPHONG.PHONGVIP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LISTNHANVIEN {
    private HashMap<String, NHANVIEN> danhSach;
    private Scanner sc;

    public LISTNHANVIEN() {
        danhSach = new HashMap<>();
        sc = new Scanner(System.in);
    }

    // Phương thức thêm nhân viên
    public void themNhanVienVaoDanhSach(NHANVIEN nv) {
        if (danhSach.containsKey(nv.getMaNhanVien())) {
            System.out.println("Nhân viên đã tồn tại trong danh sách.");
        } else {
            danhSach.put(nv.getMaNhanVien(), nv);
            System.out.println("Đã thêm nhân viên.");
        }
    }

    public void themNhanVien() throws ParseException {
        Scanner sc = new Scanner(System.in);
        int i;
        int chon;
        do {
            System.out.println("------THÊM NHÂN VIÊN-------");
            System.out.println("1. thêm nhân viên bảo vệ");
            System.out.println("2. thêm nhân lễ tân");
            System.out.println("3. thêm nhân quản lý");
            System.out.println("4. thêm nhân vệ sinh");
            System.out.println("5. Thoát");
            chon = sc.nextInt();
            NHANVIEN nv = null;
            switch (chon) {
                case 1:
                    System.out.println("--> NHÂN VIÊN BẢO VỆ");
                    nv = new NHANVIENBAOVE();
                    nv.nhapThongTin();
                    themNhanVienVaoDanhSach(nv);
                    break;
                case 2:
                    System.out.println("--> NHÂN VIÊN LỄ TÂN");
                    nv = new NHANVIENLETAN();
                    nv.nhapThongTin();
                    themNhanVienVaoDanhSach(nv);
                    break;
                case 3:
                    System.out.println("--> NHÂN VIÊN QUẢN LÝ");
                    nv = new NHANVIENQUANLY();
                    nv.nhapThongTin();
                    themNhanVienVaoDanhSach(nv);
                    break;
                case 4:
                    System.out.println("--> NHÂN VIÊN VỆ SINH");
                    nv = new NHANVIENVESINH();
                    nv.nhapThongTin();
                    themNhanVienVaoDanhSach(nv);

                case 5:
                    System.out.println("THOÁT");
                    return;
                default:
                    System.out.println("DỮ LIỆU VÀO KHÔNG CHÍNH XÁC!");
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục không? (1: Tiếp tục, khác 1: Dừng): ");
            i = sc.nextInt();
            sc.nextLine(); // Đọc và bỏ qua newline
        } while (i == 1);
    }

    // Phương thức xóa nhân viên
    public void xoaNhanVien(String maNhanVien) {
        if (danhSach.containsKey(maNhanVien)) {
            danhSach.remove(maNhanVien);
            System.out.println("Đã xóa nhân viên.");
        } else {
            System.out.println("Nhân viên không tồn tại trong danh sách.");
        }
    }

    // Phương thức sửa thông tin nhân viên
    public void capNhapNhanVien(String maNhanVien) {
        if (danhSach.containsKey(maNhanVien)) {
            NHANVIEN nv = danhSach.get(maNhanVien);
            System.out.println("Nhập thông tin mới cho nhân viên (bỏ trống nếu không thay đổi):");

            System.out.print("Nhập họ tên: ");
            String hoTen = sc.nextLine();
            if (!hoTen.isEmpty()) nv.setHoTen(hoTen);

            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            if (!ngaySinhStr.isEmpty()) {
                try {
                    nv.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr));
                } catch (Exception e) {
                    System.out.println("Ngày sinh không hợp lệ.");
                }
            }

            System.out.print("Nhập CCCD: ");
            String CCCD = sc.nextLine();
            if (!CCCD.isEmpty()) nv.setCCCD(CCCD);

            System.out.print("Nhập giới tính: ");
            String gioiTinh = sc.nextLine();
            if (!gioiTinh.isEmpty()) nv.setGioiTinh(gioiTinh);

            System.out.print("Nhập email: ");
            String email = sc.nextLine();
            if (!email.isEmpty()) nv.setEmail(email);

            System.out.print("Nhập chức vụ: ");
            String chucVu = sc.nextLine();
            if (!chucVu.isEmpty()) nv.setChucVu(chucVu);

            System.out.print("Nhập trình độ: ");
            String trinhDo = sc.nextLine();
            if (!trinhDo.isEmpty()) nv.setTrinhDo(trinhDo);

            System.out.print("Nhập kinh nghiệm (năm): ");
            String kinhNghiemStr = sc.nextLine();
            if (!kinhNghiemStr.isEmpty()) nv.setKinhNghiem(Integer.parseInt(kinhNghiemStr));

            System.out.print("Nhập mức lương: ");
            String mucLuongStr = sc.nextLine();
            if (!mucLuongStr.isEmpty()) nv.setMucLuong(Double.parseDouble(mucLuongStr));

            System.out.print("Nhập phụ cấp: ");
            String phuCapStr = sc.nextLine();
            if (!phuCapStr.isEmpty()) nv.setPhuCap(Double.parseDouble(phuCapStr));

            System.out.println("Đã cập nhật thông tin nhân viên.");
        } else {
            System.out.println("Nhân viên không tồn tại trong danh sách.");
        }
    }

    // Phương thức hiển thị danh sách nhân viên
    public void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
        } else {
            for (NHANVIEN nv : danhSach.values()) {
                System.out.println(nv.toString());
                System.out.println("----------------------------");
            }
        }
    }

    // Phương thức tìm nhân viên theo mã nhân viên
    public void timNhanVien(String maNhanVien) {
        if (danhSach.containsKey(maNhanVien)) {
            NHANVIEN nv = danhSach.get(maNhanVien);
            System.out.println("Thông tin nhân viên tìm thấy:");
            System.out.println(nv.toString());
        } else {
            System.out.println("Nhân viên không tồn tại trong danh sách.");
        }
    }
    public void sapXepTheoLuong() {
        // Chuyển đổi danhSach từ HashMap sang ArrayList
        ArrayList<NHANVIEN> danhSachNV = new ArrayList<>(danhSach.values());

        Collections.sort(danhSachNV, new Comparator<NHANVIEN>() {
            @Override
            public int compare(NHANVIEN nv1, NHANVIEN nv2) {
                return Double.compare(nv1.getMucLuong(), nv2.getMucLuong());
            }
        });

        System.out.println("Danh sách nhân viên sau khi đã sắp xếp theo mức lương:");
        for (NHANVIEN nv : danhSachNV) {
            System.out.println(nv.toString());
            System.out.println("----------------------------");
        }
    }

        public void tinhTongTienTheoTongLoaiNhanVien() {
            int tongLuongBV = 0;
            int tongLuongLT = 0;
            int tongLuongQL = 0;
            int tongLuongVS = 0;

            if (this.danhSach.isEmpty()) {
                System.out.println("Danh sách nhân viên trống, không có dữ liệu để tính toán.");
                return;
            }

            for (NHANVIEN p : this.danhSach.values()) {
                    if (p instanceof NHANVIENBAOVE) {
                        tongLuongBV += p.tinhLuong();
                    } else if (p instanceof NHANVIENLETAN) {
                        tongLuongLT += p.tinhLuong();
                    } else if (p instanceof NHANVIENQUANLY) {
                        tongLuongQL += p.tinhLuong();
                    } else if (p instanceof NHANVIENVESINH) {
                        tongLuongVS += p.tinhLuong();
                    }
            }

            System.out.println("Tổng tiền nhân viên bảo vệ: " + tongLuongBV + " VNĐ");
            System.out.println("Tổng tiền nhân viên lễ tân: " + tongLuongLT + " VNĐ");
            System.out.println("Tổng tiền nhân viên quản lý: " + tongLuongQL + " VNĐ");
            System.out.println("Tổng tiền nhân viên vệ sinh: " + tongLuongVS + " VNĐ");
        }

}