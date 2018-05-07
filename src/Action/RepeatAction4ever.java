package Action;

import base.GameObject;

public class RepeatAction4ever implements Action{
    private Action action;

    public RepeatAction4ever(Action action) {
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
        if(this.action.run(owner)){
            this.action.reset();
        }
        return false;
    }

    @Override
    public void reset() {

    }
}
