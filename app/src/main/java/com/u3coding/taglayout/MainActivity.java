package com.u3coding.taglayout;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TagLayout tagLayout = findViewById(R.id.tagview);
        tagLayout.setAdapter(new MyAdapter(getDatas()));
    }
      public List<TagBean> getDatas() {
        List<TagBean> datas=new ArrayList<>();
        datas.add(new TagBean(Color.parseColor("#F8F2EC"),"微信"));
        datas.add(new TagBean(Color.parseColor("#F8EAEB"),"百度糯米"));
        datas.add(new TagBean(Color.parseColor("#F2F2F2"),"qq"));
        datas.add(new TagBean(Color.parseColor("#F2F5E9"),"大众点评"));
        datas.add(new TagBean(Color.parseColor("#F2F5E9"),"同程旅游"));
        datas.add(new TagBean(Color.parseColor("#F2F5E9"),"爱奇艺"));
        datas.add(new TagBean(Color.parseColor("#F8F2EC"),"贝贝"));
        datas.add(new TagBean(Color.parseColor("#F8EAEB"),"万能钥匙"));
        datas.add(new TagBean(Color.parseColor("#E8F6F6"),"驾校一点通"));
        datas.add(new TagBean(Color.parseColor("#F8F2EC"),"天天快报"));
        datas.add(new TagBean(Color.parseColor("#E8F6F6"),"蘑菇街"));
        return datas;
    }
    class MyAdapter extends TagAdapter{

    private List<TagBean> datas;

    public MyAdapter(List<TagBean> datas){

        this.datas = datas;
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public View getViews(final int position, ViewGroup parent) {
        TextView itmeView = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.tag_item, parent, false);
        itmeView.setText(datas.get(position).getSrc());
        GradientDrawable drawable=new GradientDrawable();
        drawable.setStroke(1,Color.parseColor("#99541D"));
        drawable.setCornerRadius(5);
        drawable.setColor(datas.get(position).getBgColor());
        itmeView.setBackgroundDrawable(drawable);
        //设置点击事件
        itmeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,datas.get(position).getSrc(),Toast.LENGTH_SHORT).show();
            }
        });
        return itmeView;
    }

}
}

