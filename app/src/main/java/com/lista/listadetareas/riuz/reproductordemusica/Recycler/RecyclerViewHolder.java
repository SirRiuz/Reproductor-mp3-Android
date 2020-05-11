package com.lista.listadetareas.riuz.reproductordemusica.Recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lista.listadetareas.riuz.reproductordemusica.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.musica_dir);
    }

    public TextView getTextView () {
        return textView;
    }
}
