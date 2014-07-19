import java.util.ArrayList;
import java.util.List;

/**
 * Autor: jinshuai
 * Date: 2014/7/19
 * Time: 20:53
 */
public class SortTest {
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("b");
		list.add("b");
		sortList(list);
		System.out.println(list.toArray());
	}

	public static void sortList(List<?> l){
		int j=0;
		while(j==l.size()-1){
			for(int i=j+1;i<l.size();i++){
				if((Object)l.get(i)==l.get(j)){
					l.remove(i);
				}
			}
			j++;
		}
	}
}
