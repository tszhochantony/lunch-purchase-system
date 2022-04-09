//sub class of Menu
public class WesternMenu extends Menu{
    public WesternMenu(){
        //initialize the keys and title as WesternMenu
        key = "w";
        title = "Western";
        menuName.put(key,title);
    }

    public SideDish getSDList(){ //return Western side dish list
        return new WesternSideDish();
    }
    
    public Drink getDrinkList(){ //return Western drink list
        return new WesternDrink();
    }
}