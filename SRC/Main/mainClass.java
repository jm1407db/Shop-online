package Main;
import Model.BankTransfer;
import Model.Card;
import Model.PaymentMethod;
import Model.cliente;
import Model.pedido;
import Model.shop;
import View.ShopnowUI;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class mainClass {
    public static void main(String[] args) {
        cliente cliente= new cliente("Pepe","123");
        BankTransfer metodoPago= new BankTransfer(cliente.getName(), 123450, 12345678, "Bancolombia");
        pedido pedidoCliente= new pedido(123, "Pepe",metodoPago);
        shop shoponline = new shop("Shop online", "Duitama");

        SwingUtilities.invokeLater(()->{
            new ShopnowUI().setVisible(true);
        });
    }
}
