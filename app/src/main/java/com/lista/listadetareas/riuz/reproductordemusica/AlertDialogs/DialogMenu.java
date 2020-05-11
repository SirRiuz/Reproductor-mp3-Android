package com.lista.listadetareas.riuz.reproductordemusica.AlertDialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogMenu extends DialogFragment {

    @NonNull @Override public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Hello")
                .setMessage("asdasd");

        return dialog.create();
    }
}
