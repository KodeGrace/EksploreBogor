package com.example.eksplorebogor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import com.example.eksplorebogor.adapter.ListWisAlamAdapter;
import com.example.eksplorebogor.model.wisAlam;

import java.util.ArrayList;

public class wisata_alam extends AppCompatActivity {
    private RecyclerView rvAlam;
    private final ArrayList<wisAlam> listAlam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_alam);

        String title = getIntent().getStringExtra("TITLE_NAME");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        rvAlam = findViewById(R.id.rv_Alam);
        rvAlam.setHasFixedSize(true);

        listAlam.addAll(getListwisAlam());
        showList();
    }

    private void showList() {
        rvAlam.setLayoutManager(new LinearLayoutManager(this));
        ListWisAlamAdapter listWisAlamAdapter = new ListWisAlamAdapter(listAlam);
        rvAlam.setAdapter(listWisAlamAdapter);

        listWisAlamAdapter.setOnItemClickCallback(new ListWisAlamAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(wisAlam data) {
                Toast.makeText(wisata_alam.this, "Hello " + data.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(wisata_alam.this, detailActivity.class);
                intent.putExtra("NAME", data.getName());
                intent.putExtra("DESC", data.getDescription());
                intent.putExtra("PHOTO", data.getPhoto());
                startActivity(intent);
            }
        });
    }

    private ArrayList<wisAlam> getListwisAlam() {
        String[] dataName = getResources().getStringArray(R.array.data_name_alam);
        String[] dataDesc = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_foto_alam);

        ArrayList<wisAlam> listAlam = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            wisAlam alam = new wisAlam();
            alam.setName(dataName[i]);
            alam.setDescription(dataDesc[i]);
            alam.setPhoto(dataPhoto.getResourceId(i, 0));
//            cara setnya kalo lewat java
//            mhs.setPhoto(image_ids[i]);
            listAlam.add(alam);
        }
        dataPhoto.recycle();
        return listAlam;
    }

    private final Integer[] data_foto_alam = {
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
    };
}
