package com.android.newsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.newsapp.R;
import com.android.newsapp.model.News;

/**
 * Screen showing news detail
 */
public class NewsDetailActivity extends AppCompatActivity {

    public static final String INTENT_KEY_DATA = "Intent data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        TextView textview = findViewById(R.id.titleview);
        News news  = (News) getIntent().getSerializableExtra(INTENT_KEY_DATA);
        if (news != null)
            textview.setText(news.getTitle());
    }
}
