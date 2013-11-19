package Charges;

public interface Charge {
    int max_charge = 40000;
    char coupled = 'C';
    char trailer = 'T';
    char simple = 'S';
    
    public int getCharge();
}
