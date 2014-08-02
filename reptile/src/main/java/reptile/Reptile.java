package reptile;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reptile {
	// 糗事百科图片贴地址
	public static final String URL = "http://www.ishuhui.com/archives/category/zaixianmanhua/haizeiwang/page/";
	// 更新参数
//	public static final String PARAM = "1";
	// 模仿UA
	public static final String UA = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.47 Safari/536.11";
	// 匹配属性名
	public static final String MATCH_ATTR_NAME = "alt";
	// 每话div节点选择器
	public static final String GOOD_IMG_DIV_SELECTOR = ".thumbnail";
	public static final int MAX_PAGE = 6;
	// 存储路径
	public static final String BASE_PATH = "d:/鼠绘漫画/海贼王";
	//图片div节点
	public static final String IMG_DIV=".article-content img";

	public static void main(String[] args) {
		List<String> urlList = new ArrayList<String>();
		for (int i = 1; i <= MAX_PAGE; i++) {
			String url = URL + i;
			System.out.println("解析URL(第" + i + "页):" + url);
			String result = getResultByUrl(url);
			List<String> urls = getGoodUrl(result);
			urlList.addAll(urls);
		}

		for(String url:urlList){
			System.out.println(url);
			String result = getResultByUrl(url);
			List<String> urls = getImgUrlByRes(result);
			for (String str : urls) {
				System.out.println(str);
				File img_file = getStoreFile(str);
				if (saveImg(str, img_file))
					System.out.println("存入图片" + img_file.getName());
			}
		}
	}

	/**
	 * 给定url获取内容
	 *
	 * @param url
	 * @return
	 */
	public static String getResultByUrl(String url) {
		HttpClient hc = new DefaultHttpClient();
//		HttpClient hc = (HttpClient) HttpClientBuilder.create();
		try {
			HttpGet httpget = new HttpGet(url);
			httpget.setHeader("User-Agent", UA);
			HttpResponse response = hc.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream in = entity.getContent();
				StringWriter sw = new StringWriter();
				IOUtils.copy(in, sw);
				in.close();
				return sw.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static List<String> getGoodUrl(String str) {
		List<String> img_urls = new ArrayList<String>();
		Document doc = Jsoup.parse(str);
		Elements es = doc.select(GOOD_IMG_DIV_SELECTOR);
		for (Element e:es) {
			Element up_a = e.select(".caption a").get(0);
			img_urls.add(up_a.attr("href"));
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
		for (Element e:es) {
			img_urls.add(e.attr("src"));
		}
		return img_urls;
	}

	/**
	 * 将图片写入本地
	 */
	public static boolean saveImg(String img_url, File file) {
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
	}

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
		String path = BASE_PATH + File.separator +dir_name+File.separator;
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