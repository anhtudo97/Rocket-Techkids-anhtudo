package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {

    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;

    public Player() {
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.boxCollider = new BoxCollider(20, 20);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        this.checkCollision();
    }

    private void checkCollision() {
        Enemy enemy = GameObjectManager.instance.checkCollisionEnemy(this.boxCollider);
        if (enemy != null) {
            this.getHit();
            enemy.getHit();
        }
    }

    public void getHit() {
        this.isAlive = false;
    }
}
