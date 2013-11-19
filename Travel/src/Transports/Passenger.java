/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * No esta implementado como el modelo, se hizo para jugar con las GUIs no mas.
 * 
 */
package Transports;

import Vehicles.Vehicle;

/**
 *
 * @author RotseN
 */
public abstract class Passenger extends Vehicle {
    private int passenger_quantity;

    public int getPassenger_quantity() {
        return passenger_quantity;
    }

    public void setPassenger_quantity(int passenger_quantity) {
        this.passenger_quantity = passenger_quantity;
    }
}
