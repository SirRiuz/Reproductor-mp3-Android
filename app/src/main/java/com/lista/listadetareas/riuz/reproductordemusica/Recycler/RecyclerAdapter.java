package com.lista.listadetareas.riuz.reproductordemusica.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lista.listadetareas.riuz.reproductordemusica.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<String> MusecName;

    public RecyclerAdapter (ArrayList<String> ListName) {
        this.MusecName = ListName;
    }

    @NonNull @Override public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view , parent , false);
        return new RecyclerViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getTextView().setText(MusecName.get(position));
    }

    @Override public int getItemCount() {
        return MusecName.size();
    }

    public String array () {
        return MusecName.get(0);
    }

}
