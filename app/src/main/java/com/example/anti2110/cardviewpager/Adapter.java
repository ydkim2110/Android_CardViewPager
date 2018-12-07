package com.example.anti2110.cardviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends PagerAdapter {

    private static final String TAG = "Adapter";

    private List<Model> mModels;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public Adapter(List<Model> models, Context context) {
        mModels = models;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mLayoutInflater = LayoutInflater.from(mContext);
        View view = mLayoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);

        imageView.setImageResource(mModels.get(position).getImage());
        title.setText(mModels.get(position).getTitle());
        desc.setText(mModels.get(position).getDesc());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
