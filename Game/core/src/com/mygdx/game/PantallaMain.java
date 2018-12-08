package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actores.ActorCaja;
import com.mygdx.game.Actores.ActorJugador;

import java.io.Console;

public class PantallaMain extends PantallaPrincipal {

    private Stage stage;
    private ActorJugador jugador;
    private Texture jugadorTectura;
    private Texture cajaTextura;
    private TextureRegion regionCaja;
    private ActorCaja caja;

    public PantallaMain(clsPrincipal game) {

        super(game);
        jugadorTectura = new Texture("principal.png");
        cajaTextura = new Texture("caja.png");
        regionCaja = new TextureRegion(cajaTextura);

    }

    @Override
    public void show() {

        stage = new Stage();
        stage.setDebugAll(true);
        jugador = new ActorJugador(jugadorTectura);
        caja = new ActorCaja(regionCaja);
        stage.addActor(jugador);
        stage.addActor(caja);

        jugador.setPosition(20,100);
        caja.setPosition(700,100);
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

        comprobarColision();

        stage.draw();
    }

    private void comprobarColision() {

        if(jugador.isEsVivo() &&
                (jugador.getX() + jugador.getWidth()) > caja.getX()){

            System.out.println("colision");

            jugador.setEsVivo(false);
        }
    }


}
