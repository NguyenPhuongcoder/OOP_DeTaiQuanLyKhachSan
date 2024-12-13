package QUANLYNHANVIEN;

import java.util.Date;
import java.util.Scanner;

public class NHANVIENBAOVE extends NHANVIEN {
    private String khuVucPhuTrach;
    private String gioLamViec;

    // Phương thức khởi tạo (constructor)
    public NHANVIENBAOVE() {
        super(); // Gọi constructor của lớp cha NHANVIEN
    }
    public NHANVIENBAOVE(String maNhanVien, String hoTen, Date ngaySinh, String CCCD,
                         String gioiTinh, String email, String chucVu, double mucLuong,
                         double phuCap, String trinhDo, int kinhNghiem,
                         String khuVucPhuTrach, String gioLamViec) {
        // Gọi phương thức khởi tạo của lớp cha
        super(maNhanVien, hoTen, ngaySinh, CCCD, gioiTinh, email, chucVu, mucLuong,
                phuCap, trinhDo, kinhNghiem);
        this.khuVucPhuTrach = khuVucPhuTrach;
        this.gioLamViec = gioLamViec;
    }

    // Phương thức nhập thông tin bảo vệ
    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin của lớp cha

        do {
            System.out.print("Nhập khu vực phụ trách: ");
            khuVucPhuTrach = sc.nextLine();
        } while (khuVucPhuTrach.isEmpty());

        do {
            System.out.print("Nhập giờ làm việc: ");
            gioLamViec = sc.nextLine();
        } while (gioLamViec.isEmpty());
    }

    // Phương thức hiển thị thông tin bảo vệ
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Gọi phương thức hiển thị thông tin của lớp cha
        System.out.printf("%-15s: %s%n", "Khu vực phụ trách", khuVucPhuTrach);
        System.out.printf("%-15s: %s%n", "Giờ làm việc", gioLamViec);
    }

    // Phương thức toString


        @Override
        public String toString() {
            return super.toString() + "," + khuVucPhuTrach + "," + gioLamViec;
        }


    // Phương thức tính lương (nếu có bất kỳ logic tính toán nào khác cho lương bảo vệ)
    @Override
    public double tinhLuong() {
        // Bạn có thể điều chỉnh nếu cần
        return super.tinhLuong(); // Có thể thêm công thức tính lương cụ thê cho nhân viên bảo vệ
    }

}