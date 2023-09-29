package ed.complejidad;

import java.io.*;

public class UsoComplejidad extends Complejidad {

    public static void main(String[] args) {

        Complejidad c = new Complejidad();

        System.out.println("Pascal Recursivo: " + c.tPascalRec(5, 2) + " Contador: " + c.leeContador());
        c.reestableceContador();

        System.out.println("Pascal Iterativo: " + c.tPascalIt(5, 2) + " Contador: " + c.leeContador());
        c.reestableceContador();

        System.out.println("Fibonacci Recursivo: " + c.fibonacciRec(5) + " Contador: " + c.leeContador());
        c.reestableceContador();

        System.out.println("Fibonacci Iterativo: " + c.fibonacciIt(6) + " Contador: " + c.leeContador());
        c.reestableceContador();
        c.crearArchivo("leer.txt");
        c.escribeOperaciones("leer.txt", 5, 6);
        
    }
}
