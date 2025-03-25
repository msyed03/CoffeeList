package edu.sjsu.android.project3misbahsyed;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class ListFragment extends Fragment {

    private ArrayList<Item> items;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<>();
        items.add(new Item(R.drawable.image1, R.string.name_1, R.string.des_1));
        items.add(new Item(R.drawable.image2, R.string.name_2, R.string.des_2));
        items.add(new Item(R.drawable.image3, R.string.name_3, R.string.des_3));
        items.add(new Item(R.drawable.image4, R.string.name_4, R.string.des_4));
        items.add(new Item(R.drawable.image5, R.string.name_5, R.string.des_5));
        items.add(new Item(R.drawable.image6, R.string.name_6, R.string.des_6));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // Set layout manager
            recyclerView.setAdapter(new MyAdapter(items, this::onClick)); //CHECK WHAT IS HERE
        }
        return view;
    }

    public void onClick(int position){
        if(position == items.size() - 1){
            showDialog(position);
        }
        else goDetail(position);
    }

    public void goDetail(int position){
        //Implement Mar. 11
        //Toast.makeText(requireContext(), items.get(position).getImageID(), Toast.LENGTH_SHORT).show(); //temporary thing
        Item item = items.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.my_key), item);
        NavController controller = NavHostFragment.findNavController(this);
        controller.navigate(R.id.list_to_detail, bundle);

    }

    public void showDialog(int position){
        //lecture 10 page 18
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(R.string.warning_title);
        builder.setMessage(R.string.warning_msg);
        builder.setPositiveButton(R.string.pos_button, (dialog, id) -> goDetail(position));  // When user selects yes
        builder.setNegativeButton(R.string.neg_button, (dialog, id) -> {});  // When user selects no
        builder.create().show();
    }
}