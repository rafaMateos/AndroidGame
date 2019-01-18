package com.example.rafa.deardeath2characters;

import java.util.ArrayList;

public class GestoraPersonajes {

    public ArrayList<Personaje> getPersonajes(){

        Personaje p1 = new Personaje("Uri","1","1",R.drawable.per2);
        Personaje p2 = new Personaje("Uri","1","1",R.drawable.per);
        Personaje p3 = new Personaje("Uri","1","1",R.drawable.per2);
        Personaje p4 = new Personaje("Uri","1","1",R.drawable.per);
        Personaje p5 = new Personaje("Uri","1","1",R.drawable.per2);


        ArrayList<Personaje> ListPer = new ArrayList<>();
        ListPer.add(p1);
        ListPer.add(p2);
        ListPer.add(p3);
        ListPer.add(p4);
        ListPer.add(p5);


        return ListPer;

    }
}
