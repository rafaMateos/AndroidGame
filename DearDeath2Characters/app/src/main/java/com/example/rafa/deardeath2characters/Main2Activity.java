package com.example.rafa.deardeath2characters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nombre;
    TextView ataque;
    TextView defensa;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        Personaje objeto = (Personaje)getIntent().getExtras().getParcelable("Personaje");

        nombre = findViewById(R.id.nombre);
        ataque = findViewById(R.id.Ataque);
        defensa = findViewById(R.id.Defensa);
        imageView = findViewById(R.id.imageView2);

        nombre.setText(objeto.get_nombre().toString());
        ataque.setText(objeto.get_ataque().toString());
        defensa.setText(objeto.get_defensa().toString());
        imageView.setImageResource(objeto.getImage());

    }
}
