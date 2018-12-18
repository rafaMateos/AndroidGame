package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.PlayScreens;

public class dearDeath extends Game {

    public SpriteBatch batch;
    public static final int V_Width = 500;
    public static final int V_HEIGHT = 800;

    /*Inicializamos la pantalla del juego*/
    @Override
    public void create() {

        batch = new SpriteBatch();
        setScreen(new PlayScreens(this));

    }

    /*Mostramos y actualizamos*/
    @Override
    public void render() {
        super.render();
    }


}
