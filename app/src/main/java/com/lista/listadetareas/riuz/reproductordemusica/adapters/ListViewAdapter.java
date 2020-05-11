package com.lista.listadetareas.riuz.reproductordemusica.adapters;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;
    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import com.lista.listadetareas.riuz.reproductordemusica.components.GetArtistaMusic;
    import com.lista.listadetareas.riuz.reproductordemusica.R;
    import com.lista.listadetareas.riuz.reproductordemusica.models.ListViewModel;

    import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListViewModel> {

    private List<ListViewModel> modelList;
    private Context contexto;
    private TextView textView;
    private TextView textMusicTitle;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<ListViewModel> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.modelList = objects;
    }

    @NonNull @Override public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(contexto).inflate(R.layout.card_view , null);
        }

        GetArtistaMusic artistaMusic = new GetArtistaMusic(contexto);
        final ListViewModel model = modelList.get(position);

        textView = view.findViewById(R.id.musica_dir);
        TextView artista = view.findViewById(R.id.artista_name);
        textMusicTitle = view.findViewById(R.id.titleMusic);

        textView.setText(model.getMusicName());
        artista.setText(artistaMusic.getArtista(model.getMusicName()));
        return view;
    }
}
