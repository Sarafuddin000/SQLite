package com.bitm.mad.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bitm.mad.sqlite.DBHelpers.EmployeeDBSource;
import com.bitm.mad.sqlite.pojo.Employee;

public class MainActivity extends AppCompatActivity {

    private EditText nameET, designationET, branchET, salaryET;
    private EmployeeDBSource source;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.emp_name);
        designationET = findViewById(R.id.emp_designation);
        branchET = findViewById(R.id.emp_branch);
        salaryET = findViewById(R.id.emp_salary);
        source = new EmployeeDBSource(this);

    }
    public  void saveEmployee(View view){
        String name = nameET.getText().toString();
        String designation = designationET.getText().toString();
        String branch = branchET.getText().toString();
        String salary = salaryET.getText().toString();

        /*if (name.isEmpty() || designation.isEmpty() || branch.isEmpty() || salary.isEmpty()){
            Toast.makeText(this, "Some fields may empty", Toast.LENGTH_SHORT).show();
            return;
        }*/

        boolean isValid = validate(nameET, designationET, branchET, salaryET);
        if (!isValid){
            Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show();
            return;
        }

        Employee e = new Employee(name, designation, branch, Double.parseDouble(salary));

        boolean isInserted = source.insertNewEmployee(e);
        if (isInserted){
            Toast.makeText(this, "Inserted Sucessfuly", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean validate(EditText... editTexts ){
        boolean b = true;

        for (EditText editText : editTexts){
            if (editText.getText().toString().isEmpty()){
                editText.setError("Required field");
                b = false;
            }
        }
        return b;
    }
}
