package com.jshop.android.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper1 extends SQLiteOpenHelper {
	
	
	public DBHelper1(Context context,String name,CursorFactory cursorFactory, int version) {
		super(context, name, cursorFactory, version);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		super.onOpen(db);
	}
	
	
	
//	/**
//	 * 插入数据
//	 * @param values
//	 * @param tablename
//	 */
//	public void insert(String tablename,ContentValues values){
//		SQLiteDatabase db=this.getWritableDatabase();
//		db.insert(tablename, null, values);
//		db.close();
//	}
	
//	/**
//	 * 查询数据
//	 * @param tablename
//	 * @return
//	 */
//	public Cursor query(String tablename){
//		SQLiteDatabase db=this.getWritableDatabase();
//		Cursor c=db.query(tablename, null, null, null, null, null, null);
//		return c;
//	}
//	
//	/**
//	 * 查询商品表数据
//	 * @param tablename
//	 * @return
//	 */
//	public Cursor queryByParamgoodsCategoryTid(String tablename,String param){
//		SQLiteDatabase db=this.getWritableDatabase();
//		Cursor c=db.rawQuery("select * from "+tablename+" where goodsCategoryTid=?", new String[]{String.valueOf(param)}); 
//		return c;
//	}
//	/**
//	 * 查询商品表数据goodsid
//	 * @param tablename
//	 * @return
//	 */
//	public Cursor queryByParamgoodsid(String tablename,String param){
//		SQLiteDatabase db=this.getWritableDatabase();
//		Cursor c=db.rawQuery("select * from "+tablename+" where goodsid=?", new String[]{String.valueOf(param)}); 
//		return c;
//	}
//	
//	
//	/**
//	 * 删除数据
//	 * @param talbename
//	 * @param id
//	 */
//	public void delete(String talbename,String id){
//		if(db==null){
//			db=this.getWritableDatabase();
//			db.delete(talbename, "_id=?", new String[]{String.valueOf(id)});
//		}
//	}
//	/**
//	 * 删除所有数据
//	 * @param tablename
//	 */
//	public void deleteAll(String tablename){
//		if(db==null){
//			db=this.getWritableDatabase();
//			db.delete(tablename, null, null);
//		}
//	}
//	
//	/**
//	 * 删除数据库表
//	 * @param tablename
//	 */
//	public void DropTable(String tablename){
//		db=this.getWritableDatabase();
//		db.execSQL("drop table "+tablename);
//	}
//	/**
//	 * 删除数据库
//	 * @param tablename
//	 */
//	public void DropDB(){
//		db=this.getWritableDatabase();
////		db.execSQL("drop database jshopmactive");
//		onUpgrade(db,3,4);
//	}
	


}
