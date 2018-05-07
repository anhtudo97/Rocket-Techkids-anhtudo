package game.player.Expolosion;

import base.GameObject;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class PlayerDieAni extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    // constructor
    public PlayerDieAni() {
        this.velocity = new Vector2D();
        this.runHitObject = new RunHitObject(Enemy.class);
        this.boxCollider = new BoxCollider(5, 5);
        this.renderer = new ImageRenderer("resources/images/star.png", 12, 12,Color.ORANGE);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }


    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
