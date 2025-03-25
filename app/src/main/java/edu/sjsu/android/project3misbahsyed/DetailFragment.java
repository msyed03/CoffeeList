package edu.sjsu.android.project3misbahsyed;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DetailFragment extends Fragment {
    private Item selectedItem;

    public DetailFragment(){
        //Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            selectedItem = getArguments().getParcelable(getString(R.string.my_key));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ((ImageView) view.findViewById(R.id.image1)).setImageResource(selectedItem.getImageID());
        ((TextView) view.findViewById(R.id.detail_name1)).setText(selectedItem.getNameID());
        ((TextView) view.findViewById(R.id.detail1)).setText(selectedItem.getDesID());
    }
}
