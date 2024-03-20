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

public class FoodAdapter extends FirebaseRecyclerAdapter<Food, FoodAdapter.FoodViewHolder> {
    Context mcontext;
    public FoodAdapter(@NonNull FirebaseRecyclerOptions<Food> options , Context context) {
        super(options);
        mcontext= context;

    }

    @Override
    protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
        holder.classification.setText(model.getViBap());
        holder.Price.setText(String.valueOf(model.getGiaTien()));

        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontext, Test.class);
                i.putExtra("price",String.valueOf(model.getGiaTien()));
                mcontext.startActivity(i);
            }
        });
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bap,parent,false);
        return new FoodViewHolder(view);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTicket;
        TextView classification,Price;
        Button btnBuy;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTicket = itemView.findViewById(R.id.imgTicket);
            classification= itemView.findViewById(R.id.classification);
            Price= itemView.findViewById(R.id.Price);
            btnBuy=itemView.findViewById(R.id.btnBuy);
        }
    }
}
