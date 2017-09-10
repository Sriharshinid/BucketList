package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bucketlist.database.DBHelper;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.bucketlist.futureList.TIME_DISPLAY;

public class DetailActivity extends AppCompatActivity {

    DBHelper dbHelper;
    DataItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        dbHelper = new DBHelper(this);
//        String itemId = getIntent().getExtras().getString(DataItemAdapter.ITEM_ID_KEY);
//        DataItem item = SampleDataProvider.dataItemMap.get(itemId);
//        Intent intent = new Intent(this, completedList.class);  //// FIXME: 9/2/2017
//        intent.putExtra("Source", "from DetailActivity");

        item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        if(item != null){
            int[] tagsArray = new int[12];;
            tagsArray[0] = item.getpGrowth();
            tagsArray[1] = item.getFoodDrink();
            tagsArray[2] = item.getTravel();
            tagsArray[3] = item.getEntertainment();
            tagsArray[4] = item.getEvents();
            tagsArray[5] = item.getCareer();
            tagsArray[6] = item.getRelationship();
            tagsArray[7] = item.getFamily();
            tagsArray[8] = item.getCharity();
            tagsArray[9] = item.getHealthFitness();
            tagsArray[10] = item.getCreative();
            tagsArray[11] = item.getSports();
            int numTags = 0;
            List<String> selectedTags = new ArrayList<>();
            for(int i = 0; i < tagsArray.length; i++){
                if(tagsArray[i] == 1) {
                    selectedTags.add(futureList.TAG_STRINGS[i]);
                    numTags++;
                }
            }

            String name = item.getItemName();
            String cost = "Cost: $" + String.valueOf(item.getCost());
            if(item.getCost() < 0){
                cost = "Cost: N/A";
            }
            String time = "Duration: " + TIME_DISPLAY[item.getTime()];
            String _description = "Description: " + item.getDescription();
            float priority = (float) item.getPriority();
            String tags = "Tags: ";


            for(int i = 0; i < selectedTags.size(); i++){
                if(i == selectedTags.size()-1){
                    tags = tags + selectedTags.get(i);
                } else{
                    tags = tags + selectedTags.get(i) + ", ";
                }
            }


            TextView act_name = (TextView) findViewById(R.id.activityName);
            act_name.setText(name);

            RatingBar _priority = (RatingBar) findViewById(R.id.priorityLevel);
            _priority.setRating(priority);

            TextView cost_text = (TextView) findViewById(R.id.costText);
            cost_text.setText(cost);

            TextView duration_text = (TextView) findViewById(R.id.durationDisp);
            duration_text.setText(time);

            TextView tags_text = (TextView) findViewById(R.id.tagsDisp);
            tags_text.setText(tags);

            TextView descrip_text = (TextView) findViewById(R.id.descriptionDisp);
            descrip_text.setText(_description);



        }else{
            Toast.makeText(this, "Didn't receive any data. ", Toast.LENGTH_SHORT).show();
        }

    }

    public void onDelete(View view){
        String name = item.getItemName();
        dbHelper.delete(item.getItemId());
        Toast.makeText(this, name + " has been deleted!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, completedList.class);
        intent.putExtra("Source", "from DetailActivity");
        startActivity(intent);
    }

    public void onUpdate(View view){
        Intent intent = new Intent(this, futureList.class);
        intent.putExtra(futureList.ITEM_KEY, item);
        startActivity(intent);
    }


}
