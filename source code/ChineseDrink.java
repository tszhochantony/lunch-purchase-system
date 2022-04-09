import java.util.HashMap;
import java.util.ArrayList;
//sub class of Drink
public class ChineseDrink extends Drink{
    private static HashMap<String, String> chineseDrink = new HashMap<String, String>(); //store all drink name and keyword belong to chinese menu    
    public ChineseDrink(){
        //initialize
        chineseDrink.put("t","Oolong tea");
    }
    
    public ArrayList<String> getDrinkName(){return new ArrayList<>(chineseDrink.values());}// return all drink name

    public HashMap<String, String> getDrinkList(){return chineseDrink;}     //return all drink name and keyword
}