import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    private List<Star> stars;
    private List<Enemy> enemies;
    public Player player;


    private BufferedImage backBuffered;
    private Background background;
    private Graphics graphics;
    private Random random;


    private FrameCounter enemyCounter;
    private FrameCounter starCounter;


    public GameCanvas() {
        // Set size
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.stars = new ArrayList<>();
        this.random = new Random();
        this.background = new Background();
        this.player = new Player();
        this.player.position.set(200, 200);
        this.enemies = new ArrayList<>();
        this.setVisible(true);

        // init counter
        enemyCounter = new FrameCounter(40);
        starCounter = new FrameCounter(30);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR); //khoi tao object
        this.graphics = this.backBuffered.getGraphics();
        BufferedImage back2 = this.backBuffered; //dang tro cung den mot object (cung chua mot dia chi)
        back2.setRGB(20, 20, 255);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }

    public void runAll() {
        this.background.run();
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.player.run();
        this.createEnemy();
        this.runEnemies();
    }

    private void createEnemy() {
        if (this.enemyCounter.run()) {
            Enemy enemy = new Enemy();
            enemy.position.set(new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)));
            this.enemies.add(enemy);
            this.enemyCounter.reset();
        }
    }

    private void runEnemies() {
        this.enemies.forEach(enemy -> enemy.velocity.set(
                player.position
                        .subtract(enemy.position)
                        .normalize()
        ).multiply(2));
        this.enemies.forEach(enemy -> enemy.run());
    }

    private void createStar() {
        if (this.starCounter.run()) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.velocity.set(this.random.nextInt(2) + 1, 0);
            this.stars.add(star);
            this.starCounter.reset();
        }
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
