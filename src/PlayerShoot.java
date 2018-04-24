import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {

    public List<BulletPlayer> bulletPlayers;
    public boolean isPlayerShoot = false;
    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.bulletPlayers = new ArrayList<>();
        this.frameCounter = new FrameCounter(5);
    }

    public void run(Player player) {
        if (this.isPlayerShoot) {
            if (this.frameCounter.run()) {
                BulletPlayer bulletPlayer = new BulletPlayer();
                bulletPlayer.position.set(player.position);
                Vector2D vector2D = new Vector2D(7, 0);
                Vector2D rotate = vector2D.rotate(player.playerMove.angle);
                bulletPlayer.velocity.set(rotate);
                this.bulletPlayers.add(bulletPlayer);
                this.frameCounter.reset();
            }
        } else {
            this.frameCounter.reset();
        }
    }
}
