package Action;

import base.GameObject;

import java.util.Arrays;
import java.util.List;

public class SequenceAction implements Action {
    private List<Action> actions;
    private int currentIndex = 0;

    public SequenceAction(Action... actions) {
        this.actions = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject owner) {
        Action action = this.actions.get(this.currentIndex);
        if(action.run(owner)){
            if(currentIndex == this.actions.size()-1){
                return  true;
            }else {
                currentIndex++;
                return false;
            }
        }
        return false;
    }

    @Override
    public void reset() {
        this.actions.forEach(action -> action.reset());
        this.currentIndex = 0;
    }
}
