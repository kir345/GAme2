public class Warlock extends BaseHero {
    public Warlock( String name,
                   int health, int attack, int defense, int speed,
                   int damage, int posX, int posY ) {
        super( name, health, attack, defense, speed, damage, posX, posY );
    }
    public Warlock( String name, int posX, int posY  ) {
        this( name, 7, 3, 3, 1, 1, posX, posY );
    }
}


