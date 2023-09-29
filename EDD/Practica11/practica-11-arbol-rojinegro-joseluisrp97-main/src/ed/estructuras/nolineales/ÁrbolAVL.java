
package ed.estructuras.nolineales;

public abstract class ÁrbolAVL<C extends Comparable<C>> extends ÁrbolBOLigado<C> {
    private NodoAVL<C> creaNodo(C dato,
            NodoAVL<C> padre,
            NodoAVL<C> hijoI,
            NodoAVL<C> hijoD) {
        return new NodoAVL<>(dato, padre, hijoI, hijoD);
    }

    @Override
    public NodoAVL<C> addNode(C e) {
        NodoAVL<C> nuevo = creaNodo(e, null, null, null);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            boolean agregado = false;
            NodoAVL<C> actual = (NodoAVL<C>) raiz;
            while (!agregado) {
                int rescomp = e.compareTo(actual.dato());
                if (rescomp < 0) { // e es menor que la raíz.
                    if (actual.hijoI() == null) {
                        actual.hijoI(nuevo);
                        nuevo.padre(actual);
                        agregado = true;
                    } else {
                        actual = (NodoAVL<C>) actual.hijoI();
                    }
                } else { // e es mayor o igual a la raíz.
                    if (actual.hijoD() == null) {
                        actual.hijoD(nuevo);
                        nuevo.padre(actual);
                        agregado = true;
                    } else {
                        actual = (NodoAVL<C>) actual.hijoD();
                    }
                }
            }
        }
        return nuevo;
    }

    @Override
    public boolean add(C elem) {
        NodoAVL<C> temp = addNode(elem);
        NodoAVL<C> padreTemp;
        while (temp != null) {
            temp.actualizaAltura();
            padreTemp = (NodoAVL<C>) temp.padre();
            if (Math.abs(temp.factorBalanceo()) == 2) {
                if (padreTemp == null) {
                    raiz = temp.rebalancea();
                } else {
                    if (padreTemp.hijoD() == temp) {
                        NodoAVL<C> nuevoHijo = temp.rebalancea();
                        padreTemp.hijoI(nuevoHijo);
                        nuevoHijo.padre(padreTemp);
                    } else {
                        NodoAVL<C> nuevoHijo = temp.rebalancea();
                        padreTemp.hijoD(nuevoHijo);
                        nuevoHijo.padre(padreTemp);
                    }
                }
            }
            temp = padreTemp;
        }
        tam++;
        return true;
    }

    private NodoAVL<C> findNode(C elem) {
        if (!contains(elem)) {
            return null;
        }
        boolean encontrado = false;
        NodoAVL<C> actual = (NodoAVL<C>) raiz;
        while (!encontrado) {
            int cmp = elem.compareTo(actual.dato());
            if (cmp == 0) {
                encontrado = true;
            } else if (cmp < 0) {
                actual = (NodoAVL<C>) actual.hijoI();
            } else {
                actual = (NodoAVL<C>) actual.hijoD();
            }
        }
        return actual;
    }

    private NodoAVL<C> remueveNodo(C elem) {
        NodoAVL<C> aElim = findNode(elem);
        int gradoNodo = aElim.getGrado();
        if (gradoNodo == 0) { // Si es hoja se elimina sin problemas.
            if (aElim == raiz) {
                raiz = null;
            } else {
                NodoAVL<C> padreElim = (NodoAVL<C>) aElim.padre();
                if (padreElim.hijoI() == aElim) {
                    padreElim.hijoI(null);
                } else {
                    padreElim.hijoD(null);
                }
            }
        } else if (gradoNodo == 1) { // Nodo con un solo hijo.
            if (aElim == raiz) {
                NodoAVL<C> nuevaRaiz = (NodoAVL<C>) ((raiz.hijoI() != null) ? raiz.hijoI() : raiz.hijoD());
                raiz = nuevaRaiz;
                raiz.padre(null);
            } else {
                NodoAVL<C> padreElim = (NodoAVL<C>) aElim.padre(); // padre del nodo eliminado.
                NodoAVL<C> nuevoHijo = (NodoAVL<C>) ((aElim.hijoI() != null) ? aElim.hijoI() : aElim.hijoD());
                if (padreElim.hijoI() == aElim) {
                    padreElim.hijoI(nuevoHijo);
                } else {
                    padreElim.hijoD(nuevoHijo);
                }
                nuevoHijo.padre(padreElim);
            }
        } else { // Nodo con dos hijos.
            NodoAVL<C> hijoD = (NodoAVL<C>) aElim.hijoD();
            NodoAVL<C> minDer = (NodoAVL<C>) hijoD.másChico(); // El nodo más pequeño del subárbol derecho.
            NodoAVL<C> padreMD = (NodoAVL<C>) minDer.padre(); // Padre del nodo más pequeño.
            intercambia(minDer, aElim);
            if (padreMD.hijoI() == minDer) {
                padreMD.hijoI(minDer.hijoD());
            } else {
                padreMD.hijoD(minDer.hijoD());
            }
            if (minDer.hijoD() != null) {
                minDer.hijoD().padre(padreMD);
            }
            aElim = minDer;
        }
        return aElim;
    }

    private void intercambia(NodoAVL<C> nodo1, NodoAVL<C> nodo2) {
        C temp = nodo1.dato();
        nodo1.dato(nodo2.dato());
        nodo2.dato(temp);
    }

    @Override
    public boolean remove(C elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (!contains(elem)) {
            return false;
        }
        NodoAVL<C> eliminado = remueveNodo(elem);
        // Actualizar las alturas.
        NodoAVL<C> temp = (NodoAVL<C>) eliminado.padre();
        NodoAVL<C> padreTemp;
        while (temp != null) {
            temp.actualizaAltura();
            padreTemp = (NodoAVL<C>) temp.padre();
            if (Math.abs(temp.factorBalanceo()) == 2) {
                if (padreTemp == null) {
                    raiz = temp.rebalancea();
                } else {
                    if (padreTemp.hijoI() == temp) {
                        NodoAVL<C> nuevoHijo = temp.rebalancea();
                        padreTemp.hijoI(nuevoHijo);
                        nuevoHijo.padre(padreTemp);
                    } else {
                        NodoAVL<C> nuevoHijo = temp.rebalancea();
                        padreTemp.hijoD(nuevoHijo);
                        nuevoHijo.padre(padreTemp);
                    }
                }
            }
            temp = padreTemp;
        }
        tam--;
        return true;
    }
}