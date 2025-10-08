package Model;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
public class Card extends PaymentMethod {
    private String cardNumber;
    private LocalDateTime expeditionDateTime;
    private String CVV;
    public Card(String ownerName, double amount, String cardNumber,String cVV) {
        super(ownerName, amount);
        this.cardNumber = cardNumber;
        expeditionDateTime = expeditionDateTime.now().plusYears(3);
        CVV = cVV;
    }
    @Override 
     public void ProccessPayment(double totalPrice){
        if (totalPrice<=amount) {
            JOptionPane.showMessageDialog(null,"Pago realizado desde tarjeta de credito con numero ****"+cardNumber.substring(cardNumber.length()-4)+"\n Dinero total de la cuenta de"+(amount-totalPrice));
            amount=amount-totalPrice;
        }else{
            JOptionPane.showMessageDialog(null, "Dinero en la cuenta insuficiente");
        }
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public LocalDateTime getExpeditionDateTime() {
        return expeditionDateTime;
    }
    public void setExpeditionDateTime(LocalDateTime expeditionDateTime) {
        this.expeditionDateTime = expeditionDateTime;
    }
    public String getCVV() {
        return CVV;
    }
    public void setCVV(String cVV) {
        CVV = cVV;
    }
    
    

}
