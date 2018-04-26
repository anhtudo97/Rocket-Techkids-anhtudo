package game.player.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    // constructor
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5,5);
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.checkCollision();
    }

    private void checkCollision() {
        Enemy enemy = GameObjectManager.instance.checkCollision(this.boxCollider);
        if(enemy != null){
            enemy.getHit();
            this.getHit();
        }
    }

    private void getHit() {
        this.isAlive = false;
    }

}
