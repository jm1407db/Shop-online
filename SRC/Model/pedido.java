package Model;

import java.util.ArrayList;

public class pedido {
    private String idPedido;
    private ArrayList<product> orderProduct= new ArrayList<product>();

    public pedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void AddProduct(product product){
        orderProduct.add(product);
    }
    
    public double TotalPrice(){
        double totalPrice=0;
        for (int i = 0; i < orderProduct.size(); i++) {
            totalPrice+=orderProduct.get(i).getPrice();
        }
        return totalPrice;
    }
}
