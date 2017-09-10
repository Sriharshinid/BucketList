package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class NameFilter extends AppCompatActivity {
    DataSource ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_filter);
        ds = new DataSource(this);
    }


    public void onSearch(View view){
        EditText substrField = (EditText) findViewById(R.id.searchKeyWord);
        String substr = (substrField.getText().toString()).toLowerCase();
        List<DataItem> queriedList = new ArrayList<>();

        List<DataItem> allItems = ds.getAllItems();

        for (DataItem item:allItems) {
            if((item.getItemName().toLowerCase()).contains(substr)){
                queriedList.add(item);
            }
        }

        Intent intent = new Intent(this, completedList.class);
        intent.putExtra("Source", "filter");
        intent.putExtra("list", (ArrayList<DataItem>)queriedList);
        startActivity(intent);

    }
}
