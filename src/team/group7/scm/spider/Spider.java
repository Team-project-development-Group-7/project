package team.group7.scm.spider;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* 使用说明：
 * (1)类
 * 		1. Spider类：
 * 			int current_page = 1;							//开始爬取的页数。记录继续时开始爬取的页数，初始值为1。
 * 			int max_page = 100;							//最大爬取的页数。初始值为100。
 * 			int reply_code = 0;							//网页响应码。初始值为0。
 * 			boolean pause = false;							//暂停标识符。
 * 			String target = "";							//加载目标。
 * 			ArrayList<Data> datas = new ArrayList<Data>();				//记录股评数据的集合。
 * 
 * 		2. 股评数据类 Data：{String id, String user, String comment};
 *         	   股评数据单位 data;
 *         	   股评数据数组 datas;
 *         
 * 		3. 响应码类 CodeReply：{int code};
 *        	   响应码单位 replycode;
 *    
 * (2)公共接口：
 * 		1. Load()
 * 			加载target指向的“股评数据集合”，并记录“响应码”。
 * 		2. PrintDatas()
 * 			输出“股评数据集合”的信息。
 * 		3. OnlyComment()
 * 			返回“股评数据集合”中的“评论集合”。
 * 		4. PrintReply()
 * 			输出网页响应码所对应的信息。
 * 		5. Pause()
 * 			暂停加载。并在Capture()中保留当前的加载页数。
 * 		6. Continue()
 * 			继续加载。按暂停时的页数继续往后加载。
 * 		7. SetMaxPage(int page)
 * 			设置加载股评时的最大页数。默认最大页数为100。
 * 			用于控制股评加载规模。
 * 		8. SetTarget(String input)
 * 			设置爬取目标的url或者id。
 * 			设置时，会重置暂停的加载过程 --- 当前页数重置为1。
 * 
 * (3)爬取逻辑：
 * 		1. Load()[ → InputDetect() → SiteDetect()] → 
 * 		   Capture()[ → SetUrl() → Request()] → 
 * 		   [Parse() → Replace()]
 * 		2. Load() 	--- 作为加载接口。
 * 				  		--- 检测target和获取replycode。
 * 				  		--- InputDetect() 	--- 检测target的输入格式，如果存在网站格式，则转换为删除前缀再输出。
 * 				  		--- SiteDetect() 	--- 检测网页能否成功访问，并返回网页响应码。
 * 				  		--- 如果响应码为200，则开始进行数据Capture()。
 * 		3. Capture() 	--- 正式加载数据。
 * 					 	--- 检测是否有暂停请求。没有就继续以下步骤。
 * 					 	--- SetUrl() 		--- 生成目标动态页面的url。
 * 					 	--- Request() 		--- 对url请求访问，并返回访问信息。
 * 						--- Parse() 进入信息清洗环节。
 * 		4. Parse() 	--- 解析并筛选出访问信息中的所需信息：id、user、comment。
 * 				   		--- Replace() 		--- 对comment中含有的html标签进行清洗，并返回清洗后的comment。
 * 				   		--- 整理好所需信息后，返回“股评数据集合”。
 * */
public class Spider {
	//用于存储用户的股评数据。
	public static class Data{
		public String id;
		public String user;
		public String comment;
	}
	
	//用于存储爬取时的全部信息。
	static private int current_page = 1;
	static private int max_page = 100;
	public static int reply_code = 0;
	static private boolean pause = false;
	static private ArrayList<Data> datas = new ArrayList<Data>();
	static private String target = "";
	
	//用于调用爬取指定股票的股评数据。
	//变量：id->股票代码
	private static void Capture(String target) throws IOException{
		for(int i = Spider.current_page; i<=Spider.max_page; i++) {
			if(Spider.pause == true) {
				Spider.current_page = i;
				Spider.reply_code = 0;
				break;
			}
			String url = SetUrl(target, i);
			try {
				String unparseStr = Request(url);
				Spider.datas.addAll(Parse(unparseStr));
			}catch(IOException e1) {
				throw new IOException();
			}
		}		
	}
	
	//生成指定股票代码的url，对所有评论页数进行爬取。
	//变量：id->股票代码
	private static String SetUrl(String id, int page){
		String url = "https://xueqiu.com/query/v1/symbol/search/status?u=201619610712737&uuid=1387395443553611776&count=10&comment=0&symbol=&hl=0&source=all&sort=&page=&q=&type=11&session_token=null&access_token=520e7bca78673752ed71e19b8820b5eb854123af";
		url = url.replaceAll("symbol=&", "symbol="+id+"&");
		url = url.replaceAll("page=&", "page="+page+"&");
		return url;
	}
	
	
	//向目标网页提交Get请求，并获取其返回的信息。
	//变量：url->网站地址
	private static String Request(String url) throws IOException{
		String result = "";
		BufferedReader in = null;
		try {
			 HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			 connection.setRequestProperty("accept", "*/*");
			 connection.setRequestProperty("connection", "Keep-Alive");
			 connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			 connection.connect();
			 in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			 String line;
			 while((line = in.readLine())!=null)  result+=line;
		}catch (IOException e) {
			throw new IOException();
		}
		finally {
			try {
				if(in != null) 	in.close();
			}catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		return result;
	}
	
	
	//处理网络数据(对象：unparseString), 并返回所需的数据(评论者ID、标题、评论者信息)
	private static ArrayList<Data> Parse(String unparseStr) {
		ArrayList<Data> datas = new ArrayList<Data>();
		JSONObject jsonObject = JSONObject.parseObject(unparseStr);	
		JSONArray lists = (JSONArray) jsonObject.get("list");
		if (lists == null) {return null;}
		for (int i=0; i<lists.size(); i++) {
			JSONObject list = (JSONObject)lists.get(i);
			JSONObject user = (JSONObject)list.get("user");
			Data data = new Data();
			data.id = list.getString("id");
			data.user = user.getString("screen_name");
			data.comment = Replace(list.getString("text"));
			datas.add(data);
		}
		return datas;
	}
	
	
	//处理对象中不需要的网页标签内容。
	//变量：unparse->数据对象。
	private static String Replace(String unparse) {
		unparse = unparse.replaceAll("&nbsp;", "");
		unparse = unparse.replaceAll("<a.*?>", "");
		unparse = unparse.replaceAll("</a.*?>", "");
		unparse = unparse.replaceAll("<b.*?>", "");
		unparse = unparse.replaceAll("</b.*?>", "");
		unparse = unparse.replaceAll("<p.*?>", "");
		unparse = unparse.replaceAll("</p.*?>", "");
		unparse = unparse.replaceAll("<br/.*?>", "");
		unparse = unparse.replaceAll("<img.*?>", "");
		unparse = unparse.replaceAll("</img.*?>", "");
		return unparse;
	}
	
	//用于测试的直接输入获取。
	private static String GetInput() {
		System.out.println("Please input the target: ");
		Scanner input = new Scanner(System.in); 
		String text = input.next();
		return text;
	}
	
	//对输入对应网址或股票代码，能够输出相应结果。
	//能够直接输入测试和输入筛选。
	private static String InputDetect(String text) {
		if(text.contains("xueqiu.com/S/"))
			text = text.replaceAll("(.*)xueqiu.com/S/", "");
		return text;
	}
	
	//获取访问情况。对目标的静态页面发出请求，并获取其响应码。
	//变量：id->访问目标。
	private static int SiteDetect(String id){
		String url = "https://xueqiu.com/S/" + id;
		int code = 0;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			code = new Integer(connection.getResponseCode());
			return code;
		} catch (IOException e) {
			System.out.println("Warning: Input error or Network disconnect.");
		}
		return code;
	}
	
	//提供接口：进行目标数据的爬取，并返回网站响应码。
	//变量：id->爬取目标。
	public static void Load() {
		try {
			Spider.target = InputDetect(Spider.target);
			Spider.reply_code = SiteDetect(Spider.target);
			if(Spider.reply_code == 200)
				Spider.Capture(target);
		}
		catch (IOException e) {
			System.out.println("Warning: The process exist error in running.");
		}
	}
	
	//提供接口：进行对datas的直接输出测试。
	public static void PrintDatas(){
		for(Data data : Spider.datas) 
			System.out.println(data.id + " " + data.user + ":\n    " + data.comment);
	}
	
	//提供接口：返回评论数据集。
	public static ArrayList<String> OnlyComment() {
		ArrayList<String> comments = new ArrayList<String>();
		for(Data data : Spider.datas) 
			comments.add(data.comment);
		return comments;
	}
	
	//提供接口：对爬取时状态的判断。
	public static void PrintReply() {
		int code = Spider.reply_code;
		switch(code) {
			case 0 : 
				System.out.println("Reply code is " + code + " 网络未连接."); break;
			case 200 : 
				System.out.println("Reply code is " + code + " 成功."); break;
			case 403 :
				System.out.println("Reply code is " + code + " 拒绝请求."); break;
			case 404 :
				System.out.println("Reply code is " + code + " 未找到网页."); break;
			case 408 :
				System.out.println("Reply code is " + code + " 请求超时."); break;
			case 503 :
				System.out.println("Reply code is " + code + " 服务不可用."); break;
			default :
				System.out.println("Reply code is " + code + " Error."); break;
		}
	}
	
	public static void Pause() {
		Spider.pause = true;
	}
	
	public static void Continue() {
		Spider.pause = false;
		Load();
	}
	
	public static void SetMaxPage(int page) {
		Spider.max_page = page;
	}
	
	public static void SetTarget(String input) {
		Spider.current_page = 1;
		Spider.target = input;
	}
	
//	主函数。用于测试。
//	Test URL1: https://xueqiu.com/S/SH600887
//	Test URL2: http://xueqiu.com/S/SH600887
//	Test URL3: SH600887
/*	public static void main(String[] args) {
		System.out.println("Process: Start running.");
		String target = GetInput();
		
		System.out.println("\nProcess: Catching.");
		Spider spider = new Spider();
		Spider.SetMaxPage(3);
		Spider.SetTarget(target);
		Spider.Load();
		Spider.PrintReply();
		Spider.PrintDatas();
		
		System.out.println("\nProcess: Finish.");
	}*/
	public static ArrayList<Data> downLoad(String id){
		Spider.SetMaxPage(9);
		Spider.SetTarget(id);
		Spider.Load();
		return datas;
	}
}
	

