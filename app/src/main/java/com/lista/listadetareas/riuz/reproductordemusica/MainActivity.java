package com.lista.listadetareas.riuz.reproductordemusica;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.core.content.ContextCompat;
        import androidx.fragment.app.Fragment;
        import androidx.viewpager.widget.ViewPager;
        import android.Manifest;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import java.util.ArrayList;
        import static com.lista.listadetareas.riuz.reproductordemusica.R.layout.activity_main;
        import com.lista.listadetareas.riuz.reproductordemusica.adapters.*;
        import com.lista.listadetareas.riuz.reproductordemusica.fragments.FilekFragment;
        import com.lista.listadetareas.riuz.reproductordemusica.fragments.MusicFragment;

public class MainActivity extends AppCompatActivity implements MusicFragment.OnFragmentInteractionListener, FilekFragment.OnFragmentInteractionListener{

    public static String dirMusic = null;
    private Toolbar toolbar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        if (ContextCompat.checkSelfPermission(this , Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            ArrayList<Fragment> fragmentsList = new ArrayList<>();
            fragmentsList.add(new MusicFragment());
            fragmentsList.add(new FilekFragment());
            ViewPager pager = findViewById(R.id.pager);
            pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager() , fragmentsList);
            pager.setAdapter(adapter);

            pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

                @Override public void onPageSelected(int position) {
                    switch (position) {

                        case 0:
                            toolbar.setTitle("Mi musica");
                            break;

                        case 1:
                            toolbar.setTitle("Favoritos");
                            break;

                        case 2:
                            toolbar.setTitle("Archivos");
                            break;
                    }
                }

                @Override public void onPageScrollStateChanged(int state) { }
            });
        } else {
            finish();
        }
    }

    @Override public void onFragmentInteraction(Uri uri) { }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    public static String getDirMusic() {
        return dirMusic;
    }
}
