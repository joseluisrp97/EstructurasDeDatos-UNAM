package ed.ordenamientos;

import java.util.Arrays;

public class MergeSorter<C extends Comparable<C>> implements IOrdenador<C> {

    public C[] ordena(C[] a) {
        return mergesort(a, 0, a.length - 1);
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

    private C[] mergesort(C[] a, int l, int r) {
        if (r > l) {
            int middle = (r + l) / 2;
            C[] left = mergesort(a, l, middle);
            C[] right = mergesort(a, middle + 1, r);
            merge(a, l, middle, r);
        }
        return a;
    }

    private void merge(C[] a, int l, int m, int r) {
        int lengthLeft = m - l + 1;
        int lengthRight = r - m;

        C left[] = Arrays.copyOf(a, lengthLeft);
        C right[] = Arrays.copyOf(a, lengthRight);

        for (int i = 0; i < lengthLeft; ++i)
            left[i] = a[l + i];
        for (int j = 0; j < lengthRight; ++j)
            right[j] = a[m + 1 + j];

        int i = 0;
        int j = 0;

        int k = l;
        while (i < lengthLeft && j < lengthRight) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < lengthLeft) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < lengthRight) {
            a[k] = right[j];
            j++;
            k++;
        }
    }

}