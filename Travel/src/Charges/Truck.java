/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 * No esta implementado como el modelo, se hizo para jugar con las GUIs no mas.
 * 
 */
package Charges;

import Vehicles.Vehicle;

public class Truck extends Vehicle implements Charge {
    private int charge;
    private char type;
    private char fuel = 'P';
           
    public char getFuel() {
        return fuel;
    }

    public void setFuel(char fuel) {
        this.fuel = fuel;
    }  
    
    public void setCharge(int charge) {
        this.charge = charge;
    }
    
    public void setType(char type) {
        this.type = type;
    }
    
    public char getType() {
        return this.type;
    }
    
    public int getCharge() {
       return this.charge;
    }
    
    public int Consumption() {
       int consumption =  this.getFull_tank() - (this.getTraveled_distance()/(this.getKms_per_liter()*(getCharge())));
       return consumption;
    } 
}
