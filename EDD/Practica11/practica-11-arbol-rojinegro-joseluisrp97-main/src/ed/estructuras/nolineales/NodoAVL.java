
package ed.estructuras.nolineales;

public class NodoAVL<C extends Comparable<C>> extends NodoBOLigado<C> {

    public NodoAVL(C dato) {
        super(dato);
    }

    public NodoAVL(C dato, NodoAVL<C> padre, NodoAVL<C> hijoI, NodoAVL<C> hijoD) {
        super(dato, padre, hijoI, hijoD);
        this.altura = 0;
    }

    @Override
    public NodoAVL<C> padre() {
        return (NodoAVL<C>) padre;
    }

    @Override
    public void padre(NodoBinario<C> padre) throws ClassCastException {
        if (padre != null && !(padre instanceof NodoAVL)) {
            throw new ClassCastException("El padre debe ser de tipo NodoAVL");
        }
        this.padre = (NodoAVL<C>) padre;
    }

    @Override
    public NodoAVL<C> hijoI() {
        return (NodoAVL<C>) hijoI;
    }

    @Override
    public void hijoI(NodoBinario<C> hijoI) throws ClassCastException {
        if (hijoI != null && !(hijoI instanceof NodoAVL)) {
            throw new ClassCastException("El hijo izquierdo debe ser de tipo NodoAVL");
        }
        this.hijoI = (NodoAVL<C>) hijoI;
    }

    @Override
    public NodoAVL<C> hijoD() {
        return (NodoAVL<C>) hijoD;
    }

    @Override
    public void hijoD(NodoBinario<C> hijoD) throws ClassCastException {
        if (hijoD != null && !(hijoD instanceof NodoAVL)) {
            throw new ClassCastException("El hijo derecho debe ser de tipo NodoAVL");
        }
        this.hijoD = (NodoAVL<C>) hijoD;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Realiza rotación derecha sobre este nodo.
     * Se asume que este nodo tiene hijo izquierdo diferente de null.
     * 
     * @return nueva raíz.
     */
    public NodoAVL<C> rotaDerecha() {
        NodoAVL<C> r2 = this;
        NodoAVL<C> r1 = (NodoAVL<C>) hijoI();
        NodoAVL<C> hijoDR1 = (NodoAVL<C>) r1.hijoD();
        r2.hijoI(hijoDR1);
        if (hijoDR1 != null) {
            hijoDR1.padre(r2);
        }
        r1.hijoD(r2);
        r2.padre(r1);
        r2.actualizaAltura();
        r1.actualizaAltura();
        return r1;
    }

    /**
     * Realiza rotación izquierda sobre este nodo.
     * Se asume que este nodo tiene hijo derecho diferente de null.
     * 
     * @return nueva raíz.
     */
    public NodoAVL<C> rotaIzquierda() {
        NodoAVL<C> r1 = this;
        NodoAVL<C> r2 = (NodoAVL<C>) hijoD();
        NodoAVL<C> hijoIR2 = (NodoAVL<C>) r2.hijoI();
        r1.hijoD(hijoIR2);
        if (hijoIR2 != null) {
            hijoIR2.padre(r1);
        }
        r2.hijoI(r1);
        r1.padre(r2);
        r1.actualizaAltura();
        r2.actualizaAltura();
        return r2;
    }

    public int factorBalanceo() {
        int altIzq = (hijoI() == null) ? -1 : hijoI().altura();
        int altDer = (hijoD() == null) ? -1 : hijoD().altura();
        return altIzq - altDer;
    }

    public NodoAVL<C> rebalancea() {
        NodoAVL<C> newRoot = null;
        if (factorBalanceo() == 2) {
            NodoAVL<C> hijoI = (NodoAVL<C>) hijoI();
            if (hijoI.factorBalanceo() == 1) { // Una rotación derecha
                newRoot = rotaDerecha();
            } else { // rotación doble LR
                hijoI(hijoI.rotaIzquierda());
                newRoot = rotaDerecha();
            }
        } else { // factor de balanceo es igual a -2
            NodoAVL<C> hijoD = (NodoAVL<C>) hijoD();
            if (hijoD.factorBalanceo() == -1) { // una rotación izquierda.
                newRoot = rotaIzquierda();
            } else { // rotación doble RL
                hijoD(hijoD.rotaDerecha());
                newRoot = rotaIzquierda();
            }
        }
        newRoot.padre(null);
        return newRoot;
    }

}