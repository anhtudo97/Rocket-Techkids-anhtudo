package game.player;

import base.GameObject;
import base.Vector2D;
import game.Particle.Particle;
import game.enemy.Enemy;
import game.player.Expolosion.Expolosion;
import physic.*;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody, HitObject {

    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Player() {
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );

        this.boxCollider = new BoxCollider(20, 16);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();

        this.runHitObject = new RunHitObject(Enemy.class);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);

        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        this.runHitObject.run(this);

        Particle.effectSmoke(this.position,this.playerMove.velocity.normalize().multiply(-2),11,11,Color.ORANGE,5,15);
    }

    public void getHit(GameObject gameObject) {
        this.isAlive = false;
        Expolosion expolosion = new Expolosion();
        expolosion.position = this.position;
        expolosion.run();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
