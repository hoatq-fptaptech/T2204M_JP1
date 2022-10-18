package assignment;

public class KhachHang {
    private String code;
    private String fullName;
    private String invoiceDate;
    private Integer qty;

    public KhachHang(String code, String fullName, String invoiceDate, Integer qty) {
        this.code = code;
        this.fullName = fullName;
        this.invoiceDate = invoiceDate;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double calculateMoney(){
        return 2000* getQty();
    }
}
