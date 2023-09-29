package ed.estructuras.nolineales;

public class NodoRojinegro<C extends Comparable<C>> extends NodoBOLigado<C> {

    private Color color;

    /**
     * Constructor de un nodoRojiNegro
     * 
     * @param dato - nodo del árbol RojiNegro
     */
    public NodoRojinegro(C dato) {
        super(dato, null, null, null);
        this.color = Color.ROJO;
    }

    /**
     * Constructor de un nodo padre de un árbol RojiNegro
     * 
     * @param padre - nodo padre del árbol RojiNegro
     * @param dato  - nodo
     */
    public NodoRojinegro(C dato, NodoRojinegro<C> padre) {
        super(dato, padre, null, null);
        this.color = Color.ROJO;
    }

    /**
     * Constructor de un nodo padre, hijo izquierdo e hijo derecho de un árbol
     * RojiNegro
     * 
     * @param padre - nodo padre del árbol Rojinegro
     * @param dato  - nodo
     * @param hijoI - hijoIzquierdo
     * @param hijoD - hijoDerecho
     */
    public NodoRojinegro(C dato, NodoRojinegro<C> padre, NodoRojinegro<C> hijoI, NodoRojinegro<C> hijoD) {
        super(dato, padre, hijoI, hijoD);
        this.color = Color.ROJO;
    }

    /**
     * Constructor de un nodo padre, hijo izquierdo,hijo derecho y un color de un
     * árbol RojiNegro
     * 
     * @param padre - nodo padre del árbol Rojinegro
     * @param dato  - nodo
     * @param hijoI - hijoIzquierdo
     * @param hijoD - hijoDerecho
     * @param color - color
     */
    public NodoRojinegro(C dato, NodoRojinegro<C> padre, NodoRojinegro<C> hijoI, NodoRojinegro<C> hijoD, Color color) {
        super(dato, padre, hijoI, hijoD);
        this.color = color;
    }

    /**
     * Método para obtener el color de un nodo
     * 
     * @return color - color del nodo
     */
    public Color color() {
        return this.color;
    }

    /**
     * Método para asignar el color de un nodo
     * 
     * @param c - color del nodo
     */
    public void color(Color c) {
        this.color = c;
    }

    /**
     * Realiza rotación derecha sobre este nodo.
     * Se asume que este nodo tiene hijo izquierdo diferente de null.
     * 
     * @return nueva raíz.
     */
    public NodoRojinegro<C> rotaDerecha() {
        NodoRojinegro<C> r2 = this;
        NodoRojinegro<C> r1 = (NodoRojinegro<C>) hijoI();
        NodoRojinegro<C> hijoDR1 = (NodoRojinegro<C>) r1.hijoD();
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
    public NodoRojinegro<C> rotaIzquierda() {
        NodoRojinegro<C> r1 = this;
        NodoRojinegro<C> r2 = (NodoRojinegro<C>) hijoD();
        NodoRojinegro<C> hijoIR2 = (NodoRojinegro<C>) r2.hijoI();
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

    public NodoRojinegro<C> rebalancea() {
        NodoRojinegro<C> newRoot = null;
        if (factorBalanceo() == 2) {
            NodoRojinegro<C> hijoI = (NodoRojinegro<C>) hijoI();
            if (hijoI.factorBalanceo() == 1) { // Una rotación derecha
                newRoot = rotaDerecha();
            } else { // rotación doble LR
                hijoI(hijoI.rotaIzquierda());
                newRoot = rotaDerecha();
            }
        } else { // factor de balanceo es igual a -2
            NodoRojinegro<C> hijoD = (NodoRojinegro<C>) hijoD();
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

    public NodoRojinegro<C> tio() {
        if (this.padre().padre().hijoI() == this.padre())
            return (NodoRojinegro<C>) this.padre().padre().hijoD();
        else
            return (NodoRojinegro<C>) this.padre().padre().hijoI();
    }

    public void tio(NodoBinario<C> tio) throws ClassCastException {
        if (tio != null && !(tio instanceof NodoRojinegro)) {
            throw new ClassCastException("El tio debe ser de tipo NodoRojinegro");
        }
        this.padre = (NodoRojinegro<C>) padre;
    }

    @Override
    public NodoRojinegro<C> padre() {
        return (NodoRojinegro<C>) padre;
    }

    @Override
    public void padre(NodoBinario<C> padre) throws ClassCastException {
        if (padre != null && !(padre instanceof NodoRojinegro)) {
            throw new ClassCastException("El padre debe ser de tipo NodoRojinegro");
        }
        this.padre = (NodoRojinegro<C>) padre;
    }

    @Override
    public NodoRojinegro<C> hijoI() {
        return (NodoRojinegro<C>) hijoI;
    }

    @Override
    public void hijoI(NodoBinario<C> hijoI) throws ClassCastException {
        if (hijoI != null && !(hijoI instanceof NodoRojinegro)) {
            throw new ClassCastException("El hijo izquierdo debe ser de tipo NodoRojinegro");
        }
        this.hijoI = (NodoRojinegro<C>) hijoI;
    }

    @Override
    public NodoRojinegro<C> hijoD() {
        return (NodoRojinegro<C>) hijoD;
    }

    @Override
    public void hijoD(NodoBinario<C> hijoD) throws ClassCastException {
        if (hijoD != null && !(hijoD instanceof NodoRojinegro)) {
            throw new ClassCastException("El hijo derecho debe ser de tipo NodoRojinegro");
        }
        this.hijoD = (NodoRojinegro<C>) hijoD;
    }

    /**
     * Método para crear objetos constante que representan el color rojo y negro.
     */
    public enum Color {
        ROJO, NEGRO
    }
    
}