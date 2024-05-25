package com.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ArrayList<CategoryModel> categoryList = setUpCategoryModels();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private ArrayList<CategoryModel> setUpCategoryModels() {
        ArrayList<CategoryModel> categoryList = new ArrayList<>();
        String[] categoryLabels = getResources().getStringArray(R.array.label);
        int[] categoryThumbnail = {
                R.drawable.blh, R.drawable.gog, R.drawable.grn,
                R.drawable.hol, R.drawable.med, R.drawable.plc,
                R.drawable.sme, R.drawable.stv, R.drawable.ths
        };
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryList.add(new CategoryModel(categoryThumbnail[i], categoryLabels[i]));
        }
        return categoryList;
    }

    public void goDetails(View v) {
        Intent i = new Intent(HomeActivity.this, DetailActivity.class);
        startActivity(i);
        HomeActivity.this.finish();
    }
}