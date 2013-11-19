/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestore;

import Store.Inventory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.SequenceInputStream;

/**
 *
 * @author RotseN
 */
public class Deserializer implements Serializable {

    public static Inventory deserialize(String inventory)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Inventory new_inventory = null;
        FileInputStream filein = 
                new FileInputStream("inventory" + inventory + ".object");
        ObjectInputStream objectin = new ObjectInputStream (filein);
        Object object = objectin.readObject();

        if (object instanceof Inventory)
        {
            new_inventory = (Inventory) object;
        }
        
        return new_inventory;
    }

}
