package collisionHandler;

import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public class WaterWaterCollisionHandler extends CollisionHandler{
    public WaterWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Sprite c1, Sprite c2) {
        return Water.class.equals(c1.getClass()) && Water.class.equals(c2.getClass());
    }

    @Override
    public void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        System.out.println("Water 與 Water 的碰撞效果： 移動失敗。");
    }
}
