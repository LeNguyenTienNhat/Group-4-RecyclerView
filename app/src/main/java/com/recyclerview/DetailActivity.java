package com.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        String labelData = i.getStringExtra("label");
        String desData = i.getStringExtra("des");
        int thumbnailData = i.getIntExtra("thumbnailID",0);

        TextView label = findViewById(R.id.label);
        TextView des = findViewById(R.id.des);
        ImageView thumbnail = findViewById(R.id.thumbnail);
        Button backBtn = findViewById(R.id.back);

        label.setText(labelData);
        des.setText(desData);
        thumbnail.setImageResource(thumbnailData);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.this.finish();
                System.exit(0);
            }
        });
    }
}