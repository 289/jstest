package sort;

import java.util.*;

/**
 * @author: Jin Shuai
 * @date: 15/7/11
 */
public class Sorts {
    public static final int[] WAIT_SORT = new int[]{34,78,3,5,12,3,7,8,345,998,34,5,2,5,23,7878};

    public static int[] getWaitSortArray(){
        Random random = new Random();
        int length = 50000;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] waitSortArray1 = getWaitSortArray();
        int[] waitSortArray2 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray3 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray4 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray5 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray6 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray7 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray8 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray9 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray10 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray11 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        int[] waitSortArray12 = Arrays.copyOf(waitSortArray1, waitSortArray1.length);
        System.out.println("0  " + Arrays.toString(waitSortArray1));
        System.out.println("==================================================");
//        System.out.println("1  " + Arrays.toString(insertSort(waitSortArray1)));
//        System.out.println("2  " + Arrays.toString(shellInsertSort(waitSortArray2)));
//        System.out.println("3  " + Arrays.toString(selectSort(waitSortArray3)));
//        System.out.println("4  " + Arrays.toString(selectSort2(waitSortArray4)));
//        System.out.println("5  " + Arrays.toString(heapSort(waitSortArray5)));
//        System.out.println("6  " + Arrays.toString(bubbleSort(waitSortArray6)));
//        System.out.println("7  " + Arrays.toString(bubbleSort2(waitSortArray7)));
//        System.out.println("8  " + Arrays.toString(bubbleSort3(waitSortArray8)));
//        System.out.println("9  " + Arrays.toString(quickSort(waitSortArray9)));
//        System.out.println("10 " + Arrays.toString(quickSort2(waitSortArray10)));
//        System.out.println("11 " + Arrays.toString(mergeSort(waitSortArray11)));
//        System.out.println("12 " + Arrays.toString(radixSort(waitSortArray12)));


        long start = System.currentTimeMillis();

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            insertSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("insertSort                      ");
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            shellInsertSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("shellInsertSort                 ");
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            selectSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("selectSort                      ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            selectSort2(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("selectSort2                     ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            heapSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("heapSort                        ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            bubbleSort(Arrays.copyOf(waitSortArray1,waitSortArray1.length));
        }
        System.out.print("bubbleSort                      ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            bubbleSort2(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("bubbleSort2                     ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            bubbleSort3(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("bubbleSort3                     ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            quickSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("quickSort                       ");
        System.out.println(System.currentTimeMillis()-start);


        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            quickSort2(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("quickSort2                      ");
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            mergeSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("mergeSort                       ");
        System.out.println(System.currentTimeMillis()-start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            radixSort(Arrays.copyOf(waitSortArray1, waitSortArray1.length));
        }
        System.out.print("radixSort                       ");
        System.out.println(System.currentTimeMillis()-start);

    }


    /**
     * 桶排序/基数排序 (Radix Sort)
     * 先排个位，再排十位，一直往高位排，排完最高位后就是顺序的了（也可以先排高位）
     * @param array
     * @return
     */
    public static int[] radixSort(int[] array){
        int count = 1;
        int index = 1;
        HashMap<Integer, List<Integer>> bucket = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            count = Math.max(count, String.valueOf(array[i]).split("").length);
            int key = (int) (array[i] / Math.pow(10,index - 1));
            key = key % 10;
            if(!bucket.containsKey(key)){
                bucket.put(key, new ArrayList<Integer>());
            }
            bucket.get(key).add(array[i]);
        }
        index++;
        count --;
        while (count > 0){
            HashMap<Integer, List<Integer>> bucket2 = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                if(bucket.containsKey(i)){
                    for (Integer var : bucket.get(i)) {
                        int key = (int) (var / Math.pow(10,index - 1));
                        key = key % 10;
                        if(!bucket2.containsKey(key)){
                            bucket2.put(key, new ArrayList<Integer>());
                        }
                        bucket2.get(key).add(var);
                    }
                }
            }
            index++;
            count--;
            bucket = bucket2;
        }
        int index1 = 0;
        for (int i = 0; i < 10; i++) {
            if(bucket.containsKey(i)){
                for (Integer var : bucket.get(i)) {
                    array[index1] = var;
                    index1++;
                }
            }
        }
        return array;
    }

    /**
     * 归并排序 （Merge Sort）
     * 按2的次方分组，给相邻的组排序，然后次方数++，再排相邻的组，直到结束
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array){
        int childLength = 1;
        while (childLength <= array.length){
            for (int i = 0; i < array.length; ) {
                int startIndex = i;
                int midIndex = i + childLength - 1;
                int endIndex = midIndex + childLength;
                if(midIndex + 1 >= array.length){
                    break;
                } else if(endIndex >= array.length){
                    endIndex = array.length - 1;
                }
                array = merge(array, startIndex, midIndex, endIndex);
                i = endIndex + 1;
            }
            childLength *= 2;
        }
        return array;
    }

    /**
     * 合并两个子序列，并排序
     * @param array
     * @param startIndex
     * @param midIndex
     * @param endIndex
     * @return
     */
    private static int[] merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int[] mergeArray = Arrays.copyOf(array, array.length);
        int k = startIndex;
        int startIndex2 = midIndex + 1;
        while (startIndex <= midIndex && startIndex2 <= endIndex){
            if(array[startIndex] < array[startIndex2]){
                mergeArray[k] = array[startIndex];
                startIndex++;
            } else {
                mergeArray[k] = array[startIndex2];
                startIndex2++;
            }
            k++;
        }
        while (startIndex <= midIndex){
            mergeArray[k] = array[startIndex];
            startIndex++;
            k++;
        }
        while (startIndex2 <= endIndex){
            mergeArray[k] = array[startIndex2];
            startIndex2++;
            k++;
        }
        return mergeArray;
    }

    /**
     * 快速排序变种
     * 对大于K的子序列递归排序，然后用插入排序
     * @param array
     * @return
     */
    public static int[] quickSort2(int[] array){
        int start = 0;
        int end = array.length - 1;
        int k = 8;
        quickSort2_0(array, start, end, k);
        for (int i = 0; i < array.length - 1; i++) {
            int index = i + 1;
            while (index > 0 && array[index] < array[index - 1]){
                swap(array, index, index - 1);
                index--;
            }
        }
        return array;
    }

    /**
     * 从数组的索引start到end排序，序列长度必须大于k
     * @param array
     * @param start
     * @param end
     * @param k
     */
    private static void quickSort2_0(final int[] array, int start, int end, final int k) {
        if(start >= end){
            return;
        }
        if(end - start <= k){
            return;
        }
        int startIndex = start;
        int endIndex = end;

        while (end != start){
            while (end != start){
                if(array[end] < array[start]){
                    swap(array, start, end);
                    start++;
                    break;
                } else {
                    end--;
                }
            }

            while (end != start){
                if(array[start] > array[end]){
                    swap(array, start, end);
                    end--;
                    break;
                } else {
                    start++;
                }
            }
        }

        quickSort2_0(array, startIndex, start - 1, k);
        quickSort2_0(array, start + 1, endIndex, k);
    }

    public static int[] quickSort(int[] array){
        int start = 0;
        int end = array.length - 1;
        quickSort0(array, start, end);
        return array;
    }


    /**
     * 交换排序—快速排序（Quick Sort）
     * 先确定一个基准值（一般取第一个值），排序保证左边的值都小于此值，右边的值都大于此值，然后以相同的方法递归处理左右两个子数组
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort0(final int[] array, int start, int end){
        if(start >= end){
            return;
        }

        int startIndex = start;
        int endIndex = end;

        while (end != start){
            while (end != start){
                if(array[end] < array[start]){
                    swap(array, start, end);
                    start++;
                    break;
                } else {
                    end--;
                }
            }

            while (end != start){
                if(array[start] > array[end]){
                    swap(array, start, end);
                    end--;
                    break;
                } else {
                    start++;
                }
            }
        }

        quickSort0(array, startIndex, start - 1);
        quickSort0(array, start + 1, endIndex);
    }

    /**
     * 冒泡排序变种
     * 每一趟冒泡一个大值，一个小值
     * @param array
     * @return
     */
    public static int[] bubbleSort3(int[] array){
        boolean exchange = false;
        int startIndex = 0;
        int endIndex = array.length - 1;
        for (; startIndex < endIndex;) {
            for (int j = startIndex; j <= endIndex - 1; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    exchange = true;
                }
            }
            endIndex--;
            for (int j = endIndex; j >= startIndex + 1; j--) {
                if(array[j] < array[j - 1]){
                    swap(array, j, j - 1);
                    exchange = true;
                }
            }
            startIndex++;
            if (!exchange) {
                break;
            }
        }
        return array;
    }

    /**
     * 冒泡排序变种
     * 添加一个标记值，记录每趟排序是否有值交换，若没有，表示已经是正确的顺序
     * @param array
     * @return
     */
    public static int[] bubbleSort2(int[] array){
        boolean exchange = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
        return array;
    }

    /**
     * 交换排序—冒泡排序（Bubble Sort）
     * 每一趟冒出一个最大值
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if(array[j - 1] > array[j]){
                    swap(array, j - 1, j);
                }
            }
        }
        return array;
    }

    /**
     * 选择排序—堆排序（Heap Sort）
     * 堆的定义如下：具有n个元素的序列（k1,k2,...,kn),当且仅当满足 Ki <= K2i, Ki <= K2i + 1 或者 Ki >= K2i, Ki >= K2i + 1
     * @param array
     * @return
     */
    public static int[] heapSort(int[] array){
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            heapAdjust(array, 0, i);
        }
        return array;
    }

    /**
     * 将数组转换成堆
     * 最后一个节点的父节点的索引一定是array.length / 2
     * 从最后一个节点的父节点开始调整
     * @param array
     */
    private static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0 ; i--) {
            heapAdjust(array, i, array.length);
        }
    }

    /**
     * 只有头部不满足完全二叉树的条件，调整堆以满足完全二叉树的条件
     * @param array
     * @param headIndex
     * @param adjustLegth
     */
    private static void heapAdjust(int[] array, int headIndex, int adjustLegth){
        int childIndex = 2 * headIndex + 1;
        if (childIndex >= adjustLegth){
            return;
        }
        if(childIndex + 1 < adjustLegth
                && array[childIndex + 1] > array[childIndex]){
            childIndex = childIndex + 1;
        }
        while (array[headIndex] < array[childIndex]){
            swap(array, headIndex, childIndex);
            headIndex = childIndex;
            childIndex = 2 * headIndex + 1;
            if (childIndex >= adjustLegth){
                return;
            }
            if(childIndex + 1 < adjustLegth
                    && array[childIndex + 1] > array[childIndex]){
                childIndex = childIndex + 1;
            }
        }
    }

    /**
     * 选择排序—简单选择排序（Simple Selection Sort）
     * 变种，每次选一个最大值，一个最小值
     * @param array
     * @return
     */
    public static int[] selectSort2(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int index = i + 1; index < length; index++){
                if (array[minIndex] > array[index]){
                    minIndex = index;
                } else if (array[maxIndex] < array[index]){
                    maxIndex = index;
                }
            }
            swap(array, i, minIndex);
            if(maxIndex == i){
                maxIndex = minIndex;
            }
            swap(array, length - 1, maxIndex);
            length--;
        }
        return array;
    }

    /**
     * 选择排序—简单选择排序（Simple Selection Sort）
     *
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
     * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，
     * 直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int index = i + 1; index < array.length; index++){
                if (array[minIndex] > array[index]){
                    minIndex = index;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }


    /**
     * 插入排序—直接插入排序(Straight Insertion Sort)
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index >= 1 && array[index] < array[index - 1]){
                swap(array, index, index - 1);
                index--;
            }
        }
        return array;
    }

    /**
     * 插入排序—希尔排序（Shell`s Sort）
     * 又换版的插入排序
     * 将原序列以gap为间隔分成若干个子序列，没个子序列进行插入排序，
     * 然后gap /= 2; 重复上面的步骤
     * @param array
     * @return
     */
    public static int[] shellInsertSort(int[] array){
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {
                    int index = j;
                    while (index >= gap && array[index] < array[index - gap]){
                        swap(array, index, index - gap);
                        index -= gap;
                    }
                }
            }
        }
        return array;
    }

    /**
     * 交换数组的两个索引的值
     * @param array
     * @param index1
     * @param index2
     */
    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
