/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestore;

import Store.Inventory;

/**
 *
 * @author RotseN
 */
public class VehicleStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory("Porsche");
        inventory.add(1, 10000, 5000, 3000, 2, 2, "944 Turbo", "Black");
        inventory.add(2, 15000, 5000, 2800, 2, 2, "911 Carrera", "Red");
        inventory.add(3, 18300, 5000, 1200, 2, 2, "917", "White");
        System.out.println(inventory.list());
    }
}
