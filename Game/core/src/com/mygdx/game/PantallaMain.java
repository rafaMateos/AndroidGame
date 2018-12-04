package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actores.ActorJugador;

public class PantallaMain extends PantallaPrincipal {

    public PantallaMain(clsPrincipal game) {

        super(game);
        jugadorTectura = new Texture("principal.png");

    }

    private Stage stage;
    private ActorJugador jugador;
    Texture jugadorTectura;


    @Override
    public void show() {


        stage = new Stage();
        jugador = new ActorJugador(jugadorTectura);
        stage.addActor(jugador);

        jugador.setPosition(20,100);
    }

    @Override
    public void hide() {

        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255,255,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
