package com.mygdx.game.Actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorJugador extends Actor {

    private Texture jugador;
    private boolean esVivo;

    public boolean isEsVivo() {
        return esVivo;
    }

    public void setEsVivo(boolean esVivo) {
        this.esVivo = esVivo;
    }

    public ActorJugador(Texture jugador){

        this.jugador = jugador;
        this.esVivo = true;
        setSize(150,150);

    }


    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(jugador,getX(),getY(),150,150);

    }
}
