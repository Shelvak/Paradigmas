/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestore;

import Store.Inventory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author RotseN
 */
public class Serializer implements Serializable {
    
    public static void serialize (Inventory inventory) 
            throws FileNotFoundException, IOException {
        
        FileOutputStream fileout = 
                new FileOutputStream("inventory" + inventory.brand + ".object");
        ObjectOutputStream objectout = new ObjectOutputStream (fileout);
        objectout.writeObject (inventory);
    }
    
    
}
