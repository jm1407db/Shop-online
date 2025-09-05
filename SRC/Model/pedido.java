package Model;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class pedido {
    private String idPedido;
    private ArrayList<product> orderProduct= new ArrayList<product>();
    private LocalDateTime buyDate;

    public pedido(String idPedido) {
        this.idPedido = idPedido;
        this.buyDate= buyDate.now();
    }

    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
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

    public void ShowInfoOrder(){
        System.out.println("Id del pedido="+ idPedido);
        System.out.println("Fecha del pedido="+buyDate);
        for (product p : orderProduct) {
             System.out.println("El producto "+p.getNameProduct()+" tuvo un costo de:$"+p.getPrice());
        }
        System.out.println("El costo total del producto es="+ ShowTotalPrice());
        System.out.println("la fecha maxima de pago"+buyDate.plusHours(24));
    }
}
