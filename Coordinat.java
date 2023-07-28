public class Coordinat {
    public int posX;
    public int posY;

    public Coordinat( int x, int y ) {
        this.posX = x;
        this.posY = y;
    }

    public Coordinat() {
        this( 0, 0 );
    }


    public String toString() {
        return String.format( "(%d, %d)", this.posX, this.posY );
    }

    protected double getDistance ( Coordinat enemy ) {
        return Math.sqrt( Math.pow( posX - enemy.posX, 2 ) + Math.pow( posY - enemy.posY, 2 ) );
    }
}

