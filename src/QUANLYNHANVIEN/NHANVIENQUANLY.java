package QUANLYNHANVIEN;

import java.util.Date;
import java.util.Scanner;

public class NHANVIENQUANLY extends NHANVIEN {
    private int soLuong; // Số lượng nhân viên quản lý
    private String phanQuyen; // Quyền hạn của nhân viên quản lý

    public NHANVIENQUANLY() {
        super(); // Gọi constructor của lớp cha NHANVIEN
    }

    public NHANVIENQUANLY(String maNhanVien, String hoTen, Date ngaySinh, String CCCD,
                          String gioiTinh, String email, String chucVu, double mucLuong,
                          double phuCap, String trinhDo, int kinhNghiem,
                          int soLuong, String phanQuyen) {
        // Gọi phương thức khởi tạo của lớp cha
        super(maNhanVien, hoTen, ngaySinh, CCCD, gioiTinh, email, chucVu, mucLuong,
                phuCap, trinhDo, kinhNghiem);
        this.soLuong = soLuong;
        this.phanQuyen = phanQuyen;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    // Phương thức nhập thông tin dành riêng cho nhân viên quản lý
    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin của lớp cha

        do {
            System.out.print("Nhập số lượng nhân viên quản lý (>= 0): ");
            while (!sc.hasNextInt()) {
                System.out.println("Số lượng phải là số nguyên. Vui lòng nhập lại.");
                sc.next();
            }
            soLuong = sc.nextInt();
        } while (soLuong < 0);
        sc.nextLine(); // Xóa bộ đệm sau khi nhập số lượng

        do {
            System.out.print("Nhập phân quyền: ");
            phanQuyen = sc.nextLine();
        } while (phanQuyen.isEmpty());
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Gọi phương thức hiển thị thông tin của lớp cha
        System.out.printf("%-15s: %d%n", "Số lượng nhân viên", soLuong);
        System.out.printf("%-15s: %s%n", "Phân quyền", phanQuyen);
    }

    @Override
    public String toString() {
        return super.toString() + "," + soLuong + "," + phanQuyen;
    }

    // Phân công công việc cho nhân viên
    public void phanCongCongViec(String nhanVien, String congViec) {
        System.out.println("Phân công " + nhanVien + " làm công việc: " + congViec);
    }

    // Kiểm tra phân quyền
    public boolean kiemTraPhanQuyen() {
        return this.phanQuyen.equals("Admin");
    }


}