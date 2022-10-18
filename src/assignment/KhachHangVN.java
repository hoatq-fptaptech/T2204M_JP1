package assignment;

public class KhachHangVN extends KhachHang{
    private String doiTuong;

    public KhachHangVN(String code, String fullName, String invoiceDate, Integer qty, String doiTuong) {
        super(code, fullName, invoiceDate, qty);
        this.doiTuong = doiTuong;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    @Override
    public double calculateMoney() {
        if(getQty()<50)
            return getQty() * 1000;
        else if(getQty() < 100)
            return 50*1000+ (getQty()-50)*1200;
        else if(getQty() < 200)
            return 50*1000 + 50 * 1200 + (getQty()-100)*1500;
        else
            return 50*1000 + 50 * 1200 + 100 * 1500 + (getQty()-200)*2000;
    }
}
