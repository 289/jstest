import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/**
 * @author:jinshuai
 * @Date:2014/6/26.
 * 朗福德对 3 1 2 1 3 2
 * 任意输入数字求朗福德对
 */
public class AmazonTest3 {
    public static  void langford(int N) {
        if(N == 0) {
            System.out.println(" no result ");
            System.exit(0);
        }
        BitSet bs = new BitSet();
        bs.set(N * 2);
        int[] a=new int[2 * N];
        put(bs, N, a);
        if(bs.nextClearBit(0) >= 0) {
            System.out.println(" no result ");
        }
    }
    public  static void put(BitSet bs, int n, int[] arr) {
        if (n == 0) {
            System.out.println(Arrays.toString(arr));
            System.exit(0);
        }
        for (int i = -1, L = bs.length() - n - 1;
             (i = bs.nextClearBit(i + 1)) < L ;) {
            final int j = i + n + 1;
            if (!bs.get(j)) {
                arr[i] = n;
                arr[j] = n;
                bs.flip(i);
                bs.flip(j);
                put(bs, n - 1, arr);
                bs.flip(i);
                bs.flip(j);
            }
        }
    }
    public static void main(String[] args) {
        langford(7);
    }

    /**
     * 另外一种解法
     * @param n
     * @return
     */
        public ArrayList<int[]> getLangford(int n){
            ArrayList<int[]> returnVal = new ArrayList<int[]>();
            int[] record = new int[2 * n];
            lanfordHelper(returnVal, record, n);
            return returnVal;
        }
        private void lanfordHelper(ArrayList<int[]> returnVal, int[] record, int downNum){
            // Edge case
            if(downNum < 0)        return;
            // Base
            if(downNum == 0){
                returnVal.add(Arrays.copyOf(record, record.length));
                return;
            }
            //Normal
            for(int i = 0; i <= record.length - downNum - 2; i++){
                if(record[i] == 0 && record[i + downNum + 1] == 0){
                    record[i] = downNum;
                    record[i + downNum + 1] = downNum;
                    lanfordHelper(returnVal, record, downNum - 1);
                    record[i] = 0;
                    record[i + downNum + 1] = 0;
                }
            }
        }


}
