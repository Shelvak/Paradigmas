/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Device;

import Store.Bodywork;
import Store.Engine;
import Store.Inventory;
import Store.Vehicle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RotseN
 */
public class Printer implements Serializable {
    public String print(String brand, List<Vehicle> vehicles) {
        String result = "Brand: ";
        result = result.concat(brand + "\n");
        result = result.concat("-------------------------------------------------\n");
        
        for (Vehicle vehicle : vehicles) { 
            float tmp = vehicle.parts[0].price+vehicle.parts[1].price;
            result = result.concat("Price: " + tmp + "\n");
            result = result.concat("Weight: " + vehicle.weight + "\n");
            result = result.concat("Description: " + ((Bodywork)vehicle.parts[1]).description + "\n");
            result = result.concat("Color: " + ((Bodywork)vehicle.parts[1]).color + "\n");
            result = result.concat("Cylinder Quantity: " + ((Engine)vehicle.parts[0]).cylinder_quantity + "\n");
            result = result.concat("displacement: " + ((Engine)vehicle.parts[0]).displacement + "\n");
            result = result.concat("-------------------------------------------------\n");
        }
        
        return result;
    }
}
