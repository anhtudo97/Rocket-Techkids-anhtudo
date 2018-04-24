import java.awt.*;

public class Player extends GameObject {

    public PlayerMove playerMove;
    public PlayerShoot playerShoot;

    public Player() {
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.playerShoot.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
