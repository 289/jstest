/**
 * @author:jinshuai
 * @Date:2014/7/2.
 */
import java.util.HashMap;
import java.util.Map;
/**补充完该类,不修改main方法,使得get()方法可以取到值*/
public class StudentTest {
    private static final class Student {
        private static String name;
        public Student(String name) {
            this.name = name;
        }

        /*@Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj.hashCode()==name.hashCode();
        }
        达不到效果，考点在这两个方法
        */
    }
    public static void main(String[] args) {
        Map p = new HashMap();
        p.put(new Student("lily"), "sister");
        System.out.println(p.get("lily"));
        System.out.print(p.keySet().iterator().next());
    }
}
