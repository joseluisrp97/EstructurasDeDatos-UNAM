package ed.ordenamientos;

public class InsertionSorter<C extends Comparable<C>> implements IOrdenador<C> {

    public C[] ordena(C[] a) {
        for (int k = 0; k < a.length - 1; k++) {
            for (int i = k, j = k + 1; i >= 0; i--, j--) {
                if (a[i].compareTo(a[j]) > 0)
                    swap(a, i, j);
                else
                    break;
            }
        }
        return a;
    }

    public int[] peorCaso(int tam) {
        int[] a = new int[tam];
        int count = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = count++;
        }
        return a;
    }

    @Override
    public int[] mejorCaso(int tam) {
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}