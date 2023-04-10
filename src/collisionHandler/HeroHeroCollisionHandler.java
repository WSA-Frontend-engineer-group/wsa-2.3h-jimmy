package collisionHandler;

import sprite.Hero;
import sprite.Sprite;

import java.util.Map;

public class HeroHeroCollisionHandler extends CollisionHandler {
    public HeroHeroCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if (Hero.class.equals(c1.getClass()) && Hero.class.equals(c2.getClass())) {
            System.out.println("Hero 與 Hero 的碰撞效果： 移動失敗");
        } else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    }

}
