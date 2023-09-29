package ed.estructuras.nolineales;

public abstract class ÁrbolRojinegro<C extends Comparable<C>> extends ÁrbolBOLigado<C> {

    private NodoRojinegro<C> z;

    /**
     * Constructor de ÁrbolRojiNegro
     */
    public ÁrbolRojinegro() {
        this.z = null;
    }

    /**
     * Método que crea un nodo
     * 
     * @return un nuevo nodo
     */
    protected NodoRojinegro<C> creaNodo(C dato, NodoBOLigado<C> padre, NodoBOLigado<C> hijoI, NodoBOLigado<C> hijoD) {
        return new NodoRojinegro(dato, (NodoRojinegro<C>) padre, (NodoRojinegro<C>) hijoI, (NodoRojinegro<C>) hijoD);
    }

    /*
     * Método privado para verificar que tiene un tioRojo
     * 
     * @return true si tiene tio rojo, false en otro caso
     */
    private boolean tieneTioRojo(NodoRojinegro<C> nodo) {
        if (nodo.tio() == null)
            return false;
        else if (nodo.tio().color() == NodoRojinegro.Color.ROJO)
            return true;
        return false;
    }

    /*
     * Método privado booleano para verififcar que sea nodo negro
     * 
     * @return true si lo tiene, false en otro caso
     */
    private boolean esNodoNegro(NodoRojinegro<C> nodo) {
        if (nodo == null)
            return true;
        else if (nodo.color() == NodoRojinegro.Color.NEGRO)
            return true;
        return false;
    }

    /**
     * Método booleano que verifica que un elemento fue agregado
     * 
     * @param c - Elemento a ser agregado
     */
    public boolean add(C c) {
        this.raíz();
        z = (NodoRojinegro<C>) addNode(c);
        if (z != this.raiz()) {
            NodoRojinegro<C> y;
            while (z.padre().color() == NodoRojinegro.Color.ROJO) {
                if (z.padre().esHijoI()) {
                    y = z.padre().padre().hijoD();
                    if (tieneTioRojo(z)) {
                        z.padre().color(NodoRojinegro.Color.NEGRO);
                        y.color(NodoRojinegro.Color.NEGRO);
                        z.padre().padre().color(NodoRojinegro.Color.ROJO);
                        z = z.padre().padre();
                        if (z == this.raiz())
                            break;
                    } else {
                        if (z.esHijoD()) {
                            z = z.padre();
                            z.rotaIzquierda();
                        }
                        z.padre().color(NodoRojinegro.Color.NEGRO);
                        z.padre().padre().color(NodoRojinegro.Color.ROJO);
                        z.padre().padre().rotaDerecha();
                    }
                } else {
                    y = z.padre().padre().hijoI();
                    if (tieneTioRojo(z)) {
                        z.padre().color(NodoRojinegro.Color.NEGRO);
                        y.color(NodoRojinegro.Color.NEGRO);
                        z.padre().padre().color(NodoRojinegro.Color.ROJO);
                        z = z.padre().padre();
                        if (z == this.raiz())
                            break;
                    } else {
                        if (z.esHijoI()) {
                            z = z.padre();
                            z.rotaDerecha();
                        }
                        z.padre().color(NodoRojinegro.Color.NEGRO);
                        z.padre().padre().color(NodoRojinegro.Color.ROJO);
                        z.padre().padre().rotaIzquierda();
                    }
                }
            }
        }
        if (z != null) {
            while (z.padre() != null) {
                z = z.padre();
            }
            setRaiz(z);
        }
        raiz().color(NodoRojinegro.Color.NEGRO);
        return true;
    }

    /**
     * Método booleano que verifica que un elemento fue removido
     * 
     * @param c - elemento que fue removido
     */
    public boolean remove(C c) {
        if (c == null)
            throw new NullPointerException();
        if (!this.contains(c))
            return false;
        else {
            NodoRojinegro<C> removido;
            NodoRojinegro<C> x = removido = (NodoRojinegro<C>) this.raiz().buscarNodo(c);
            NodoRojinegro<C> p = (NodoRojinegro<C>) x.padre();
            NodoRojinegro<C> w;

            while (x != raiz() && esNodoNegro(x)) {
                if (x == p.hijoI()) {
                    w = p.hijoD();
                    if (w.color() == NodoRojinegro.Color.ROJO) {
                        w.color(NodoRojinegro.Color.NEGRO);
                        p.color(NodoRojinegro.Color.ROJO);
                        p.rotaIzquierda();
                        if (p == this.raiz())
                            setRaiz(p.padre());
                        w = p.hijoD();
                    }
                    if (esNodoNegro(w.hijoI()) && esNodoNegro(w.hijoD())) {
                        w.color(NodoRojinegro.Color.ROJO);
                        x = p;
                        p = x.padre();
                    } else {
                        if (esNodoNegro(w.hijoD())) {
                            w.hijoI().color(NodoRojinegro.Color.NEGRO);
                            w.color(NodoRojinegro.Color.ROJO);
                            w.rotaDerecha();
                            w = p.hijoD();
                        }
                        w.color(p.color());
                        p.color(NodoRojinegro.Color.NEGRO);
                        w.hijoD().color(NodoRojinegro.Color.NEGRO);
                        p.rotaIzquierda();
                        if (p == this.raiz())
                            setRaiz(p.padre());
                        break;
                    }
                } else {
                    w = p.hijoI();
                    if (w.color() == NodoRojinegro.Color.ROJO) {
                        w.color(NodoRojinegro.Color.NEGRO);
                        p.color(NodoRojinegro.Color.ROJO);
                        p.rotaDerecha();
                        if (p == this.raiz())
                            setRaiz(p.padre());
                        w = p.hijoI();
                    }
                    if (esNodoNegro(w.hijoI()) && esNodoNegro(w.hijoD())) {
                        w.color(NodoRojinegro.Color.ROJO);
                        x = p;
                        p = x.padre();
                    } else {
                        if (esNodoNegro(w.hijoI())) {
                            w.hijoD().color(NodoRojinegro.Color.NEGRO);
                            w.color(NodoRojinegro.Color.ROJO);
                            w.rotaIzquierda();
                            w = p.hijoI();
                        }
                        w.color(p.color());
                        p.color(NodoRojinegro.Color.NEGRO);
                        w.hijoI().color(NodoRojinegro.Color.NEGRO);
                        p.rotaDerecha();
                        if (p == this.raiz())
                            setRaiz(p.padre());
                        break;
                    }
                }
            }

            if (x != null)
                x.color(NodoRojinegro.Color.NEGRO);
            NodoBOLigado<C> tempNode = new NodoBOLigado<>(removido.dato());
            removido = (NodoRojinegro<C>) removeNode(tempNode);
            return true;

        }
    }

    /**
     * Método para obtener la raíz
     * 
     * @return metodo para obtener la raíz obtiendo la raíz del árbol
     */
    public NodoRojinegro<C> raiz() {
        return (NodoRojinegro<C>) super.raíz();
    }

}