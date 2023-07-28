public class Monk extends BaseHero{
    public Monk( String name,
                   int health, int attack, int defense, int speed,
                   int damage, int posX, int posY ) {
        super( name, health, attack, defense, speed, damage, posX, posY );
    }
    public Monk( String name, int posX, int posY  ) {
        this( name, 6, 3, 2, 4, 1, posX, posY );
    }
}
