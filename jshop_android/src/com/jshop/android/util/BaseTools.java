package com.jshop.android.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.EncodingUtils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BaseTools extends Activity {

	/**
	 * 写入一个默认的餐桌值，用来检测未就做即可点菜的问题
	 * @param content
	 */
	public void writeJmtable(String content){
		try{
			//实例化文件文件输出流
			FileOutputStream fos=openFileOutput(JshopMParams.SHAREMTABLEPARAM,MODE_WORLD_WRITEABLE+MODE_WORLD_WRITEABLE);
			fos.write(content.getBytes());
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 读取餐桌信息文件
	 * @return
	 */
	public String readJmtable(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.SHAREMTABLEPARAM);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 读取服务器地址
	 */
	public void gethosturl(){
		String oserverhost=read();
		if(oserverhost!=null){
			//放入静态变量
			JshopActivityUtil.BASE_URL="http://"+oserverhost;
		}
	}
	
	/**
	 * 读取服务器地址文件
	 * @return
	 */
	public String read(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.FILENAME);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 写文件，保存服务器地址
	 * @param content
	 */
	public void write(String content){
		try{
			//实例化文件文件输出流
			FileOutputStream fos=openFileOutput(JshopMParams.FILENAME,MODE_WORLD_WRITEABLE+MODE_WORLD_WRITEABLE);
			fos.write(content.getBytes());
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取网络图片
	 * @param pictureurl
	 * @return
	 * @throws IOException
	 */
	public  Bitmap getPictureurlImg(String pictureurl) throws IOException{
		URL url=new URL(pictureurl);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5*1000);
		InputStream in=conn.getInputStream();
		Bitmap bm=BitmapFactory.decodeStream(in);
		in.close();
		return bm;
	}
}
