package com.lista.listadetareas.riuz.reproductordemusica.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class pagerAdapter extends FragmentPagerAdapter {

    private  ArrayList<Fragment> fragmentsLis;
    private String[] titleTabs = {"Musica" , "Archivos"};
    private int position;

    public pagerAdapter(@NonNull FragmentManager fm , ArrayList<Fragment> fragmentsList) {
        super(fm);
        this.fragmentsLis = fragmentsList;
    }

    @NonNull @Override public Fragment getItem(int position) {
        this.position = position;
        return fragmentsLis.get(position);
    }

    @Override public int getCount() {
        return fragmentsLis.size();
    }

    public String getTitle () {
        return titleTabs[this.position];
    }

}
