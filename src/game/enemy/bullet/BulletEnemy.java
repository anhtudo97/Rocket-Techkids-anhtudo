package game.enemy.bullet;

import base.GameObject;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletEnemy extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public BulletEnemy() {
        this.runHitObject = new RunHitObject(Player.class);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5, 5);
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 5, 5,Color.GREEN);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
}
