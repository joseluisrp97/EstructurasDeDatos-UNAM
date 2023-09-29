package ed.aplicaciones.algebra;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para un monomio.
 */
class MonomioTest {

	@Test
	void suma() {
		System.out.print("Suma:");
		Monomio monomio1 = new Monomio(5.2, 2);
		Monomio monomio2 = new Monomio(1.2, 2);
		Monomio r = monomio1.más(monomio2);
		System.out.println(" " + monomio1 + " + " + monomio2 + " = " + r);
		assertEquals(6.4, r.c());
		assertEquals(2, r.p());
	}
}
