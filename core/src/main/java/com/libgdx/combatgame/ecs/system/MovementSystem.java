package com.libgdx.combatgame.ecs.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.libgdx.combatgame.ecs.component.FirstPlayerComponent;
import com.libgdx.combatgame.ecs.component.TransformComponent;

public class MovementSystem extends IteratingSystem {
    private final ComponentMapper<TransformComponent> trm;

    public MovementSystem() {
        super(Family.one(FirstPlayerComponent.class).get());

        trm = ComponentMapper.getFor(TransformComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TransformComponent trc = trm.get(entity);
        Vector2 position = trc.position;

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += 1;
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= 1;
        }
    }
}
