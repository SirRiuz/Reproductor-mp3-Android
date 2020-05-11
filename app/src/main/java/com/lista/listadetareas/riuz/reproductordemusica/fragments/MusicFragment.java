package com.lista.listadetareas.riuz.reproductordemusica.fragments;

        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.media.MediaMetadataRetriever;
        import android.net.Uri;
        import android.os.Bundle;
        import androidx.fragment.app.Fragment;
        import android.os.Environment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.google.android.material.bottomsheet.BottomSheetDialog;
        import com.lista.listadetareas.riuz.reproductordemusica.components.GetMusicPlayList;
        import com.lista.listadetareas.riuz.reproductordemusica.adapters.ListViewAdapter;
        import com.lista.listadetareas.riuz.reproductordemusica.models.ListViewModel;
        import com.lista.listadetareas.riuz.reproductordemusica.MainActivity;
        import com.lista.listadetareas.riuz.reproductordemusica.components.PlaySocg;
        import com.lista.listadetareas.riuz.reproductordemusica.R;
        import java.io.File;
        import java.util.ArrayList;
        import java.util.List;


public class MusicFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MusicFragment() {
        // Required empty public constructor
    }


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_music, container, false);
        List<ListViewModel> models = new ArrayList<>();

        File fileRaiuz = Environment.getExternalStoragePublicDirectory("/");
        final GetMusicPlayList getMusicPlayList = new GetMusicPlayList(
                fileRaiuz.getPath() , getActivity()
        );

        ArrayList<String> listMusicMemori = getMusicPlayList.getPlayMusic();

        int pos = 0;
        for (String nameMusic : getMusicPlayList.getMusicName_()){

            Uri uri = Uri.parse(getMusicPlayList.getFileDir().get(pos));
            MediaMetadataRetriever mmr = new MediaMetadataRetriever();
            mmr.setDataSource(getActivity(),uri);
            String durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            int millSecond = Integer.parseInt(durationStr);

            models.add(new ListViewModel(nameMusic , String.valueOf(millSecond)));
            pos = pos + 1;
        }

        ListViewAdapter arrayAdapter = new ListViewAdapter(getActivity() , R.layout.card_view , models);
        final ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.dirMusic =  getMusicPlayList.getFileDir().get(position);
                PlaySocg playSocg = new PlaySocg(getMusicPlayList.getFileDir() , getActivity() , position , getActivity().getWindow().getDecorView().getRootView());
                playSocg.play();
            }
        });


        listView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override public boolean onLongClick(View v) {
                //BottomSheetDialog dialogOptions = new BottomSheetDialog(getActivity().getApplicationContext() , R.style.BottomOptionsTheme);
                //dialogOptions.setTitle("Music title");
                //dialogOptions.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //dialogOptions.setContentView(R.layout.bottom_sheet_dialog);
                //dialogOptions.show();
                Toast.makeText(v.getContext() , "LONG" , Toast.LENGTH_LONG).show();
                return false;
            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
