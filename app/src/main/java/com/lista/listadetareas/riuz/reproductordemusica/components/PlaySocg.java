package com.lista.listadetareas.riuz.reproductordemusica.components;

        import android.content.Context;
        import android.media.MediaPlayer;
        import android.net.Uri;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;
        import com.lista.listadetareas.riuz.reproductordemusica.R;
        import java.io.File;
        import java.util.ArrayList;

public class PlaySocg implements MediaPlayer.OnCompletionListener {

    private static MediaPlayer player;
    private static ArrayList<String> listPlayer;
    public Context context;
    private int position;
    private static int clicks = 0;
    private TextView titleMusic;
    private View view;
    private GetMusicPlayList namePlayer;
    private TextView musicName;
    private TextView artisnaMane;
    private GetArtistaMusic artistName;



    /*
    *
    *                 GetArtistaMusic getArtistaMusic = new GetArtistaMusic(view.getContext());


                TextView textView = getActivity().findViewById(R.id.musica_title);
                TextView textArtista = getActivity().findViewById(R.id.artista_name_2);

                textArtista.setText(getArtistaMusic.getArtista(getMusicPlayList.getMusicName_().get(position)));
                textView.setText(getMusicPlayList.getMusicName_().get(position));

    *
    * */

    public PlaySocg (ArrayList<String> playerList , Context contexto , int position , View view) {
        this.context = contexto;
        this.listPlayer = playerList;
        this.position = position;
        this.view = view;
        musicName = view.findViewById(R.id.musica_title);
        artisnaMane = view.findViewById(R.id.artista_name_2);
        artistName = new GetArtistaMusic(this.context);
    }

    public void play () {
        clicks = clicks +1;

        if (player != null) { player.release(); }

        File files = new File(listPlayer.get(position));
        player = MediaPlayer.create(context , Uri.parse(listPlayer.get(position)));
        player.start();
        player.setOnCompletionListener(this);
        navDrawlSetTitle(files.getName());
        Toast.makeText(context , "Estas escuchando : " + files.getName() , Toast.LENGTH_LONG).show();
        musicName.setText(files.getName());
        artisnaMane.setText(artistName.getArtista(files.getName()));
    }

    @Override public void onCompletion(MediaPlayer mp) {
        try{
            nextMusic();
        } catch (Exception e) {
            position = 0;
            nextMusic();
        }
    }

    private void nextMusic () {

        File files = new File(listPlayer.get(position));

        if (position >= listPlayer.size() ) {
            position = 0;
            navDrawlSetTitle(files.getName());
            Toast.makeText(context , "Automatico 1 : " + files.getName() , Toast.LENGTH_LONG).show();
            musicName.setText(files.getName());
            artisnaMane.setText(artistName.getArtista(files.getName()));
        } else {
            position = position +1;
            Toast.makeText(context , "Automatico 2 : " + files.getName() , Toast.LENGTH_LONG).show();
            Toast.makeText(context , "Siguiente cancion" + listPlayer.get(position) , Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(context , Uri.parse(listPlayer.get(position)));
            player.start();
            player.setOnCompletionListener(this);
            navDrawlSetTitle(files.getName());
            musicName.setText(files.getName());
            artisnaMane.setText(artistName.getArtista(files.getName()));
        }
    }

    private void navDrawlSetTitle (String nameMusic) {
        titleMusic = view.findViewById(R.id.musica_title_nav_drawl);
        titleMusic.setText(nameMusic);
    }
}
