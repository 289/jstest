import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Autor: jinshuai
 * Date: 2014/7/20
 * Time: 1:17
 */
public class RegexTest {
	public static void main(String[] args) throws IOException {
		List l=getEmail(new File("d:/test.txt"));
		for(Object s:l){
			System.out.println(s.toString().replace("@","#"));
		}
	}

	public static List getEmail(File file) throws IOException {
		Pattern pattern=Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		List list=new ArrayList<>();
		BufferedReader r=new BufferedReader(new FileReader(file));
		String line="";
		while((line=r.readLine())!=null){
			Matcher matcher=pattern.matcher(line);
			while(matcher.find()){
				list.add(matcher.toMatchResult().group());
			}
		}
		return list;

	}
}
