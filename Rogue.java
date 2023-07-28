public class Rogue extends BaseHero {
    public Rogue( String name,
                   int health, int attack, int defense, int speed,
                   int damage, int posX, int posY ) {
        super( name, health, attack, defense, speed, damage, posX, posY );
    }
    public Rogue( String name, int posX, int posY  ) {
        this( name, 4, 7, 1, 1, 1, posX, posY );
    }
}
