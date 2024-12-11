package QUANLYTAIKHOANKH;

public class KIEMTRA {
    public KIEMTRA() {
    }


    public boolean checkTenTK(String chuTaiKhoan){
        return !chuTaiKhoan.matches(".*[0-9]+.*") &&!chuTaiKhoan.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
    }

    public boolean kiemTraDoManhMatKhau(String matKhau)
    {
        return matKhau.length() >= 6 && matKhau.matches(".*[A-Z]+.*") &&
                matKhau.matches(".*[a-z]+.*") &&
                matKhau.matches(".*[0-9]+.*") &&
                matKhau.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*");
    }

    public boolean checkCCCD(String cccd) {
        return cccd.matches("\\d{12}");
    }

    // Phương thức kiểm tra số điện thoại
    public boolean checkSdt(String sdt) {
        return sdt.matches("\\d{10}|\\d{11}");
    }

}
