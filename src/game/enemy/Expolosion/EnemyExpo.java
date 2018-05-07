package game.enemy.Expolosion;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Expolosion.PlayerDieAni;

public class EnemyExpo extends GameObject {
    @Override
    public void run() {
        super.run();
        Vector2D vector2D = new Vector2D(4, 0);
        for (int i = 0; i < 8; i++) {
            BulletDieAni playerDieAni = GameObjectManager.instance.recycle(BulletDieAni.class);
            playerDieAni.position.set(this.position);
            Vector2D rotate = vector2D.rotate(i * 45);
            playerDieAni.velocity.set(rotate);
        }
    }
}
