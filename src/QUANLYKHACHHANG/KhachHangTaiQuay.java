package QUANLYKHACHHANG;

import java.time.LocalDateTime;
import java.util.Scanner;

public class KhachHangTaiQuay extends KhachHang {
    public String tenQuay; // Tên quầy  
    public LocalDateTime thoiGianGiaoDich; // Thời gian giao dịch  

    private static final Scanner scanner = new Scanner(System.in); // Khai báo scanner để nhập dữ liệu  

    @Override
    public void Nhap() {
        super.Nhap(); // Gọi phương thức Nhap() của lớp cha  
        System.out.print("Nhập tên quầy thanh toán: ");
        tenQuay = scanner.nextLine(); // Nhập tên quầy  
        thoiGianGiaoDich = LocalDateTime.now(); // Ghi lại thời gian giao dịch  
        System.out.println("Nhập thông tin khách hàng hoàn tất!");
    }

    @Override
    public void Xuat() {
        super.Xuat(); // Gọi phương thức Xuat() của lớp cha  
        System.out.println("Tên quầy thanh toán: " + tenQuay); // Hiển thị tên quầy  
        System.out.println("Thời gian giao dịch: " + thoiGianGiaoDich); // Hiển thị thời gian giao dịch  
    }
}