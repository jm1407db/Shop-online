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

    public Double ShowTotalPrice(){
        double totalPrice=0;
        for (int i = 0; i < orderProduct.size(); i++) {
            totalPrice+=orderProduct.get(i).getPrice();
        }
        return totalPrice;
    }
    
    public String ShowInfoOrder(){
        String mensaje="";
        for (int i = 0; i < orderProduct.size(); i++) {
            mensaje+="El producto "+orderProduct.get(i).getNameProduct()+" tuvo un costo de:$"+orderProduct.get(i).getPrice()+"\n";
        } 
        return mensaje;
    }
}
