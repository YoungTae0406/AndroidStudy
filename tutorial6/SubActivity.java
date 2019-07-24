package com.example.tutorial6;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity { //화면을 나타내기 때문에 저걸 상속해야함.
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activitiy_sub);
        TextView nameText = (TextView) findViewById(R.id.nameText);
        Intent intent = getIntent();
        nameText.setText(intent.getStringExtra("nameText").toString());//nameText에 해당되는 내용을 가져옴
    }
}
