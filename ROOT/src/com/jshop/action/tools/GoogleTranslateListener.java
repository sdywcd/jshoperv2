package com.jshop.action.tools;

import cn.edu.ctgu.ghl.fetion.Contact;
import cn.edu.ctgu.ghl.fetion.Fetion;
import cn.edu.ctgu.ghl.fetion.FetionEvent;
import cn.edu.ctgu.ghl.fetion.IFetionEventListener;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

public class GoogleTranslateListener implements IFetionEventListener {


	private Fetion fetion = null;
	public GoogleTranslateListener(Fetion fetion){
		this.fetion = fetion;
	}
	public void process(FetionEvent sm) {
		//SipMessage sm = (SipMessage)event.getSource();
		if(sm.getFirstLine().startsWith("M")
				&&!"system-message".equals(sm.getHeader("N"))){
			String s = sm.hasBody()?sm.getBody():"";
			if(!s.startsWith("中英 ")
					&& !s.startsWith("ec ")){
				return;
			}
			if(sm.getFirstLine().startsWith("M")){
				System.out.println( "\r\n---------------☆-[" 
						+ getPhoneByUri(sm.getHeader("F"))
						+ "]-☆------------------\r\n" + sm.toString());
			}
			try {
				String c = null;
				if(s.startsWith("中英 ") && s.length()>3){
					String e = s.substring(2).trim();
					c = Translate.translate(e, Language.CHINESE, Language.ENGLISH);
				}else if(s.startsWith("ec ") && s.length()>3){
					String e = s.substring(2).trim();
					c = Translate.translate(e, Language.ENGLISH, Language.CHINESE);
				}
				this.fetion.sendSms(sm.getHeader("F"), c);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private String getPhoneByUri(String uri){
		String ret = uri;
		if(uri==null){
			return null;
		}
		for(Contact c: this.fetion.getContacts()){
			if(uri.equals(c.getUri())){
				ret = c.getPhoneNum() + "(" +c.getNickName() + ")";
				break;
			}
		}
		return ret;
	}



}
