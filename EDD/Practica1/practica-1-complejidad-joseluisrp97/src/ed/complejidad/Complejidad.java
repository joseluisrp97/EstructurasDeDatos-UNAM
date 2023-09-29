package ed.complejidad;

import java.io.*;



public class Complejidad implements IComplejidad {

    private long cont;
    File archivo;

    public  void crearArchivo(String nombre) {
        archivo = new File(nombre); //creamos un nuevo archivo, nuestra pokedex
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            }
        } catch (IOException exepcion) {
            exepcion.printStackTrace(System.out);
        }
    } 
    

    /**
     * Método constructor por omisión con contador=0:
     */
    public Complejidad() {
        cont = 0;
    }

    /**
     * Devuelve el número de operaciones acumuladas desde la última vez que se
     * reinició el contador.
     *
     * @return número de operaciones.
     */
    @Override
    public long leeContador() {
        return cont;
    }

    /**
     * Método para reestablecer el contador a su valor inicial: 0
     */
    public void reestableceContador() {
        cont = 0;
    }

    public void escribeOperaciones(String archivo, int par, long ops) throws FileNotFoundException {
        try{
            FileWriter escritura = new FileWriter(archivo,true); //usamos como parametros el archivo y despues un boolean, true para que a la hora de escribir, no se sobrescriba el archivo, lo mantenga
            escritura.write(par +"\t"+ ops); 
            escritura.close();
        }catch(IOException exepcion){
        exepcion.printStackTrace(System.out);
        }
        /**
         * Método para guardar las operaciones cuando sólo se usa un parámetro.
         *
         * @param archivo nombre del archivo en el cual se agrega el reporte del
         * número de operaciones que tardó en ejecutarse el método.
         * @param par valor que se usó al llamar al último método ejecutado.
         * @param ops número de operaciones realizadas.
         * @throws java.io.FileNotFoundException
         */
    }

    public void escribeOperaciones(String archivo, int par1, int par2, long ops) throws FileNotFoundException {
        try{
            FileWriter escritura = new FileWriter(archivo,true); //usamos como parametros el archivo y despues un boolean, true para que a la hora de escribir, no se sobrescriba el archivo, lo mantenga
            escritura.write(par +"\t"+ par2 + "\t" + ops);
            escritura.close();
        }catch(IOException exepcion){
        exepcion.printStackTrace(System.out);
        }
        /**
         * Método para guardar las operaciones cuando se llamó una función con
         * dos parámetros.
         *
         * @param archivo nombre del archivo en el cual se agrega el reporte del
         * número de operaciones que tardó en ejecutarse el método.
         * @param par1 primer valor que se usó al llamar al último método
         * ejecutado.
         * @param par2 segundo valor que se usó al llamar al último método
         * ejecutado.
         * @param ops número de operaciones realizadas.
         */
    }

    public static void escribeLineaVacía(String archivo) throws FileNotFoundException {
        try ( PrintStream writer = new PrintStream(new FileOutputStream(archivo, true))) {
            writer.println();
        }
        /**
         * Método para escribir una línea en blanco en un archivo. Se utilizará
         * para las gráficas 3D.
         *
         * @param archivo Nombre del archivo.
         * @throws FileNotFoundException
         */
    }

    /**
     * Método para calcular, de forma recursiva, el elemento en la fila
     * <code>i</code>, en la columna <code>j</code> del triangulo de Pascal
     *
     * @param ren el numero de fila
     * @param col el numero de columna Si es <code>null</code> no se realizará
     * este cálculo.
     * @return el método auxiliar.
     * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
     * <code>j</code> son inválidos
     */
    @Override
    public int tPascalRec(int ren, int col) {
        if (col > ren || ren < 0 || col < 0) {
            cont = 0;
            throw new IndexOutOfBoundsException();
        }

        return tPascalRecAux(ren, col);
    }

    /**
     * Método auxiliar para calcular, de forma recursiva, el elemento en la fila
     * <code>i</code>, en la columna <code>j</code> del triangulo de Pascal
     *
     * @param ren el numero de fila
     * @param col el numero de columna Si es <code>null</code> no se realizará
     * este cálculo.
     * @return El elemento en la <code>i</code>-esima fila y la
     * <code>j</code>-esima columna del triangulo de Pascal.
     */
    public int tPascalRecAux(int ren, int col) {
        cont++;
        if (col == 0 || col == ren) {
            return 1;
        }
        return tPascalRecAux(ren - 1, col - 1) + tPascalRecAux(ren - 1, col);
    }

    /**
     * Metodo para calcular, iterativamente, el elemento en la fila
     * <code>i</code> y la columna <code>j</code> del triangulo de Pascal
     *
     * @param ren el numero de fila
     * @param col el numero de columna
     * @return El elemento en la i-esima fila y la j-esima columna del triangulo
     * de Pascal.
     * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
     * <code>j</code> son inválidos
     */
    @Override
    public int tPascalIt(int ren, int col) {
        if (col > ren || ren < 0 || col < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (col == 0 || col == ren) {
            cont++;
            return 1;
        }

        int x = 1;
        for (int i = 0; i < col; i++) {
            x = x * (ren - i);
            x = x / (i + 1);
            cont++;
        }
        return x;
    }

    /**
     * Devuelve el n-esimo elemento, calculado de forma recursiva, de la
     * sucesion de Fibonacci. Por conveción fibonacci(0) = 0, fibonacci(1) = 1.
     *
     * @param n el indice del elemento que se desea calcular
     * @return el método auxiliar
     * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es
     * inválido
     */
    @Override
    public int fibonacciRec(int n) {

        if (n < 0) {
            cont = 0;
            throw new IndexOutOfBoundsException();
        }
        return fibonacciRecAux(n);
    }

    /**
     * Método auxiliar que devuelve el n-esimo elemento, calculado de forma
     * recursiva, de la sucesion de Fibonacci. Por conveción fibonacci(0) = 0,
     * fibonacci(1) = 1.
     *
     * @param n el indice del elemento que se desea calcular
     * @return el n-esimo elemento de la sucesion de Fibonacci
     *
     */
    public int fibonacciRecAux(int n) {
        if (n < 2) {
            cont++;
            return n;
        }
        cont++;
        return fibonacciRecAux(n - 1) + fibonacciRecAux(n - 2);
    }

    /**
     * Devuelve el n-esimo elemento, calculado de forma iterativa, de la
     * sucesion de Fibonacci. Por conveción fibonacci(0) = 0, fibonacci(1) = 1.
     *
     * @param n el indice del elemento que se desea calcular
     * @return el n-esimo elemento de la sucesiond de Fibonacci
     * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es
     * inválido
     */
    @Override
    public int fibonacciIt(int n) {
        if (n == 0) {
            cont++;
            return n;
        }

        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }

        int ant1 = 0;
        int ant = 1;
        int sum = 0;

        for (int i = 2; i <= n; i++) {

            sum = ant1 + ant;
            ant1 = ant;
            ant = sum;
            cont++;
        }
        return sum;
    }

}

