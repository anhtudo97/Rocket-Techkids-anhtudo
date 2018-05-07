package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.player.bullet.BulletPlayer;

public class PlayerShoot {

    public boolean isPlayerShoot = false;
    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(5);
    }

    public void run(Player player) {
        if (this.isPlayerShoot) {
            if (this.frameCounter.run()) {
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(player.position);
                Vector2D vector2D = new Vector2D(7, 0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bulletPlayer.velocity.set(rotate);
                this.frameCounter.reset();
            }
        } else {
            this.frameCounter.reset();
        }
    }
}
