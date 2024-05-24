package com.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<CategoryModel> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        setUpCategoryModel();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void setUpCategoryModel() {
        String[] categoryLabels = getResources().getStringArray(R.array.label);
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryList.add(new CategoryModel(R.drawable.thumb, categoryLabels[i]));
        }
    }
}