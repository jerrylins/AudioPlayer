package com.example.zhangyunxi.audioplayer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.appunite.ffmpeg.audio.*;

import java.io.FileInputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_play;
    private Button bt_pause;
    private Button bt_stop;

    AudioPlayer mAudioPlayer;

    private String s1="/sdcard/netease/cloudmusic/Music/10cc-I'm Not in Love.mp3";
    private String s2="netease/cloudmusic/Music/10cc - I'm Not in Love.mp3";
    private String s3="netease/cloudmusic/Music/ImNotinLove.mp3";
    private String s4="ImNotinLove.mp3";
    private String root="";
    private String TAG="play mess ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_view();
        root= Environment.getExternalStorageDirectory().toString() +"/" ;
        Log.i(TAG,root);
    }

    private void init_view(){

        bt_play=(Button) findViewById(R.id.bt_play);
        bt_pause=(Button) findViewById(R.id.bt_pause);
        bt_stop=(Button) findViewById(R.id.bt_stop);
        bt_play.setOnClickListener(this);
        bt_pause.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v ){

        switch (v.getId()) {

            case R.id.bt_play:
                try {

                    Log.i(TAG,root);
                    mAudioPlayer=new AudioPlayer(new FileInputStream(root+s4));
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    Log.i(TAG,"play");
                    mAudioPlayer.play();
                }
                break;

            case R.id.bt_pause:
                Log.i(TAG,"pause");
                mAudioPlayer.pause();
                break;

            case R.id.bt_stop:
                Log.e(TAG,"stop");
//                Log.i(TAG,root);
                mAudioPlayer.stop();
                break;

        }

    }
}
