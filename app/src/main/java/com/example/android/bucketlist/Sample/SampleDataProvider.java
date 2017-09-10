package com.example.android.bucketlist.Sample;


import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
     public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static{
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();





    }

    private static void addItem(DataItem item){
        dataItemList.add(item);
        dataItemMap.put(item.getItemId(), item);
    }
}
