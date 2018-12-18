package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.dearDeath;

import java.awt.TexturePaint;

public class PlayScreens implements Screen {

    private dearDeath game;
    Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private boolean aBoolean = false;


    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    public PlayScreens(dearDeath game){

        this.game = game;
        //texture = new Texture("badlogic.jpg");

        gamecam = new OrthographicCamera();
        gamePort = new FillViewport(dearDeath.V_Width,dearDeath.V_Width,gamecam);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("ProbandoMapa.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        gamecam.position.set(gamePort.getScreenWidth() , gamePort.getScreenHeight(),0);

    }


    @Override
    public void show() {

    }


    public void update(float dt){

        handleInput(dt);

        gamecam.update();
        renderer.setView(gamecam);
    }

    private void handleInput(float dt) {

        if(Gdx.input.isTouched() || aBoolean ){
            gamecam.position.x += 100*dt;
            aBoolean = true;

        }

    }

    @Override
    public void render(float delta) {

        update(delta);
        Gdx.gl.glClearColor(255,255,255,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        //game.batch.draw(texture,0,0);
        game.batch.end();


    }

    @Override
    public void resize(int width, int height) {

        gamePort.update(width, height);


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
