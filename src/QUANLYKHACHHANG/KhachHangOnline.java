package QUANLYKHACHHANG;

public class KhachHangOnline extends KhachHang {
    public String phuongThucThanhToan; // Phương thức thanh toán  
    public String trangThaiThanhToan; // Trạng thái thanh toán  
    public String maGiamGia; // Mã giảm giá  

    @Override
    public void Nhap() {
        super.Nhap(); // Gọi phương thức Nhap() của lớp cha  
        System.out.print("Nhập phương thức thanh toán: ");
        phuongThucThanhToan = scanner.nextLine(); // Nhập phương thức thanh toán  
        System.out.print("Nhập trạng thái thanh toán: ");
        trangThaiThanhToan = scanner.nextLine(); // Nhập trạng thái thanh toán  
        System.out.print("Nhập mã giảm giá: ");
        maGiamGia = scanner.nextLine(); // Nhập mã giảm giá  
        System.out.println("Nhập thông tin khách hàng hoàn tất!"); // Thông báo hoàn tất  
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Phương thức thanh toán: " + phuongThucThanhToan); // Hiển thị phương thức thanh toán  
        System.out.println("Trạng thái thanh toán: " + trangThaiThanhToan); // Hiển thị trạng thái thanh toán  
        System.out.println("Mã giảm giá: " + maGiamGia); // Hiển thị mã giảm giá  
    }
}