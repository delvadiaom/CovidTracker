package com.degtu.cowid_19casesdata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private String[] texts = {"Daily Covid Statistics","Take Neccessary Precautions","Updated Health News"};
    private String[] longtexts = {"covered relavent information about covid 19 pendemic situations.","it might be our first priority to take some steps regarding our health.","one can to be in connect with the health care affairs provided by us which are daily updated."};

    ViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.splash_item,null);
        TextView textView = view.findViewById(R.id.firsttext);
        TextView textView1 = view.findViewById(R.id.longtext);
        TextView skip = view.findViewById(R.id.skip);
        TextView continuebtn = view.findViewById(R.id.continuebtn);
        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PhoneNumberActivity.class);
                context.startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PhoneNumberActivity.class);
                context.startActivity(intent);
            }
        });
        textView.setText(texts[position]);
        textView1.setText(longtexts[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view  = (View) object;
        viewPager.removeView(view);
    }
}
