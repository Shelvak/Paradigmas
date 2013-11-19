/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;


/**
 *
 * @author RotseN
 */
interface IAccion<T extends Number> {
    public void accion(Object dato);
}

class AccionAdapter<T extends Number> implements IAccion {
    public void accion(Object dato) {
        System.out.print(dato + ", ");
    }
}

class Arbol<T extends Number> {
    private Arbol izq;
    private Arbol der;
    private Object dato;
    
    public Arbol(Object dato){
        izq = null;
        der = null;
        this.dato = dato;
    }

    public static Arbol insertar(Arbol raiz, Comparable dato){
        if ( raiz == null )
            return new Arbol((Object)dato);
        if ( dato.compareTo( raiz.dato ) < 0 ){
            raiz.izq = insertar( raiz.izq, dato );
        } else {
            raiz.der = insertar( raiz.der, dato );
        }
        return raiz;
    }
    static void preorden(Arbol raiz, IAccion accion){
        if ( raiz!=null ){
            accion.accion(raiz.dato);
            preorden (raiz.izq, accion);
            preorden (raiz.der, accion);
        }
    }
    static void inorden(Arbol raiz, IAccion accion){
        if ( raiz!=null ){
            inorden (raiz.izq, accion);
            accion.accion(raiz.dato);
            inorden (raiz.der, accion);
        }
    }
    static void postorden(Arbol raiz, IAccion accion){
        if ( raiz!=null ){
            postorden (raiz.izq, accion);
            postorden (raiz.der, accion);
            accion.accion(raiz.dato);
        }
    }
}

class EjerClaseGenerica {
    public static void main(String[] args) {
        
        Arbol<Float> arbol = null;
        
        // arbol = Arbol.insertar( arbol, new String("c"));
        
        arbol = Arbol.insertar( arbol, new Float(1.47));
        arbol = Arbol.insertar( arbol, new Float(2.37));
        arbol = Arbol.insertar( arbol, new Float(11.77));
        arbol = Arbol.insertar( arbol, new Float(3.87));
        arbol = Arbol.insertar( arbol, new Float(5.17));
        arbol = Arbol.insertar( arbol, new Float(9.47));

       
        IAccion<Float> accion = new AccionAdapter<Float>() { };
        
        System.out.println( "\nListado en Orden\n");
        Arbol.inorden( arbol, accion );
    }
}