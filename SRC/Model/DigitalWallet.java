package Model;

import javax.swing.JOptionPane;

public class DigitalWallet extends PaymentMethod{
    private int walletId;
    public DigitalWallet(String ownerName, double amount, int walletId) {
        super(ownerName, amount);
        this.walletId = walletId;
    }
    @Override
    public void ProccessPayment(double totalPrice){
        String textid=""+walletId;
        if (totalPrice<=amount) {
            JOptionPane.showMessageDialog(null,"Pago realizado desde Billetera digital con numero ****"+textid.substring(textid.length()-4)+"\n Dinero total de la cuenta de"+(amount-totalPrice));
            amount=amount-totalPrice;
        }else{
            JOptionPane.showMessageDialog(null, "Dinero en la cuenta insuficiente");
        }
    }
    public int getWalletId() {
        return walletId;
    }
    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
    
    
}
