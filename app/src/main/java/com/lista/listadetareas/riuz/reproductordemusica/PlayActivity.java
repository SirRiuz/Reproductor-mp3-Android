package com.lista.listadetareas.riuz.reproductordemusica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayActivity extends AppCompatActivity {

    private static String musicaName;
    private static int duration;
    public static int x;
    public static int nextMusic_ ;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_);

        Bundle bundle = getIntent().getExtras();
        musicaName = bundle.getString("dir_music");

        MediaPlayer mediaPlayer = MediaPlayer.create(this , Uri.parse(musicaName));
        mediaPlayer.start();

        nextMusic_ = bundle.getInt("musicPosition") + 1;

        getDuration(mediaPlayer.getDuration() , bundle.getStringArrayList("musicDir"));
        Toast.makeText(getApplicationContext() , String.valueOf(x) , Toast.LENGTH_LONG).show();
    }

    public void getDuration (final int duration , final ArrayList<String> nexMusic) {

        final Timer durationTask = new Timer(false);

        final int duration_ = duration -100;
        final boolean[] estado = {true};
        final Bundle bundle = getIntent().getExtras();

        Log.e("DURACION" , String.valueOf(duration_));
        Log.e("TASK" , "INICIANDO"  +" posicion : " + bundle.getInt("musicPosition"));

        TimerTask durationManager = new TimerTask() {
            @Override public void run() {
                if (x<=duration_){
                    PlayActivity.x = PlayActivity.x+1;
                } else {
                    Log.e("TASK" , "CANCION TERMINADA");
                    durationTask.cancel();
                    MediaPlayer mediaPlayer = MediaPlayer.create(PlayActivity.this , Uri.parse( nexMusic.get(nextMusic_)));
                    mediaPlayer.start();
                    getDuration(mediaPlayer.getDuration() , bundle.getStringArrayList("musicDir"));

                }
            }
        };
            durationTask.schedule(durationManager , 1 , 1);
    }

}
