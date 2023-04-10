package collisionHandler;

import sprite.Hero;
import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public class HeroWaterCollisionHandler extends  CollisionHandler{
    public HeroWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if (Hero.class.equals(c1.getClass()) && Water.class.equals(c2.getClass())) {
            System.out.println("Hero 與 Water 的碰撞效果：");
            System.out.println("Hero 生命值增加 10 滴。");
            System.out.println("Water 從世界中被移除。");
            System.out.println("如果 c1 為 Hero，c1 移動成功。");
            c1.heal(10);
            map.remove(x1);
            map.remove(x2);
            map.put(x2, c1);
        } else if (Hero.class.equals(c2.getClass()) && Water.class.equals(c1.getClass())) {
            System.out.println("Hero 與 Water 的碰撞效果：");
            System.out.println("Hero 生命值增加 10 滴。");
            System.out.println("Water 從世界中被移除。");
            System.out.println("如果 c1 為 Hero，c1 移動成功。");
            c2.heal(10);
            map.remove(x1);
        }  else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    }
}
