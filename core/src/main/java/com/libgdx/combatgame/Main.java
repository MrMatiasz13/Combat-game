package com.libgdx.combatgame;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.combatgame.ecs.component.TextureComponent;
import com.libgdx.combatgame.ecs.component.TransformComponent;
import com.libgdx.combatgame.ecs.system.RenderSystem;

public class Main extends ApplicationAdapter {
    private Engine engine;
    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        engine = new Engine();
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");

        engine.addSystem(new RenderSystem(batch));

        Entity player = new Entity();
        player.add(new TextureComponent(image));
        player.add(new TransformComponent(50, 50));

        Entity label2 = new Entity();
        label2.add(new TextureComponent(image));
        label2.add(new TransformComponent(200, 200));

        engine.addEntity(player);
        engine.addEntity(label2);
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
        image.dispose();
    }
}
