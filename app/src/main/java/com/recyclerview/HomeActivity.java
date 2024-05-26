package com.recyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ArrayList<CategoryModel> categoryList = setUpCategoryModels();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, categoryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private ArrayList<CategoryModel> setUpCategoryModels() {
        ArrayList<CategoryModel> categoryList = new ArrayList<>();
        String[] categoryLabels = getResources().getStringArray(R.array.label);
        String[] categoryDes = getResources().getStringArray(R.array.description);
        int[] categoryThumbnail = {
                R.drawable.blh, R.drawable.gog, R.drawable.grn,
                R.drawable.hol, R.drawable.med, R.drawable.plc,
                R.drawable.sme, R.drawable.stv, R.drawable.ths
        };
        for (int i = 0; i < categoryLabels.length; i++) {
            categoryList.add(new CategoryModel(categoryThumbnail[i], categoryLabels[i], categoryDes[i]));
        }
        return categoryList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.search_option) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.cart_option) {
            Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}