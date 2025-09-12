package Main;
import Model.cliente;
import Model.pedido;
import Model.shop;
import javax.swing.JOptionPane;

public class mainClass {
    public static void main(String[] args) {

        shop shoponline = new shop("Shop online", "Duitama");

        JOptionPane.showMessageDialog(null, "BIENVENIDO A SHOP ONLINE", "Inicio", 1);
        int usuario=12;
        do {
            usuario=Integer.parseInt(JOptionPane.showInputDialog(null, "Esto son los productos que ofrecemos en nuestra tienda: \n "
                    + shoponline.showInfoProductsOfShop()
                    + "\n (Si quiere seleccionar un producto porfavor escriba el id del producto, !Si desea salir presione 0!)"));
            if (usuario!=0) {
                if (shoponline.VerifyProductId(usuario)==true) {
                    pedido.AddProduct(shoponline.ReturnProduct(usuario));
                }
            }
        } while (usuario!=0);
        JOptionPane.showMessageDialog(null, pedido.ShowInfoOrder()+"\n Gracias por usar shop online", "Bye", usuario);
    }
}
