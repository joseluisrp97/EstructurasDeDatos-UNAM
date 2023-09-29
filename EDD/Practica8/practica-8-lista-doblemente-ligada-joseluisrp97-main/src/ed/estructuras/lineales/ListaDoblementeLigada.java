package ed.estructuras.lineales;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListaDoblementeLigada<E> extends ColecciónAbstracta<E> implements List<E> {

    Nodo<E> centinel; // Nodo centinela de la lista ligada

    /**
     * Constructor que crea una lista ligada vacía.
     */
    public ListaDoblementeLigada() {
        centinel = new Nodo<>(null);
        centinel.setSiguiente(centinel);
        centinel.setAnterior(centinel);
        tam = 0;
    }

    /**
     * Constructor que crea una lista ligada a partir de una colección.
     * 
     * @param c colección.
     */
    public ListaDoblementeLigada(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Agrega al elemento especificado al final de la lista.
     * 
     * @param e elemento a agregar a la lista.
     * @return true si se agrega a e, false en otro caso.
     */
    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    /**
     * Inserta el elemento especificado en la posición dada en esta lista.
     * Desplaza el elemento actualmente en esa posición (si lo hay) y
     * cualquier elemento posterior a la derecha (añade uno a sus índices).
     *
     * @param index   índice en el que se desea insertar el elemento
     * @param element elemento a insertar
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index > size())
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> lit = listIterator(index);
        lit.add(element);
    }

    /**
     * Inserta todos los elementos de la colección especificada en esta lista
     * a partir de la posición dada. Desplaza el elemento actualmente en esa
     * posición (si lo hay) y cualquier elemento posterior a la derecha
     * (añade el tamaño de la colección a sus índices).
     *
     * @param index índice en el que se desea insertar los elementos de la colección
     * @param c     colección que contiene los elementos a insertar
     * @return true si esta lista cambió como resultado de la llamada
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index > size())
     * @throws IllegalArgumentException  si la colección es igual a esta lista
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (c == this) {
            throw new IllegalArgumentException();
        }
        ListIterator<E> lit = listIterator(index);
        Iterator<? extends E> itc = c.iterator();
        boolean cambios = false;
        while (itc.hasNext()) {
            lit.add(itc.next());
            cambios = true;
        }
        return cambios;
    }

    /**
     * Elimina todos los elementos de la lista. La lista estará vacía después
     * de que se ejecute este método.
     */
    @Override
    public void clear() {
        centinel.setSiguiente(centinel);
        centinel.setAnterior(centinel);
        tam = 0;
    }

    /**
     * Devuelve el elemento en la posición especificada en esta lista.
     *
     * @param index índice del elemento a devolver
     * @return el elemento en la posición especificada en esta lista
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index >= size())
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> lit = listIterator(index);
        return lit.next();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        Collection<?> obj = (Collection<?>) o;
        Iterator<E> it1 = iterator();
        Iterator<?> it2 = obj.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            E elemit1 = it1.next();
            if (elemit1 == null) {
                if (it2.next() != null) {
                    return false;
                }
            } else if (!elemit1.equals(it2.next())) {
                return false;
            }
        }
        if (it1.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve el índice de la primera aparición del objeto especificado
     * en esta lista, o -1 si esta lista no contiene el objeto. Si el objeto
     * es null, devuelve el índice de la primera aparición de null.
     *
     * @param o objeto a buscar en la lista
     * @return el índice de la primera aparición del objeto especificado en
     *         esta lista, o -1 si esta lista no contiene el objeto
     */

    @Override
    public int indexOf(Object o) {
        ListIterator<E> lit = listIterator();
        if (o == null) {
            while (lit.hasNext()) {
                if (lit.next() == null) {
                    return lit.previousIndex();
                }
            }
        } else {
            while (lit.hasNext()) {
                if (o.equals(lit.next())) {
                    return lit.previousIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Devuelve un iterador sobre los elementos en esta lista en la secuencia
     * correcta. El iterador no permite la modificación directa de los elementos
     * de la lista
     *
     * @return un iterador sobre los elementos en esta lista en la secuencia
     *         correcta
     */
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) listIterator();
    }

    /**
     * Devuelve el índice de la última aparición del elemento especificado en
     * esta lista, o -1 si esta lista no contiene el elemento. Más formalmente,
     * devuelve el índice más alto i tal que (o == null ? get(i) == null :
     * o.equals(get(i))),
     * o -1 si no hay tal índice.
     *
     * @param o elemento buscado
     * @return el índice de la última aparición del elemento especificado en
     *         esta lista, o -1 si esta lista no contiene el elemento
     */
    @Override
    public int lastIndexOf(Object o) {
        ListIterator<E> lit = listIterator(size());
        if (o == null) {
            while (lit.hasPrevious()) {
                if (lit.previous() == null) {
                    return lit.nextIndex();
                }
            }
        } else {
            while (lit.hasPrevious()) {
                if (o.equals(lit.previous())) {
                    return lit.nextIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Devuelve un iterador de lista sobre los elementos en esta lista
     * (en la secuencia correcta).
     * 
     * @return un iterador de lista sobre los elementos en esta lista (en la
     *         secuencia correcta)
     */
    @Override
    public ListIterator<E> listIterator() {
        return new ListaIterador();
    }

    /**
     * Devuelve un iterador de lista sobre los elementos en esta lista, comenzando
     * desde la posición especificada en la lista.
     *
     * @param index índice del primer elemento que se devolverá desde el iterador de
     *              la lista
     * @return un iterador de lista sobre los elementos en esta lista, comenzando en
     *         la posición especificada
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index > size())
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        ListaIterador lit;
        // este if garantiza que se realicen n/2 iteraciones, en el peor caso.
        if (index < size() / 2) {
            lit = new ListaIterador();
            while (lit.nextIndex() < index) {
                lit.next();
            }
        } else {
            lit = new ListaIterador(centinel.getAnterior(), centinel, size());
            while (lit.nextIndex() > index) {
                lit.previous();
            }
        }
        return lit;
    }

    /**
     * Elimina el elemento en la posición especificada en esta lista.
     * Desplaza los elementos posteriores hacia la izquierda (resta uno a sus
     * índices).
     *
     * @param index índice del elemento a eliminar
     * @return el elemento que fue eliminado de la lista
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> lit = listIterator(index);
        E retVal = lit.next();
        lit.remove();
        return retVal;
    }

    /**
     * Reemplaza el elemento en la posición especificada en esta lista con el
     * elemento especificado. El elemento previo en la posición especificada
     * es devuelto.
     *
     * @param index   índice del elemento a reemplazar
     * @param element elemento a ser almacenado en la posición especificada
     * @return el elemento previamente en la posición especificada
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     *                                   (index < 0 || index >= size())
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<E> lit = listIterator(index);
        E retVal = lit.next();
        lit.set(element);
        return retVal;
    }

    /**
     * Devuelve una vista de la porción de esta lista entre los índices
     * especificados, incluido el índice 'fromIndex' y excluido el índice 'toIndex'.
     * La lista devuelta está respaldada por esta lista, por lo que los cambios en
     * la lista devuelta se reflejan en esta lista y viceversa.
     *
     * @param fromIndex índice inicial de la sublista (incluido)
     * @param toIndex   índice final de la sublista (excluido)
     * @return una vista de la porción especificada de esta lista
     * @throws IndexOutOfBoundsException si los índices están fuera del rango
     *                                   (fromIndex < 0 || toIndex > size() ||
     *                                   fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        ListaDoblementeLigada<E> listaNueva = new ListaDoblementeLigada<>();
        ListIterator<E> lit = listIterator(fromIndex);
        while (lit.nextIndex() < toIndex) {
            listaNueva.add(lit.next());
        }
        return listaNueva;
    }

    private class ListaIterador implements ListIterator<E> {

        Nodo<E> prev; // pevio
        Nodo<E> nex; // siguiente.
        public Nodo<E> devuelto;
        int indiceSig;
        boolean nextCalled;

        public ListaIterador() {
            prev = centinel;
            nex = centinel.getSiguiente();
            devuelto = null;
            indiceSig = 0;
        }

        private ListaIterador(Nodo<E> previo, Nodo<E> siguiente, int indice) {
            prev = previo;
            nex = siguiente;
            devuelto = null;
            indiceSig = indice;
        }

        /**
         * Inserta el elemento especificado en la lista antes del siguiente
         * elemento
         * Después de la inserción, el elemento insertado se convierte en el
         * elemento anterior,
         *
         * @param e elemento a insertar en la lista
         */
        @Override
        public void add(E e) {
            Nodo<E> nuevo = new Nodo<>(e, prev, nex);
            prev.setSiguiente(nuevo);
            nex.setAnterior(nuevo);
            nex = nuevo;
            tam++;
            next();
            devuelto = null;
        }

        /**
         * Comprueba si hay un elemento siguiente en la lista.
         *
         * @return true si hay un elemento siguiente en la lista, false en caso
         *         contrario
         */
        @Override
        public boolean hasNext() {
            return indiceSig < tam;
        }

        /**
         * Comprueba si hay un elemento previo en la lista.
         *
         * @return true si hay un elemento previo en la lista, false en caso
         *         contrario
         */
        @Override
        public boolean hasPrevious() {
            return indiceSig > 0;
        }

        /**
         * Devuelve el siguiente elemento en la lista y avanza el cursor de iterador.
         *
         * @return el siguiente elemento en la lista
         * @throws NoSuchElementException si no hay un elemento siguiente en la lista
         */

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            devuelto = nex;
            E retVal = devuelto.getDato();
            nex = nex.getSiguiente();
            prev = devuelto;
            indiceSig++;
            nextCalled = true;
            return retVal;
        }

        /**
         * Se obtiene el índice siguiente
         * 
         * @return el índice siguiente
         */
        @Override
        public int nextIndex() {
            return indiceSig;
        }

        /**
         * Devuelve el elemento previo en la lista y retrocede el cursor de iterador.
         *
         * @return el elemento previo en la lista
         * @throws NoSuchElementException si no hay un elemento previo en la lista
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            devuelto = prev;
            E retVal = devuelto.getDato();
            prev = prev.getAnterior();
            nex = devuelto;
            indiceSig--;
            nextCalled = false;
            return retVal;
        }

        /**
         * Se obtiene el índice anterior
         * 
         * @return el índice anterior
         */
        @Override
        public int previousIndex() {
            return indiceSig - 1;
        }

        /**
         * Elimina el elemento actual de la lista. Esta operación no se puede realizar
         * si next() no ha sido llamado previamente,
         * o si ya se ha llamado remove() una vez en el mismo elemento.
         *
         * @throws IllegalStateException si se llama a este método antes de llamar a
         *                               next() o si se llama dos veces seguidas.
         */
        @Override
        public void remove() {
            if (devuelto == null) {
                throw new IllegalStateException();
            }
            Nodo<E> antDev = devuelto.getAnterior();
            Nodo<E> sigDev = devuelto.getSiguiente();
            antDev.setSiguiente(sigDev);
            sigDev.setAnterior(antDev);
            devuelto.setSiguiente(null);
            devuelto.setAnterior(null);
            devuelto = null;
            if (nextCalled) {
                indiceSig--;
                prev = antDev;
            } else {
                nex = sigDev;
            }
            tam--;
        }

        /**
         * Reemplaza el último elemento devuelto por el iterador con el elemento
         * especificado.
         *
         * @param e el elemento con el que se debe reemplazar el último elemento
         *          devuelto por el iterador.
         * @throws IllegalStateException si se llama a este método antes de llamar a
         *                               next() o previous(),
         *                               o si se llama a remove() o add() después de la
         *                               última llamada a next() o previous().
         */

        @Override
        public void set(E e) {
            if (devuelto == null) {
                throw new IllegalStateException();
            }
            devuelto.setDato(e);
        }
    }
}