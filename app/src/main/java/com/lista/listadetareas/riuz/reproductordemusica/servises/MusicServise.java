package com.lista.listadetareas.riuz.reproductordemusica.servises;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicServise extends Service {


    @Nullable @Override public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext() , "SERVICIO" , Toast.LENGTH_LONG).show();
        return null;
    }

}
