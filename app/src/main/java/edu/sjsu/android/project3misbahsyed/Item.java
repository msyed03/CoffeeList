package edu.sjsu.android.project3misbahsyed;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable{
    private int imageID;
    private int nameID;
    private int desID; //Description ID

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Item(int imageID, int nameID, int desID) {
        this.imageID = imageID;
        this.nameID = nameID;
        this.desID = desID;
    }

    public Item(Parcel in) {
    }

    public int getDesID() {
        return desID;
    }

    public int getImageID() {
        return imageID;
    }

    public int getNameID() {
        return nameID;
    }

    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i){
        parcel.writeInt(imageID);
        parcel.writeInt(nameID);
        parcel.writeInt(desID);
    }
}
