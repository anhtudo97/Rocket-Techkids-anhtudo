package game.enemy.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class BulletEnemy extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5,5);
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 5, 5);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.checkCollision();
    }

    private void checkCollision() {
        Player player = GameObjectManager.instance.checkCollisionPlayer(this.boxCollider);
        if(player != null){
            player.getHit();
            this.getHit();
        }
    }

    private void getHit() {
        this.isAlive = false;
    }
}
