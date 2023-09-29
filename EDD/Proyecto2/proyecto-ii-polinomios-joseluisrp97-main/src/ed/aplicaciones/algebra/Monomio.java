
package ed.aplicaciones.algebra;

public class Monomio {
    private double coeficiente;
    private int potencia;

    // Constructor
    public Monomio(double coef, int pot) {
        coeficiente = coef;
        potencia = pot;
    }

    public Monomio(Monomio m) {
        this.coeficiente = m.coeficiente;
        this.potencia = m.potencia;
    }

    /**
     * Copia el monomio.
     * 
     * @return copia del monomio original
     */
    @Override
    protected Monomio clone() {
        return new Monomio(coeficiente, potencia);
    }

    /**
     * Devuelve al coeficiente del monomio.
     * 
     * @return coeficiente
     */
    public double c() {
        return coeficiente;
    }

    /**
     * Devuelve la potencia del monomio.
     * 
     * @return potencia
     */
    public int p() {
        return potencia;
    }

    /**
     * Método que suma a este monomio con otro.
     * 
     * @param m monomio.
     * @return Monomio resultante de la suma
     */
    public Monomio más(Monomio m) {
        if (m.p() != potencia) {
            throw new IllegalArgumentException("Los monomios tienen que tener el mismo exponente");
        }
        return new Monomio(coeficiente + m.c(), potencia);
    }

    /**
     * Multiplica este monomio por otro.
     * 
     * @param m monomio
     * @return Monomio resultante de la multiplicación
     */
    public Monomio por(Monomio m) {
        return new Monomio(coeficiente * m.c(), potencia + m.p());
    }

    @Override
    public String toString() {
        String cadena = "";
        if (potencia == 0) {
            cadena = String.valueOf(coeficiente);
        } else if (potencia == 1) {
            cadena = coeficiente + "x";
        } else {
            cadena = coeficiente + "x^" + potencia;
        }
        return cadena;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Monomio) {
            Monomio m = (Monomio) o;
            if (m.p() == p() && m.c() == c()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}