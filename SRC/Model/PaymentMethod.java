package Model;
public class PaymentMethod {
    private String ownerName;
    public double amount;
    
    public PaymentMethod(String ownerName, double amount) {
        this.ownerName = ownerName;
        this.amount = amount;
    }
    public void ProccessPayment(double totalPrice){
        
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
