package complex;

import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;
    
    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public void setReal(double real) {
        this.real = real;
    }
    
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    
    public Complex getComplex() {
        return new Complex(this.real, this.imaginary);
    }
    
    public void Show() {
        System.out.println("Real: " + real);
        System.out.println("Imaginary: " + imaginary);
    }
    
    public void Sum(Complex a) {
        this.real += a.real;
        this.imaginary += a.imaginary;
    }    
   
    public static void main(String[] args) {
        
        Complex a = new Complex(1,2);
        Complex b = new Complex(3,4);
        
        a.Show();
        b.Show();
        
        a.Sum(b);
        
        a.Show();
    }
}