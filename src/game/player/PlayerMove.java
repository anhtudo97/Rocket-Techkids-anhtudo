package game.player;

import base.Vector2D;
import input.KeyInput;

import java.util.Random;

public class PlayerMove {

    public Vector2D velocity;
    public double angle = 0.0;
    private Random random;

    private Vector2D defaultVelocity = new Vector2D(3.5f, 0);

    public PlayerMove() {
        this.velocity = new Vector2D(3.5f, 0);
        this.random = new Random();
    }

    public void run(Player player) {
        this.hangleEventKeyBoard(player);
        player.position.addUp(this.velocity);
        this.checkPlayerMove(player);


    }

    private void checkPlayerMove(Player player) {
        if (player.position.x > 1024) {
            player.position.set(0, this.random.nextInt(600));
        }
        if (player.position.x < 0) {
            player.position.set(1024, this.random.nextInt(600));
        }
        if (player.position.y > 600) {
            player.position.set(this.random.nextInt(1024), 0);
        }
        if (player.position.y < 0) {
            player.position.set(this.random.nextInt(1024), 600);
        }
    }

    private void hangleEventKeyBoard(Player player) {
        if (KeyInput.instance.leftPressed) {
            this.angle += 5;
        }
        if (KeyInput.instance.rightPressed) {
            this.angle -= 5;
        }
        if (KeyInput.instance.upPressed) {
            this.defaultVelocity.set(10, 0);
        }
        if (KeyInput.instance.spacePressed) {
            player.playerShoot.isPlayerShoot = true;
        }

        /*----------------------------------*/

        if (KeyInput.instance.upRelease) {
            this.defaultVelocity.set(3.5f, 0);
        }
        if (KeyInput.instance.spaceRelease) {
            player.playerShoot.isPlayerShoot = false;
        }

        this.velocity.set(this.defaultVelocity.rotate(this.angle));
    }
}
