package com.example.tutorial6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.tutorial6.R.id.nameText;

public class MainActivity extends AppCompatActivity { //Activity 화면을 바꾸는 방법

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = (EditText) findViewById(R.id.nameText);
        Button nameButton = (Button) findViewById(R.id.nameButton);

        nameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = nameText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class); //새로운 창을 여는 데 필요한 객체
                intent.putExtra("nameText", name);
                startActivity(intent);

            }

        });
    }


}
