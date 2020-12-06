import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] myInventory;
        int[] opInventory;
 
        // game loop
        while (true) {
            int actionCount = in.nextInt(); // the number of spells and recipes in play
            ArrayList<Brew> brewActions = new ArrayList<>();
            ArrayList<Cast> myCastActions = new ArrayList<>();
            ArrayList<Cast> opCastActions = new ArrayList<>();
            myInventory = new int[4];
            opInventory = new int[4];
            for (int i = 0; i < actionCount; i++) {
                int actionId = in.nextInt(); // the unique ID of this spell or recipe
                String actionType = in.next(); // in the first league: BREW; later: CAST, OPPONENT_CAST, LEARN, BREW
                int delta0 = in.nextInt(); // tier-0 ingredient change
                int delta1 = in.nextInt(); // tier-1 ingredient change
                int delta2 = in.nextInt(); // tier-2 ingredient change
                int delta3 = in.nextInt(); // tier-3 ingredient change
                int price = in.nextInt(); // the price in rupees if this is a potion
                int tomeIndex = in.nextInt(); // in the first two leagues: always 0; later: the index in the tome if this is a tome spell, equal to the read-ahead tax; For brews, this is the value of the current urgency bonus
                int taxCount = in.nextInt(); // in the first two leagues: always 0; later: the amount of taxed tier-0 ingredients you gain from learning this spell; For brews, this is how many times you can still gain an urgency bonus
                boolean castable = in.nextInt() != 0; // in the first league: always 0; later: 1 if this is a castable player spell
                boolean repeatable = in.nextInt() != 0; // for the first two leagues: always 0; later: 1 if this is a repeatable player spell
                if(actionType.equals("BREW")){
                    brewActions.add(new Brew(actionId, delta0, delta1, delta2, delta3, price, myInventory));
                }else if(actionType.equals("CAST")){
                    myCastActions.add(new Cast(actionId,delta0, delta1, delta2, delta3, myInventory));
                }else if(actionType.equals("OPPONENT_CAST")){
                    opCastActions.add(new Cast(actionId,delta0, delta1, delta2, delta3, opInventory));
                }
                State.brewActions = brewActions;
                State.myCastActions = myCastActions;
                State.opCastActions = opCastActions;
            }
            for (int i = 0; i < 2; i++) {
                int inv0 = in.nextInt(); // tier-0 ingredients in inventory
                int inv1 = in.nextInt();
                int inv2 = in.nextInt();
                int inv3 = in.nextInt();
                int score = in.nextInt(); // amount of rupees
                if(i==0){
                    State.myInventory[0] = inv0;
                    State.myInventory[1] = inv1;
                    State.myInventory[2] = inv2;
                    State.myInventory[3] = inv3;
                }else if(i==1){
                    State.opInventory[0] = inv0;
                    State.opInventory[1] = inv1;
                    State.opInventory[2] = inv2;
                    State.opInventory[3] = inv3;                   
                }
            }
            for (Brew cast : opCastActions) {
                
            }
            Collections.sort(State.brewActions, (x,y)->y.price.compareTo(x.price));
            for (Brew brew : brewActions) {
                if(brew.delta0+inventory[0]>=0 && 
                    brew.delta1+inventory[1]>=0 &&
                    brew.delta2+inventory[2]>=0 &&
                    brew.delta3+inventory[3]>=0){
                        System.out.println("BREW " + String.valueOf(brew.id));
                        break;
                    }
            }
        }
    }
}
static class State{
    static ArrayList<Brew> brewActions;
    static ArrayList<Cast> myCastActions;
    static ArrayList<Cast> opCastActions;
    static Integer[] myInventory;
    static Integer[] opInventory;
}

class Brew extends Action{
    Integer id;
    Integer delta0;
    Integer delta1;
    Integer delta2;
    Integer delta3;
    Integer price;
    Integer[] inventory;
    Brew(int id, int delta0, int delta1, int delta2, int delta3, int price){
        this.id = id;
        this.delta0 = delta0;
        this.delta1 = delta1;
        this.delta2 = delta2;
        this.delta3 = delta3;
        this.price = price;
    }
    int evaluate(){
        int score = 0;
        for (int i = 0; i < 4; i++) {
            
        }
        return score;
    }
    @Override
    public String toString() {
        String val = "";
        val += String.valueOf(id);
        val += " [";
        val += String.valueOf(delta0);
        val += ", ";
        val += String.valueOf(delta1);
        val += ", ";
        val += String.valueOf(delta2);
        val += ", ";
        val += String.valueOf(delta3);
        val += "] ";
        val += String.valueOf(price);
        return val;
    }
}
class Cast extends Actions{
    Integer id;
    Integer delta0;
    Integer delta1;
    Integer delta2;
    Integer delta3;
    Cast(int id, int delta0, int delta1, int delta2, int delta3){
        this.id = id;
        this.delta0 = delta0;
        this.delta1 = delta1;
        this.delta2 = delta2;
        this.delta3 = delta3;
    }
    @Override
    public String toString() {
        String val = "";
        val += String.valueOf(id);
        val += " [";
        val += String.valueOf(delta0);
        val += ", ";
        val += String.valueOf(delta1);
        val += ", ";
        val += String.valueOf(delta2);
        val += ", ";
        val += String.valueOf(delta3);
        val += "]";
        return val;
    }
}