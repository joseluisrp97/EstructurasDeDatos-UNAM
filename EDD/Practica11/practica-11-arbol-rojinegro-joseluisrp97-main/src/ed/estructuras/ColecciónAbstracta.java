package ed.estructuras;

import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;

public abstract class ColecciónAbstracta<E> implements Collection<E> {
    protected int tam = 0; // Elementos en la colección

    /**
     * Verifica si la colección es vacía
     * 
     * @return true si es vacía, false si no
     */
    public boolean isEmpty() {
        return tam == 0;
    }

    /**
     * Indica el tamaño
     * 
     * @return el tamaño de la colección
     */
    public int size() {
        return tam;
    }

    /**
     * Verifica si la colección contiene al elemento o
     * 
     * @param o elemento a comprobar si está en la colección
     * @return true si o está en la colección, false si no
     */
    public boolean contains(Object o) {
        // Verifica si el objeto es nulo.
        if (o == null) {
            // Recorre el conjunto y devuelve verdadero si encuentra un elemento nulo.
            for (E e : this) {
                if (e == null) {
                    return true;
                }
            }
        } else {
            // Recorre el conjunto y devuelve verdadero si encuentra un objeto igual al que
            // se busca.
            for (E e : this) {
                if (o.equals(e)) {
                    return true;
                }
            }
        }
        // Devuelve falso si el objeto no está en el conjunto.
        return false;
    }

    /**
     * Crea un arreglo que contiene a todos los elementos en la colección.
     * 
     * @return arreglo, que contiene a todos los elementos en la colección.
     */
    public Object[] toArray() {
        Object[] arreglo = new Object[tam];
        Iterator<E> iterador = iterator();
        int i = 0;
        while (iterador.hasNext()) {
            arreglo[i] = iterador.next();
            i++;
        }
        return arreglo;
    }

    /**
     * 
     * Devuelve un arreglo que contiene a todos los elementos en esta colección
     * Si el arreglo especificado es lo suficientemente grande para contener los
     * elementos de la colección,
     * los elementos se almacenan en ese arreglo y se devuelve ese mismo arreglo. En
     * caso contrario,
     * se crea un nuevo arreglo de tipo E y se almacenan los elementos de la
     * colección en él.
     * 
     * @param a el arreglo en el cual los elementos de esta colección serán
     *          almacenados si es lo suficientemente grande; en caso contrario, se
     *          crea un nuevo arreglo de tipo E.
     * @return un arreglo que contiene a todos los elementos en esta colección.
     */

    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("El arreglo del parámetro es nulo");
        }

        if (a.length >= tam) {
            Iterator<E> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                a[i] = (T) it.next();
                i++;
            }
            while (i < a.length) {
                a[i] = null;
                i++;
            }
            return a;
        } else {
            T[] niuArray = Arrays.copyOf(a, tam);
            Iterator<E> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                niuArray[i] = (T) it.next();
                i++;
            }
            return niuArray;
        }
    }

    /**
     * 
     * Verifica si esta colección contiene todos los elementos de la
     * colección c.
     * 
     * @param c la colección a ser verificada por contenimiento en esta colección.
     * @return true si esta colección contiene a todos los elementos en c.
     */
    public boolean containsAll(Collection<?> c) {
        if (c == null)
            throw new NullPointerException("La colección es nula.");
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Agrega todos los elementos de c en esta colección.
     * 
     * @param c la colección que contiene a los elementos a ser agregados en esta
     *          colección.
     * @return true si esta colección cambió como resultado de la llamada.
     */
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("La colección pasada como parámetro es nula.");
        }

        if (this == c) {
            throw new IllegalArgumentException("No se puede agregar la colección a sí misma.");
        }

        boolean cam = false;
        Iterator<? extends E> it = c.iterator();
        while (it.hasNext()) {
            if (add(it.next())) {
                cam = true;
            }
        }
        return cam;
    }

    /**
     * 
     * Elimina la primera aparición del elemento especificado en esta
     * colección, si está presente.
     * 
     * @param o el elemento a ser eliminado de esta colección, si está presente.
     * @return true si un elemento fue eliminado como resultado de la llamada.
     */

    public boolean remove(Object o) {
        if (contains(o)) {
            Iterator<E> it = iterator();
            if (o == null) {
                boolean elim = false;
                while (!elim && it.hasNext()) {
                    if (it.next() == null) {
                        it.remove();
                        elim = true;
                    }
                }
            } else {
                boolean elim = false;
                while (!elim && it.hasNext()) {
                    E sig = it.next();
                    if (sig != null && o.equals(sig)) {
                        it.remove();
                        elim = true;
                    }
                }
            }
            return true;
        } else {
            return false; // si no está, se devuelve false.
        }
    }

    /**
     * 
     * Elimina todos los elementos de esta colecciónque también están
     * contenidos en la colección c.
     * Después de realizar la operación, esta colección no contendrá elementos en
     * común con c.
     * 
     * @param c la colección que contiene a los elementos a ser eliminados de esta
     *          colección.
     * @return true si esta colección cambió como resultado de la llamada.
     */
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("El parámetro es nulo.");
        }
        boolean cam = false;
        if (equals(c)) {
            if (!isEmpty()) {
                clear();
                cam = true;
            }
        } else {
            Iterator<?> it = c.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    cam = true;
                }
            }
        }
        return cam;
    }

    /**
     * Retiene en esta colección todos los elementos que también están
     * contenidos en la colección c.
     * Después de realizar la operación, esta colección solo contendrá elementos que
     * estén en ambas colecciones.
     * 
     * @param c la colección que contiene a los elementos que se retendrán en esta
     *          colección.
     * @return true si esta colección cambió como resultado de la llamada.
     * @throws NullPointerException si el parámetro c es nulo.
     */
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("El parámetro es nulo.");
        }
        if (equals(c)) {
            return false;
        }
        Iterator<E> it = iterator();
        boolean cam = false;
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                cam = true;
            }
        }
        return cam;
    }

    /**
     * Elimina todos los elementos de esta colección
     */
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        tam = 0;
    }

    /**
     * 
     * Devuelve el código hash de esta colección
     * 
     * @return el código hash de esta colección
     */
    @Override
    public int hashCode() {
        int sum = 0;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            sum += it.next().hashCode();
        }
        return sum;
    }

    /**
     * 
     * Devuelve una representación en cadena de esta colección
     * 
     * @return una representación en cadena de esta colección
     */
    @Override
    public String toString() {
        String retVal = "[";
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (elem != null) {
                retVal = retVal + elem.toString() + ", ";
            } else {
                retVal += "null, ";
            }
        }
        retVal = retVal.substring(0, retVal.length() - 2);
        retVal += "]";
        return retVal;
    }
}