import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinshuai
 * @Date:2014/6/26.
 * ——————
 * |          /
 * |        /
 * ————
 * 按如上方向遍历矩阵，右->左下->左->上  循环直到无法前进
 */
public class AmazonTest1 {
        public static void main(String[] args){
            int[] num1=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            int[] num2=new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
            int[] num3=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
            int[] num4=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
            Integer[] pellAllMatrix1=convertMatrix(5,3,num1);
            for(Integer i:pellAllMatrix1){
                System.out.print(i.toString() + " ");
            }
            System.out.println();
            Integer[] pellAllMatrix2=convertMatrix(4,3,num2);
            for(Integer i:pellAllMatrix2){
                System.out.print(i.toString() + " ");
            }
            System.out.println();
            Integer[] pellAllMatrix3=convertMatrix(6,4,num3);
            for(Integer i:pellAllMatrix3){
                System.out.print(i.toString()+" ");
            }
            System.out.println();
            Integer[] pellAllMatrix4=convertMatrix(5,6,num4);
            for(Integer i:pellAllMatrix4){
                System.out.print(i.toString()+" ");
            }
            System.out.println();
        }
        public static Integer[] convertMatrix(int width,int length,int[] matrix){
            int[][] newMatrix=new int[length][width];
            int[][] zeroOneMatrix=new int[length][width];
            for(int i=0;i<length;i++){
                int start=i*width;
                System.arraycopy(matrix,start,newMatrix[i],0,width);
            }
            for(int i=0;i<length;i++){
                 for(int j=0;j<width;j++){
                     zeroOneMatrix[i][j]=0;
                 }
            }
            List<Integer> matrixList=ergodicZeroOneMatrix(zeroOneMatrix,newMatrix);
            return matrixList.toArray(new Integer[matrixList.size()]);

        }

    public static List<Integer> ergodicZeroOneMatrix(int[][] zeroOneMatrix,int[][] newMatrix){
        List<Integer> matrixList=new ArrayList<Integer>();
        int width=zeroOneMatrix[0].length;
        int length=zeroOneMatrix.length;
        int x=0,y=0;
        zeroOneMatrix[0][0]=1;
        matrixList.add(newMatrix[0][0]);
        int flg=0;
        do{
            flg=0;
                while(x+1<=width-1&&zeroOneMatrix[y][x+1]==0){
                    zeroOneMatrix[y][++x]=1;
                    matrixList.add(newMatrix[y][x]);
                    flg=1;
                }
            while(x-1>=0&&y+1<=length-1&&zeroOneMatrix[y+1][x-1]==0){
                zeroOneMatrix[++y][--x]=1;
                matrixList.add(newMatrix[y][x]);
                flg=1;
            }
            while(x-1>=0&&zeroOneMatrix[y][x-1]==0){
                zeroOneMatrix[y][--x]=1;
                matrixList.add(newMatrix[y][x]);
                flg=1;
            }
            while(y-1>=0&&zeroOneMatrix[y-1][x]==0){
                zeroOneMatrix[--y][x]=1;
                matrixList.add(newMatrix[y][x]);
                flg=1;
            }
        }while(flg==1);

        return matrixList;
    }


}
