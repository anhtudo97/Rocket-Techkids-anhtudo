package game.enemy;

import base.GameObject;
import renderer.ImageRenderer;

public class Enemy extends GameObject {
    public EnemyMove enemyMove;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
        enemyMove = new EnemyMove();
    }

    public void run() {
        super.run();
        this.enemyMove.run(this);
    }

}
