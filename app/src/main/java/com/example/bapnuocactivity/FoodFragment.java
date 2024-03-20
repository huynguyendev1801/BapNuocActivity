package com.example.bapnuocactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bapnuocactivity.Moodle.Food;
import com.example.bapnuocactivity.Moodle.FoodAdapter;
import com.example.bapnuocactivity.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FoodFragment extends Fragment {
    RecyclerView rcv_food;
    DatabaseReference databaseReference;
    FoodAdapter foodAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        databaseReference = FirebaseDatabase.getInstance().getReference();

        View view =inflater.inflate(R.layout.fragment_food,container,false);

        DatabaseReference foodRef = databaseReference.child("bap");
        FirebaseRecyclerOptions<Food> options = new FirebaseRecyclerOptions.Builder<Food>()
                .setQuery(foodRef,Food.class)
                .build();

        foodAdapter = new FoodAdapter(options, getContext());
        rcv_food =view.findViewById(R.id.rcv_food);
        rcv_food.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_food.setAdapter(foodAdapter);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        foodAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        foodAdapter.stopListening();
    }
}