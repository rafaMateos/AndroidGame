package com.example.rafa.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CronometroViewModel extends ViewModel {

    private MutableLiveData<String> mSegundos;

    public MutableLiveData<String> getSegundos(){

        if(mSegundos ==  null){

            mSegundos = new MutableLiveData<String>();

        }
        return mSegundos;

    }

}
