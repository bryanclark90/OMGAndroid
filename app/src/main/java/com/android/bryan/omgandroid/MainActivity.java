package com.android.bryan.omgandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {


    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdpater;
    ArrayList mNameList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Hey!");
        //access the button defined in layout XML
        //and listen here
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        //access the list
        mainListView = (ListView) findViewById(R.id.main_listview);
        //create an arrayAdapter for the ListView
        mArrayAdpater =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdpater);
        mainListView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
        mainTextView.setText(mainEditText.getText().toString()
                + " is learning Android development!");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdpater.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        // Log the item's position and contents
        // to the console in Debug
        Log.d("omg android", position + ": " + mNameList.get(position));
    }
}
