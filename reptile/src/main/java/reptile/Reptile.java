package reptile;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Reptile {
	public static final String URL = "http://www.douban.com/group/beijingzufang/discussion?start=";
	// 更新参数
//	public static final String PARAM = "1";
	// 模仿UA
	public static final String UA = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.47 Safari/536.11";
	// 匹配属性名
	public static final String MATCH_ATTR_NAME = "alt";
	// 每话div节点选择器
	public static final String GOOD_IMG_DIV_SELECTOR = ".thumbnail";
	public static final int MAX_PAGE = 120;
	// 存储路径
	public static final String BASE_PATH = "d:/豆瓣租房/";
	//图片div节点
	public static final String IMG_DIV = ".article-content img";

	public static void main(String[] args) throws IOException {
		List<String> urlList = new ArrayList<String>();
		for (int i = 0; i <= MAX_PAGE; i++) {
			String url = URL + (i * 25);
			System.out.println("解析URL(第" + (i + 1) + "页):" + url);
			String result = getResultByUrl(url);
			List<String> urls = getGoodUrl(result);
			urlList.addAll(urls);
		}
		int i=1;
		for (String url : urlList) {
			System.out.println(url);
			String result = getResultByUrl(url);
			if(result.contains("8号线")||result.contains("霍营")){
				 File file=new File(BASE_PATH+i+".html");
				 FileWriter writer=new FileWriter(file);
				writer.append(result);
				writer.flush();
				i++;
			}
//			List<String> urls = getImgUrlByRes(result);
//			for (String str : urls) {
//				System.out.println(str);
//				File img_file = getStoreFile(str);
//				if (saveImg(str, img_file))
//					System.out.println("存入图片" + img_file.getName());
//			}
		}
	}

	/**
	 * 给定url获取内容
	 *
	 * @param url
	 * @return
	 */
	public static String getResultByUrl(String url) {
		HttpClient hc = new HttpClient();
		try {
			GetMethod httpget = new GetMethod(url);
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			hc.getParams().setParameter("http.protocol.single-cookie-header", true);
			setHeaders(httpget);
			hc.executeMethod(httpget);
			String responseStr = readInputStream(httpget.getResponseBodyAsStream());
			// log response
			httpget.releaseConnection();
			return responseStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String readInputStream(InputStream responseBodyAsStream) throws IOException {
		return IOUtils.toString(responseBodyAsStream, "utf-8");
	}

	private static void setHeaders(HttpMethod method) {
		method.setRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;");
		method.setRequestHeader("Accept-Language", "zh-cn");
		method.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
		method.setRequestHeader("Accept-Charset", "utf-8");
		method.setRequestHeader("Keep-Alive", "300");
		method.setRequestHeader("Connection", "Keep-Alive");
		method.setRequestHeader("Cache-Control", "no-cache");
	}

	public static List<String> getGoodUrl(String str) {
		List<String> img_urls = new ArrayList<String>();
		Document doc = Jsoup.parse(str);
		Elements es = doc.select("td").select(".title").select("a");
		for (Element e : es) {
			String url = e.attr("href");
			if (url == null || url.isEmpty()) {
				continue;
			}
			img_urls.add(url);
		}
		return img_urls;
	}

	/**
	 * 从页面中找出图片的地址
	 *
	 * @param str
	 * @return
	 */
	public static List<String> getImgUrlByRes(String str) {
		List<String> img_urls = new ArrayList<String>();
		Document doc = Jsoup.parse(str);
		Elements es = doc.select(IMG_DIV);
		for (Element e : es) {
			img_urls.add(e.attr("src"));
		}
		return img_urls;
	}

	/**
	 * 将图片写入本地
	 */
	/*public static boolean saveImg(String img_url, File file) {
		HttpClient hc = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(img_url);
			httpget.setHeader("User-Agent", UA);
			HttpResponse response = hc.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream in = entity.getContent();
				OutputStream os = new FileOutputStream(file);
				int count = IOUtils.copy(in, os);
				IOUtils.closeQuietly(in);
				IOUtils.closeQuietly(os);
				if (0 != count)
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}*/

	/**
	 * 生成存储路径
	 *
	 * @param url
	 * @return
	 */
	public static File getStoreFile(String url) {
		String[] tmp = url.split("/");
		String file_name = tmp[tmp.length - 1];
		String dir_name = tmp[tmp.length - 2];
		String path = BASE_PATH + File.separator + dir_name + File.separator;
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();
		File img_file = new File(path + file_name);
		if (!img_file.exists()) {
			try {
				img_file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img_file;
	}
}