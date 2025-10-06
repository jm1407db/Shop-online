package Model;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class pedido {
    //Atributo polimorfico pr que puede tomar diferentes formas
    private PaymentMethod metodoPago;
    private String idPedido;
    private ArrayList<product> orderProduct= new ArrayList<product>();
    private LocalDateTime buyDate;
    private cliente cliente;
    private static final DateTimeFormatter formateadorhora= DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm");

    public void ProccessOrder(){
        System.out.println("Procesando pedido "+ idPedido +"\n" );
        metodoPago.ProccessPayment();
    }
    public pedido(String idPedido,cliente cliente,PaymentMethod metodoPago) {
        this.idPedido = idPedido;
        this.buyDate= buyDate.now();
        this.cliente= cliente;
        this.metodoPago=metodoPago;
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

    public String ShowDateOrder(){
        return buyDate.format(formateadorhora);
    }

    public String ShowExpirationDate(){
        return buyDate.plusHours(24).format(formateadorhora);
    }

    public double ShowTotalPrice(){
        double totalPrice=0;
        for (int i = 0; i < orderProduct.size(); i++) {
            totalPrice+=orderProduct.get(i).getPrice();
        }
        return totalPrice;
    }

    public String ShowInfoOrder(){
        String InfoOrder="";
        InfoOrder+= "Id del pedido="+ idPedido+"\n"+"Fecha del pedido"+ShowDateOrder();
        for (product p : orderProduct) {
            InfoOrder+="\n El producto "+p.getNameProduct()+" tuvo un costo de:$"+p.getPrice();
        }
            InfoOrder+="\n El costo total del producto es="+ ShowTotalPrice()+"\n la fecha maxima de pago es el "+ ShowExpirationDate();
            return InfoOrder;
    }
}
