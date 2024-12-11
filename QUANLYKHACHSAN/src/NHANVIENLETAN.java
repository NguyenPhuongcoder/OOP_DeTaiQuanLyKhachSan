
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NHANVIENLETAN extends NHANVIEN {
    private String caLamViec;
    private String kiNang;
    private Scanner sc = new Scanner(System.in); // Khởi tạo Scanner để nhập liệu

    public NHANVIENLETAN() {
        super(); // Gọi constructor của lớp cha NHANVIEN
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getKiNang() {
        return kiNang;
    }

    public void setKiNang(String kiNang) {
        this.kiNang = kiNang;
    }

    public void nhapThongTin() {
        super.nhapThongTin(); // Gọi phương thức nhập thông tin của lớp cha

        do {
            System.out.print("Nhập ca làm việc: ");
            caLamViec = sc.nextLine();
        } while (caLamViec.isEmpty());

        do {
            System.out.print("Nhập kỹ năng: ");
            kiNang = sc.nextLine();
        } while (kiNang.isEmpty());
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin(); // Gọi phương thức hiển thị thông tin của lớp cha
        System.out.println("Ca làm việc: " + caLamViec);
        System.out.println("Kỹ năng: " + kiNang);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Ca làm việc: " + caLamViec + "\n" +
                "Kỹ năng: " + kiNang;
    }

    // Phương thức đặt lịch hẹn với khách hàng
    public void datLichHen(String khachHang, Date thoiGian) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("Đã đặt lịch hẹn với khách hàng " + khachHang + " vào lúc " + sdf.format(thoiGian));
    }


}