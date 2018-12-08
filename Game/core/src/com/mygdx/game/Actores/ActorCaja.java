package com.mygdx.game.Actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorCaja extends Actor {

    private TextureRegion caja;

    public ActorCaja(TextureRegion caja){

        this.caja = caja;
        setSize(caja.getRegionWidth(),caja.getRegionHeight());

    }

    @Override
    public void act(float delta) {

        setX(getX()-250 * delta);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(caja,getX(),getY());
    }
}
