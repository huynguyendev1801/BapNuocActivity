package com.example.bapnuocactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bapnuocactivity.FoodFragment;

public class FoodAndDrinkActivity extends AppCompatActivity {

    TextView tvThucan, tvDouong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_drink);
        LoadFragment(new FoodFragment());
        tvThucan = findViewById(R.id.tvThucan);
        tvDouong = findViewById(R.id.tvDouong);

        tvThucan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new FoodFragment());
            }
        });
        tvDouong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new DrinkFragment());
            }
        });
    }

    void LoadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_food_drink_activity, fragment).commit();
    }
}