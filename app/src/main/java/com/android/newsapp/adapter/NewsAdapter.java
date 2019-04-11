package com.android.newsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.newsapp.R;
import com.android.newsapp.model.News;

import java.util.ArrayList;

/**
 * Bind data to Recyclerview
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    /**
     * Hold list of data
     */
    private ArrayList<News> mNews;
    /**
     * Application context
     */
    private Context mContext;
    /**
     * Item action listener
     */
    private INewsListener mActionListener;

    public NewsAdapter(Context context) {
        mContext = context;
    }

    public void setList(ArrayList<News> newsData){
        mNews = newsData;
    }

    public void setListener(INewsListener actionListener){
        mActionListener = actionListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_news_list_item, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder viewHolder, int i) {
        if (mNews != null) {
            News item = mNews.get(i);
            if (item != null) {
                viewHolder.mTitleView.setText(item.getTitle());
                viewHolder.mDescView.setText(item.getDescription());
                viewHolder.mDateView.setText(item.getDate());
                viewHolder.mView.setTag(item);
            }
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (mNews != null) {
            size = mNews.size();
        }
        return size;
    }

    /**
     * Viewholder class to create views only once and reuse it
     */
    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View mView;
        private final TextView mTitleView;
        private final TextView mDescView;
        private final TextView mDateView;


        private NewsViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = view.findViewById(R.id.title_textview);
            mDescView = view.findViewById(R.id.desc_textview);
            mDateView = view.findViewById(R.id.date_textview);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mActionListener.onListItemClick(v);
        }
    }

    /**
     * Interface definition for a callback to be invoked when a recyclerview item is clicked.
     */
    public interface INewsListener {
        void onListItemClick(View view);
    }
}
