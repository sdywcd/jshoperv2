package com.jshop.action.tools;

import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class ToChangePDF {
	
	public static void PDF() throws Exception{
		Document d = new Document();
		try {
			String path=ServletActionContext.getServletContext().getRealPath("");//获取根目录
			PdfWriter.getInstance(d, new FileOutputStream("e:/hello.pdf"));
			BaseFont bf = BaseFont.createFont( "c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			d.addTitle("java生成PDF文件");
			d.addSubject("主题");
			d.addKeywords("关键字");
			d.addAuthor("作者-alextao");
			d.open();
			d.add(new Paragraph("你好",new Font(bf)));
			d.close();
		} catch (Exception e) {
			throw e;
		} 
		
	}

}
