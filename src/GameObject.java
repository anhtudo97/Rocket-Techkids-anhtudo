import java.awt.*;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;

    public GameObject() {
        this.position = new Vector2D();
    }

    public void run() {
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
