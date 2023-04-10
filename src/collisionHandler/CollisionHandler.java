package collisionHandler;

import sprite.Hero;
import sprite.Sprite;
import sprite.Water;

import java.util.Map;

public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map) {
        if (match(c1, c2)) {
           doHandling(c1, c2, x1, x2, map);
        }  else if (next != null) {
            next.handle(c1, c2, x1, x2, map);
        }
    };

    public abstract boolean match(Sprite c1, Sprite c2);
    public abstract void doHandling(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map);
}
