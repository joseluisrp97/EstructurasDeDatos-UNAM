package ed.estructuras.nolineales.gráficas;

import java.util.*;

public class GráficaLigada<T> {
    private List<Vertice> vertices;
    private Map<T, Vertice> tablaDeDispersión;

    private class Vertice {
        T etiqueta;
        List<Arista> vecinos;
        boolean visitado = false;

        public Vertice(T etiqueta) {
            if (etiqueta == null) {
                throw new IllegalArgumentException("La etiqueta del vértice no puede ser null.");
            }
            this.etiqueta = etiqueta;
            this.vecinos = new ArrayList<Arista>();
        }
    }

    private class Arista {
        Vertice v1;
        Vertice v2;
        int peso;

        public Arista(Vertice v1, Vertice v2, int peso) {
            if (v1 == null || v2 == null) {
                throw new IllegalArgumentException("Los vértices conectados por la arista no pueden ser null.");
            }
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
        }
    }

    public GráficaLigada() {
        this.vertices = new ArrayList<Vertice>();
        this.tablaDeDispersión = new HashMap<>();
    }

    /**
     * Este método agrega un nuevo vértice a la gráfica.
     * 
     * @param etiqueta La etiqueta del vértice que se va a agregar.
     */
    public void agregaVértice(T etiqueta) {
        Vertice v = new Vertice(etiqueta);
        vertices.add(v);
    }

    /**
     * Este método devuelve el vértice que corresponde a la etiqueta dada.
     * Si la etiqueta no está asociada con ningún vértice en la gráfica, devuelve
     * null.
     *
     * @param etiqueta La etiqueta del vértice que se busca.
     * @return El vértice que corresponde a la etiqueta dada, o null si tal vértice
     *         no existe.
     */
    private Vertice getVertice(T etiqueta) {
        for (Vertice v : vertices) {
            if (v.etiqueta.equals(etiqueta)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Este método agrega una arista dirigida entre dos vértices existentes.
     * 
     * @param etiqueta1 La etiqueta del primer vértice.
     * @param etiqueta2 La etiqueta del segundo vértice.
     * @param peso      El peso de la arista.
     * @throws IllegalArgumentException Si alguno de los vértices no existe en la
     *                                  gráfica.
     */
    public void agregaArista(T etiqueta1, T etiqueta2, int peso) {
        Vertice v1 = getVertice(etiqueta1);
        Vertice v2 = getVertice(etiqueta2);

        if (v1 != null && v2 != null) {
            Arista arista = new Arista(v1, v2, peso);
            v1.vecinos.add(arista);
        }
    }

    /**
     * Este método devuelve un iterador que recorre la gráfica en amplitud
     * comenzando desde un vértice dado.
     * 
     * @param inicio La etiqueta del vértice de inicio del recorrido.
     * @return Un iterador que recorre la gráfica en amplitud.
     * @throws IllegalArgumentException Si el vértice de inicio no existe en la
     *                                  gráfica.
     */

    public Iterator<T> iteradorAmplitud(T inicio) {
        Vertice verticeInicial = null;

        for (Vertice v : vertices) {
            if (v.etiqueta.equals(inicio)) {
                verticeInicial = v;
                break;
            }
        }

        if (verticeInicial == null) {
            throw new IllegalArgumentException("El vértice de inicio no se encuentra en la gráfica.");
        }

        return new IteradorAmplitud(verticeInicial);
    }

    public class IteradorAmplitud implements Iterator<T> {
        private Queue<Vertice> cola;

        public IteradorAmplitud(Vertice verticeInicial) {
            cola = new LinkedList<>();
            cola.add(verticeInicial);
            verticeInicial.visitado = true;
        }

        @Override
        public boolean hasNext() {
            return !cola.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Vertice actual = cola.poll();

            for (Arista arista : actual.vecinos) {
                if (!arista.v2.visitado) {
                    cola.add(arista.v2);
                    arista.v2.visitado = true;
                }
            }

            return actual.etiqueta;
        }

    }

    /**
     * Este método devuelve la ruta más corta entre dos vértices utilizando el
     * algoritmo de Dijkstra.
     * 
     * @param inicio La etiqueta del vértice de inicio.
     * @param fin    La etiqueta del vértice de fin.
     * @return Una lista con las etiquetas de los vértices de la ruta más corta.
     * @throws IllegalArgumentException Si alguno de los vértices no existe en la
     *                                  gráfica.
     */
    public List<T> rutaDijkstra(T inicio, T fin) {
        Vertice verticeInicio = getVertice(inicio);
        Vertice verticeFin = getVertice(fin);

        if (verticeInicio == null || verticeFin == null) {
            return null;
        }

        int[] distancias = new int[vertices.size()];
        List<Vertice> predecesores = new ArrayList<Vertice>(Collections.nCopies(vertices.size(), null));

        for (int i = 0; i < vertices.size(); i++) {
            distancias[i] = Integer.MAX_VALUE;
        }

        distancias[vertices.indexOf(verticeInicio)] = 0;

        for (int i = 0; i < vertices.size() - 1; i++) {
            for (Arista arista : vertices.get(i).vecinos) {
                int nuevaDistancia = distancias[i] + arista.peso;
                int indiceVecino = vertices.indexOf(arista.v2);

                if (nuevaDistancia < distancias[indiceVecino]) {
                    distancias[indiceVecino] = nuevaDistancia;
                    predecesores.set(indiceVecino, vertices.get(i));
                }
            }
        }

        List<T> camino = new ArrayList<>();
        for (Vertice v = verticeFin; v != null; v = predecesores.get(vertices.indexOf(v))) {
            camino.add(0, v.etiqueta);
        }

        return camino;
    }
}
