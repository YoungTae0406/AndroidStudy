package com.example.tutorial9;

import android.content.Context;
import android.view.View;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adapter extends PagerAdapter {

    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount(){ //images의 전체 개수
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == ((LinearLayout) object); //object를 형변환했을 때 view와 같은 지 확인
    }

    public Object instatiateItem(ViewGroup container, int position){ //현재 가리키는 이미지 위치
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        imageView.setImageResource(images[position]);
        textView.setText((position + 1) + "번째 이미지입니다.");
        container.addView(v);
        return v;
    }
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();
    }

}
