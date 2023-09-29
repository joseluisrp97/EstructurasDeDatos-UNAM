
package ed.estructuras.lineales;

import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;

public class PilaLigada<E> extends ColecciónAbstracta<E> implements Pila<E> {
    Nodo<E> cabeza; // Nodo que guarda al elemento al tope de la pila.

    public PilaLigada() {
        tam = 0;
        cabeza = null;
    }

    /**
     * Muestra el elemento al tope de la pila. Devuelve <code>null</code> si
     * está vacía.
     *
     * @return Una referencia al elemento siguiente.
     */
    public E mira() {
        if (isEmpty())
            return null;

        return cabeza.getDato();
    }

    /**
     * Devuelve el elemento al tope de la pila y lo elimina. Devuelve
     * <code>null</code> si está vacía.
     *
     * @return Una referencia al elemento siguiente.
     */
    public E expulsa() {
        if (isEmpty())
            return null;

        E retval = mira();
        cabeza = cabeza.getSiguiente();
        tam--;
        return retval;
    }

    /**
     * Agrega un elemento al tope de la pila.
     *
     * @param e Referencia al elemento a agregar.
     * @throws NullPointerException si <code>e</code> es <code>null</code>.
     */
    public void empuja(E elem) {
        if (elem == null) {
            throw new NullPointerException("El elemento a empujar es nulo.");
        }

        if (isEmpty()) {
            cabeza = new Nodo<>(elem);
        } else {
            Nodo<E> nuevo = new Nodo<>(elem, cabeza);
            cabeza = nuevo;
        }
        tam++;
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

        empuja(elem);
        return true;
    }

    /**
     * Elimina la primera aparición del objeto especificado de esta lista, si está
     * presente.
     *
     * @param o el objeto a eliminar de esta lista
     * @return true si se eliminó un elemento como resultado de esta llamada
     */

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("El argumento no puede ser nulo");
        }
        Nodo<E> actual = cabeza;
        Nodo<E> prev = null;
        while (actual != null) {
            if (o.equals(actual.getDato())) {
                if (prev == null) {
                    cabeza = actual.getSiguiente();
                } else {
                    prev = actual.getSiguiente();
                }
                tam--;
                return true;
            }
            prev = actual;
            actual = actual.getSiguiente();
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
        cabeza = null;
        tam = 0;
    }

    public Iterator<E> iterator() {
        return new Iterador();
    }

    private class Iterador implements Iterator<E> {
        Nodo<E> sig;

        public Iterador() {
            sig = cabeza;
        }

        public boolean hasNext() {
            return (sig != null);
        }

        public E next() {
            if (sig == null) {
                throw new NoSuchElementException();
            }

            E retval = sig.getDato();
            sig = sig.getSiguiente();
            return retval;
        }

        public void remove() {
            throw new UnsupportedOperationException();
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
        PilaLigada<E> obj = (PilaLigada<E>) o;
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