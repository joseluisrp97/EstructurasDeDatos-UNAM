package ed.estructuras.nolineales;

import ed.estructuras.ColecciónAbstracta;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public abstract class ÁrbolBOLigado<C extends Comparable<C>> extends ColecciónAbstracta<C>
        implements ÁrbolBinarioOrdenado<C> {
    protected NodoBOLigado<C> raiz;

    @Override
    public boolean add(C e) {
        NodoBOLigado<C> newNode = addNode(e);
        return newNode != null;
    }

    protected NodoBOLigado<C> creaNodo(C dato) {
        return new NodoBOLigado<>(dato);
    }

    protected NodoBOLigado<C> creaNodo(C dato, NodoBinario<C> padre, NodoBinario<C> hijoI, NodoBinario<C> hijoD) {
        return new NodoBOLigado<>(dato, (NodoBOLigado<C>) padre, (NodoBOLigado<C>) hijoI, (NodoBOLigado<C>) hijoD);
    }

    protected NodoBOLigado<C> addNode(C e) {
        if (raiz == null) {
            raiz = creaNodo(e);
            tam++;
            return raiz;
        }

        NodoBOLigado<C> nodoActual = raiz;
        while (true) {
            int comparison = e.compareTo(nodoActual.dato());
            if (comparison < 0) {
                if (nodoActual.hijoI() == null) {
                    NodoBOLigado<C> newNode = creaNodo(e, nodoActual, null, null);
                    nodoActual.hijoI(newNode);
                    tam++;
                    return newNode;
                } else {
                    nodoActual = (NodoBOLigado<C>) nodoActual.hijoI();
                }
            } else if (comparison > 0) {
                if (nodoActual.hijoD() == null) {
                    NodoBOLigado<C> newNode = creaNodo(e, nodoActual, null, null);
                    nodoActual.hijoD(newNode);
                    tam++;
                    return newNode;
                } else {
                    nodoActual = (NodoBOLigado<C>) nodoActual.hijoD();
                }
            } else {
                // No se permiten duplicados, no se añade el elemento
                return null;
            }
        }
    }

    protected NodoBOLigado<C> encontrarNodo(C dato) {
        NodoBOLigado<C> nodoActual = raiz;

        while (nodoActual != null) {
            int comparison = dato.compareTo(nodoActual.dato());
            if (comparison < 0) {
                nodoActual = (NodoBOLigado<C>) nodoActual.hijoI();
            } else if (comparison > 0) {
                nodoActual = (NodoBOLigado<C>) nodoActual.hijoD();
            } else {
                return nodoActual;
            }
        }

        return null;
    }

    protected NodoBOLigado<C> removeNode(NodoBOLigado<C> nodo) {
        if (nodo == null) {
            return null;
        }

        // Si el nodo tiene dos hijos, se reemplaza por su sucesor inorden
        if (nodo.hijoI() != null && nodo.hijoD() != null) {
            NodoBOLigado<C> sucesorInorden = (NodoBOLigado<C>) nodo.hijoD();
            while (sucesorInorden.hijoI() != null) {
                sucesorInorden = (NodoBOLigado<C>) sucesorInorden.hijoI();
            }
            nodo.dato(sucesorInorden.dato());
            return removeNode(sucesorInorden);
        }

        // Si el nodo tiene un hijo, se elimina y se reemplaza por el hijo
        NodoBOLigado<C> hijo = nodo.hijoI() != null ? (NodoBOLigado<C>) nodo.hijoI()
                : (NodoBOLigado<C>) nodo.hijoD();

        if (nodo.padre() == null) {
            raiz = hijo;
        } else {
            if (nodo.padre().hijoI() == nodo) {
                nodo.padre().hijoI(hijo);
            } else {
                nodo.padre().hijoD(hijo);
            }
        }

        if (hijo != null) {
            hijo.padre(nodo.padre());
        }

        tam--;
        return nodo;
    }

    public void clear() {
        raiz = null;
        tam = 0;
    }

    public NodoBinario<C> raíz() {
        return raiz;
    }

    public void setRaiz(NodoBOLigado<C> raiz) {
        this.raiz = raiz;
    }

    @Override
    public Iterator<C> iteradorInorden() {
        return new Iterador("inorden");
    }



    private class Iterador implements Iterator<C> {

        NodoBinario<C> siguiente;

        public Iterador(String rec) {
            siguiente = raiz;
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public C next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            C dato = siguiente.dato();

            if (siguiente.hijoD() != null) {
                siguiente = siguiente.hijoD();
                while (siguiente.hijoI() != null) {
                    siguiente = siguiente.hijoI();
                }
            } else {
                NodoBinario<C> temp = siguiente;
                NodoBinario<C> padreTemp;
                boolean encontrado = false; // es true si ya se encontró siguiente.
                while (!encontrado && temp != raiz) {
                    padreTemp = temp.padre();
                    if (padreTemp.hijoI() == temp) {
                        siguiente = padreTemp;
                        encontrado = true;
                    }
                    temp = padreTemp;
                }
                if (!encontrado) {
                    siguiente = null;
                }
            }
            return dato;
        }
    }

    @Override
    public boolean contains(C o) {
        return encontrarNodo(o) != null;
    }

    public boolean remove(C o) {
        NodoBOLigado<C> nodoARemover = encontrarNodo(o);
        if (nodoARemover != null) {
            removeNode(nodoARemover);
            return true;
        }
        return false;
    }

}