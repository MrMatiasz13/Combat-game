package com.libgdx.combatgame.ecs.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.libgdx.combatgame.ecs.component.TextureComponent;
import com.libgdx.combatgame.ecs.component.TransformComponent;

public class RenderSystem extends IteratingSystem {
    private final ComponentMapper<TextureComponent> tm;
    private final ComponentMapper<TransformComponent> trm;

    private final SpriteBatch batch;

    public RenderSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class, TransformComponent.class).get());
        tm = ComponentMapper.getFor(TextureComponent.class);
        trm = ComponentMapper.getFor(TransformComponent.class);

        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float v) {
        TextureComponent tc = tm.get(entity);
        TransformComponent trc = trm.get(entity);

        batch.begin();
        batch.draw(tc.region, trc.position.x, trc.position.y);
        batch.end();
    }
}
