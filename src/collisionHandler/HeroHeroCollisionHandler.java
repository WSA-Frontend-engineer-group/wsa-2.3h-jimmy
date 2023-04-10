package collisionHandler;

import sprite.Hero;
import sprite.Sprite;

import java.util.Map;

public class HeroHeroCollisionHandler extends CollisionHandler {
    public HeroHeroCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Sprite c1, Sprite c2) {
        return Hero.class.equals(c1.getClass()) && Hero.class.equals(c2.getClass());
    }

    @Override
    public void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        System.out.println("Hero 與 Hero 的碰撞效果： 移動失敗");
    }

}
