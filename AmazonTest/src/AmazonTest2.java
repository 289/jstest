import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author:jinshuai
 * @Date:2014/6/26.
 * 求爬过山峰到达终点的距离
 */
public class AmazonTest2 {
    public static void main(String[] args){
        int i1=new AmazonTest2().getLength(3,"1,3,2","2,4,4","6,7,5");
        int i2=new AmazonTest2().getLength(3,"1,2,2","2,4,4","6,7,5");
        int i3=new AmazonTest2().getLength(3,"2,3,2","2,4,4","6,7,5");
        int i4=new AmazonTest2().getLength(3,"2,5,5","3,5,3","2,7,10","4,6,3","4,9,15");
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
    }

    public int getLength(int size, String... mountainStr){
        List<Point> pointList=new ArrayList<Point>();
        for(String s:mountainStr){
            String[] mountain=s.split(",");
            if(Integer.parseInt(mountain[1])<Integer.parseInt(mountain[0])){
                size--;
                continue;
            }
            Point point=new Point();
            Point nextPoint=new Point();
            nextPoint.setX(Integer.parseInt(mountain[1]));
            nextPoint.setY(Integer.parseInt(mountain[2]));
            point.setX(Integer.parseInt(mountain[0]));
            point.setY(Integer.parseInt(mountain[2]));
            point.setNextPoint(nextPoint);
            pointList.add(point);
            pointList.add(nextPoint);
        }
        Point[] pointArray=new Point[pointList.size()];
        pointArray=pointList.toArray(pointArray);
        Arrays.sort(pointArray,new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int i=((Point)o1).getX()-((Point)o2).getX();
                if(i>0){
                     return 1;
                }
                else if(i==0){
                     return 0;
                }
                else{
                    return -1;
                }
            }
        });
        List<Point> list=new ArrayList<Point>();
        for(int i=0;i<pointArray.length;i++){
            if(i==pointArray.length-1){
                list.add(pointArray[i]);
                continue;
            }
              if(pointArray[i].getX()==pointArray[i+1].getX()){
                  if(pointArray[i].getY()>pointArray[i+1].getY()){
                      pointArray[i+1]=pointArray[i];
                  }
              }else{
                  list.add(pointArray[i]);
              }
        }
        int sumY=0;
        Point biggestPoint=list.get(0).getNextPoint();
        for(int i=1;i<list.size();i++){
            if(list.get(i).getX()<=biggestPoint.getX()){
                if(list.get(i).getNextPoint()!=null){
                    biggestPoint.setX(biggestPoint.getX()>list.get(i).getNextPoint().getX()?biggestPoint.getX():list.get(i).getNextPoint().getX());
                }
                biggestPoint.setY(biggestPoint.getY()>list.get(i).getY()?biggestPoint.getY():list.get(i).getY());

            }else{
                sumY+=biggestPoint.getY()*2;
                biggestPoint=list.get(i).getNextPoint();
            }
        }
        sumY+=biggestPoint.getY()*2;

        return sumY+biggestPoint.getX();
    }

    class Point{
        private int x;
        private int y;
        private Point nextPoint;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point getNextPoint() {
            return nextPoint;
        }

        public void setNextPoint(Point nextPoint) {
            this.nextPoint = nextPoint;
        }
    }
}
