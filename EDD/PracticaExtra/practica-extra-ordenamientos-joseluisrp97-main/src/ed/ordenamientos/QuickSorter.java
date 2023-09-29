
package ed.ordenamientos;

public class QuickSorter<C extends Comparable<C>> implements IOrdenador<C> {

    public C[] ordena(C[] a) {
        return quicksort(a, 0, a.length - 1);
    }

    public int[] peorCaso(int tam) {
        int[] a = new int[tam];

        for (int i = 0; i < a.length; i++)
            a[i] = i;

        return a;
    }

    public int[] mejorCaso(int tam) {
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private int partition(C[] arr, int first, int last) {
        C pivot = arr[first];
        int low = (first + 1);
        int high = last;

        while (high > low) {

            while (low <= high && arr[low].compareTo(pivot) <= 0)
                low++;

            while (low <= high && arr[high].compareTo(pivot) > 0)
                high--;

            if (high > low)
                swap(arr, low, high);
        }

        while (high > first && arr[high].compareTo(pivot) >= 0)
            high--;

        if (pivot.compareTo(arr[high]) > 0) {
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    private C[] quicksort(C[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
        return arr;
    }

}