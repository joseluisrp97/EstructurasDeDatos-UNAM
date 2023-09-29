package ed.estructuras.nolineales;
import java.util.NoSuchElementException;

public class NodoBOLigado<C extends Comparable<C>> implements NodoBinarioOrdenado<C> {
    protected C dato;
    protected NodoBOLigado<C> padre;
    protected NodoBOLigado<C> hijoI;
    protected NodoBOLigado<C> hijoD;
    protected int altura;

    public NodoBOLigado(C dato) {
        this(dato, null, null, null);
    }

    public NodoBOLigado(C dato, NodoBOLigado<C> padre, NodoBOLigado<C> hijoI, NodoBOLigado<C> hijoD) {
        this.dato = dato;
        this.padre = padre;
        this.hijoI = hijoI;
        this.hijoD = hijoD;
        this.altura = 0;
    }

    @Override
    public C dato() {
        return dato;
    }

    @Override
    public void dato(C dato) throws NullPointerException {
        if (dato == null) {
            throw new NullPointerException("El dato no puede ser null");
        }
        this.dato = dato;
    }

    @Override
    public NodoBOLigado<C> padre() {
        return padre;
    }

    @Override
    public void padre(NodoBinario<C> padre) throws ClassCastException {
        if (padre != null && !(padre instanceof NodoBOLigado)) {
            throw new ClassCastException("El padre debe ser de tipo NodoBOLigado");
        }
        this.padre = (NodoBOLigado<C>) padre;
    }

    @Override
    public NodoBOLigado<C> hijoI() {
        return hijoI;
    }

    @Override
    public void hijoI(NodoBinario<C> hijoI) throws ClassCastException {
        if (hijoI != null && !(hijoI instanceof NodoBOLigado)) {
            throw new ClassCastException("El hijo izquierdo debe ser de tipo NodoBOLigado");
        }
        this.hijoI = (NodoBOLigado<C>) hijoI;
    }

    @Override
    public NodoBOLigado<C> hijoD() {
        return hijoD;
    }

    @Override
    public void hijoD(NodoBinario<C> hijoD) throws ClassCastException {
        if (hijoD != null && !(hijoD instanceof NodoBOLigado)) {
            throw new ClassCastException("El hijo derecho debe ser de tipo NodoBOLigado");
        }
        this.hijoD = (NodoBOLigado<C>) hijoD;
    }

    @Override
    public boolean esHoja() {
        return hijoI == null && hijoD == null;
    }

    @Override
    public int altura() {
        return altura;
    }

    @Override
    public int actualizaAltura() {
        int alturaI = hijoI != null ? hijoI.altura() : -1;
        int alturaD = hijoD != null ? hijoD.altura() : -1;
        altura = 1 + Math.max(alturaI, alturaD);
        return altura;
    }

    @Override
    public void remueveHijo(NodoBinario<C> hijo) {
        if (hijo == hijoI) {
            hijoI = null;
        } else if (hijo == hijoD) {
            hijoD = null;
        } else {
            throw new NoSuchElementException("El nodo proporcionado no es hijo de este nodo");
        }
    }

    @Override
    public NodoBOLigado<C> másGrande() {
        NodoBOLigado<C> nodo = this;
        while (nodo.hijoD() != null) {
            nodo = nodo.hijoD();
        }
        return nodo;
    }

    @Override
    public NodoBOLigado<C> másChico() {
        NodoBOLigado<C> nodo = this;
        while (nodo.hijoI() != null) {
            nodo = nodo.hijoI();
        }
        return nodo;
    }
}
