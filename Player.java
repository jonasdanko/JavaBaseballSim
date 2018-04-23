import java.util.Random;

public class Player {
    private String name;
    private int position;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
    }

    public boolean getHit(){
        Random random = new Random();
        int chanceToGetHit = random.nextInt(100);
        if(chanceToGetHit<=50){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName(){
        return name;
    }
}
