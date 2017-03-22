package com.example.shivanshu.alumniconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shivanshu on 3/20/2017.
 */

public class DataBaseConnectivity extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static String DETAIL_DATA="Detail.db";
    public static String STUDENT_TABLE="StudentDetail";
    public static String ALUMNI_TABLE="AlumniDetail";
    public static String Name="Name";
    public static String CollegeName="CollegeName";
    public static String CollegeId="CollegeId";
    public static String EmailId="EmailId";
    public static String ContactNO="ContactNo";
    public static String BrancH="Branch";
    public static String PassworD="Password";
    public static String CompanyName="CompanyName";
    public static String WorkTechnology="WorkTechnology";


    public DataBaseConnectivity(Context context) {
        super(context,DETAIL_DATA , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+ STUDENT_TABLE +"(Name TEXT,CollegeName TEXT,CollegeId TEXT,EmailId TEXT,ContactNo TEXT,Branch TEXT,Password TEXT PRIMARY KEY)");
        db.execSQL("Create Table "+ ALUMNI_TABLE +"(Name TEXT,CollegeName TEXT,CompanyName TEXT,EmailId TEXT,ContactNo TEXT,WorkTechnology TEXT,Password TEXT PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }
    public boolean studentDataInsert(String name,String Collegename,String CollegeID,String EmailID,String ContactNo,String Branch,String Password)
    { db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(CollegeName,Collegename);
        contentValues.put(CollegeId,CollegeID);
        contentValues.put(EmailId,EmailID);
        contentValues.put(ContactNO,ContactNo);
        contentValues.put(BrancH,Branch);
        contentValues.put(PassworD,Password);
        long check=db.insert(STUDENT_TABLE,null,contentValues);
        if(check==-1)
        {
            return false;
        }
        else return true;

    }
    public boolean alumniDataInsert(String name,String Collegename,String companyName,String EmailID,String ContactNo,String workTechnology,String Password)
    {
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(CollegeName,Collegename);
        contentValues.put(CompanyName,companyName);
        contentValues.put(EmailId,EmailID);
        contentValues.put(ContactNO,ContactNo);
        contentValues.put(WorkTechnology,workTechnology);
        contentValues.put(PassworD,Password);
        long check=db.insert(ALUMNI_TABLE,null,contentValues);
        if(check==-1)
        {
            return false;
        }
        else return true;

    }
    public Cursor studentGetAuthorised(DataBaseConnectivity dob)
    {
        db=dob.getReadableDatabase();
        String[] colums={CollegeId,PassworD};
        Cursor Cr=db.query(STUDENT_TABLE,colums,null,null,null,null,null);
        return Cr;
    }
    public Cursor alumniGetAuthorised(DataBaseConnectivity dob)
    {
        db=dob.getReadableDatabase();
        String[] colums={EmailId,PassworD};
        Cursor Cr=db.query(STUDENT_TABLE,colums,null,null,null,null,null);
        return Cr;
    }
}