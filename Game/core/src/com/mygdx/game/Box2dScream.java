package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


public class Box2dScream extends PantallaPrincipal {

    private World world;
    private Box2DDebugRenderer renderer;
    private OrthographicCamera camera;
    private Body juagor ,sueloBody;
    private Fixture jugadorFix,sueloFix;

    public Box2dScream(clsPrincipal game) {
        super(game);
    }

    @Override
    public void show() {
        world = new World(new Vector2(0,-10),true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(7.11f,4);
        camera.translate(0,1.5f);

        BodyDef jugadordef = createBodyFef();
        sueloBody = world.createBody(createSueloBodyDef());
        juagor = world.createBody(jugadordef);

        PolygonShape circulo = new PolygonShape();
        circulo.setAsBox(0.5f,0.5f);

        jugadorFix = juagor.createFixture(circulo,1);
        circulo.dispose();

        PolygonShape suelo  = new PolygonShape();
        suelo.setAsBox(500,1);

        sueloFix = sueloBody.createFixture(suelo,1);
        suelo.dispose();

    }

    private BodyDef createSueloBodyDef() {

        BodyDef def = new BodyDef();
        def.position.set(0,-1);

        return def;

    }

    private BodyDef createBodyFef() {

        BodyDef def = new BodyDef();
        def.position.set(0,10);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;
    }



    @Override
    public void dispose() {
        juagor.destroyFixture(jugadorFix);
        world.destroyBody(juagor);
        world.dispose();
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta,6,2);

        camera.update();
        renderer.render(world,camera.combined);
    }
}
