package collisionHandler;

import sprite.Hero;
import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public class HeroWaterCollisionHandler extends CollisionHandler{
    public HeroWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Sprite c1, Sprite c2) {
        return (Hero.class.equals(c1.getClass()) && Water.class.equals(c2.getClass())) || (Hero.class.equals(c2.getClass()) && Water.class.equals(c1.getClass()));
    }

    @Override
    public void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        System.out.println("Hero 與 Water 的碰撞效果：");
        System.out.println("Hero 生命值增加 10 滴。");
        System.out.println("Water 從世界中被移除。");
        map.remove(x2);
        if (Hero.class.equals(c1.getClass())) {
            c1.heal(10);
            System.out.println("如果 c1 為 Hero，c1 移動成功。");
            map.remove(x1);
            map.put(x2, c1);
        } else if (Hero.class.equals(c2.getClass())) {
            c2.heal(10);
        }
    }
}
