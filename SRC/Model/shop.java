package Model;

import java.util.ArrayList;

public class shop {
    private ArrayList <product> ShopProducts= ProducLoader.loadProducts("C:\\Users\\User\\Downloads\\Shop online\\Catalogo.txt");
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

    public boolean VerifyProductId(int idProduct ){
        for (product product2 : ShopProducts) {
            if(product2.getIdProduct()==idProduct){
                return true;
            }
        }
        return false ;
    }

    public product ReturnProduct(int idProduct){
        for (product product : ShopProducts) {
            if (product.getIdProduct()==idProduct) {
                return product;
            }
        }
        return null;
    }
    
}
