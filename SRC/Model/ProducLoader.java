package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProducLoader {
    public static ArrayList<product> loadProducts(String pathFile){
        ArrayList<product> products= new ArrayList<>();
        try (BufferedReader bufferReader= new BufferedReader(new FileReader(pathFile))){
            String line;
            while ((line=bufferReader.readLine())!=null) {
                String [] values= line.split(",");
                int id= Integer.parseInt(values[0]);
                String nombre= values[1];
                double precio= Double.parseDouble(values[2]);
                products.add(new product(nombre, id, precio));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
        return products;
    }
}
