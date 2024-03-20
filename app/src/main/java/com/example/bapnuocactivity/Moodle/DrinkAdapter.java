package com.example.bapnuocactivity.Moodle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bapnuocactivity.R;
import com.example.bapnuocactivity.Test;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DrinkAdapter extends FirebaseRecyclerAdapter<Drink, DrinkAdapter.DrinkViewHolder> {
Context mcontext;

    public DrinkAdapter(@NonNull FirebaseRecyclerOptions<Drink> options, Context context) {
        super(options);
        mcontext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull DrinkViewHolder holder, int position, @NonNull Drink model) {
        holder.classification.setText(model.getTenNuoc());
        holder.Price.setText(String.valueOf(model.getGiaTien()));

        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, Test.class);
                i.putExtra("price", String.valueOf(model.getGiaTien()));
                mcontext.startActivity(i);
            }
        });
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nuoc,parent,false);
        return new DrinkViewHolder(view);
    }

    public class DrinkViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTicket;
        TextView classification,Price;
        Button btnBuy;

        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTicket = itemView.findViewById(R.id.imgTicket);
            classification= itemView.findViewById(R.id.classification);
            Price= itemView.findViewById(R.id.Price);
            btnBuy=itemView.findViewById(R.id.btnBuy);
        }
    }

}
