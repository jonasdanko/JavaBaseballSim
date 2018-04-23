public class Game {
    private Team t1;
    private Team t2;
    private int homeScore;
    private int awayScore;
    private boolean topOfInning;
    private int inning;
    private String[] t1Players = {"Curtis Granderson", "Josh Donaldson", "Justin Smoak", "Kevin Pillar", "Troy Tulo", "Russell Martin", "Marcus Stroman", "Devin Travis", "Ryan Goins"};
    private String[] t2Players = {"Jonas", "Jackson", "Rob", "Q", "Aidan", "Josh", "Nick","Orion", "Andrew", "Tyrus"};

    public Game(){
        t1 = new Team("Blue Jays", t1Players);
        t2 = new Team("Yankees", t2Players);
        homeScore = 0;
        awayScore = 0;
        t1.coinFlip(t2);
        topOfInning = true;
        inning = 0;
    }

    public void playGame(){
        while(inning<10){
            System.out.println("Inning: " + inning + " Score-> " + t1 + ": " +  homeScore + " || " + t2 + ": " + awayScore);
            if(topOfInning){
                awayScore += t1.playInning(inning);
                topOfInning = false;
            }
            else{
                homeScore += t2.playInning(inning);
                ++inning;
                topOfInning = true;
            }
        }
        System.out.println("GAME OVER!");
        System.out.println("Final Score.... " + t1 + ": " + homeScore + " || " + t2 + ": " + awayScore);
    }

}
