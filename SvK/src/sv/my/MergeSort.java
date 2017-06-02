package sv.my;

/**
 * Created by Surya Vamsi on 29-May-15.
 */
public class MergeSort {
    public static long CountInversions(int[] array) {
        int mid = array.length / 2;
        int k;
        long left, right, merge;
        if (array.length <= 1) return 0;
        int[] l = new int[mid];
        for (k = 0; k < mid; ++k) l[k] = array[k];
        int[] r = new int[array.length - mid];
        for (k = 0; k < array.length - mid; k++) r[k] = array[mid + k];
        left = CountInversions(l);
        right = CountInversions(r);
        int[] result = new int[array.length];
        merge = mergeCount(l, r, result);
        for (k = 0; k < array.length; k++) array[k] = result[k];
        return left + right + merge;
    }

    private static long mergeCount(int[] l, int[] r, int[] result) {
        int  a = 0, b = 0,i, k = 0;long count=0;
        while ((a < l.length) && (b < r.length)) {
            if (l[a] <= r[b]) {
                result[k] = l[a++];
            } else {
                result[k] = r[b++];
                count += l.length - a;
            }
            k++;
        }
        if (a == l.length) {
            for (i = b; i < r.length; i++) result[k++] = r[i];
        } else for (i = a; i < l.length; i++) result[k++] = l[i];
        return count;
    }
}
