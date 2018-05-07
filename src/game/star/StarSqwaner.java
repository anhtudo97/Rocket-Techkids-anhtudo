package game.star;

import Action.Action;
import Action.WaitAction;
import Action.ActionAdapter;
import Action.SequenceAction;
import Action.RepeatAction4ever;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSqwaner extends GameObject {

    private Random random = new Random();

    public void createAction() {
        Action waitAction = new WaitAction(30);
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                Star star = GameObjectManager.instance.recycle(Star.class);
                star.position.set(1024, random.nextInt(600));
                star.velocity.set(random.nextInt(2) + 1, 0);
                return true;
            }
        };

//        Action sequenceAction = new SequenceAction(
//                waitAction,
//                createAction
//        );
//
//        Action repeateAction = new RepeatActionForever(sequenceAction);
//        this.addAction(repeateAction);
        this.addAction(
                new RepeatAction4ever(
                        new SequenceAction(
                                waitAction,
                                createAction
                        )
                )
        );
    }
}
