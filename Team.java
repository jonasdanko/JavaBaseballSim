
public class Team {
    private Player[] team;
    private String teamName;
    private String homeOrAway;
    private int spotInLineup;

    public Team(String teamName, String[] playerNames){
        this.teamName = teamName;
        team = new Player[9];
        for (int i=0 ; i<9 ; ++i){
            team[i] = new Player(playerNames[i], i);
        }
        spotInLineup = 0;
    }

    public void coinFlip(Team other){
        double coin = Math.random();
        if(coin<=0.5){
            this.homeOrAway = "home";
            other.homeOrAway = "away";
        }
        else{
            this.homeOrAway = "away";
            other.homeOrAway = "home";
        }
    }

    public boolean batter(){
        if(spotInLineup>8){
            spotInLineup = 0;
        }
        boolean result = team[spotInLineup].getHit();
        if(result){
            System.out.println(team[spotInLineup].getName() + " got a hit!");
        }
        else{
            System.out.println(team[spotInLineup].getName() + " got out!");
        }
        ++spotInLineup;

        return result;
    }

    public int playInning(int inningNumber){
        int numOut = 0;
        int numOnBases = 0;
        int runsInInning = 0;
        while (numOut<3){
            System.out.println();
            if(numOnBases==4){
                ++runsInInning;
                numOnBases = 3;
            }
            System.out.println("Inning: " + inningNumber + " Out: " + numOut);
            boolean atBat = batter();
            if(atBat == true){
                ++numOnBases;
            }
            else{
                ++numOut;
            }
        }

        return runsInInning;
    }

    public String toString(){
        return teamName;
    }
}
