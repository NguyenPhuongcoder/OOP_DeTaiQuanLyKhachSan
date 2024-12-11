import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LISTNHANVIEN {
    private HashMap<String, NHANVIEN> DANHSACH;
    private Scanner sc;

    public LISTNHANVIEN() {
        DANHSACH = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void QuanLyNhanVien() {
        while (true) {
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Cap nhat thong tin nhan vien");
            System.out.println("4. Hien thi danh sach nhan vien");
            System.out.println("5. Tim kiem lich lam viec");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    ThemNhanVien();
                    break;
                case 2:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maNhanVien = sc.nextLine();
                    xoaNhanVien(maNhanVien);
                    break;
                case 3:
                    System.out.print("Nhap ma nhan vien can cap nhat: ");
                    maNhanVien = sc.nextLine();
                    capNhapNhanVien(maNhanVien);
                    break;
                case 4:
                    hienThiDanhSach();
                    break;
                case 5:
                    System.out.print("Nhap ma nhan vien hoac ho ten de tim kiem lich lam viec: ");
                    String keyword = sc.nextLine();
                    timKiemLichLamViec(keyword);
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap lai.");
            }
        }
    }

    public void ThemNhanVien() {
        while (true) {
            System.out.println("1. Them nhan vien le tan");
            System.out.println("2. Them nhan vien bao ve");
            System.out.println("3. Them nhan vien quan ly");
            System.out.println("4. Them nhan vien ve sinh");
            System.out.println("5. Thoat");
            System.out.println("nhap lua chon : ");
            int lc = sc.nextInt();
            sc.nextLine();
            switch (lc) {
                case 1:
                    NHANVIENLETAN nvLeTan = new NHANVIENLETAN();
                    nvLeTan.nhapThongTin();
                    DANHSACH.put(nvLeTan.getMaNhanVien(), nvLeTan);
                    break;
                case 2:
                    NHANVIENBAOVE nvBaoVe = new NHANVIENBAOVE();
                    nvBaoVe.nhapThongTin();
                    DANHSACH.put(nvBaoVe.getMaNhanVien(), nvBaoVe);
                    break;
                case 3:
                    NHANVIENQUANLY nvQuanLy = new NHANVIENQUANLY();
                    nvQuanLy.nhapThongTin();
                    DANHSACH.put(nvQuanLy.getMaNhanVien(), nvQuanLy);
                    break;
                case 4:
                    NHANVIENVESINH nvVeSinh = new NHANVIENVESINH();
                    nvVeSinh.nhapThongTin();
                    DANHSACH.put(nvVeSinh.getMaNhanVien(), nvVeSinh);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le! Vui long nhap lai.");
            }
        }
    }


    public void xoaNhanVien(String maNhanVien) {
        if (DANHSACH.containsKey(maNhanVien)) {
            DANHSACH.remove(maNhanVien);
            System.out.println("Da xoa nhan vien.");
        } else {
            System.out.println("Nhan vien khong ton tai trong danh sach.");
        }
    }

    public void capNhapNhanVien(String maNhanVien) {
        if (DANHSACH.containsKey(maNhanVien)) {
            NHANVIEN nv = DANHSACH.get(maNhanVien);
            System.out.println("Nhap thong tin moi cho nhan vien (bo trong neu khong thay doi):");

            System.out.print("Nhap ho ten: ");
            String hoTen = sc.nextLine();
            if (!hoTen.isEmpty()) nv.setHoTen(hoTen);

            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            if (!ngaySinhStr.isEmpty()) {
                try {
                    nv.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr));
                } catch (Exception e) {
                    System.out.println("Ngay sinh khong hop le.");
                }
            }

            System.out.print("Nhap CCCD: ");
            String CCCD = sc.nextLine();
            if (!CCCD.isEmpty()) nv.setCCCD(CCCD);

            System.out.print("Nhap gioi tinh: ");
            String gioiTinh = sc.nextLine();
            if (!gioiTinh.isEmpty()) nv.setGioiTinh(gioiTinh);

            System.out.print("Nhap email: ");
            String email = sc.nextLine();
            if (!email.isEmpty()) nv.setEmail(email);

            System.out.print("Nhap chuc vu: ");
            String chucVu = sc.nextLine();
            if (!chucVu.isEmpty()) nv.setChucVu(chucVu);

            System.out.print("Nhap trinh do: ");
            String trinhDo = sc.nextLine();
            if (!trinhDo.isEmpty()) nv.setTrinhDo(trinhDo);

            System.out.print("Nhap kinh nghiem (nam): ");
            String kinhNghiemStr = sc.nextLine();
            if (!kinhNghiemStr.isEmpty()) nv.setKinhNghiem(Integer.parseInt(kinhNghiemStr));

            System.out.print("Nhap muc luong: ");
            String mucLuongStr = sc.nextLine();
            if (!mucLuongStr.isEmpty()) nv.setMucLuong(Double.parseDouble(mucLuongStr));

            System.out.print("Nhap phu cap: ");
            String phuCapStr = sc.nextLine();
            if (!phuCapStr.isEmpty()) nv.setPhuCap(Double.parseDouble(phuCapStr));

            System.out.println("Da cap nhat thong tin nhan vien.");
        } else {
            System.out.println("Nhan vien khong ton tai trong danh sach.");
        }
    }

    public void hienThiDanhSach() {
        if (DANHSACH.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
        } else {
            for (NHANVIEN nv : DANHSACH.values()) {
                System.out.println(nv.toString());
                System.out.println("----------------------------");
            }
        }
    }

    public void timKiemLichLamViec(String keyword) {
        boolean found = false;
        for (NHANVIEN nv : DANHSACH.values()) {
            if (nv.getMaNhanVien().equalsIgnoreCase(keyword) || nv.getHoTen().equalsIgnoreCase(keyword)) {
                System.out.println("Lich lam viec cua nhan vien:");
                System.out.println(nv.toString()); // Giả sử toString chứa lịch làm việc
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien co lich lam viec nhu yeu cau.");
        }
    }




}
