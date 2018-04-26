package game.enemy;

import base.GameObject;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class Enemy extends GameObject {
    public EnemyMove enemyMove;
    public EnemyShot enemyShot;
    public BoxCollider boxCollider;

    public Enemy() {
        enemyMove = new EnemyMove();
        enemyShot = new EnemyShot();
        this.boxCollider = new BoxCollider(20, 20);
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    public void run() {
        super.run();
        this.enemyMove.run(this);
        this.enemyShot.run(this);
        this.boxCollider.position.set(this.position);
    }

    public void getHit() {
        this.isAlive = false;
    }
}
