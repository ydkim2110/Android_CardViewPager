package com.example.anti2110.cardviewpager;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager mViewPager;
    private Adapter mAdapter;
    private List<Model> mModels;
    private Integer[] mColors = null;
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        mModels = new ArrayList<>();

        mModels.add(new Model(R.drawable.brochure, "Brochure", "Brochure is informative paper document"));
        mModels.add(new Model(R.drawable.sticker, "Sticker", "Sticker is informative paper document"));
        mModels.add(new Model(R.drawable.poster, "Poster", "Poster is informative paper document"));
        mModels.add(new Model(R.drawable.namecard, "NameCard", "NameCard is informative paper document"));

        mAdapter = new Adapter(mModels, this);

        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        mColors = colors_temp;

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int postionOffsetPixels) {
                if (position < (mAdapter.getCount() - 1) && position <(mColors.length - 1)) {
                    mViewPager.setBackgroundColor(
                            (Integer) mArgbEvaluator.evaluate(
                                positionOffset,
                                mColors[position],
                                mColors[position+1]
                            )
                    );
                }
                else {
                    mViewPager.setBackgroundColor(mColors[mColors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
