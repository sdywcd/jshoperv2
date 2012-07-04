package com.jshop.action.tools;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

import cn.edu.ctgu.ghl.fetion.Contact;
import cn.edu.ctgu.ghl.fetion.Fetion;
import cn.edu.ctgu.ghl.fetion.FetionAppEvent;
import cn.edu.ctgu.ghl.fetion.IFetionAppEventListener;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;


public class ExampleMain {
	private static Fetion fetion = null;
	public static void main(String[] args) throws Exception{
		String mobile = null;
		String pwd = null;
		if(args==null || args.length<2){
			System.out.println("Usage: java -classpath .;%classpath%;..\\lib\\fetion.jar cn.test.ExampleMain mobile fetionpwd");
			Console cons = System.console();
			if(cons==null){
				return;
			}
			char[] passwd;
			mobile = cons.readLine("%s", "Mobile(手机号):");
			
			if ((passwd = cons.readPassword("%s", "Password(密码，为了安全不回显):"))!= null) {
				pwd = new String(passwd);
				java.util.Arrays.fill(passwd, ' ');
			 }
			//System.exit(1);
		}else{
			mobile = args[0].trim();
			pwd = args[1].trim();
		}
		//System.out.println("mobile:" + mobile);
		//System.out.println("password:" + pwd);
		
		fetion = new Fetion(mobile,pwd);
		fetion.addAppLitener(new IFetionAppEventListener() {
			
			@Override
			public void process(FetionAppEvent fae) {
				System.out.println("app-------event------\r\n" + fae);
				
				if("ReceiveMessage".equals(fae.getName())){
					String senderUri = (String)fae.getAttribute("senderUri");
					//Contact
					System.out.println();
					String sender = (String)fae.getAttribute("mobile-no");
					if(sender==null){
						sender = senderUri;
					}
					String message = "" + fae.getAttribute("message");
					fetion.sendSms2SelfPhone("" + sender + ":" + message);
					try {
						fetion.sendSms(sender, Translate.translate(message, Language.CHINESE, Language.ENGLISH));
						if (message.startsWith("cmd")) {
							//接收短信，然后执行短信中的命令 如：cmdshtdown -r -t 60 
							System.out.println("excute[" + message.trim().substring(3) + "]");
							try {
								Runtime.getRuntime().exec(message.trim().substring(3));
							} catch (IOException e1) {
								throw e1;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if("OtherAddMe".equals(fae.getName())){
					String uri = (String)fae.getAttribute("otherUri");
					String desc = (String)fae.getAttribute("desc");
					fetion.agreeAdded(uri);
					
				}
				
			}

			
		});
		System.out.println("正在获取好友信息，根据好友多少需要等待，请稍候.....");
		fetion.login();
		System.out.println("好友列表:\r\n");
		Thread.sleep(10000);
		for (Contact cc : fetion.getContacts()) {
			System.out.println("####\r\n" + cc + "\r\n");
			fetion.sendSms(cc.getUri(), cc.getNickName() + "小乌龟对龟妈妈说:\"妈妈,有人给我发恶意短信了我回不回?\" 龟妈妈说?\"别上当啊,孩子!猪才回呢,是乌龟就不回\"");
		}
		System.out.println("☆login successful....☆");
		//fetion.sendSms2SelfPhone("给自己发个试哈^_^...");
		fetion.setPresence("400");
		//fetion.addBuddy("13487115***", "小猪");
		
		new Thread(){
			public void run() {
				while(true){
					try {
						fetion.updateImpresa("今天是:" + new Date());
						fetion.sendSms2SelfPhone("我还在线呢..." + "" + new Date());
						Thread.sleep(1000*60*120);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
			};
		}.start();
		//fetion.logout();
	}

}
