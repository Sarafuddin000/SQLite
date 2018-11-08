package com.bitm.mad.sqlite.DBHelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "basic_info";
    public static final String DB_COL_ID = "id";
    public static final String DB_COL_NAME = "name";
    public static final String DB_COL_designation = "designation";
    public static final String DB_COL_BRANCH = "branch";
    public static final String DB_COL_SALARY = "salary";

    public static final String TABLE_INSERTING_QUERY = "CREATE TABLE " + TABLE_NAME
            + " ("+ DB_COL_ID+" INTEGER PRIMARY KEY, "
            +DB_COL_NAME+" TEXT, "
            +DB_COL_designation+" TEXT, "
            +DB_COL_BRANCH+" TEXT, "
            +DB_COL_SALARY+" REAL);";


    public EmployeeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_INSERTING_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
