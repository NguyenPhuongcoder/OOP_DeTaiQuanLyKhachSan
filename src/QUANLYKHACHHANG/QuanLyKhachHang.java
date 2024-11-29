package QUANLYKHACHHANG;
public interface QuanLyKhachHang {
        void khachHangMoi(KhachHang kh); // Thêm khách hàng mới
        void xoaKhachHang(String maKH);  // Xóa khách hàng theo mã
        void chinhSuaThongTin(String maKH); // Chỉnh sửa thông tin khách hàng
        void In(); // In danh sách khách hàng
        void tinhSoNgayThue(String maKH); // Tính số ngày thuê của một khách hàng
}


