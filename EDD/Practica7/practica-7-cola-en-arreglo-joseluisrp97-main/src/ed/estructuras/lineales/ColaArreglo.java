
package ed.estructuras.lineales;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColaArreglo<E> extends ColecciónAbstracta<E> implements Cola<E> {

    private E[] buffer;
    private int prim;
    private int ult;
    private static final int DEFAULT_INITIAL_SIZE = 4; // tamaño inicial por default.

    public ColaArreglo(E[] a) {
        this(a, DEFAULT_INITIAL_SIZE);

    }

    public ColaArreglo(E[] a, int inicial) {
        if (a.length > 0) {
            throw new IllegalArgumentException("No es de tamaño 0");
        }
        buffer = Arrays.copyOf(a, inicial);
        prim = 0;
        ult = 0;
        tam = 0;

    }

    /**
     * Crea un arreglo del doble de tamaño del actual y copia todos los elementos
     * de un arreglo al otro.
     */
    private void expande() {
        E[] temporal = Arrays.copyOf(buffer, buffer.length * 2);
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = null;
        }
        for (int i = prim, i2 = 0; i2 < tam; i = (i + 1) % buffer.length, i2++) {
            temporal[i2] = buffer[i];
        }
        buffer = temporal;
        prim = 0;
        ult = tam;
    }

    /**
     * Crea un arreglo de la mitad del tamaño del actual y copia todos
     * los elementos de uno al otro.
     */
    private void contrae() {
        E[] temporal = Arrays.copyOf(buffer, buffer.length / 2);
        for (int i = 0; i < temporal.length; i++) {
            temporal[i] = null;
        }
        for (int i = prim, i2 = 0; i2 < tam; i = (i + 1) % buffer.length, i2++) {
            temporal[i2] = buffer[i];
        }
        buffer = temporal;
        prim = 0;
        ult = tam;
    }

    /**
     * Muestra el elemento al inicio de la cola.
     * Devuelve <code>null</code> si está vacía.
     *
     * @return Una referencia al elemento siguiente.
     */
    public E mira() {
        if (isEmpty()) {
            return null;
        }
        E retVal = buffer[prim];
        return retVal;
    }

    /**
     * Devuelve el elemento al inicio de la cola y lo elimina.
     * Devuelve <code>null</code> si está vacía.
     *
     * @return Una referencia al elemento siguiente.
     */
    public E atiende() {
        if (isEmpty()) {
            return null;
        }
        E retVal = buffer[prim];
        buffer[prim] = null;
        prim = (prim + 1) % buffer.length;
        tam--;
        // Posible contracción.
        double tamDoub = (double) tam;
        double lengthDoub = (double) buffer.length;
        double alfa = tamDoub / lengthDoub;
        if ((buffer.length > DEFAULT_INITIAL_SIZE) && (alfa <= 0.25)) {
            contrae();
        }
        return retVal;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param e Referencia al elemento a agregar.
     * @throws NullPointerException si se intenta forma un elemento nulo.
     */
    public void forma(E e) {
        if (e == null) {
            throw new NullPointerException("El elemento a formar no debe ser null.");
        }
        buffer[ult] = e;
        ult = (ult + 1) % buffer.length;
        tam++;
        if (tam == buffer.length) {
            expande();
        }
    }

    /**
     * 
     * Agrega el elemento especificado al final de la lista.
     * 
     * @param elem el elemento que se desea agregar.
     * 
     * @return true si el elemento se agregó correctamente, o false si el elemento
     *         es nulo y no se agregó nada.
     */

    public boolean add(E elem) {
        if (elem == null) {
            return false;
        }

        forma(elem);
        return true;
    }

    /**
     * 
     * Elimina la primera aparición del elemento especificado de esta colección. Si
     * la colección no contiene el elemento, no se modifica.
     * 
     * @param o el objeto a eliminar de esta colección.
     * 
     * @return true si se eliminó el elemento especificado, false de lo contrario.
     * 
     * @throws NullPointerException si el objeto pasado como argumento es nulo.
     */

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("El objeto es nulo.");
        }

        if (isEmpty()) {
            return false;
        }

        E element = buffer[prim];
        if (element != null && element.equals(o)) {
            buffer[prim] = null;
            prim = (prim + 1) % buffer.length;
            tam--;
            return true;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll no disponible");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll no disponible");
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            atiende();
        }
    }

    public Iterator<E> iterator() {
        return new Iterador();
    }

    /*
     * public void remove() {
     * throw new
     * IllegalStateException("No se puede remover un elemento antes de llamar a next()"
     * );
     * }
     */

    private class Iterador implements Iterator<E> {
        private int indice;
        private int elementosRemovidos;
        private int ultimoRetornado = -1;

        public Iterador() {
            indice = prim;
        }

        public boolean hasNext() {
            return elementosRemovidos < tam;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E retVal = buffer[indice];
            ultimoRetornado = indice;
            indice = (indice + 1) % buffer.length;
            elementosRemovidos++;
            return retVal;
        }

        public void remove() {
            if (ultimoRetornado < 0) {
                throw new IllegalStateException("No se puede remover un elemento antes de llamar a next()");
            }
            int indiceRemovido = (ultimoRetornado - 1 + buffer.length) % buffer.length;
            buffer[indiceRemovido] = null;
            elementosRemovidos--;
            if (elementosRemovidos == 0) {
                prim = ult = indice;
            } else {
                prim = (prim + 1) % buffer.length;
            }
            ultimoRetornado = -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        ColaArreglo<E> obj = (ColaArreglo<E>) o;
        Iterator<E> it1 = iterator();
        Iterator<E> it2 = obj.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            if (!it1.next().equals(it2.next())) {
                return false;
            }
        }
        if (it1.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }
}