package com.example.tutorial3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] list = {"망고", "포도", "삼겹살"};
    @Override
    protected void onCreate(Bundle savedInstanceState) { //만들어지자 마자 작동되는 메소드같은데
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton = (Button)findViewById(R.id.listButton); //뷰의 객체를 가져올 수 있게 함
        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("리스트");
                builder.setItems(list, new DialogInterface.OnClickListener(){//리스트를 클릭했을 때 이벤트
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(getApplicationContext(), list[i], Toast.LENGTH_SHORT).show(); //Toast 하단에 잠깐 뜨는 거

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료할겁니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int i){
                                    finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int i){
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create(); //dialog의 객체를 builder에서 받아옴
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });

    }
}
