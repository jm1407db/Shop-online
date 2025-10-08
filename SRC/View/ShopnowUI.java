package View;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Model.BankTransfer;
import Model.Card;
import Model.PaymentMethod;
import Model.ProducLoader;
import Model.pedido;
import Model.product;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    private PaymentMethod paymentMethod ;
    private cliente cliente;
    public ShopnowUI( cliente cliente, PaymentMethod paymentMethod){
        this.cliente= cliente;
        this.paymentMethod= paymentMethod;
        this.pedido= new pedido(cliente.getId(), cliente, paymentMethod);
        setTitle("Productos-----------------------------Carrito compras");
        //tamaño de la ventana
        setSize(800,900);
        //para que al cerrar se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //bordes
        setLayout(new BorderLayout());

        //se le asigna a catalogo los productos
        catalog= ProducLoader.loadProducts("Catalogo.txt");
        ListModel= new DefaultListModel<>();
        //le asignamos los productos a la lista para que los organice con add element string 
        for (product product : catalog) {
            ListModel.addElement("("+product.getIdProduct()+"--"+product.getNameProduct()+"---$"+product.getPrice()+")");
        }
        //la lista organizada en string se manda a productlist
        productList=new JList<>(ListModel);
        JScrollPane scrollCatalogo= new JScrollPane(productList);
        JButton addButton= new JButton("Agregar al carrito");
        cartArea = new JTextArea(10,30);
        
        addButton.addActionListener((ActionEvent e)->{
            int selectProduct= productList.getSelectedIndex();
            if (selectProduct!=-1) {
                product product= catalog.get(selectProduct);
                pedido.AddProduct(product);
                cartArea.append(product.getNameProduct()+" $"+product.getPrice());
                
            }
        });
        //Panel del catalogo de productos
        JPanel leftPanel= new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Catalogo de productos"),BorderLayout.NORTH);
        leftPanel.add(scrollCatalogo,BorderLayout.CENTER);
        leftPanel.add(addButton,BorderLayout.SOUTH);

        //Panel del carrito
        JScrollPane scrollCarrito= new JScrollPane(cartArea);
        JPanel rigthPanel= new JPanel(new BorderLayout());
        rigthPanel  .add(new JLabel("Carrito de compras"),BorderLayout.NORTH);
        rigthPanel.add(scrollCarrito,BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Finalizar pedido");
        checkoutButton.addActionListener((ActionEvent e)->{
            double totalPrice= pedido.ShowTotalPrice();
            cartArea.append(pedido.ShowInfoOrder());
            paymentMethod.ProccessPayment(totalPrice);
            if (totalPrice<paymentMethod.amount) {
                pedido.resetPedido();
            }
        });
        rigthPanel.add(checkoutButton,BorderLayout.SOUTH);

        //Dividir la pantalla en dos
        add(leftPanel,BorderLayout.WEST);
        add(rigthPanel,BorderLayout.EAST);

    }
}