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
        cliente cliente= new cliente("Pepe","123");
        BankTransfer bancoCliente= new BankTransfer(cliente.getName(), 123450, 12345678, "Bancolombia");
        DigitalWallet billeteraCliente= new DigitalWallet(cliente.getName(), 249800, 23456789);
        Card tarjetaCliente= new Card(cliente.getName(), 189000, "123451289", "123");
        pedido pedidoClienteBanco= new pedido("223", cliente, bancoCliente);
        pedido pedidoClienteTarjeta= new pedido("321", cliente, tarjetaCliente);
        pedido pedidoClienteBilletera= new pedido("123", cliente, billeteraCliente);
        pedidoClienteBanco.ProccessOrder();
        pedidoClienteTarjeta.ProccessOrder();
        pedidoClienteBilletera.ProccessOrder();

        SwingUtilities.invokeLater(()->{
            new ShopnowUI().setVisible(true);
        });
    }
}
