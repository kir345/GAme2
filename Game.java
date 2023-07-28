
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

        public static List<BaseHero> team1 = new ArrayList<>();
        
        public static List<BaseHero> team2 = new ArrayList<>();
    
        public static List<BaseHero> allTeam = new ArrayList<>();
        
    public static void main( String[] args ) {
        ArrayList<BaseHero> blackTeam = getTeam( 10, "black", 10 );
        ArrayList<BaseHero> whiteTeam = getTeam( 10, "white", 1 );
        ArrayList<BaseHero> allHeroes = new ArrayList<>();
        allHeroes.addAll( blackTeam );
        allHeroes.addAll( whiteTeam );

        System.out.println( "\nHeroes sorted by speed" );
        sort( allHeroes );
        allHeroes.forEach( n -> {
            if ( n.state != -1 ) {
                System.out.print( n );
            }
        } );

        System.out.println( "\n" );

        for ( BaseHero hero: allHeroes ) {
            if ( whiteTeam.contains( hero ) )
                hero.doStep( blackTeam );
            else
                hero.doStep( whiteTeam );
        }

        System.out.println( "\nHeroes after Battle round: (погибшие удалены)" );
        allHeroes.forEach( n -> {
            if ( n.state != -1 ) {
                System.out.print( n );
            }
        } );

        System.out.println( "\n" );

     
        for (int i = 0; i < 10; i++){
            switch(new Random().nextInt()){
                case 0:
                    team1.add( new Farmer (getName(), 1, i));
                    break;
                case 1:
                    team1.add(new Rogue ( getName(), 1, i));
                    break;
                case 2:
                    team1.add(new Sniper ( getName(), 1, i ));
                    break;
                case 3:
                    team1.add(new Warlock ( getName(), 1, i ));
                    break;
            }
        }
            for(int i = 0; i < 10; i++){
                switch(new Random().nextInt()){
                case 4: 
                    team2.add(new Farmer ( getName(), 10, i ));
                    break;
                case 5:
                    team2.add(new Spearman ( getName(), 10, i));
                    break;
                case 6:
                    team2.add(new Crossbowman ( getName(), 10, i ));
                    break;
                case 7:
                    team2.add(new Monk ( getName(), 10, i ));
                    break;
            }
            
        }
        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort(BaseHero:: compareTo);

  

        try (Scanner in = new Scanner(System.in)) {
            while(true){

                View.view();
                in.nextLine();
                for (BaseHero hero : allTeam){
                    if (team2.contains(hero)){
                        hero.step(team1, team2);
                    }else hero.step(team1,team2);
                }
                if(isListDie(team2)){
                    System.out.println("List 2 (Blue) win");
                    break;
                }
                if(isListDie(team1)){
                    System.out.println("List 1 (Green) win");
                    break;
                }
            }
        }
    }


    private static boolean isListDie(List<BaseHero> list12) {
        return false;
    }


    static void sort( ArrayList<BaseHero> team ) {
        team.sort( new Comparator<BaseHero>() {
            @Override
            public int compare( BaseHero o1, BaseHero o2 ) {
                if ( o2.getSpeed() == o1.getSpeed() )
                    return ( int )( o2.health - o1.health );
                return o2.speed - o1.speed;
            }
        } );
    }
        
    
    public static ArrayList<BaseHero> getTeam(int groupSize, String teamName, int posY) {
        ArrayList<BaseHero> team = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = 0;
        if (teamName.equals("white")) {
            start = 0;
            end = 2;
        }
        if (teamName.equals("black")) {
            start = 0;
            end = 2;
        }
        while ( count < groupSize ) {
            switch ( new Random().nextInt( start, end ) ) {
                case 0:
                    team.add( new Crossbowman( getName(), count + 1, posY ) );
                    break;
                case 1:
                    team.add( new Farmer( getName(), count + 1, posY ) );
                    break;
            }
            count++;
        }
        return team;
    }


    private static String getName() {
        return Names.values()[ new Random().nextInt( Names.values().length ) ].toString();
    }
}