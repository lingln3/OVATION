package com.example.taixinjianceapp;
/**
 *胎动监测仪
 *功能：      1. 记录当前的胎动时间
 *		2. 手动添加某一时刻的胎动
 *		3. 查看胎动历史
 *		4. 绘制胎动曲线图
 *
 * 主活动：
 * 对操作界面的各项按键进行活动分配
*/

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Taixinjiance extends Activity implements OnClickListener{
	private Button recrd_Btn;//记录 按钮 
	private MyDatabaseHelper dbHelper;
	/*
	 * 覆写onCreate函数
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbHelper = new MyDatabaseHelper(this,"Taidong.db",null,1);
		recrd_Btn = (Button)findViewById(R.id.recrdButton);
		recrd_Btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.recrdButton:
			//获取当前系统的年-月-日 时-分-秒
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String date = sDateFormat.format(new java.util.Date());
			
			SQLiteDatabase db =dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("time", date);
			db.insert("Taidong", null, values);
			break;
		default:
			break;
		}
	}
		
}