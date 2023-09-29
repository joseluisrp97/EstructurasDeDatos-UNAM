package ed.estructuras.lineales;

import java.io.*;

public class ArregloPolinomio implements Arreglo {
    private int[] dimensiones;
    private int[] local;

    /**
     * Método Constructor
     * 
     * @param dimensiones - Dimensiones del arreglo
     * @throw IllegalSizeException si algun valor del arreglo es
     *        negativo
     */
    public ArregloPolinomio(int[] dimensiones) {
        this.dimensiones = dimensiones;
        int mult = 1;
        for (int i = 0; i < this.dimensiones.length; i++) {
            if (this.dimensiones[i] < 0)
                throw new IllegalSizeException("El índice " + i + " está fuera de rango.");
        }
        for (int i = 0; i < dimensiones.length; i++) {
            mult *= this.dimensiones[i];
        }
        local = new int[mult];
    }

    /**
     * Devuelve el elemento que se encuentra en la posición <code>th</code> en
     * el arreglo multidimensional.
     *
     * @param indices arreglo con los índices del elemento a recuperar.
     * @return el elemento almacenado en la posición <code>i</code>.
     */
    @Override
    public int obtenerElemento(int[] índices) {
        return local[obtenerÍndice(índices)];
    }

    /**
     * Asigna un elemento en la posición <code>th</code> del arreglo
     * multidimensional.
     *
     * @param índices arreglo con los índices donde se almacenará el elemento.
     * @param elem    elemento a almacenar.
     */
    @Override
    public void almacenarElemento(int[] índices, int elem) {
        local[obtenerÍndice(índices)] = elem;
    }

    /**
     * Devuelve la posición <code>i</code> del elemento en el arreglo de una
     * dimensión.
     *
     * @param índices arreglo con los índices donde está el elemento en el
     *                arreglo multidimensional. Se debe cumplir que cada índice es
     *                positivo y
     *                menor que el tamaño de la dimensión correspondiente.
     *
     * @return la posición del elemento en el arreglo de una dimensión.
     * @throws IndexOutOfBoundsException si alguno de los índices del arreglo no
     *                                   está dentro del rango.
     */
    @Override
    public int obtenerÍndice(int[] índices) {

        if (índices.length != dimensiones.length) {
            throw new IllegalSizeException("Algún índice está fuera de rango.");
        }
        for (int i = 0; i < índices.length; i++) {
            if (índices[i] < 0 || índices[i] >= dimensiones[i]) {
                throw new IndexOutOfBoundsException("El índice " + i + " está fuera de rango.");
            }
        }
        int x = 1;
        int poli = 0;
        for (int i = índices.length - 1; i >= 0; i--) {
            poli += x * índices[i];
            x *= dimensiones[i];
        }
        return poli;
    }

    public static void main(String[] args) {
        Arreglo b;

        b = new ArregloPolinomio(new int[] { 3, 2, 4, 1, 3 });
        int[] c = { 2, 1, 0, 2, 1 };

        System.out.println(b.obtenerÍndice(c));

    }

}
