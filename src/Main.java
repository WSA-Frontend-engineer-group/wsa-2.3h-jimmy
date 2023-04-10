import collisionHandler.*;

public class Main {
    public static void main(String[] args) {
        World world = new World(new FireWaterCollisionHandler(new WaterWaterCollisionHandler(new FireFireCollisionHandler(new HeroFireCollisionHandler(new HeroWaterCollisionHandler(new HeroHeroCollisionHandler(null)))))));
        world.autoRun();
    }
}