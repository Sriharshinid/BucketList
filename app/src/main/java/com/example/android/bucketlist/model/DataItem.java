package com.example.android.bucketlist.model;


import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.bucketlist.database.ItemsTable;

import java.util.UUID;

public class DataItem implements Parcelable {

    private String itemId;
    private String itemName;
    private String description;
    private double priority;
    private int cost;
    private int pGrowth;
    private int foodDrink;
    private int travel;
    private int entertainment;
    private int events;
    private int career;
    private int relationship;
    private int family;
    private int charity;
    private int healthFitness;
    private int creative;
    private int sports;
    private int time;
    private int done;

    public DataItem(){
    }

    public DataItem(String itemId, String itemName, String description, double priority, int cost, int[] tag, int time) {
        if(itemId == null){
            itemId = UUID.randomUUID().toString();
        }

        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.priority = priority;
        this.cost = cost;
        this.time = time;
        this.done = 0;
        this.pGrowth = tag[0];
        this.foodDrink = tag[1];
        this.travel = tag[2];
        this.entertainment = tag[3];
        this.events = tag[4];
        this.career = tag[5];
        this.relationship = tag[6];
        this.family = tag[7];
        this.charity = tag[8];
        this.healthFitness = tag[9];
        this.creative = tag[10];
        this.sports = tag[11];
    }




    public int getpGrowth() {
        return pGrowth;
    }

    public void setpGrowth(int pGrowth) {
        this.pGrowth = pGrowth;
    }

    public int getFoodDrink() {
        return foodDrink;
    }

    public void setFoodDrink(int foodDrink) {
        this.foodDrink = foodDrink;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }

    public int getEvents() {
        return events;
    }

    public void setEvents(int events) {
        this.events = events;
    }

    public int getCareer() {
        return career;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getCharity() {
        return charity;
    }

    public void setCharity(int charity) {
        this.charity = charity;
    }

    public int getHealthFitness() {
        return healthFitness;
    }

    public void setHealthFitness(int healthFitness) {
        this.healthFitness = healthFitness;
    }

    public int getCreative() {
        return creative;
    }

    public void setCreative(int creative) {
        this.creative = creative;
    }

    public int getSports() {
        return sports;
    }

    public void setSports(int sports) {
        this.sports = sports;
    }

    public int[] getAllTags() {
        int[] Tarray = new int[12];
        Tarray[0] = pGrowth;
        Tarray[1] = foodDrink;
        Tarray[2] = travel;
        Tarray[3] = entertainment;
        Tarray[4] = events;
        Tarray[5] = career;
        Tarray[6] = relationship;
        Tarray[7] = family;
        Tarray[8] = charity;
        Tarray[9] = healthFitness;
        Tarray[10] = creative;
        Tarray[11] = sports;
        return Tarray;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDone(int done){
        this.done = done;
    }
    public int getDone(){return done;}



    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", cost=" + cost +
                ", pGrowth=" + pGrowth +
                ", foodDrink=" + foodDrink +
                ", travel=" + travel +
                ", entertainment=" + entertainment +
                ", events=" + events +
                ", career=" + career +
                ", relationship=" + relationship +
                ", family=" + family +
                ", charity=" + charity +
                ", healthFitness=" + healthFitness +
                ", creative=" + creative +
                ", sports=" + sports +
                ", time=" + time +
                ", done=" + done +
                '}';
    }
    public ContentValues toValues(){
        ContentValues values = new ContentValues(8);
        values.put(ItemsTable.COLUMN_ID, itemId);
        values.put(ItemsTable.COLUMN_NAME, itemName);
        values.put(ItemsTable.COLUMN_DESCRIPTION, description);
        values.put(ItemsTable.COLUMN_PRIORITY, priority);
        values.put(ItemsTable.COLUMN_PGROWTH, pGrowth);
        values.put(ItemsTable.COLUMN_FOOD, foodDrink);
        values.put(ItemsTable.COLUMN_TRAVEL, travel);
        values.put(ItemsTable.COLUMN_ENTERTAINMENT, entertainment);
        values.put(ItemsTable.COLUMN_EVENTS, events);
        values.put(ItemsTable.COLUMN_CAREER, career);
        values.put(ItemsTable.COLUMN_RELATIONSHIP, relationship);
        values.put(ItemsTable.COLUMN_FAMILY, family);
        values.put(ItemsTable.COLUMN_CHARITY, charity);
        values.put(ItemsTable.COLUMN_HEALTH, healthFitness);
        values.put(ItemsTable.COLUMN_CREATIVE, creative);
        values.put(ItemsTable.COLUMN_SPORTS, sports);
        //values.put(ItemsTable.COLUMN_TAGS, tags);
        values.put(ItemsTable.COLUMN_COST, cost);
        values.put(ItemsTable.COLUMN_TIME, time);
        values.put(ItemsTable.COLUMN_DONE, done);
        return values;
    }

    protected DataItem(Parcel in) {
        itemId = in.readString();
        itemName = in.readString();
        description = in.readString();
        priority = in.readDouble();
        cost = in.readInt();
        pGrowth = in.readInt();
        foodDrink = in.readInt();
        travel = in.readInt();
        entertainment = in.readInt();
        events = in.readInt();
        career = in.readInt();
        relationship = in.readInt();
        family = in.readInt();
        charity = in.readInt();
        healthFitness = in.readInt();
        creative = in.readInt();
        sports = in.readInt();
        time = in.readInt();
        done = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(itemName);
        dest.writeString(description);
        dest.writeDouble(priority);
        dest.writeInt(cost);
        dest.writeInt(pGrowth);
        dest.writeInt(foodDrink);
        dest.writeInt(travel);
        dest.writeInt(entertainment);
        dest.writeInt(events);
        dest.writeInt(career);
        dest.writeInt(relationship);
        dest.writeInt(family);
        dest.writeInt(charity);
        dest.writeInt(healthFitness);
        dest.writeInt(creative);
        dest.writeInt(sports);
        dest.writeInt(time);
        dest.writeInt(done);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };


}
