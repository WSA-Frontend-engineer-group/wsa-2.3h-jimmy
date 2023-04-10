import collisionHandler.CollisionHandler;
import sprite.Fire;
import sprite.Hero;
import sprite.Sprite;
import sprite.Water;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private Map<Integer, Sprite> map;

    private CollisionHandler handler;

    public World(CollisionHandler handler) {
        this.handler = handler;
        init();
    }

    private void init() {
        map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            if (getRandomNumber(100)%3 == 0) {
                map.put(i, new Hero());
            } else if (getRandomNumber(300)%3 == 1) {
                map.put(i, new Fire());
            } else if (getRandomNumber(200)%3 == 2) {
                map.put(i, new Water());
            }
        }
    }

    public void autoRun() {
        while (!map.values().stream().allMatch(sprite -> Hero.class.equals(sprite.getClass()))) {
            move(getRandomNumber(30), getRandomNumber(30));
        }
    }

    private void move(int x1, int x2) {
        if (x1 < 0 || x1 > 29 || x2 < 0 || x2 > 29 || x1 == x2) {
            return;
        }

        Sprite c1 = map.get(x1);
        Sprite c2 = map.get(x2);
        if (c1 == null || c2 == null) {
            return;
        }
        System.out.printf("====== World sprite left: %d, %d -> %s, %d -> %s ======= \n", map.values().size(), x1, c1.getClass().getName(), x2, c2.getClass().getName());

        handler.handle(c1, c2, x1, x2, map);
    }

    public int getRandomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }

}
