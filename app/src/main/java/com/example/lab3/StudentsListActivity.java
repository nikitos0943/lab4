package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class StudentsListActivity extends AppCompatActivity {

    public static final String GROUP_NUMBER = "groupnumber";
    private float textSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);


       String txtStudents = "";
        for(Student s: Student.getStudents(grpNumber)){
            txtStudents +=s.getName() + "\n";
        }
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtStudents);

        textSize = textView.getTextSize();
        if(savedInstanceState !=null){
            textSize = savedInstanceState.getFloat("testSize");
        }
    }

    public void onPlusBtnClick(View view){
        textSize = textSize * 1.1f;
        TextView textView = findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    public void onSendBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Список студентов");
        startActivity(intent);
    }

    protected void onSaveInstantState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putFloat("textSize", textSize);
    }

}