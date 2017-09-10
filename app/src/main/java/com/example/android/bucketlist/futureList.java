package com.example.android.bucketlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.bucketlist.database.DBHelper;
import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

public class futureList extends AppCompatActivity {
    Context mContext;
    DataSource ds;
    public static final String[] TIME_OPTIONS = {"Choose a duration", "Minutes", "Hours", "Days", "A week", "Weeks", "Months", "Years"};
    public static final String[] TIME_DISPLAY = {"N/A", "Minutes", "Hours", "Days", "A week", "Weeks", "Months", "Years"};
    public static final String[] TAG_STRINGS = {"Personal Growth", "Food/Drink", "Travel", "Entertainment", "Events", "Career", "Relationship", "Family", "Charity", "Health/Fitness", "Creative", "Sports" };
    public static final String ITEM_KEY = "item_key";
    int[] tags = new int[12];
    DBHelper db;
    boolean updated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext =this;
        updated= false;
        db = new DBHelper(mContext);
        ds = new DataSource(mContext);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ActName = (EditText) findViewById(R.id.editText);
                String _activity = ActName.getText().toString();
                EditText Cost = (EditText) findViewById(R.id.Cost);
                String cost = Cost.getText().toString();
                int _cost;
                if(cost.equals("")){
                    _cost = -1;
                }else{
                    _cost = Integer.parseInt(cost);
                }

                CheckBox[] _tagBox = {(CheckBox)findViewById(R.id.checkBox0), (CheckBox)findViewById(R.id.checkBox1), (CheckBox)findViewById(R.id.checkBox2), (CheckBox)findViewById(R.id.checkBox3),
                        (CheckBox)findViewById(R.id.checkBox4), (CheckBox)findViewById(R.id.checkBox5), (CheckBox)findViewById(R.id.checkBox6), (CheckBox)findViewById(R.id.checkBox7),
                        (CheckBox)findViewById(R.id.checkBox8), (CheckBox)findViewById(R.id.checkBox9), (CheckBox)findViewById(R.id.checkBox10), (CheckBox)findViewById(R.id.checkBox11)};
                DataItem oldItem = getIntent().getExtras().getParcelable(ITEM_KEY);
                RatingBar priority = (RatingBar) findViewById(R.id.ratingBar);
                float _priority = priority.getRating();
                EditText descrip = (EditText) findViewById(R.id.editText3);
                String _description = descrip.getText().toString();
                Spinner duration = (Spinner) findViewById(R.id.spinner);
                String _time = duration.getSelectedItem().toString();
                int _duration = 0;

                for (int i = 0; i < 12; i++){
                    if(_tagBox[i].isChecked()){
                        tags[i] = 1;
                    }
                    else{
                        tags[i] = 0;
                    }
//                      Toast.makeText(mContext, String.valueOf(tags[i]), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(mContext, "whhat", Toast.LENGTH_SHORT).show();
                }



                //NEED TO GET TAGS!
                for(int i = 0; i < TIME_OPTIONS.length; i++){
                    if(TIME_OPTIONS[i].equals(_time)){
                        _duration = i;
                        break;
                    }
                }

                DataItem item = new DataItem(null, _activity, _description, _priority, _cost,tags, _duration);

                Toast.makeText(futureList.this, "Duration: " + tags[0] + " description: "+ tags[1] + "Rating: " +_priority,
                        Toast.LENGTH_SHORT).show();     //Change toast later!
                ds.open();
                ds.createItem(item);
                if(oldItem.getItemId() != null){
                    db.delete(oldItem.getItemId());
                }
                Intent intent = new Intent(mContext, completedList.class);
                intent.putExtra("Source", "futureList");
                startActivity(intent);

            }
        });

        DataItem oldItem = getIntent().getExtras().getParcelable(ITEM_KEY);
        if(oldItem.getItemId() != null){
            updateAct(oldItem);
        }

    }

    public void updateAct(DataItem item){
       CheckBox[] _tagBox = {(CheckBox)findViewById(R.id.checkBox0), (CheckBox)findViewById(R.id.checkBox1), (CheckBox)findViewById(R.id.checkBox2), (CheckBox)findViewById(R.id.checkBox3),
         (CheckBox)findViewById(R.id.checkBox4), (CheckBox)findViewById(R.id.checkBox5), (CheckBox)findViewById(R.id.checkBox6), (CheckBox)findViewById(R.id.checkBox7),
              (CheckBox)findViewById(R.id.checkBox8), (CheckBox)findViewById(R.id.checkBox9), (CheckBox)findViewById(R.id.checkBox10), (CheckBox)findViewById(R.id.checkBox11)};
        EditText _Name = (EditText) findViewById(R.id.editText);
        _Name.setText(item.getItemName());
        EditText _Cost = (EditText) findViewById(R.id.Cost);
        if(item.getCost() != -1) {
            _Cost.setText(String.valueOf(item.getCost()));
        }

        RatingBar _Priority = (RatingBar) findViewById(R.id.ratingBar);
        _Priority.setRating((float)item.getPriority());
        Spinner duration = (Spinner) findViewById(R.id.spinner);
        duration.setSelection(item.getTime());
        EditText _Description = (EditText) findViewById(R.id.editText3);
        _Description.setText(item.getDescription());

        int[] allTags = item.getAllTags();
        for(int i = 0; i < allTags.length; i++) {
            if (allTags[i] == 1) {
                _tagBox[i].setChecked(true);
            }
        }

        updated = true;

    }

}
