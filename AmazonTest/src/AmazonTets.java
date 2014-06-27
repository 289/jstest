import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinshuai
 * @Date:2014/6/26.
 */
public class AmazonTets {
    public static void main(String[] args){
        int[] num=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Integer[] pellAllMatrix=convertMatrix(5,3,num);
        for(Integer i:pellAllMatrix){
             System.out.print(i.toString()+" ");
        }
    }
    public static Integer[] convertMatrix(int width,int length,int[] matrix){
        int[][] newMatrix=new int[length][width];
        for(int i=0;i<length;i++){
            int start=i*width;
            System.arraycopy(matrix,start,newMatrix[i],0,width);
        }
        List<Integer> matrixList=new ArrayList<Integer>();
        while(width>=3&&length>=2){
            matrixList.addAll(peelMatrix(newMatrix));
            width-=3;
            length-=2;
            newMatrix=getNewMatrix(newMatrix);
        }
        for(int i=0;i<width;i++){
            matrixList.add(newMatrix[0][i]);
        }
        return  matrixList.toArray(new Integer[matrixList.size()]);


    }

    public static List<Integer> peelMatrix(int[][] newMatrix){
        int width=newMatrix[0].length;
        int length=newMatrix.length;
        List<Integer> matrixList=new ArrayList<Integer>();
        if(width>3&&length>2){
            for(int i=0;i<width;i++){
                matrixList.add(newMatrix[0][i]);
            }
            for(int i=0;i<length-1;i++){
                matrixList.add(newMatrix[i+1][width-2]);
            }
            for(int i=0;i<width-2;i++){
                matrixList.add(newMatrix[length-1][width-3-i]);
            }
            for(int i=0;i<length-2;i++){
                matrixList.add(newMatrix[length-2-i][0]);
            }
        }
        return matrixList;
    }
    public static int[][] getNewMatrix(int[][] matrix){
        int[][]   newMatrix=new int[matrix.length-2][matrix[0].length-3];
        for(int i=0;i<newMatrix.length;i++){
            System.arraycopy(matrix[i+1],1,newMatrix[i],0,newMatrix[0].length);
        }
        return newMatrix;
    }
}
