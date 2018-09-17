package com.example.taixinjianceapp;
/**
 *̥�������
 *���ܣ�      1. ��¼��ǰ��̥��ʱ��
 *		2. �ֶ����ĳһʱ�̵�̥��
 *		3. �鿴̥����ʷ
 *		4. ����̥������ͼ
 *
 * �����
 * �Բ�������ĸ�������л����
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
	private Button recrd_Btn;//��¼ ��ť 
	private MyDatabaseHelper dbHelper;
	/*
	 * ��дonCreate����
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
			//��ȡ��ǰϵͳ����-��-�� ʱ-��-��
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