package com.example.rafa.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private TextView segundos;
    private CronometroViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        segundos = findViewById(R.id.segundos);

        segundos.setText("0");
        //Obtenemos el ViewModel
        mViewModel = ViewModelProviders.of(this).get(CronometroViewModel.class);

        //Realizamos el Observer para asi poder cambiar los valores
        final Observer<String> segundosObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String string) {

                segundos.setText(string);
            }
        };

        mViewModel.getSegundos().observe(this, segundosObserver);


    }

    public void actualizarSegundos(View view){



            int num = Integer.parseInt(segundos.getText().toString());
            num = num + 1;
            String numActu = String.valueOf(num);

            mViewModel.getSegundos().setValue(numActu);



    }
}
