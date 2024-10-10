package com.libgdx.combatgame;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.combatgame.ecs.entity.Player;
import com.libgdx.combatgame.ecs.system.RenderSystem;

public class Main extends ApplicationAdapter {
    private Engine engine;
    private SpriteBatch batch;

    private Player player;

    @Override
    public void create() {
        engine = new Engine();
        batch = new SpriteBatch();

        engine.addSystem(new RenderSystem(batch));

        player = new Player(engine);
        player.createPlayer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float deltaTime = Gdx.graphics.getDeltaTime();
        engine.update(deltaTime);
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }
}
