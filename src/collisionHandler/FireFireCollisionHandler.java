package collisionHandler;

import sprite.Fire;
import sprite.Sprite;

import java.util.Map;

public class FireFireCollisionHandler extends CollisionHandler{
    public FireFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if ((Fire.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass()))) {
            System.out.println("Fire 與 Fire 的碰撞效果： 移動失敗。");
        } else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    }
}
