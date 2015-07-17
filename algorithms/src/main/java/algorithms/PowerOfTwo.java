package algorithms;

/**
 * @author Jin Shuai
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));
    }

    public boolean isPowerOfTwo(int n){
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
