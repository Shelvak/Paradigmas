package fibonacci;

import java.util.Scanner;

public class Fibonacci {
    
    public int Fibo(int a) {      
        if (a < 2) return 1;
        return Fibo(a-1) + Fibo(a-2);
    }
    
    public static void main(String[] args) {
        System.out.println("Ingrese un nº:");
        Scanner scan = new Scanner(System.in);
        int number = 1;
        if(scan.hasNextLine()){
            number = Integer.parseInt(scan.nextLine());
        }
        
        Fibonacci f = new Fibonacci();
        System.out.println("El fibonacci de " + number + " es: " + f.Fibo(number));
    }
}
