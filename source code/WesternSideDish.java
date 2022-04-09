import java.util.HashMap;
import java.util.ArrayList;
public class WesternSideDish extends SideDish{
    private HashMap<String, String> westernSideDish = new HashMap<String, String>();  //store all side dish name and keyword belong to western menu
    public WesternSideDish(){
        //initialize
        westernSideDish.put("r","rice");
        westernSideDish.put("s","spaghetti");
        westernSideDish.put("f","french fries");
    }

    public ArrayList<String> getSideDishName(){ //return all side dish name
        ArrayList<String> targetList = new ArrayList<String>(westernSideDish.values());
        return targetList;
    }

    public String selectSideDish(String key){return westernSideDish.get(key);}

    public String getSoup(){return "western soup";}  

    public HashMap<String, String> getSideDish(){return westernSideDish;}

    public String getSDMark(){return " or ";}
}