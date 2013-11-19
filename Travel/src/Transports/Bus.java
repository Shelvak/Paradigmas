/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * No esta implementado como el modelo, se hizo para jugar con las GUIs no mas.
 * 
 */
package Transports;

/**
 *
 * @author RotseN
 */
public class Bus extends Passenger {
    private boolean double_floor;
    private char fuel = 'P';
   
    public Bus() {
        setPassenger_quantity(40);
    }
    
    public char getFuel() {
        return fuel;
    }

    public void setFuel(char fuel) {
        this.fuel = fuel;
    }  

    public boolean getDouble_floor() {
        return double_floor;
    }

    public void setDouble_floor(boolean double_floor) {
        this.double_floor = double_floor;
    }

    public int Consumption() {
        int consumption =  this.getFull_tank() - (this.getTraveled_distance()/(this.getKms_per_liter()*(getPassenger_quantity()/10)));
        return consumption;
    }
}
