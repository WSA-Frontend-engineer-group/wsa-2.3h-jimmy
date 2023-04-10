package sprite;

public class Hero extends Sprite {

    public Hero() {
        super(30);
    }

    @Override
    public void heal(int hp) {
        setHp(getHp() + hp);
    }

    @Override
    public void damage(int hp) {
        setHp(getHp() - hp);
    }
}
