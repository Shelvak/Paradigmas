/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

/**
 *
 * @author RotseN
 * 
 * No esta implementado como el modelo, se hizo para jugar con las GUIs no mas.
 * 
 */
public abstract class Vehicle {
    private String plate;
    private int weight;
    private int max_speed;
    private int speed;
    private int wheel_count;
    private int kms_per_liter;
    private int full_tank;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWheel_count() {
        return wheel_count;
    }

    public void setWheel_count(int wheel_count) {
        this.wheel_count = wheel_count;
    }
    private int traveled_distance;
      
    public int getKms_per_liter() {
        return traveled_distance/full_tank;
    }

    public void setKms_per_liter(int kms_per_liter) {
        this.kms_per_liter = kms_per_liter;
    }

    public int getFull_tank() {
        return full_tank;
    }

    public void setFull_tank(int full_tank) {
        this.full_tank = full_tank;
    }

    public int getTraveled_distance() {
        return traveled_distance;
    }

    public void setTraveled_distance(int traveled_distance) {
        this.traveled_distance = traveled_distance;
    }

    public abstract int Consumption();
    
    public int timeToTravel() {
        return traveled_distance/getSpeed();
    }
}
