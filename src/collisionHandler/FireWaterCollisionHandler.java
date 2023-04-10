package collisionHandler;

import sprite.Fire;
import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public class FireWaterCollisionHandler extends CollisionHandler {
    public FireWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if ((Water.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass())) || (Water.class.equals(c2.getClass()) && Fire.class.equals(c1.getClass()))) {
            System.out.println("Water 與 Fire 的碰撞效果");
            System.out.println("Water 從世界中被移除");
            System.out.println("Fire 從世界中被移除。");
            map.remove(x1);
            map.remove(x2);
        } else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    }
}
