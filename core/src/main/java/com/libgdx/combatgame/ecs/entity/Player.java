package com.libgdx.combatgame.ecs.entity;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.libgdx.combatgame.ecs.component.TextureComponent;
import com.libgdx.combatgame.ecs.component.TransformComponent;

public class Player {
    private final Engine engine;
    private final Texture texture;

    public Player(Engine engine) {
        this.engine = engine;
        this.texture = new Texture("libgdx.png");
    }

    public void createPlayer() {
        Entity entity = engine.createEntity();
        TransformComponent transform = engine.createComponent(TransformComponent.class);
        TextureComponent texture = engine.createComponent(TextureComponent.class);

        transform.position.x = 100;
        transform.position.y = 200;
        texture.region = new TextureRegion(this.texture);

        entity.add(transform);
        entity.add(texture);

        engine.addEntity(entity);
    }

    public void dispose() {
        texture.dispose();
    }
}
