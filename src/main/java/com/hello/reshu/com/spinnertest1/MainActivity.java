package com.hello.reshu.com.spinnertest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Student{
    String name,address,college;
    int phoneNo;

    Student(int phoneNo,String name,String address,String college)
    {
        this.name=name;
        this.address=address;
        this.college=college;
        this.phoneNo=phoneNo;
    }
}

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    String collegeName = "";
    ArrayList<Student> stu=new ArrayList<Student>();

    String collegeNames[]={"Select college name","DIT","Graphic Era","HNB"};

    TextView textview_name,display_data,studentDisplay;
    EditText edittext_name,studentName,studentPhoneNumber,studentAddress,studentCollege;
    Button button_displayresult,displaybtn,addbtn;
    Spinner spinnerCollegeNames;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName=(EditText) findViewById(R.id.edittext_name);
        studentPhoneNumber=(EditText) findViewById(R.id.edittext_phone);
        studentAddress=(EditText) findViewById(R.id.edittext_address);

        studentDisplay=(TextView) findViewById(R.id.display_data);

        spinnerCollegeNames = findViewById(R.id.college_name_spinner);
//        String collegeNames[] = {"Select college name","DIT", "Graphic Era", "HNB"};


       /* studentNameDisplay=(TextView) findViewById(R.id.display_name);
        studentCourseDisplay=(TextView) findViewById(R.id.display_course);
        studentFeeDisplay=(TextView) findViewById(R.id.display_fee);*/


        addbtn=(Button) findViewById(R.id.btn_add);
        displaybtn=(Button) findViewById(R.id.button_displayresult);




        spinnerCollegeNames.setOnItemSelectedListener(this);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, collegeNames);


        spinnerCollegeNames.setAdapter(arrayAdapter);

        spinnerCollegeNames.setPrompt(collegeNames[0]);

        spinnerCollegeNames.setOnItemSelectedListener(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = String.valueOf(studentName.getText());
                try {
                    int phoneNo = Integer.parseInt(studentPhoneNumber.getText().toString());
                    String address=String.valueOf(studentAddress.getText());
                    String collegeName=spinnerCollegeNames.getSelectedItem().toString();
                    stu.add(new Student(phoneNo,name,address,collegeName));


                    Toast.makeText(getApplicationContext(), "Your data has been Submitted", Toast.LENGTH_LONG).show();

                }

                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Enter valid phone number", Toast.LENGTH_LONG).show();
                }

            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<stu.size();i++){
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).name);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).phoneNo);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).address);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +stu.get(i).college);
                    studentDisplay.setText(studentDisplay.getText() + "\n" +"**********");
                }

            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        collegeName = collegeNames[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


