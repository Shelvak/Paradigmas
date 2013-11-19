package listaenteros;

import java.util.Vector;

public class ListaEnteros {
    private Vector<Integer> elementos = new Vector();
    
    void insertar(int a){
        elementos.add(a);
    }
    
    int suma(){
        int sum = 0;
        for(int elemento : elementos)
            sum += elemento;
            
        return sum;
    }
    
    Vector<Integer> inverso(){
        Vector<Integer> reverso  = new Vector();
        int e = elementos.size() - 1 ;
        for(int i = e; i >= 0; i--)
            reverso.add(elementos.get(i));
            
        return reverso;
    }
    
    int sacar(int a){
        return elementos.get(a);
    }
    
    void eliminar(int a){
        while(elementos.contains(a))
            elementos.remove(elementos.indexOf(a));
            
    }
    
    static ListaEnteros intersectar(ListaEnteros a, ListaEnteros b){
        ListaEnteros inter = new ListaEnteros();
        Vector<Integer> stored = new Vector();
        for(int i : a.elementos){
            for(int o : b.elementos){
                if(o == i) {
                    if(!stored.contains(i)){
                        inter.insertar(i);
                        stored.add(i);
                    }
                }
            }
        }
        return inter;
    }
    
    public static void main(String[] args) {
        ListaEnteros lala = new ListaEnteros();
        
        lala.insertar(3);
        lala.insertar(2);
        lala.insertar(3);
        lala.insertar(2);
        lala.insertar(4);
        lala.insertar(2);
        lala.insertar(4);
        lala.insertar(2);
        lala.insertar(4);
        lala.insertar(2);
        lala.insertar(4);
        System.out.println("Suma: " + lala.suma());
        
        for(int a : lala.elementos)
            System.out.println("Elemento: " + a);
        
        for(int a : lala.inverso())
            System.out.println("Elemento invertido: " + a);
        
        lala.eliminar(4);
        for(int a : lala.elementos)
            System.out.println("Elemento: (con 4 eliminado) " + a);
        for(int a : lala.elementos)
            System.out.println("Elemento: " + a);
        
        ListaEnteros lala_b = new ListaEnteros();
        
        lala_b.insertar(2);
        lala_b.insertar(9);
        
        System.out.println("Interseccion");
        for(int a : ListaEnteros.intersectar(lala, lala_b).elementos)
            System.out.println("Elemento: " + a);
    }

}
