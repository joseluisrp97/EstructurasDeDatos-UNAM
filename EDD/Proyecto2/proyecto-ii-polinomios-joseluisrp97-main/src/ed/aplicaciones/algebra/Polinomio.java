
package ed.aplicaciones.algebra;

import java.util.ListIterator;
import java.util.LinkedList;


public class Polinomio {

    public LinkedList<Monomio> lista;

    public Polinomio() {
        lista = new LinkedList<>();
    }

    // Constructor
    public Polinomio(double[] coefs, int[] exps) {
        lista = new LinkedList<>();
        for (int i = 0; i < coefs.length && i < exps.length; i++) {
            inserta(new Monomio(coefs[i], exps[i]));
        }
    }

    /**
     * Método que reduce el polinomio, agrupando términos semejantes
     */
    public void simplifica() {
        LinkedList<Monomio> nueva = new LinkedList<>();
        ListIterator<Monomio> iterador = lista.listIterator();
        if (iterador.hasNext()) {
            nueva.addLast(iterador.next());
        }

        while (iterador.hasNext()) {
            Monomio siguiente = iterador.next(); // Monomio del iterador.
            Monomio ultimo = nueva.getLast(); // Último monomio de la lista nueva.
            if (ultimo.p() == siguiente.p()) { // Si la potencia es igual, se suman.
                nueva.set(nueva.size() - 1, ultimo.más(siguiente));
            } else { // si la potencia es diferente, simplemente se agrega el siguiente.
                if (ultimo.c() == 0) {
                    nueva.removeLast();
                }
                nueva.addLast(siguiente);
            }
        }

        lista = nueva;
    }

    /**
     * Método que inserta un monomio en la posición adecuada en la lista.
     */
    public void inserta(Monomio nuevo) {
        if (lista.isEmpty()) {
            lista.add(nuevo);
            return;
        }
        ListIterator<Monomio> lit = lista.listIterator();
        while (lit.hasNext()) {
            Monomio sig = lit.next();
            if (sig.p() > nuevo.p()) {
                lit.previous();
                lit.add(nuevo);
                return;
            }
        }
        lit.add(nuevo);
    }

    /**
     * Método que suma a este polinomio con otro.
     * 
     * @param p polinomio.
     * @return polinomio resultante de la suma
     */
    public Polinomio más(Polinomio p) {
        Polinomio pNuevo = new Polinomio();
        ListIterator<Monomio> litThis = lista.listIterator();
        ListIterator<Monomio> litP = p.lista.listIterator();
        while (litP.hasNext() && litThis.hasNext()) {
            Monomio nextP = litP.next();
            Monomio nextThis = litThis.next();
            if (nextP.p() < nextThis.p()) {
                pNuevo.lista.addLast(nextP.clone());
                litThis.previous();
            } else {
                pNuevo.lista.addLast(nextThis.clone());
                litP.previous();
            }
        }
        while (litP.hasNext()) {
            pNuevo.lista.addLast(litP.next().clone());
        }
        while (litThis.hasNext()) {
            pNuevo.lista.addLast(litThis.next().clone());
        }
        pNuevo.simplifica();
        return pNuevo;
    }

    /**
     * Método que multiplica polinomio por monomio.
     * 
     * @param m monomio por el cual se va a multiplicar.
     * @return Polinomio resultante de la multiplicación
     */
    private Polinomio porMonomio(Monomio m) {
        Polinomio nuevo = new Polinomio();
        for (Monomio elem : lista) {
            nuevo.lista.addLast(elem.por(m));
        }
        return nuevo;
    }

    /**
     * Método que multiplica este polinomio por otro.
     * 
     * @param p polinomio
     * @return POlinomio resultante de la multipicación
     */
    public Polinomio por(Polinomio p) {
        Polinomio nuevo = null;
        for (Monomio mono : p.lista) {
            if (nuevo == null) {
                nuevo = this.porMonomio(mono);
            } else {
                nuevo = nuevo.más(this.porMonomio(mono));
            }
        }
        nuevo.simplifica();
        return nuevo;
    }

    public String toString() {
        String salida = "";
        ListIterator<Monomio> lit = lista.listIterator();
        if (lit.hasNext()) {
            salida += lit.next().toString();
        }
        while (lit.hasNext()) {
            Monomio sig = lit.next();
            if (sig.c() > 0) {
                salida = salida + " + " + sig.toString();
            } else {
                salida += " " + sig.toString();
            }
        }
        return salida;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Polinomio) {
            Polinomio p = (Polinomio) o;
            return lista.equals(p.lista);
        } else {
            return false;
        }
    }
}