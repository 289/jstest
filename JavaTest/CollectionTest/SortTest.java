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
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(4);
		list1.add(5);
		list1.add(5);
		sortList(list1);
		for(String s:list){
			System.out.println(s);
		}
		for(Integer i:list1){
			System.out.println(i);
		}
	}

	public static void sortList(List<?> l){
		int j=0;
		int size=l.size()-1;
		while(j<size){
			for(int i=j+1;i<l.size();i++){
				if(l.get(i)==l.get(j)){
					l.remove(i);
				}
			}
			j++;
		}
	}
}
