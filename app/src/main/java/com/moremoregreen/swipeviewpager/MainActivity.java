package com.moremoregreen.swipeviewpager;


import android.animation.ArgbEvaluator;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moremoregreen.swipeviewpager.Adapter.PageAdapter;
import com.moremoregreen.swipeviewpager.Model.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    List<Article> articles = new ArrayList<>();
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articles.add(new Article(R.drawable.brochure, "Brochure", "A brochure is an informative paper document (often also used for advertising) that can be folded into a template, pamphlet or leaflet. A brochure can also be a set of related unfolded papers put into a pocket folder or packet. Brochurest are promotional documents, primarily used to introduce a company, organization, products or services and inform prospective customers or members of the public of the benefits."));
        articles.add(new Article(R.drawable.sticker, "Sticker", "Sticker = 貼紙"));
        articles.add(new Article(R.drawable.poster, "Poster", "Poster = 海報"));
        articles.add(new Article(R.drawable.namecard, "Namecard", "Namecard = 名片"));

        pagerAdapter = new PageAdapter(articles, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };
        colors = colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (pagerAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position] + 1
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
