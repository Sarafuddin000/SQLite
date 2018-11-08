package com.bitm.mad.sqlite.DBHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bitm.mad.sqlite.pojo.Employee;

public class EmployeeDBSource {

    private EmployeeDBHelper helper;
    private SQLiteDatabase database;

    public EmployeeDBSource(Context context){
        helper = new EmployeeDBHelper(context);
    }

    public void open(){
        database = helper.getWritableDatabase();
    }
    public void close(){
        database.close();
    }

    public boolean insertNewEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDBHelper.DB_COL_NAME, employee.getName());
        values.put(EmployeeDBHelper.DB_COL_designation, employee.getDesignation());
        values.put(EmployeeDBHelper.DB_COL_BRANCH, employee.getBranch());
        values.put(EmployeeDBHelper.DB_COL_SALARY, employee.getSalary());
        long insertedRow = database.insert(EmployeeDBHelper.TABLE_NAME, null, values);

        this.close();
        if (insertedRow > 0){
            return true;
        }
        return false;
    }

}
