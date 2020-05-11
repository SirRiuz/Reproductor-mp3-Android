package com.lista.listadetareas.riuz.reproductordemusica.components;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class GetMusicPlayList {

    private static  String fileRaiz ;
    private static final String formatos[] = {".mp3"};
    private static final ArrayList<String> playList = new ArrayList<>();
    private static final ArrayList<String> musicName = new ArrayList<>();

    private Context context;

    public GetMusicPlayList (String fileRaiz_ , Context contexto){
        GetMusicPlayList.fileRaiz = fileRaiz_;
        this.context = contexto;
    }

    public ArrayList<String> getPlayMusic () {

        File file = new File(fileRaiz);
        Toast.makeText(context , fileRaiz , Toast.LENGTH_LONG).show();

        if (file.exists()) {
            File fileList[] = file.listFiles();
            for (File getDirectori : fileList){

                if (getDirectori.isDirectory()) {
                    String fileDir = getDirectori.toString();
                    AbrirCarpeta(fileDir);
                } else {
                    if (getDirectori.getName().toLowerCase().endsWith(formatos[0])){
                        for (String formato : formatos){
                            if (getDirectori.getName().toLowerCase().endsWith(formato)) {
                                playList.add(getDirectori.getName().toString());
                                Toast.makeText(context , getDirectori.getName() + " - Es una archivo de musica" , Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }

        }
        return playList;
    }


    public void AbrirCarpeta (String ruta) {
        File abCarpeta = new File(ruta);
        if (abCarpeta.exists()) {
            File carpeta[] = abCarpeta.listFiles();
            for (File sub : carpeta) {
                if (sub.isDirectory()) {
                    AbrirCarpeta(sub.toString());
                } else{
                    if(sub.getName().toLowerCase().endsWith(formatos[0])) {
                        for (String formato : formatos){
                            if (sub.getName().toLowerCase().endsWith(formato)) {
                                playList.add(sub.getPath());
                                musicName.add(sub.getName());
                            }
                        }
                    }
                }
            }

        } else { System.out.println("El archivo " + ruta + " no existe"); }
    }

    public ArrayList<String> getFileDir () { return playList; }


    /*  El metodo getMusicName_ se encarga de retornar un arrayList com
    *   todos los nombres de un archivo mp3
    */

    public ArrayList<String> getMusicName_ () {

        /*
                ArrayList<String> musicList = new ArrayList<>();
        Collections.sort(musicName);

        for (String item : musicName) {
            musicList.add(item);
        }
        return musicList;
        * */

        return musicName;

    }
}
