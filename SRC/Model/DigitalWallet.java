package Model;

public class DigitalWallet extends PaymentMethod{
    private int walletId;
    public DigitalWallet(String ownerName, double amount, int walletId) {
        super(ownerName, amount);
        this.walletId = walletId;
    }
    @Override
    public void ProccessPayment(){
        String textid=""+walletId;
        System.out.println("procesando pago desde billetera digital con id ****"+textid.substring(textid.length()-4));
    }
    public int getWalletId() {
        return walletId;
    }
    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
    
    
}
