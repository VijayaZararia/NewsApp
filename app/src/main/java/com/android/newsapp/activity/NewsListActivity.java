package com.android.newsapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.android.newsapp.R;
import com.android.newsapp.adapter.NewsAdapter;
import com.android.newsapp.model.News;

import java.util.ArrayList;

/**
 * Screen showing list of news
 */
public class NewsListActivity extends AppCompatActivity implements NewsAdapter.INewsListener {

    private RecyclerView mRecyclerView;
    private NewsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NewsAdapter(this);
        mAdapter.setList(getNewsData());
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Getting hardcoded data for now, should have api call here
    private ArrayList<News> getNewsData() {
        ArrayList<News> mNews = new ArrayList<>();

        String[] titles = {"European Union Extends Brexit Deadline to Oct. 31",
                "In India, Voting Begins in Elections Unmatched in Size and Scope\nPhoto\nFlood Freed Gators in Rio Neighborhood. Officials Said It Was Too Dangerous to Help.\nPhoto\nIran’s Revolutionary Guards: The Supreme Leader’s Military-Industrial Complex Photo Restoration of Holy Stairs Lets Visitors to Rome Follow in Pilgrims’ Knees Photo"
                , "Four Bees Living in Her Eye, Feeding on Her Tears", "Netanyahu’s Road Through Israel’s History", "Netanyahu’s Coalition May Help Stave Off Indictment", "A Family Craft With a Deadly Toll: Illegal Gun Making", "China’s ‘Belt and Road’ Plan in Pakistan Takes a Military Tu", "Black Hole, William Barr, Human Species: Your Wednesday Evening Briefing",
                "‘You Shouldn’t Be Here’: U.S. Pushes U.N. to Pull Venezuela Envoy’s Credentials"};

        for (String title :
                titles) {
            News news = new News();
            news.setTitle(title);
            news.setDescription("UNITED NATIONS — Vice President Mike Pence on Wednesday urged the United Nations to revoke the credentials of Venezuela’s ambassador to the world body, portraying him as a loyalist to the country’s disputed president, Nicolás Maduro, and to a government that has allowed crime, violence and starvation to rise." +
                    "In a 20-minute speech to the United Nations Security Council, Mr. Pence called for a formal recognition of Juan Guaidó as the rightful leader of Venezuela, which he called “a failed state — and as history teaches, failed states know no boundaries.”");
            news.setDate("11th Apr,2019");
            mNews.add(news);
        }

        return mNews;
    }

    @Override
    public void onListItemClick(View view) {
        News news = (News) view.getTag();
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.INTENT_KEY_DATA, news);
        startActivity(intent);

    }
}
