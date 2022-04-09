//sub class of Menu
public class ChineseMenu extends Menu{    
    public ChineseMenu(){
        //initialize the keys and title as ChineseMenu
        key = "c";
        title = "Chinese";
        menuName.put(key,title);
    }

    public SideDish getSDList(){    //return chinese side dish list
        return new ChineseSideDish();
    }
    
    public Drink getDrinkList(){    //return chinese drink list
        return new ChineseDrink();
    }
}