package com.example.bapnuocactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bapnuocactivity.Moodle.Drink;
import com.example.bapnuocactivity.Moodle.DrinkAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DrinkFragment extends Fragment {

    RecyclerView rcv_drink;
    DatabaseReference databaseReference;
    DrinkAdapter drinkAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        databaseReference = FirebaseDatabase.getInstance().getReference();

        View view =inflater.inflate(R.layout.fragment_drink,container,false);

        DatabaseReference drinkRef = databaseReference.child("nuoc");
        FirebaseRecyclerOptions<Drink> options = new FirebaseRecyclerOptions.Builder<Drink>()
                .setQuery(drinkRef,Drink.class)
                .build();

        drinkAdapter = new DrinkAdapter(options, getContext());
        rcv_drink =view.findViewById(R.id.rcv_nuoc);
        rcv_drink.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_drink.setAdapter(drinkAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        drinkAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        drinkAdapter.stopListening();
    }
}