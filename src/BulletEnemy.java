public class BulletEnemy extends GameObject {
    public Vector2D velocity;

    public BulletEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png", 5, 5);
    }

    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
