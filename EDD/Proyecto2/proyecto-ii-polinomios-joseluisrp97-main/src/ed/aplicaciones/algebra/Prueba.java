
package ed.aplicaciones.algebra;

public class Prueba{
    public static void main(String[] args) {
        Polinomio p1 = new Polinomio(new double[] { 3.0, 4.0, 5.0, 6.0, 7.0 },
                new int[] { 0, 1, 2, 3, 4 });
        Polinomio p2 = new Polinomio(new double[] { 1.0, 2.0, 3.0, 4.0 },
                new int[] { 4, 5, 6, 7 });
        Polinomio p3 = new Polinomio(new double[] { 2.0, 1.0, 3.0 },
                new int[] { 1, 2, 3 });
        Polinomio p4 = new Polinomio(new double[] { -4.0, -3.0 },
                new int[] { 2, 3 });
        Polinomio p5 = new Polinomio(new double[] { 2.0, 10.0 },
                new int[] { 5, 6 });

        System.out.println("Polinomio 1: " + p1.toString());
        System.out.println("Polinomio 2: " + p2.toString());
        System.out.println("Polinomio 3: " + p3.toString());
        System.out.println("Polinomio 4: " + p4.toString());
        System.out.println("Polinomio 5: " + p5.toString());

        System.out.println("Sumas:");
        System.out.println("p1 + p2:\n" + p1.más(p2).toString());
        System.out.println("p3 + p4:\n" + p3.más(p4).toString());
        System.out.println("p5 + p1:\n" + p5.más(p1).toString());

        System.out.println("Multiplicaciones:");
        System.out.println("p1 * p2:\n" + p1.por(p2).toString());
        System.out.println("p3 * p4:\n" + p3.por(p4).toString());
        System.out.println("p5 * p1:\n" + p5.por(p1).toString());

    }
}