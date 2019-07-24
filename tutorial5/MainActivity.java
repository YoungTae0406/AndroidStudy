package com.example.tutorial5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //adapter 실제로 들어갈 부분을 담는다.

        String[] items = {"삼겹살", "소고기", "닭고기"};
        ListAdapter adapter = new imageAdapter(this, items);//items이 imageAdapter의 텍스트로 들어가게 됨
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id){
                        String item = String.valueOf(parent.getItemAtPosition(i)); //아이템을 클릭했을 때 그 클릭한 객체를 item으로 만든다.
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }
}
