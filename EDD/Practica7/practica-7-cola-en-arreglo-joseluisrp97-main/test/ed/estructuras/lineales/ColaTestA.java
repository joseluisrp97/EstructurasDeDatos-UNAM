/**
 * Código utilizado para el curso de Estructuras de Datos.
 *
 * Se permite consultarlo para fines didácticos de forma personal, pero no está
 * permitido transferirlo tal cual a estudiantes actuales o potenciales pues se
 * afectará su realización de los ejercicios.
 */

package ed.estructuras.lineales;

import java.util.Collection;

import org.junit.Test;
import static org.junit.Assert.*;

import ed.estructuras.ColecciónAbstractaTestA;

/**
 * Clase que agrega pruebas unitarias para las clases hijas de la clase ICola.
 *
 * @author mindahrelfen
 */
public abstract class ColaTestA extends ColecciónAbstractaTestA {

    @Override
    public void init() {
        allowRemove = true;
        allowNull = allowRemoveAll = allowRetainAll = allowIteratorRemove = false;
        allowDifferentConstructor = false;
    }

    @Override
    protected Collection<String> getColecciónAbstracta() {
        return getCola();
    }

    /**
     * Devuelve una cola bien construida.
     *
     * @return ICola Una cola de tipo String vacía.
     */
    protected abstract Cola<String> getCola();

    // atiende

    @Test
    public void atiendeContainsTest() {
        Cola<String> structure;

        startTest("Prueba que la estructura no contenga elementos después de borrarlos", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
        }

        /**
         * Luego los expulsa hasta que la estructura este vacía.
         */
        while (!structure.isEmpty()) {
            structure.atiende();
        }

        /**
         * Revisa que ningún elemento insertado se encuentre en la estructura.
         */
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            assertFalse(structure.contains(rsgIt.next()));
        }

        addUp(1.0);
        passed();
    }

    @Test
    public void atiendeSizeTest() {
        int index;
        Cola<String> structure;

        startTest("Revisa que la cantidad de elementos tras borrar sea consistente", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
        }

        /**
         * Borra los elementos de la estructura de uno en uno y revisa que cada
         * borrado mantenga el tamaño deseado.
         */
        index = 1;
        while (index <= range) {
            structure.atiende();
            assertEquals(structure.size(), range - index++);
        }

        /**
         * Revisa que la estructura este vacía al finalizar el borrado de todos
         * sus elementos.
         */
        assertTrue(structure.isEmpty());

        addUp(1.0);
        passed();
    }

    @Test
    public void atiendeEmptyTest() {
        Cola<String> structure;

        startTest("Revisa que se devuelva null cuando se intenta borrar y no hay elementos", 1.0, "Borrado");

        /**
         * Si se intenta borrar sobre una estructura vacía debe devolver null.
         */
        structure = getCola();
        assertNull(structure.atiende());

        addUp(1.0);
        passed();
    }

    @Test
    public void atiendeMiraTest() {
        String str;
        Cola<String> structure;

        startTest("Prueba que mira y atiende devuelvan el mismo valor", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
        }

        /**
         * Revisa hasta que la estructura este vacía que el elemento devuelto
         * por mira sea el mismo que devuelve expulsa.
         */
        while (!structure.isEmpty()) {
            str = structure.mira();
            if (str == null) {
                assertNull(structure.atiende());
            } else {
                assertTrue(str.equals(structure.atiende()));
            }
        }

        addUp(1.0);
        passed();
    }

    // forma

    @Test
    public void formaContainsTest() {
        Cola<String> structure;

        startTest("Revisa que la estructura contenga los elementos insertados", 1.0, "Inserción");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
        }

        /**
         * Se asegura que los elementos insertados estén contenidos dentro de
         * la estructura.
         */
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            assertTrue(structure.contains(rsgIt.next()));
        }

        addUp(1.0);
        passed();
    }

    @Test
    public void formaSizeTest() {
        int index;
        Cola<String> structure;

        startTest(
                "Revisa que la estructura mantenga la cantidad correcta de elementos, ademas de no estar vacía tras insertar",
                1.0, "Inserción");

        /**
         * Inserta elementos en la estructura de uno en uno y revisa que cada
         * inserción mantenga el tamaño deseado. Además, revisa que ninguna
         * inserción vuelva vacía la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        index = 1;
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
            assertEquals(structure.size(), index++);
            assertFalse(structure.isEmpty());
        }

        addUp(1.0);
        passed();
    }

    // FIFO

    @Test
    public void FIFOTest() {
        int index;
        String str;
        String[] array1, array2;
        Cola<String> structure;

        startTest("Revisa que la cola sea una estructura FIFO", 1.0, "Otros");

        /**
         * Inserta elementos en una estructura y en un arreglo en el mismo
         * orden y al mismo tiempo.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        array1 = new String[range];
        index = 0;
        while (rsgIt.hasNext()) {
            str = rsgIt.next();
            structure.forma(str);
            array1[index++] = str;
        }

        /**
         * Borra elementos de la estructura y los guarda en un arreglo.
         */
        array2 = new String[range];
        index = 0;
        while (!structure.isEmpty()) {
            array2[index++] = structure.atiende();
        }

        /**
         * Compara ambos arreglos, deben tener el mismo orden.
         */
        assertTrue(equals(array1, array2));

        addUp(1.0);
        passed();
    }

    // Collection
    /* ERROR */

    @Test(expected = NullPointerException.class)
    public void removeNullTest() {
        Collection<String> structure;

        startTest("Revisa que se lance NullPointerException si se intenta remover null", 1.0, "Borrado");

        structure = getColecciónAbstracta();

        try {
            structure.remove(null);
        } catch (NullPointerException e) {
            addUp(1.0);
            passed();
            throw e;
        }
    }

    /* ERROR */
    @Test
    public void formaRemoveTest() {
        Cola<String> structure;

        startTest("Revisa que la estructura remueva el elemento en al frente.", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        rsgIt = rsg.iterator();
        while (rsgIt.hasNext()) {
            structure.forma(rsgIt.next());
        }

        /**
         * Se asegura que los elementos insertados estén contenidos dentro de
         * la estructura.
         */
        while (!structure.isEmpty()) {
            assertTrue(structure.remove(structure.mira()));
        }

        addUp(1.0);
        passed();
    }

    /* ERROR */

    @Test
    public void formaRemoveTrueFalseTest() {
        Cola<String> structure;

        startTest("Revisa que la estructura remueva el elemento en al frente o devuelva false.", 1.0, "Borrado");

        /**
         * Inserta elementos en la estructura.
         */
        structure = getCola();
        String[] a = { "1", "2", "3", "4", "5", "6" };
        String[] b = { "1", "7", "2", "5", "7", "3" };
        boolean[] r = { true, false, true, false, false, true };

        for (String in : a) {
            structure.forma(in);
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(structure);
            System.out.println("  Removiendo " + b[i] + " frente: " + structure.mira() + " espera " + r[i]);
            assertEquals(structure.remove(b[i]), r[i]);
        }

        addUp(1.0);
        passed();
    }

    // No funcionan para esta implementación de pila, por lo tanto no se usan.
    @Test
    @Override
    public void removeContainsTest() {
    }

    @Test
    @Override
    public void removeSizeTest() {
    }
}