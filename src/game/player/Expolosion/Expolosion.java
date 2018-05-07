package game.player.Expolosion;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.Particle.Particle;
import renderer.ImageRenderer;

public class Expolosion extends GameObject {

    @Override
    public void run() {
        super.run();
        Vector2D vector2D = new Vector2D(4, 0);
            for (int i = 0; i < 8; i++) {
                PlayerDieAni playerDieAni = GameObjectManager.instance.recycle(PlayerDieAni.class);
                playerDieAni.position.set(this.position);
                Vector2D rotate = vector2D.rotate(i * 45);
                playerDieAni.velocity.set(rotate);
            }
    }

    private static FrameCounter frameCounter;

//    public void effectDie(Vector2D position, Vector2D velocity, int width, int height, Color color, int timeintervalCreate, int timeIntervalChange) {
//        if (frameCounter == null) {
//            frameCounter = new FrameCounter(timeintervalCreate);
//        }
//        if (frameCounter.run()) {
//            Vector2D vector2D = new Vector2D(4, 0);
//            if (!GameObjectManager.instance.findPlayer().isAlive)
//                for (int i = 0; i < 8; i++) {
//                    PlayerDieAni playerDieAni = GameObjectManager.instance.recycle(PlayerDieAni.class);
//                    playerDieAni.position.set(this.position);
//                    Vector2D rotate = vector2D.rotate(i * 45);
//                    playerDieAni.velocity.set(rotate);
//                }
//            Particle particle = GameObjectManager.instance.recycle(Particle.class);
//            ImageRenderer imageRenderer = new ImageRenderer("resources/images/circle.png", width, height, color, true, timeIntervalChange);
//            imageRenderer.deltaSize = 1;
//            particle.renderer = imageRenderer;
//            particle.position.set(position);
//            particle.velocity.set(velocity);
//            frameCounter.reset();
//        }
//    }
}
