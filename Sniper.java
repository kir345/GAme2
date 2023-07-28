
public class Sniper extends BaseShooter{
    public Sniper( String name,
                        int health, int attack, int defense, int speed,
                        int damageMin, int damageMax, int posX, int posY, int ammo ) {
        super( name, health, attack, defense, speed, damageMin, damageMax, posX, posY, ammo );
    }


    public Sniper( String name, int posX, int posY ) {
        this( name, 10, 6, 3, 4, 2, 3, posX, posY, 16 );
    }

}
