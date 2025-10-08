package Model;

import javax.swing.JOptionPane;

public class BankTransfer extends PaymentMethod{
    private int acountNumber;
    private String bankName;
    public BankTransfer(String ownerName, double amount, int acountNumber, String bankName) {
        super(ownerName, amount);
        this.acountNumber = acountNumber;
        this.bankName = bankName;
    }
    @Override
    public void ProccessPayment(double totalPrice){
        String acountText=""+acountNumber;
        if (totalPrice<=amount) {
            JOptionPane.showMessageDialog(null,"Pago realizado desde Banco con numero de cuenta de ****"+acountText.substring(acountText.length()-4)+"\n Dinero total de la cuenta de"+(amount-totalPrice));
            amount=amount-totalPrice;
        }else{
            JOptionPane.showMessageDialog(null, "Dinero en la cuenta insuficiente");
        }
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
