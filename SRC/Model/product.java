package Model;

public class product {
    private String nameProduct;
    private int idProduct;
    private double price;

    public product(String nameProduct, int idProduct, double price) {
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.price= price;
    }   

    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void ShowInfoProduct(){
        System.out.println("Product Information \n Name:"+nameProduct+" \n id:"+idProduct);
    }
    
}
