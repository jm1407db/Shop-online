package Main;
import Model.BankTransfer;
import Model.Card;
import Model.DigitalWallet;
import Model.PaymentMethod;
import Model.cliente;
import Model.pedido;
import Model.shop;
import View.ShopnowUI;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class mainClass {
    public static void main(String[] args) {
        shop shoponline = new shop("Shop online", "Duitama");
        // entrada de usuario donde joption pane toma los datos del usuario para crear un objeto cliente
        JOptionPane.showMessageDialog(null, "Bienvenido a shop now");
        String userName=JOptionPane.showInputDialog("Por favor escriba su nombre");
        String userId=JOptionPane.showInputDialog("Por favor escriba un id");
        cliente cliente1 = new cliente(userName, userId);
        // usuario para tomar entradas del menu de seleccion de metodo de pago
        //contador para verificar que el usuario minimo halla registrado un metodo de pago
        byte usuario=-12;
        byte contador=0;
        boolean contadorBank=false;
        boolean contadorWallet=false;
        boolean contadorCard=false;
        PaymentMethod paymentMethod=null;
        BankTransfer bankClient = null;
        Card cardClient=null;
        DigitalWallet clientWallet=null;
        do {
            usuario=Byte.parseByte(JOptionPane.showInputDialog("Escriba 1 si quieres guardar datos de Banco \n 2 para guardar datos de tarjeta de credito \n 3 para cuardar datos de billetera digital, si ya diligencio minimo 1 puede oprimir 0 para seguir"));
            switch (usuario) {
                case 1:
                    double amountClientBank= Double.parseDouble(JOptionPane.showInputDialog("Escriba la cantidad actual de dinero"));
                    int numberCountClient= Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de su cuenta de banco"));
                    String nameBankCliente= JOptionPane.showInputDialog("Escribe el nombre de tu banco asociado");
                    bankClient= new BankTransfer(userName, amountClientBank, numberCountClient, nameBankCliente);
                    JOptionPane.showMessageDialog(null, "Banco afiliado correctamente");
                    contador++;
                    contadorBank=true;
                    break;
                case 2:
                    double amountClientCard= Double.parseDouble(JOptionPane.showInputDialog("Escriba la cantidad actual de dinero"));
                    String numberCard= JOptionPane.showInputDialog("Escribe el numero de tu tarjeta de credito");
                    String cardCVVClient= JOptionPane.showInputDialog("Escribe el numero del CVV de tu tarjeta");
                    cardClient= new Card(userName, amountClientCard, numberCard, cardCVVClient);
                    contador++;
                    contadorCard=true;
                    break;
                case 3:
                    double amountClientWallet= Double.parseDouble(JOptionPane.showInputDialog("Escriba la cantidad actual de dinero"));
                    int IdWalletClient= Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de su billetera digital"));
                    clientWallet= new DigitalWallet(userName, amountClientWallet, IdWalletClient);
                    contador++;
                    contadorWallet= true;
                    break;
                }
            } while (usuario!=0 || contador==0);
            boolean verificador= false;
            do {
                usuario=Byte.parseByte(JOptionPane.showInputDialog("Escriba 1 si quiere seleccionar como metodo de pago el Banco\n2. para seleccionar tarjeta de credito\n3 para seleccionar billetera digital"));
                switch (usuario) {
                    case 1:
                        if (contadorBank==true) {
                            paymentMethod=bankClient;
                            verificador=true;
                        }else{
                            JOptionPane.showMessageDialog(null, "no tienes un banco asociado");
                        }
                        break;
                    case 2:
                        if (contadorCard==true) {
                            paymentMethod=cardClient;
                            verificador=true;
                        }else{
                            JOptionPane.showMessageDialog(null, "no tienes una tarjeta de credito asociada");
                        }
                        break;
                    case 3:
                        if (contadorWallet==true) {
                            paymentMethod=clientWallet;
                            verificador=true;
                        }else{
                            JOptionPane.showMessageDialog(null, "no tienes un Billetera digital asociada"); 
                        }
                        break;
                
                    default:
                        break;
                }
            } while (verificador==false);
            final PaymentMethod metodoPagoUi= paymentMethod;
        SwingUtilities.invokeLater(()->{
            new ShopnowUI(cliente1,metodoPagoUi).setVisible(true);
        });
    }
}
