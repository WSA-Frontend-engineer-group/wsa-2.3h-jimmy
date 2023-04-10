import sprite.Fire;
import sprite.Hero;
import sprite.Sprite;
import sprite.Water;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private Map<Integer, Sprite> map;

    public World() {
        init();
    }

    private void init() {
        map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            if (getRandomNumber(100)%3 == 0) {
                map.put(i, new Hero());
            } else if (getRandomNumber(300)%3 == 1) {
                map.put(i, new Fire());
            } else if (getRandomNumber(200)%3 == 2) {
                map.put(i, new Water());
            }
        }
    }

    public void autoRun() {
        while (!map.values().stream().allMatch(sprite -> Hero.class.equals(sprite.getClass()))) {
            move(getRandomNumber(30), getRandomNumber(30));
        }
    }

    private void move(int x1, int x2) {
        if (x1 < 0 || x1 > 29 || x2 < 0 || x2 > 29 || x1 == x2) {
            return;
        }

        Sprite c1 = map.get(x1);
        Sprite c2 = map.get(x2);
        if (c1 == null || c2 == null) {
            return;
        }
        System.out.printf("====== World sprite left: %d, %d -> %s, %d -> %s ======= \n", map.values().size(), x1, c1.getClass().getName(), x2, c2.getClass().getName());

        if ((Water.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass())) || (Water.class.equals(c2.getClass()) && Fire.class.equals(c1.getClass()))) {
            System.out.println("Water 與 Fire 的碰撞效果");
            System.out.println("Water 從世界中被移除");
            System.out.println("Fire 從世界中被移除。");
            map.remove(x1);
            map.remove(x2);
        } else if ((Water.class.equals(c1.getClass()) && Water.class.equals(c2.getClass()))) {
            System.out.println("Water 與 Water 的碰撞效果： 移動失敗。");
        } else if ((Fire.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass()))) {
            System.out.println("Fire 與 Fire 的碰撞效果： 移動失敗。");
        } else if (Hero.class.equals(c1.getClass()) && Fire.class.equals(c2.getClass())) {
            System.out.println("Hero 與 Fire 的碰撞效果：");
            System.out.println("Hero 生命值減少 10 滴。");
            System.out.println("Fire 從世界中被移除。");
            System.out.println("如果 c1 為 Hero，c1 移動成功。");
            c1.damage(10);
            map.remove(x2);
            map.remove(x1);
            if (c1.getHp() > 0) {
                map.put(x2, c1);
            } else {
                System.out.println("Hero 死亡。");
            }
        } else if (Hero.class.equals(c2.getClass()) && Fire.class.equals(c1.getClass())) {
            System.out.println("Hero 與 Fire 的碰撞效果：");
            System.out.println("Hero 生命值減少 10 滴。");
            System.out.println("Fire 從世界中被移除。");
            c2.damage(10);
            map.remove(x1);
            if (c2.getHp() <= 0) {
                System.out.println("Hero 死亡。");
                map.remove(x2);
            }
        } else if (Hero.class.equals(c1.getClass()) && Water.class.equals(c2.getClass())) {
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
        } else if (Hero.class.equals(c1.getClass()) && Hero.class.equals(c2.getClass())) {
            System.out.println("Hero 與 Hero 的碰撞效果： 移動失敗");
        }
    }

    public int getRandomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }

}
