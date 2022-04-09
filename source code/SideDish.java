import java.util.HashMap;
import java.util.ArrayList;
public abstract class SideDish{
    public abstract ArrayList<String> getSideDishName(); //return side dish name as list

    public abstract String selectSideDish(String key);//return the value of that key from map

    public abstract String getSoup();       //return soup belong to relevant type of side dish

    public abstract HashMap<String, String> getSideDish();  //return side dish name and key belong to relevant type of side dish

    public abstract String getSDMark(); //return and(&) or or(|)
}