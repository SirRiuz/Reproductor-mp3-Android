package com.lista.listadetareas.riuz.reproductordemusica.components;

import android.content.Context;

public class GetArtistaMusic {

    private Context context = null;
    private static final String Artista[] = {"Queen" , "Queens Of The Stone Age" , "The Strokes" , "Sebastián Yatra" , "Maluma"
            , "Bad Bunny" , "Cancerbero" , "Michael Jackson" , "NCS" , "Gorillaz" , "Bee Gees" , "TheFatRat" , "Ozuna" , "Anuel AA"
            ,"J Balvin" , "Daddy Yankee" , "Billie Eilish" , "Ariana Grande" , "Foster The People" , "Drake" , "Ed Sheeran" , "Eminem"
            , "Hinkik" , "Linkin Park" , "Canserbero" , "Justin Timberlake" , "Justin Bieber" , "XXXTentacion" , "Diomedes Díaz" , "Skrillex"
            , "Guns N' Roses" , "Karol G" , "Lil Pump" , "Juanes" , "Alan Walker" , "Madonna" , "Katy Perry" , "Avicii", "Mr Black" , "Taylor Swift"
            , "Beyoncé" , "Carlos Vives" , "Selena Gómez" , "Miley Cyrus" , "Rihanna"
    };

    public GetArtistaMusic (Context contexto) {
        this.context = contexto;
    }

    public String getArtista (String musicName) {
        String nameMusic = musicName.toLowerCase();
        String name = null;
        int x = 0;
        for (String nameArtistas : Artista){

            //nameMusic.indexOf(nameArtistas.toLowerCase()) != -1

            if (nameMusic.contains(nameArtistas.toLowerCase())) {
                x=1;
                name = nameArtistas;
            }
        }
        if (x == 0) {
            name = "Artista desconocido";
        }
        return name;
    }
}
