package QUANLYNHANVIEN;

import java.text.SimpleDateFormat;
import java.util.*;

public class NHANVIEN {
    protected String maNhanVien, hoTen;
    protected Date ngaySinh;
    protected String CCCD, gioiTinh, email, chucVu;
    private double mucLuong, phuCap;
    protected String trinhDo;
    protected int kinhNghiem;
    protected Scanner sc = new Scanner(System.in);

    private static Set<String> danhSachCCCD = new HashSet<>(); // Tập hợp CCCD
    private static Set<String> danhSachEmail = new HashSet<>(); // Tập hợp Email
    private static Set<String> danhSachMaNhanVien = new HashSet<>(); // Tập hợp mã nhân viên

    public NHANVIEN() {
    }



    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public int getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    public NHANVIEN(String maNhanVien, String hoTen, Date ngaySinh, String CCCD, String gioiTinh,
                    String email, String chucVu, double mucLuong, double phuCap,
                    String trinhDo, int kinhNghiem) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.CCCD = CCCD;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.chucVu = chucVu;
        this.mucLuong = mucLuong;
        this.phuCap = phuCap;
        this.trinhDo = trinhDo;
        this.kinhNghiem = kinhNghiem;
    }

    // Các phương thức getter và setter
    public void nhapMaNhanVien() {
        do {
            System.out.print("Nhập mã nhân viên (không được rỗng và không trùng lặp): ");
            maNhanVien = sc.nextLine();
        } while (maNhanVien.isEmpty() || danhSachMaNhanVien.contains(maNhanVien));

        danhSachMaNhanVien.add(maNhanVien); // Thêm mã nhân viên vào tập hợp
    }

    public void nhapHoTen() {
        do {
            System.out.print("Nhập họ tên (không được rỗng): ");
            hoTen = sc.nextLine();
        } while (hoTen.isEmpty());
    }

    public void nhapNgaySinh() {
        do {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine();
            try {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr);
                if (isGreaterThan18(date)) {
                    ngaySinh = date;
                    break;
                } else {
                    System.out.println("Nhân viên phải trên 18 tuổi. Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    public void nhapCCCD() {
        do {
            System.out.print("Nhập CCCD (đủ 12 số và không trùng lặp): ");
            CCCD = sc.nextLine();
        } while (CCCD.length() != 12 || danhSachCCCD.contains(CCCD));

        danhSachCCCD.add(CCCD); // Thêm CCCD vào tập hợp
    }

    public void nhapGioiTinh() {
        do {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            gioiTinh = sc.nextLine();
        } while (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nữ"));
    }

    public void nhapEmail() {
        do {
            System.out.print("Nhập email (định dạng: example@domain.com và không trùng lặp): ");
            email = sc.nextLine();
        } while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") || danhSachEmail.contains(email));

        danhSachEmail.add(email); // Thêm email vào tập hợp
    }

    public void nhapChucVu() {
        do {
            System.out.print("Nhập chức vụ (không được rỗng): ");
            chucVu = sc.nextLine();
        } while (chucVu.isEmpty());
    }

    public void nhapTrinhDo() {
        do {
            System.out.print("Nhập trình độ (không được rỗng): ");
            trinhDo = sc.nextLine();
        } while (trinhDo.isEmpty());
    }

    public void nhapKinhNghiem() {
        do {
            System.out.print("Nhập kinh nghiệm (>= 0): ");
            while (!sc.hasNextInt()) {
                System.out.println("Kinh nghiệm phải là số nguyên. Vui lòng nhập lại.");
                sc.next();
            }
            kinhNghiem = sc.nextInt();
        } while (kinhNghiem < 0);
        sc.nextLine();
    }

    public void nhapMucLuong() {
        do {
            System.out.print("Nhập mức lương (> 0): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Mức lương phải là số thực. Vui lòng nhập lại.");
                sc.next();
            }
            mucLuong = sc.nextDouble();
        } while (mucLuong <= 0);
        sc.nextLine(); // Để đọc ký tự xuống dòng
    }

    public void nhapPhuCap() {
        do {
            System.out.print("Nhập phụ cấp (>= 0 và nhỏ hơn mức lương): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Phụ cấp phải là số thực. Vui lòng nhập lại.");
                sc.next();
            }
            phuCap = sc.nextDouble();
        } while (phuCap < 0 || phuCap >= mucLuong); // Kiểm tra phụ cấp phải nhỏ hơn mức lương
        sc.nextLine(); // Để đọc ký tự xuống dòng
    }

    // Phương thức kiểm tra ngày sinh
    private boolean isGreaterThan18(Date birthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        cal.add(Calendar.YEAR, 18); // Cộng thêm 18 năm vào ngày sinh
        return cal.before(Calendar.getInstance()); // So sánh với ngày hiện tại
    }

    // Phương thức nhập thông tin nhân viên
    public void nhapThongTin() {
        nhapMaNhanVien();
        nhapHoTen();
        nhapNgaySinh();
        nhapCCCD();
        nhapGioiTinh();
        nhapEmail();
        nhapChucVu();
        nhapTrinhDo();
        nhapKinhNghiem();
        nhapMucLuong();
        nhapPhuCap();
    }


// Phương thức để hiển thị thông tin nhân viên
public void hienThiThongTin() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Header
    System.out.printf("%-15s: %s%n", "Mã nhân viên", maNhanVien);
    System.out.printf("%-15s: %s%n", "Họ tên", hoTen);
    System.out.printf("%-15s: %s%n", "Ngày sinh", sdf.format(ngaySinh));
    System.out.printf("%-15s: %s%n", "CCCD", CCCD);
    System.out.printf("%-15s: %s%n", "Giới tính", gioiTinh);
    System.out.printf("%-15s: %s%n", "Email", email);
    System.out.printf("%-15s: %s%n", "Chức vụ", chucVu);
    System.out.printf("%-15s: %s%n", "Trình độ", trinhDo);
    System.out.printf("%-15s: %d năm%n", "Kinh nghiệm", kinhNghiem);
    System.out.printf("%-15s: %.2f VNĐ%n", "Mức lương", mucLuong);
    System.out.printf("%-15s: %.2f VNĐ%n", "Phụ cấp", phuCap);
}

    // Phương thức toString để biểu diễn đối tượng dưới dạng chuỗi
    @Override
    public String toString() {
        return maNhanVien + "," + hoTen + "," + ngaySinh.getTime() + "," + CCCD + ","
                + gioiTinh + "," + email + "," + chucVu + "," + mucLuong + ","
                + phuCap + "," + trinhDo + "," + kinhNghiem;
    }


// Phương thức tính lương tổng
    public double tinhLuong() {
        return  phuCap + mucLuong;
    }
}