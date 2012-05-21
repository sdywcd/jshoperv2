package com.jshop.android.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.content.Context;

public class JshopActivityUtil {
	private Context context;
	private String FILESPATH;
	public static String BASE_URL="";
	public static final String BASE_HEAD="http://";
	
	
	public JshopActivityUtil() {
		
		// TODO Auto-generated constructor stub
	}
	public static HttpGet getHttpGet(String url)
	{
		HttpGet request = new HttpGet(url);
		return request;
	}
	public static HttpPost getHttpPost(String url){
		HttpPost request = new HttpPost(url);
		return request;
	}
	public static HttpResponse getHttpResponse(HttpPost request) throws ClientProtocolException, IOException{
		HttpResponse response = new DefaultHttpClient().execute(request);
		return response;
	}
	
	
	public static String queryStringForPost(String url){
		JSONObject param = new JSONObject();
		HttpPost request = JshopActivityUtil.getHttpPost(url);
		String result = null;
		try{
			HttpResponse response = JshopActivityUtil.getHttpResponse(request);
			if(response.getStatusLine().getStatusCode()==200){
				
				result = EntityUtils.toString(response.getEntity());
				return result;
			}
		}catch (ClientProtocolException e){
			e.printStackTrace();
			result = "网络异常";
			return result;
		}catch (IOException e){
			e.printStackTrace();
			result = "网络异常";
			return result;
		}
		return null;
	}
	
	
	/**
	 * 读取服务器地址文件
	 * @return
	 */
	public String readServerhost(){
		String res="";
		try{
			FileInputStream fis=context.openFileInput(JshopMParams.FILENAME);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	
}
