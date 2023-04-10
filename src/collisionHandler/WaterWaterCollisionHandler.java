package collisionHandler;

import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public class WaterWaterCollisionHandler extends CollisionHandler{
    public WaterWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if ((Water.class.equals(c1.getClass()) && Water.class.equals(c2.getClass()))) {
            System.out.println("Water 與 Water 的碰撞效果： 移動失敗。");
        } else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    }
}
