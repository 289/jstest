package sort;

import java.util.Arrays;

/**
 * @author Jin Shuai
 */
public class SortTest {

    public static void main(String[] args) {
        heapSortSolve();
    }

    public static void heapSortSolve(){
        int[] array = Sorts.getWaitSortArray(50000000);
        int[] heap = new int[10];
        long start = System.currentTimeMillis();
        for (int i : array) {
            if(i > heap[0]){
                heap[0] = i;
                Sorts.adjustToMinHeap(heap, 0, heap.length);
            }
        }
        Sorts.shellInsertSort(heap);
        System.out.println("cost time : "+(System.currentTimeMillis() - start));
        System.out.println("   result : "+Arrays.toString(heap));
    }
}
