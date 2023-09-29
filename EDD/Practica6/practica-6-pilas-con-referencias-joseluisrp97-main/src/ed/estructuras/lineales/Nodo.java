
package ed.estructuras.lineales;

class Nodo<E> {
    private E dato; // elemento almacenado en el nodo
    private Nodo<E> sig; // referencia al siguiente nodo

    /**
     * 
     * Crea un nuevo nodo con el elemento dado.
     * Si el elemento es null, se lanza una excepción NullPointerException.
     * 
     * @param dato Elemento que se va a almacenar en el nodo.
     * @throws NullPointerException Si el elemento es null.
     */
    public Nodo(E dato) {
        if (dato == null) {
            throw new NullPointerException("El valor del nodo no puede ser null");
        }
        this.dato = dato;
    }

    /**
     * 
     * Crea un nuevo nodo con el elemento y la referencia al siguiente nodo dados.
     * Si el elemento es null, se lanza una excepción NullPointerException.
     * 
     * @param dato Elemento que se va a almacenar en el nodo.
     * @param sig  Referencia al siguiente nodo.
     * @throws NullPointerException Si el elemento es null.
     */
    public Nodo(E dato, Nodo<E> sig) {
        if (dato == null) {
            throw new NullPointerException("El valor del nodo no puede ser null");
        }
        this.dato = dato;
        this.sig = sig;
    }

    /**
     * 
     * Obtiene el elemento almacenado en el nodo.
     * 
     * @return Elemento almacenado en el nodo.
     */
    public E getDato() {
        return dato;
    }

    /**
     * 
     * Cambia el elemento almacenado en el nodo por el dado.
     * 
     * @param dato Nuevo elemento que se va a almacenar en el nodo.
     */
    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * 
     * Obtiene la referencia al siguiente nodo.
     * 
     * @return Referencia al siguiente nodo.
     */
    public Nodo<E> getSiguiente() {
        return sig;
    }

    /**
     * 
     * Cambia la referencia al siguiente nodo por la dada.
     * 
     * @param sig Referencia al nuevo siguiente nodo.
     */
    public void setSiguiente(Nodo<E> sig) {
        this.sig = sig;
    }

}