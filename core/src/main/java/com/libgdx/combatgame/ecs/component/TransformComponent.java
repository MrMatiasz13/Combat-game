package com.libgdx.combatgame.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;


public class TransformComponent implements Component {
    public final Vector2 position = new Vector2();
}
