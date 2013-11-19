/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import Device.Printer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author RotseN
 */
public class Inventory implements Serializable {
    /**
     *
     */
    public String brand;
    public List<Vehicle> vehicles = new ArrayList<Vehicle>(); 
    public Printer printer = new Printer();
    
    public Inventory() {}
    
    public Inventory(String brand) {
        this.brand = brand;
    }
    
    public void add(
                int id, float engine_price, float bodywork_price, int weight, 
                int cylinder_quantity, int displacement, String description, 
                String color) {
        
        vehicles.add(
                    new Vehicle(
                        id, engine_price, bodywork_price, weight, cylinder_quantity, 
                        displacement, description, color
                    )
                );
    }
    
    public String list() {
        return printer.print(brand, vehicles);
    } 
    
}
