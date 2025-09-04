package Main;

import Model.cliente;
import Model.pedido;
import Model.product;

public class mainClass {
    public static void main(String[] args) {
        cliente pepe=new cliente("pepe", "1234");
        product sopa= new product("sopa maicena", 2345, 23450);
        product papas= new product("papas super ricas", 3456, 7500);
        product ropa= new product("camisa", 1237, 15750);
        product lentes= new product("lentes transition", 9078, 81350);
        product zapatos= new product("converse zapatos", 8767, 120400);
        pepe.MostrarInfo();
        sopa.ShowInfoProduct();
        pedido pedido= new pedido("1234");
        pedido.AddProduct(sopa);
        pedido.AddProduct(ropa);
        pedido.AddProduct(papas);
        pedido.AddProduct(zapatos);
        pedido.AddProduct(lentes);
        System.out.println("id PEDIDO:"+pedido.getIdPedido()+" \n El precio total de la compra hasta ahora es: $"+pedido.TotalPrice()+ " Pesos");

    }
}
