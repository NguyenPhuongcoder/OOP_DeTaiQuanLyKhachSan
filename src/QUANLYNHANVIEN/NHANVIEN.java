package QUANLYNHANVIEN;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NHANVIEN {
    protected String maNhanVien, hoTen;
    protected Date ngaySinh;
    protected String CCCD, gioiTinh, email, chucVu;
    private double mucLuong, phuCap;
    protected String trinhDo;
    protected int kinhNghiem;
    protected Scanner sc = new Scanner(System.in);

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

    public NHANVIEN(String maNhanVien, String hoTen, Date ngaySinh, String CCCD, String gioiTinh, String email, String chucVu, double mucLuong, double phuCap, String trinhDo, int kinhNghiem) {
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
            System.out.print("Nhập mã nhân viên (không được rỗng): ");
            maNhanVien = sc.nextLine();
        } while (maNhanVien.isEmpty());
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
                ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr);
                break;
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);
    }

    public void nhapCCCD() {
        do {
            System.out.print("Nhập CCCD (đủ 12 số): ");
            CCCD = sc.nextLine();
        } while (CCCD.length() != 12);
    }

    public void nhapGioiTinh() {
        do {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            gioiTinh = sc.nextLine();
        } while (!gioiTinh.equalsIgnoreCase("Nam") && !gioiTinh.equalsIgnoreCase("Nữ"));
    }

    public void nhapEmail() {
        do {
            System.out.print("Nhập email (định dạng: example@domain.com): ");
            email = sc.nextLine();
        } while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
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
        sc.nextLine(); // Để đọc ký tự xuống dòng
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
            System.out.print("Nhập phụ cấp (>= 0): ");
            while (!sc.hasNextDouble()) {
                System.out.println("Phụ cấp phải là số thực. Vui lòng nhập lại.");
                sc.next();
            }
            phuCap = sc.nextDouble();
        } while (phuCap < 0);
        sc.nextLine(); // Để đọc ký tự xuống dòng
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
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + sdf.format(ngaySinh));
        System.out.println("CCCD: " + CCCD);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Email: " + email);
        System.out.println("Chức vụ: " + chucVu);
        System.out.println("Trình độ: " + trinhDo);
        System.out.println("Kinh nghiệm: " + kinhNghiem + " năm");
        System.out.printf("Mức lương: %.2f\n", mucLuong);
        System.out.printf("Phụ cấp: %.2f\n", phuCap);
    }

    // Phương thức toString để biểu diễn đối tượng dưới dạng chuỗi
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Mã nhân viên: " + maNhanVien + "\n" +
                "Họ tên: " + hoTen + "\n" +
                "Ngày sinh: " + sdf.format(ngaySinh) + "\n" +
                "CCCD: " + CCCD + "\n" +
                "Giới tính: " + gioiTinh + "\n" +
                "Email: " + email + "\n" +
                "Chức vụ: " + chucVu + "\n" +
                "Trình độ: " + trinhDo + "\n" +
                "Kinh nghiệm: " + kinhNghiem + " năm\n" +
                String.format("Mức lương: %.2f\n", mucLuong) +
                String.format("Phụ cấp: %.2f\n", phuCap);
    }

    // Phương thức tính lương tổng
    public double tinhLuong() {
        return  phuCap + mucLuong;
    }
}