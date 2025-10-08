package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        } catch (FileNotFoundException e) {// elFileNotFoundException es para que el try atrape solo el error cuando el ar
            //el archivo no es encontrado para que se sepa especificamente cual es el error
            JOptionPane.showMessageDialog(null, "No se encontro el archivo"+e.getMessage());
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Inconvenienet:"+e);
        }
        return products;
    }
}
