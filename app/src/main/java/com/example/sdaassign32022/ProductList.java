package com.example.sdaassign32022;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/*
 * A simple {@link Fragment} subclass.
 * @author Chris Coughlan 2019
 */
public class ProductList extends Fragment implements Tab, FlavorViewAdapter.ItemClickListener {

    private static final String TAG = "RecyclerViewActivity";
    private static final String title = "Product List";
    private ArrayList<FlavorAdapter> mFlavors = new ArrayList<>();
    private Toast mToast;

    public ProductList() {
        // Required empty public constructor
        super();
    }
    public String getTitle() { return title; }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_product_list, container, false);
        // Create an ArrayList of AndroidFlavor objects
        mFlavors.add(new FlavorAdapter("Donut", "1.6", R.drawable.donut));
        mFlavors.add(new FlavorAdapter("Eclair", "2.0-2.1", R.drawable.eclair));
        mFlavors.add(new FlavorAdapter("Froyo", "2.2-2.2.3", R.drawable.froyo));
        mFlavors.add(new FlavorAdapter("GingerBread", "2.3-2.3.7", R.drawable.gingerbread));
        mFlavors.add(new FlavorAdapter("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb));
        mFlavors.add(new FlavorAdapter("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream));
        mFlavors.add(new FlavorAdapter("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean));
        mFlavors.add(new FlavorAdapter("KitKat", "4.4-4.4.4", R.drawable.kitkat));
        mFlavors.add(new FlavorAdapter("Lollipop", "5.0-5.1.1", R.drawable.lollipop));
        mFlavors.add(new FlavorAdapter("Marshmallow", "6.0-6.0.1", R.drawable.marshmallow));

        //start it with the view
        Log.d(TAG, "Starting recycler view");
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_view);
        FlavorViewAdapter recyclerViewAdapter = new FlavorViewAdapter(getContext(), mFlavors);
        recyclerViewAdapter.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        // Handle item click here
        FlavorAdapter clickedFlavor = mFlavors.get(position);
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(view.getContext(), "Clicked on item " + clickedFlavor.getVersionName(), Toast.LENGTH_SHORT);
        mToast.show();
    }
}
