package View;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.ProducLoader;
import Model.pedido;
import Model.product;
import java.awt.*;
import Model.cliente;
public class ShopnowUI extends JFrame{
    //es la lista de productos
    private JList<String> productList;
    // es donde se organiza la lista de productos
    private DefaultListModel<String>ListModel;
    private JTextArea cartArea;
    private pedido pedido;
    //aqui traeremos lo productos con el product loader
    private ArrayList<product> catalog;
    private cliente cliente;
    public ShopnowUI(){
        setTitle("Productos-----------------------------Carrito compras");
        //tamaño de la ventana
        setSize(800,900);
        //para que al cerrar se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //bordes
        setLayout(new BorderLayout());

        //se le asigna a catalogo los productos
        catalog= ProducLoader.loadProducts("C:\\Users\\User\\Downloads\\Shop online\\Catalogo.txt");
        cliente= new cliente("Pepe","123");
        pedido pedido = new pedido("1234",cliente);

        
        ListModel= new DefaultListModel<>();
        //le asignamos los productos a la lista para que los organice con add element string 
        for (product product : catalog) {
            ListModel.addElement("("+product.getIdProduct()+"--"+product.getNameProduct()+"---$"+product.getPrice()+")");
        }
        //la lista organizada en string se manda a productlist
        productList=new JList<>(ListModel);
        JScrollPane scrollCatalogo= new JScrollPane(productList);
    }
}
