package com.libgdx.combatgame.ecs.component;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class TransformComponent extends Component {
    public final Vector2 position = new Vector2();
    public float rotation = 0.0f;
    public boolean isHidden = false;

    public TransformComponent() {}

    public TransformComponent(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setPositionX(float x) {
        this.position.x = x;
    }

    public void setPositionY(float y) {
        this.position.y = y;
    }
}
