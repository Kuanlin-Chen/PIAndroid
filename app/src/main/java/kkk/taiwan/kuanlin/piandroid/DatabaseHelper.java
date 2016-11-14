package kkk.taiwan.kuanlin.piandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kuanlin on 2016/3/4.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Score.db";
    public static final String TABLE_NAME = "score_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITLE"; //標題
    public static final String COL_3 = "TYPE"; //種類
    public static final String COL_4 = "MARKS"; //分數

    //建構子
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        //"create table這裡要空一格" "空一格(ID INTEGER......)"
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, TYPE TEXT, MARKS REAL)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String title, String type, double marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,type);
        contentValues.put(COL_4, marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = null;
        res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public Cursor getOneScore(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_onescore = null;
        res_onescore = db.rawQuery("select "+COL_4+" from "+TABLE_NAME+" where "+COL_2+" like '"+title+"'", null);
        return res_onescore;
    }

    public Cursor getAverage()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_ave = null;
        res_ave = db.rawQuery("select avg(MARKS) from "+TABLE_NAME, null);
        return res_ave;
    }

    public Cursor getCount()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_count = null;
        res_count = db.rawQuery("select count(TITLE) from "+TABLE_NAME+" where TITLE is not null", null);
        return res_count;
    }

    public boolean updateData(String id, String title, String type, double marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,title);
        contentValues.put(COL_3,type);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public boolean searchData(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_search = null;
        Log.i("kkk", title);
        res_search = db.rawQuery("select "+COL_2+" from "+TABLE_NAME+" where "+COL_2+" like '"+title+"'", null);
        res_search.moveToFirst();
        String packagename = new String();
        if(res_search.getCount()==0)
        {
            packagename = "xyzzz";
        }
        else
        {
            packagename = res_search.getString(0);
        }

        if (packagename.equals(title)) //String==String 判斷是否參考同一個，String.equals()判斷內容
        { return true; }
        else
        { return false;}
    }
}
