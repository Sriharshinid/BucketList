package com.example.android.bucketlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class TagsFilter extends Activity {
    DataSource ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags_filter);
        ds = new DataSource(this);
    }
    
    public void onSearchTags(View view){
        List<DataItem> items = ds.getAllItems();
        List<DataItem> queriedList = new ArrayList<>();
        CheckBox[] _tagBox = {(CheckBox)findViewById(R.id.CheckBox0), (CheckBox)findViewById(R.id.CheckBox1), (CheckBox)findViewById(R.id.CheckBox2), (CheckBox)findViewById(R.id.CheckBox3),
                (CheckBox)findViewById(R.id.CheckBox4), (CheckBox)findViewById(R.id.CheckBox5), (CheckBox)findViewById(R.id.CheckBox6), (CheckBox)findViewById(R.id.CheckBox7),
                (CheckBox)findViewById(R.id.CheckBox8), (CheckBox)findViewById(R.id.CheckBox9), (CheckBox)findViewById(R.id.CheckBox10), (CheckBox)findViewById(R.id.CheckBox11)};
        List<Integer> posTagIndices = new ArrayList<>();

        for(int i = 0; i < _tagBox.length; i++){
            if(_tagBox[i].isChecked())
                posTagIndices.add(i);
        }

        if(posTagIndices.size() == 0){
            queriedList = items;
        }else {

            for (DataItem item : items) {
                int[] allTags = item.getAllTags();
                for (int i = 0; i < posTagIndices.size(); i++) {
                    if (allTags[posTagIndices.get(i)] != 1) {
                        break;
                    }
                    if (i == posTagIndices.size() - 1) {
                        queriedList.add(item);
                    }
                }

            }
        }

        Intent intent = new Intent(this, completedList.class);
        intent.putExtra("Source", "filter");
        intent.putExtra("list", (ArrayList<DataItem>) queriedList);
        startActivity(intent);

    }
    
    
}
