import java.util.Scanner;

public class NHANVIENBAOVE extends NHANVIEN {
    private String khuVucPhuTrach;
    private String gioLamViec;

    // Phương thức khởi tạo (constructor)
    public NHANVIENBAOVE() {
        super(); // Gọi constructor của lớp cha NHANVIEN
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
        System.out.println("Khu vực phụ trách: " + khuVucPhuTrach);
        System.out.println("Giờ làm việc: " + gioLamViec);
    }

    // Phương thức toString
    @Override
    public String toString() {
        return super.toString()  +
                "Khu vực phụ trách: " + khuVucPhuTrach + "\n" +
                "Giờ làm việc: " + gioLamViec;
    }

    // Phương thức tính lương (nếu có bất kỳ logic tính toán nào khác cho lương bảo vệ)
    @Override
    public double tinhLuong() {
        // Bạn có thể điều chỉnh nếu cần
        return super.tinhLuong(); // Có thể thêm công thức tính lương cụ thê cho nhân viên bảo vệ
    }

}