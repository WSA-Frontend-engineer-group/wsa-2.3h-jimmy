package collisionHandler;

import sprite.Fire;
import sprite.Sprite;

import java.util.Map;

public class FireFireCollisionHandler extends CollisionHandler{
    public FireFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Sprite c1, Sprite c2) {
        return Fire.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass());
    }

    @Override
    public void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        System.out.println("Fire 與 Fire 的碰撞效果： 移動失敗。");
    }
}
