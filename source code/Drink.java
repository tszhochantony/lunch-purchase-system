import java.util.HashMap;
import java.util.ArrayList;
public abstract class Drink{
    protected static HashMap<String, String> hotIce = new HashMap<String, String>();  //store all type of drink
    protected static HashMap<String, String> drinkList = new HashMap<String, String>(); //store all drink name and keyword
    private String drinkName;   //store the drink name with type(hot or ice)    
    public Drink(){
        //initialize the type of drink
        hotIce.put("h","hot");
        hotIce.put("i","iced");
    }

    public boolean checkKey(String key){ //check the keyword have relevant record or not
        boolean check = false;
        drinkList = getDrinkList();
        String[] result = key.split("");
        try{       
            if(hotIce.get(result[0])!=null&&drinkList.get(result[1])!=null){//get drink name when found relevant record
                drinkName = hotIce.get(result[0]) + " " + drinkList.get(result[1]);
                check=true;
            }           
        }
        catch(IndexOutOfBoundsException ioe){
        }
        return check;
    }

    public static HashMap<String, String> getDrinkType(){return hotIce;}  //return all type of drink
    public String getDrink(){return drinkName;}  //return drink name with the type
    public abstract ArrayList<String> getDrinkName();//return drink name list
    public abstract HashMap<String, String> getDrinkList();//return drink name and keyword list
}