/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author RotseN
 */
public class Vehicle implements Serializable {
    public int weight;
    public Component[] parts = new Component[2];
    
    public Vehicle(
            int id, float engine_price, float bodywork_price, int weight, 
            int cylinder_quantity, int displacement, String description, 
            String color) {   
        
        parts[0] = new Engine(cylinder_quantity, displacement);
        parts[1] = new Bodywork(description, color);       
        
        this.weight = weight;
        parts[0].number = id;
        parts[0].price = engine_price;
        parts[1].number = id;
        parts[1].price = bodywork_price;
    }
}
