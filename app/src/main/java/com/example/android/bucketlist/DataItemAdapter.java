package com.example.android.bucketlist;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bucketlist.database.DBHelper;
import com.example.android.bucketlist.model.DataItem;

import java.util.List;

import static java.lang.Integer.valueOf;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY ="item_id_key" ;
    public static final String ITEM_KEY = "item_key";
    private List<DataItem> mItems;
    private Context mContext;
    DBHelper mDBhelper;

    public DataItemAdapter(Context context, List<DataItem> items) {
        this.mContext = context;
        this.mItems = items;
        mDBhelper = new DBHelper(mContext);
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
        final DataItem item = mItems.get(position);
        holder.tvName.setText(item.getItemName());
        holder.tvPri.setText("Priority: " + String.valueOf(item.getPriority()));
        if(item.getCost() == -1){
            holder.tvCost.setText("Cost: N/A " );
        }else{
            holder.tvCost.setText("Cost: " + String.valueOf(item.getCost()));
        }

        int _dur = valueOf(item.getTime());

        holder.tvTime.setText("Time: " + futureList.TIME_DISPLAY[_dur]);
        holder.tvName.setContentDescription(item.getItemId());
        Boolean done;
        if(item.getDone() == 0){
            done = false;
        }else{
            done = true;
        }
        holder.tvName.setChecked(done);

        holder.tvName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CheckBox check = (CheckBox) v;
                String itemID = check.getContentDescription().toString();
                if(item.getDone() == 0){
                    mDBhelper.changeChecked(itemID, 1, 0);
                }else{
                    mDBhelper.changeChecked(itemID, 0, 1);
                }
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "You selected " + item.getItemName(), Toast.LENGTH_SHORT).show();
//                String itemID = item.getItemId();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(ITEM_KEY, item);
                mContext.startActivity(intent);
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Toast.makeText(mContext, "You long clicked " + item.getItemName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public CheckBox tvName;
        public TextView tvPri;
        public TextView tvCost;
        public TextView tvTime;
        public CheckBox check;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (CheckBox) itemView.findViewById(R.id.ActNameCheck);
            tvPri = (TextView) itemView.findViewById(R.id.category);
            tvCost = (TextView) itemView.findViewById(R.id.Cost);
            tvTime = (TextView) itemView.findViewById(R.id.Time);
            mView = itemView;


        }
    }
}
