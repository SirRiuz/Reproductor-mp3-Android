package com.lista.listadetareas.riuz.reproductordemusica.models;

public class ListViewModel {

    private String musicName;
    private String musicDurate;
    public static String time;

    public ListViewModel(String musicName , String duration) {
        this.musicName = musicName;
        this.musicDurate = duration;
    }


    public String getMusicName() {
        return musicName;
    }

}
