
package ed.aplicaciones.algebra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PolinomioTest {
    @Test
    void sumPol1() {
        System.out.print("Suma 1:\n");
        Polinomio p1 = new Polinomio(new double[] { 2.0, 3.0 },
                new int[] { 0, 1 });
        Polinomio p2 = new Polinomio(new double[] { 4.0, 5.0, 6.0 },
                new int[] { 1, 2, 3 });
        Polinomio p3 = new Polinomio(new double[] { 2.0, 7.0, 5.0, 6.0 },
                new int[] { 0, 1, 2, 3 });
        Polinomio resultado = p1.más(p2);
        System.out.println(p1 + "\n+");
        System.out.println(p2 + "\n=");
        System.out.println(resultado);
        assertEquals(resultado, p3);
    }

    @Test
    void sumPol2() {
        System.out.print("Suma 2:\n");
        Polinomio p1 = new Polinomio(new double[] { 1.0, -1.0 },
                new int[] { 1, 2 });
        Polinomio p2 = new Polinomio(new double[] { -1.0, 1.0 },
                new int[] { 0, 1 });
        Polinomio p3 = new Polinomio(new double[] { -1.0, 2.0, -1.0 },
                new int[] { 0, 1, 2 });
        Polinomio resultado = p1.más(p2);
        System.out.println(p1 + "\n+");
        System.out.println(p2 + "\n=");
        System.out.println(resultado);
        assertEquals(resultado, p3);
    }

    @Test
    void mulPol1() {
        System.out.print("Multiplicación 1:\n");
        Polinomio p1 = new Polinomio(new double[] { 2.0, 3.0 },
                new int[] { 0, 1 });
        Polinomio p2 = new Polinomio(new double[] { 4.0, 5.0, 6.0 },
                new int[] { 1, 2, 3 });
        Polinomio p3 = new Polinomio(new double[] { 8.0, 22.0, 28.0, 18.0 },
                new int[] { 1, 2, 3, 4 });
        Polinomio resultado = p1.por(p2);
        System.out.println(p1 + "\n+");
        System.out.println(p2 + "\n=");
        System.out.println(resultado);
        assertEquals(resultado, p3);
    }

    @Test
    void mulPol2() {
        System.out.print("Multiplicación 2:\n");
        Polinomio p1 = new Polinomio(new double[] { 1.0, -1.0 },
                new int[] { 1, 2 });
        Polinomio p2 = new Polinomio(new double[] { -1.0, 1.0 },
                new int[] { 0, 1 });
        Polinomio p3 = new Polinomio(new double[] { -1.0, 2.0, -1.0 },
                new int[] { 1, 2, 3 });
        Polinomio resultado = p1.por(p2);
        System.out.println(p1 + "\n+");
        System.out.println(p2 + "\n=");
        System.out.println(resultado);
        assertEquals(resultado, p3);
    }
}
