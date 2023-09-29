/*
 * GNU 3.0
 */
package ed.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Clase que permite acumular secuencias de bit en un buffer antes de escribir
 * al flujo.
 *
 * @author blackzafiro
 */
public class BitBufferedOutputStream extends BufferedOutputStream {

	private static final boolean DEBUG = false;

	/**
	 * Almacena los bits que aún no han sido escritos al
	 * <code>BufferedOutputStream</code> de izquierda a derecha sobre el último
	 * byte de este int, es decir, los datos están en los bits más
	 * representativos de ese último byte. Ej: 00000000 00000000 00000000
	 * 10100000
	 */
	private int bitBuffer = 0;

	/**
	 * Número de bits esperando en el buffer.
	 */
	private int numBitsEnBuffer = 0;

	/**
	 * Indica si el flujo ya había sido enviado (flushed).
	 */
	private boolean flushed = false;

	/**
	 * Crea un entero con los bits hasta la derecha en unos.
	 *
	 * @param numBits número de bits encendidos a 1.
	 */
	public static int hazMáscaraFinal(int numBits) {
		if (numBits < 0) {
			throw new IllegalArgumentException("numBits debe ser positivo");
		}
		if (numBits == 0) {
			return 0;
		}
		if (numBits == Integer.SIZE) {
			return Integer.MIN_VALUE | hazMáscaraFinal(Integer.SIZE - 1);
		}
		int máscara = (1 << numBits) - 1;
		return máscara;
	}

	/**
	 * Crea un entero con los bits hasta la izquierda en unos.
	 *
	 * @param numBits número de bits encendidos a 1.
	 */
	public static int hazMáscaraInicial(int numBits) {
		if (numBits < 0) {
			throw new IllegalArgumentException("numBits debe ser positivo");
		}
		if (numBits == 0) {
			return 0;
		}
		if (numBits == Integer.SIZE) {
			return Integer.MIN_VALUE | hazMáscaraFinal(Integer.SIZE - 1);
		}
		int máscara = (1 << numBits) - 1;
		return máscara << (Integer.SIZE - numBits);
	}

	/**
	 *
	 * @param out
	 */
	public BitBufferedOutputStream(OutputStream out) {
		super(out);
	}

	/**
	 * Escribe los primeros <code>numBits</code> de <code>data</code>.
	 *
	 * @param data Este entero debe contener los bits que se van a escribir en
	 * su dígitos más significativos.
	 * @param numBits Número de bits que serán escritos por el flujo.
	 */
	public void write(int data, int numBits) throws IOException {
		if (DEBUG) {
			System.out.format("%ndata = [%d]%s %d%n", numBits, Integer.toBinaryString(data), Integer.toBinaryString(data).length());
		}

		int porEscribir = numBits;
		int restan = Byte.SIZE - numBitsEnBuffer;

		if (DEBUG) {
			System.out.format("bitBuffer = %s [%d espacios libres]%n", Integer.toBinaryString(bitBuffer), restan);
		}
		while (porEscribir >= restan) {
			// Completar el buffer
			int bitsNuevos = (data >>> (Integer.SIZE - restan));

			if (DEBUG) {
				System.out.format("bitsNuevos = %s%n", Integer.toBinaryString(bitsNuevos));
			}

			bitBuffer = bitBuffer | bitsNuevos;

			if (DEBUG) {
				System.out.format("bitBuffer = %s%n", Integer.toBinaryString(bitBuffer));
			}

			// Escribir el contenido del buffer lleno
			super.write(bitBuffer);

			// Actualizar data, buffer, porEscribir y restan
			data <<= restan;

			porEscribir -= restan;
			bitBuffer = 0;
			numBitsEnBuffer = 0;
			restan = Byte.SIZE;

			if (DEBUG) {
				System.out.format("data = [%d]%s %d%n", porEscribir, Integer.toBinaryString(data), Integer.toBinaryString(data).length());
			}
		}
		if (porEscribir > 0) {
			// Se escribirán menos bits que los espacios disponibles en el buffer.
			int bitsNuevos = data & hazMáscaraInicial(porEscribir);
			if (DEBUG) {
				String m = Integer.toBinaryString(hazMáscaraInicial(porEscribir));
				System.out.format("máscara = %s %d%n", m, m.length());
				System.out.format("bitsNuevos = %s \t bitsEnBuffer = %d%n", Integer.toBinaryString(bitsNuevos), numBitsEnBuffer);
			}

			bitsNuevos >>>= 24 + numBitsEnBuffer;

			if (DEBUG) {
				System.out.format("bitsNuevos = %s%n", Integer.toBinaryString(bitsNuevos));
			}

			bitBuffer = bitBuffer | bitsNuevos;
			numBitsEnBuffer += porEscribir;

			if (DEBUG) {
				System.out.format("bitBuffer = %s con %d %s%n",
					Integer.toBinaryString(bitBuffer),
					numBitsEnBuffer,
					(numBitsEnBuffer == 1) ? "bit" : "bits");
			}
		}
	}

	/**
	 * Envía toda la información en el flujo de salida. Esto forza a que
	 * cualquier bit aún en el buffer sea escrito. Si el número de bits restante
	 * no es múltiplo de ocho se rellena con ceros a la derecha.
	 *
	 * @throws IOException si se llama flush más de una vez, pues causaría la
	 * presencia de ceros espúreos en medio del flujo.
	 */
	@Override
	public void flush() throws IOException {
		if (flushed) {
			throw new IOException("Este flujo no se puede enviar más de una vez");
		}
		if (numBitsEnBuffer > 0) {
			super.write(bitBuffer);
			flushed = true;
		}
		super.flush();
	}

	private static void pruebaMáscara() {
		int resultado;
		for (int i = 0; i <= 32; i++) {
			resultado = hazMáscaraInicial(i);
			System.out.format("%d bits = %s%n", i, Integer.toBinaryString(resultado));
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		BitBufferedOutputStream bbos = new BitBufferedOutputStream(System.out);
		int data = 5 << Integer.SIZE - 3; // 101
		System.out.format("Escribiendo %d = %s%n", data, Integer.toBinaryString(data));
		bbos.write(data, 3);

		data = (1 << 31) | 25436453;
		System.out.format("%nEscribiendo %d = %s%n", data, Integer.toBinaryString(data));
		bbos.write(data, 30);

		data = 3 << Integer.SIZE - 3; // 011
		System.out.format("%nEscribiendo %d = %s%n", data, Integer.toBinaryString(data));
		bbos.write(data, 3);

		bbos.flush();
		 */

		BitBufferedOutputStream bbos = new BitBufferedOutputStream(System.out);
		String[] data = {"0111", "0100", "0111", "0100", "1000"};
		int num;
		for (String datum : data) {
			num = Integer.parseInt(datum, 2);
			System.out.format("Escribiendo %d = %s%n", num, datum);
			bbos.write(num << 32 - 4, 4);
			System.out.println();
		}
		bbos.flush();

	}

}
