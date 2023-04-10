package collisionHandler;

import sprite.Fire;
import sprite.Hero;
import sprite.Sprite;

import java.util.Map;

public class HeroFireCollisionHandler extends CollisionHandler{
    public HeroFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    public boolean match(Sprite c1, Sprite c2) {
        return (Hero.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass())) || (Hero.class.equals(c2.getClass()) && Fire.class.equals(c1.getClass()));
    }

    @Override
    public void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        System.out.println("Hero 與 Fire 的碰撞效果：");
        System.out.println("Hero 生命值減少 10 滴。");
        System.out.println("Fire 從世界中被移除。");
        map.remove(x2);
        if (Hero.class.equals(c1.getClass())) {
            System.out.println("如果 c1 為 Hero，c1 移動成功。");
            c1.damage(10);
            if (c2.getHp() < 0) {
                map.remove(x1);
                System.out.println("Hero 死亡。");
            } else {
                map.remove(x1);
                map.put(x2, c1);
            }
        } else {
            c2.damage(10);
            if (c2.getHp() < 0) {
                map.remove(x1);
                System.out.println("Hero 死亡。");
            }
        }
    }
}
