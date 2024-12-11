
import java.util.Scanner;

public class NHANVIENVESINH extends NHANVIEN {
    private String khuVucLamViec; // Khu vực làm việc của nhân viên vệ sinh
    private String congCuLamViec; // Công cụ làm việc của nhân viên vệ sinh
    private String caTruc; // Ca trực của nhân viên vệ sinh

    // Constructor không tham số
    public NHANVIENVESINH() {
        super(); // Gọi constructor của lớp cha NHANVIEN
    }

    // Phương thức nhập thông tin vệ sinh
    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin của lớp cha

        // Nhập khu vực làm việc
        do {
            System.out.print("Nhập khu vực làm việc: ");
            khuVucLamViec = sc.nextLine();
        } while (khuVucLamViec.isEmpty());

        // Nhập công cụ làm việc
        do {
            System.out.print("Nhập công cụ làm việc: ");
            congCuLamViec = sc.nextLine();
        } while (congCuLamViec.isEmpty());

        // Nhập ca trực
        do {
            System.out.print("Nhập ca trực: ");
            caTruc = sc.nextLine();
        } while (caTruc.isEmpty());
    }

    // Phương thức hiển thị thông tin
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Gọi phương thức hiển thị thông tin của lớp cha
        System.out.println("Khu vực làm việc: " + khuVucLamViec);
        System.out.println("Công cụ làm việc: " + congCuLamViec);
        System.out.println("Ca trực: " + caTruc);
    }

    // Phương thức toString để trả về thông tin của nhân viên vệ sinh
    @Override
    public String toString() {
        return super.toString()  +
                "Khu vực làm việc: " + khuVucLamViec + "\n" +
                "Công cụ làm việc: " + congCuLamViec + "\n" +
                "Ca trực: " + caTruc;
    }

}