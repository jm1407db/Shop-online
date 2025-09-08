package Main;

import Model.cliente;
import Model.pedido;
import Model.product;
import Model.shop;

import javax.swing.JOptionPane;

public class mainClass {
    public static void main(String[] args) {
        shop shoponline = new shop("Shop online", "Duitama");

        cliente pepe = new cliente("pepe", "1234");

        product sopa = new product("sopa maicena", 2345, 23450);
        product papas = new product("papas super ricas", 3456, 7500);
        product camisa = new product("camisa", 1237, 15750);
        product lentes = new product("lentes transition", 9078, 81350);
        product zapatos = new product("converse zapatos", 8767, 120400);
        product crema = new product("crema hidratante", 2389, 7000);
        product televisor = new product("Televisor LG", 4523, 680900);
        product mouse = new product("mouse logitech", 6789, 81700);
        product bocinas = new product("bocinas xps", 3412, 67000);
        product cartas = new product("Cartas poker", 6709, 15000);

        shoponline.AddProducToShop(sopa);
        shoponline.AddProducToShop(papas);
        shoponline.AddProducToShop(camisa);
        shoponline.AddProducToShop(lentes);
        shoponline.AddProducToShop(zapatos);
        shoponline.AddProducToShop(crema);
        shoponline.AddProducToShop(televisor);
        shoponline.AddProducToShop(mouse);
        shoponline.AddProducToShop(bocinas);
        shoponline.AddProducToShop(cartas);

        pedido pedido = new pedido("1234");
        JOptionPane.showMessageDialog(null, "BIENVENIDO A SHOP ONLINE", "Inicio", 1);
        int usuario=12;
        do {
            usuario=Integer.parseInt(JOptionPane.showInputDialog(null, "Esto son los productos que ofrecemos en nuestra tienda: \n "
                    + shoponline.showInfoProductsOfShop()
                    + "\n (Si quiere seleccionar un producto porfavor escriba el id del producto, !Si desea salir presione 0!)"));
            switch (usuario) {
                case 2345:
                    pedido.AddProduct(sopa);
                    JOptionPane.showMessageDialog(null, "Producto"+sopa.getNameProduct()+" agregado");
                    break;
                case 3456:
                    pedido.AddProduct(papas);
                    JOptionPane.showMessageDialog(null, "Producto"+papas.getNameProduct()+" agregado");
                    break;
                case 1237:
                    pedido.AddProduct(camisa);
                    JOptionPane.showMessageDialog(null, "Producto"+camisa.getNameProduct()+" agregado");
                    break;
                case 9078:
                    pedido.AddProduct(lentes);
                    JOptionPane.showMessageDialog(null, "Producto"+lentes.getNameProduct()+" agregado");
                    break;
                case 8767:
                    pedido.AddProduct(zapatos);
                    JOptionPane.showMessageDialog(null, "Producto"+zapatos.getNameProduct()+" agregado");
                    break;
                case 2389:
                    pedido.AddProduct(crema);
                    JOptionPane.showMessageDialog(null, "Producto"+crema.getNameProduct()+" agregado");
                    break;
                case 4523:
                    pedido.AddProduct(televisor);
                    JOptionPane.showMessageDialog(null, "Producto"+televisor.getNameProduct()+" agregado");
                    break;
                case 6789:
                    pedido.AddProduct(mouse);
                    JOptionPane.showMessageDialog(null, "Producto"+mouse.getNameProduct()+" agregado");
                    break;
                case 3412:
                    pedido.AddProduct(bocinas);
                    JOptionPane.showMessageDialog(null, "Producto"+bocinas.getNameProduct()+" agregado");
                    break;
                case 6709:
                    pedido.AddProduct(cartas);
                    JOptionPane.showMessageDialog(null, "Producto "+cartas.getNameProduct()+ " agregado");
                    break;
                default:
                    if(usuario!=0){
                        JOptionPane.showMessageDialog(null, "ID NO ENCONTRADO POR FAVOR INTENTE DE NUEVO", "ERROR 404", 0);
                    }
                break;
            }
        } while (usuario!=0);
        JOptionPane.showMessageDialog(null, pedido.ShowInfoOrder()+"\n Gracias por usar shop online", "Bye", usuario);
    }
}
