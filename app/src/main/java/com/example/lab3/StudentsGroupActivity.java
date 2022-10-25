package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class StudentsGroupActivity extends AppCompatActivity {

    public static final String GROUP_NUMBER = "groupnumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_group2);

        Intent intent = getIntent();
        String grpNumber = intent.getStringExtra(GROUP_NUMBER);
        StudentsGroup
                group = StudentsGroup.getGroup(grpNumber);

        EditText txtGrpNumber = (EditText) findViewById(R.id.grpNumberEdit);
        txtGrpNumber.setText(group.getNumber());

        EditText txtFacultyName = (EditText) findViewById(R.id.faculteEdit);
        txtFacultyName.setText(group.getFacultyName());

        TextView txtImgGrp = (TextView) findViewById(R.id.grpNumberImageTxt);
        txtImgGrp.setText(group.getNumber());

        TextView txtImgFaculty = (TextView) findViewById(R.id.faculteNameImageTxt);
        txtImgFaculty.setText(group.getFacultyName());

        if(group.getEducationLevel() == 0){
            ((RadioButton) findViewById(R.id.edu_level_bachelor)).setChecked(true);
        }
        else{
            ((RadioButton) findViewById(R.id.edu_level_master)).setChecked(true);
        }

        ((CheckBox) findViewById(R.id.contract_flg)).setChecked(
                group.isContractExistsFlg());
        ((CheckBox) findViewById(R.id.privilage_flg)).setChecked(
                group.isPrivilageExistsFlg());
    }


    public void onBtnClick(View view) {
        String outString = "Группа " + ((TextView) findViewById(R.id.grpNumberEdit)).getText() + "\n";
        outString += "Факультет " + ((TextView) findViewById(R.id.faculteEdit)).getText() + "\n";

        if(((RadioButton) findViewById(R.id.edu_level_master)).isChecked()){
            outString += "уровень образования - " + "магистр\n";
        }
        else{
            outString += "уровень образования - " + "бакалавр\n";
        }

        if(((CheckBox) findViewById(R.id.contract_flg)).isChecked()){
            outString += "контрактники есть\n";
        }
        else{
            outString += "контрактников нет\n";
        }

        if(((CheckBox) findViewById(R.id.privilage_flg)).isChecked()){
            outString += "льготники есть\n";
        }
        else{
            outString += "льготников нет\n";
        }

        Toast.makeText(this, outString, Toast.LENGTH_LONG).show();

    }
}