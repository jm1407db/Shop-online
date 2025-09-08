package Model;

import java.util.ArrayList;

public class shop {
    private ArrayList <product> ShopProducts= new ArrayList<product>();
    public String shopName;
    public String ubicacion;


    public shop(String shopName, String ubicacion) {
        this.shopName = shopName;
        this.ubicacion = ubicacion;
    }
    public ArrayList<product> getShopProducts() {
        return ShopProducts;
    }
    public void setShopProducts(ArrayList<product> shopProducts) {
        ShopProducts = shopProducts;
    }

    public void AddProducToShop(product product){
        ShopProducts.add(product);
    }

    public String showInfoProductsOfShop(){
        String infoProductsOfShop="";
        for (product product : ShopProducts) {
            infoProductsOfShop+= product.ShowInfoProduct();
        }
        return infoProductsOfShop;
    }
    
}
