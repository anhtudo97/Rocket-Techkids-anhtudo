package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.bullet.BulletEnemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyShot {
    public List<BulletEnemy> bulletEnemies;
    public FrameCounter frameCounter;

    public EnemyShot() {
        this.bulletEnemies = new ArrayList<>();
        frameCounter = new FrameCounter(50);
    }

    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            Vector2D vector2D = new Vector2D(4, 0);
            for (int i = 0; i < 8; i++) {
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                Vector2D rotate = vector2D.rotate(i * 45);
                bulletEnemy.velocity.set(rotate);
                GameObjectManager.instance.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }


    }
}
