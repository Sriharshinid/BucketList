package com.example.android.bucketlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class filter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        //Cost filter
            //less than a certain amount
        //time filter
            //have to choose a specific time
        //priority filter
            //a certain amount or higher
        //tags filter
            //can select multiple filters
            //show all that fit atleast one of the filters? (Or show only ones that have all tags?)

    }

    public void nameFilter(View view){
        Intent intent = new Intent(this, NameFilter.class);
        startActivity(intent);
    }

    public void costFilter(View view){
        Intent intent = new Intent(this, CostFilter.class);
        startActivity(intent);
    }

    public void timeFilter(View view){
        Intent intent = new Intent(this, TimeFilter.class);
        startActivity(intent);
    }

    public void priorityFilter(View view){
        Intent intent = new Intent(this, PriorityFilter.class);
        startActivity(intent);
    }

    public void tagsFilter(View view){
        Intent intent = new Intent(this, TagsFilter.class);
        startActivity(intent);

    }



}
