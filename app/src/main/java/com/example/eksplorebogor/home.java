package com.example.eksplorebogor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class home extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn_alam, btn_bahari, btn_buatan, btn_budaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_alam = findViewById(R.id.gambaralam);
        btn_alam.setOnClickListener(this);

        btn_bahari = findViewById(R.id.gambarbahari);
        btn_bahari.setOnClickListener(this);

        btn_buatan = findViewById(R.id.gambarbuatan);
        btn_buatan.setOnClickListener(this);

        btn_budaya = findViewById(R.id.gambarbudaya);
        btn_budaya.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gambaralam:

                Toast.makeText(this, "Wisata Alam", Toast.LENGTH_SHORT).show();
                Intent intentAlam = new Intent(this, wisata_alam.class);
                intentAlam.putExtra("KEY_TITLE", "Wisata Alam");
                startActivity(intentAlam);
                break;

            case R.id.gambarbahari:
                Toast.makeText(this, "Wisata Bahari", Toast.LENGTH_SHORT).show();
                Intent intentBahari = new Intent(this, wisata_bahari.class);
                intentBahari.putExtra("KEY_TITLE", "Wisata Bahari");
                startActivity(intentBahari);
                break;

            case R.id.gambarbuatan:
                Toast.makeText(this, "Wisata Buatan", Toast.LENGTH_SHORT).show();
                Intent intentBuatan = new Intent(this, wisata_buatan.class);
                intentBuatan.putExtra("KEY_TITLE", "Wisata Buatan");
                startActivity(intentBuatan);
                break;

            case R.id.gambarbudaya:
                Toast.makeText(this, "Wisata Budaya", Toast.LENGTH_SHORT).show();
                Intent intentBudaya = new Intent(this, wisata_budaya.class);
                intentBudaya.putExtra("KEY_TITLE", "Wisata Budaya");
                startActivity(intentBudaya);
                break;
        }
    }
}
