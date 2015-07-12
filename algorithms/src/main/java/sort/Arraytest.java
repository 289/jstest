package sort;

import java.util.Arrays;

/**
 * @author: Jin Shuai
 * @date: 15/7/12
 */
public class Arraytest {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,1,1};
        changeArray(a);
        System.out.println(Arrays.toString(a));

        Val v1 = new Val("1");
        Val v2 = new Val("2");
        changVal(v1);
        System.out.println(v1.getS());

    }

    private static void changVal(Val v1) {
        v1 = new Val("2");
    }

    private static void changeArray(int[] a) {
        int[] a2 = new int[]{2,2,2,2,2,2,2};
        a = a2;
    }

    private static class Val{
        String s;

        public Val(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }
}
