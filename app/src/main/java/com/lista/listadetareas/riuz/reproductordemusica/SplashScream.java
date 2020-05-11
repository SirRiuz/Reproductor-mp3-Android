package com.lista.listadetareas.riuz.reproductordemusica;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.app.ActivityCompat;
    import androidx.core.content.ContextCompat;
    import android.Manifest;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SplashScream extends AppCompatActivity implements View.OnClickListener {

    private Button btnPermish;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnPermish = findViewById(R.id.btnPedirPermiso);
        ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1);
    }

    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ContextCompat.checkSelfPermission(SplashScream.this , Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(new Intent(SplashScream.this , MainActivity.class));
            Animatoo.animateZoom(SplashScream.this);
            finish();
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(SplashScream.this , R.style.DialogTheme);
            dialog.setView(R.layout.dialog_erro_permish);
            dialog.setCancelable(false);
            AlertDialog dialogs = dialog.create();
            dialogs.getWindow().getAttributes().windowAnimations = R.anim.scale_anim;
            dialogs.show();
        }
    }

    @Override public void onClick(View v) {
        ActivityCompat.requestPermissions(SplashScream.this , new String[]{Manifest.permission.READ_EXTERNAL_STORAGE} , 1);
    }
}
