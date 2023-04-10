package collisionHandler;

import sprite.Sprite;

import java.util.Map;

public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public abstract void handle(Sprite c1, Sprite c2, int x1, int x2, Map<Integer, Sprite> map);
}
