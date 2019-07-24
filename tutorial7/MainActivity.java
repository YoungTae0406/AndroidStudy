package com.example.tutorial7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity { //어플에 youtube영상을 띄우는 방법

    YouTubePlayerView youtubeView;
    Button button;
    YouTubePlayer.OnInitializedListener listener; // youtubeplayer가 초기화되면 발생하는 이벤트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.youtubeButton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("AvLDP_dz0Pk"); //비디오를 재생. youtube동영상의 id를 parameter로 복붙한 것.
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                youtubeView.initialize("AIzaSyDckkYV7oiN-vXg2OIw6UbxmcfNHH9lBHY", listener);
                //버튼이 클릭되면 초기화시킨다. 그때 API Key를 복붙해줘야 한다.
            }

        });
    }
}
