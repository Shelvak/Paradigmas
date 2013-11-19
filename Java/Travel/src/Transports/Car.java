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
public class Car extends Passenger {
    private char fuel = 'P';
    
    public Car() {
        setPassenger_quantity(4);
    }
   
    public char getFuel() {
        return fuel;
    }

    public void setFuel(char fuel) {
        this.fuel = fuel;
    }  

    public int getPassenger_quantity() {
        return super.getPassenger_quantity(); 
    }

    public void setPassenger_quantity(int passenger_quantity) {
        super.setPassenger_quantity(passenger_quantity);
    }
    
    public int Consumption() {      
        int consumption;
        consumption = this.getFull_tank() - (this.getTraveled_distance()/(this.getKms_per_liter()*(this.getPassenger_quantity())));
        return consumption;
    }
}
