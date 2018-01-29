package com.ex.flightlogbook;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by anita_lin on 2018/1/16.
 */

public class LogEditActivity extends AppCompatActivity {

    final String TAG = "LogEditActivity";
    EditText textCompany, textDate;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logedit);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        textCompany = (EditText) findViewById(R.id.inputFlight);
        textDate = (EditText) findViewById(R.id.inputDate);

        dbHelper = new DatabaseHelper(this, "flightlogbook.db", null, 1);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textCompany.getText().toString().isEmpty()|| textDate.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                }else{
                    saveLog(v);
                }
            }
        });
    }

    public void saveLog(View view){
        String date = textDate.getText().toString();
        String company = textCompany.getText().toString();
        Log.i(TAG, "company : " + company);

        // Save to sqlitedb
        ContentValues values = new ContentValues();
        values.put("date", date);
        values.put("company", company);
        long newRowId = dbHelper.getWritableDatabase().insert("logbook", null, values);

        Intent mainIntent = new Intent(this,MainActivity.class);
        //mainIntent.setClass(LogEditActivity.this, MainActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("date", date);
        bundle.putString("company", company);
        mainIntent.putExtras(bundle);

        startActivity(mainIntent);
    }

}
