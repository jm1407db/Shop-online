package Model;
public class BankTransfer extends PaymentMethod{
    private int acountNumber;
    private String bankName;
    public BankTransfer(String ownerName, double amount, int acountNumber, String bankName) {
        super(ownerName, amount);
        this.acountNumber = acountNumber;
        this.bankName = bankName;
    }
    @Override
    public void ProccessPayment(){
        String acountText=""+acountNumber;
        System.out.println("Procesando pago desde cuenta ****"+ acountText.substring(acountText.length()-4)+"\n Banco: "+bankName);
    }
    public int getAcountNumber() {
        return acountNumber;
    }
    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    
}
