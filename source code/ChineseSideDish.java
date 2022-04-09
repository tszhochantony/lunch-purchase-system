import java.util.HashMap;
import java.util.ArrayList;
public class ChineseSideDish extends SideDish{
    private HashMap<String, String> chineseSideDish = new HashMap<String, String>(); //store all side dish name and keyword belong to chinese menu
    public ChineseSideDish(){
        //initialize
        chineseSideDish.put("r","rice");
    }

    public ArrayList<String> getSideDishName(){//return all side dish name
        ArrayList<String> targetList = new ArrayList<String>(chineseSideDish.values());
        return targetList;
    }

    public String selectSideDish(String key){return chineseSideDish.get(key);}

    public String getSoup(){return "chinese soup";}

    public HashMap<String, String> getSideDish(){return chineseSideDish;}

    public String getSDMark(){return ", ";}
}