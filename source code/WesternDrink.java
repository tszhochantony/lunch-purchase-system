import java.util.HashMap;
import java.util.ArrayList;
//sub class of Drink
public class WesternDrink extends Drink{
    private static HashMap<String, String> westernDrink = new HashMap<String, String>(); //store all drink name and keyword belong to western menu
    public WesternDrink(){
        //initialize
        westernDrink.put("t","tea");
        westernDrink.put("c","coffee");
    }

    public ArrayList<String> getDrinkName(){return new ArrayList<String>(westernDrink.values());}// return all drink name

    public HashMap<String, String> getDrinkList(){return westernDrink;} //return all drink name and keyword
}