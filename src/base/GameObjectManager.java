package base;

import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);

    }

    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T gameObject = (T) this.list
                .stream()
                .filter(gameObject1 -> !gameObject1.isAlive)
                .filter(object -> cls.isInstance(object))
                .findFirst()
                .orElse(null);
        if (gameObject != null) {
            gameObject.isAlive = true;
        } else {
            try {
                gameObject = cls.getConstructor().newInstance();
                this.add(gameObject);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gameObject;
    }

    public <T extends GameObject> T checkCollison(BoxCollider boxCollider, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof PhysicBody)
                .filter(gameObject -> {
                    BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
                    return boxCollider.checkBoxCollider(other);
                })
                .findFirst()
                .orElse(null);
    }


}
