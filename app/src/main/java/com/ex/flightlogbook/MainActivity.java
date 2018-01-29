package com.ex.flightlogbook;

import java.util.ArrayList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
//    ArrayList<String> arrayList= new ArrayList<String>();
//    ArrayAdapter<String> adapter= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView logList = (ListView)findViewById(R.id.logListView);
        arrayList = new ArrayList<String>();

        // Adapter: You need three parameters 'the context, id of the layout (it will be where the data is shown),
        // and the array that contains the data
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);

        // Here, you set the data in your ListView
        logList.setAdapter(adapter);

        // Get log detail from LogEditeActivity
        Bundle logBundle = this.getIntent().getExtras();
        Log.i(TAG, "Intent Bundle");

        if(logBundle!=null) {
            String logDate = logBundle.getString("date");
            String logCompany = logBundle.getString("company");
            Log.d(TAG, "company is "+logCompany);

            if(!logCompany.isEmpty()) {
                arrayList.add(logCompany);
                adapter.notifyDataSetChanged();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.createbutton) {
            Intent logEditIntent = new Intent(this,LogEditActivity.class);
            startActivity(logEditIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
