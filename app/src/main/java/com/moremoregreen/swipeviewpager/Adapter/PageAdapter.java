package com.moremoregreen.swipeviewpager.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moremoregreen.swipeviewpager.Model.Article;
import com.moremoregreen.swipeviewpager.R;

import java.util.List;

public class PageAdapter extends PagerAdapter {
    private List<Article> articles;
    private Context context;
    private LayoutInflater layoutInflater;

    public PageAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc;
        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(articles.get(position).getImage());
        title.setText(articles.get(position).getTitle());
        desc.setText(articles.get(position).getDesc());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
