import java.util.HashMap;
//abstract class for record menu information
public abstract class Menu{ 
    protected static int menuSize=0;
    protected String title;  //store menu name
    protected String key;    //store menu short name(key word)
    protected String[] setMenu = new String[6]; //use to store the menu information when user edit
    protected static MessageCreater mc = new MessageCreater();
    protected static HashMap<String, String> menuName = new HashMap<String, String>(); //store menu name and their key word
    protected static HashMap<String, String[]> menu = new HashMap<String, String[]>(); //store menu information(e.g. price,count)
    //excute those process when user edit menu
    public final void editMenu() {
        setTitle();
        setMainDish();
        setSideDish();
        setDrink();
        setPrice();
        setCount();
        setMenu();
        System.out.println("Menu Updated\n");
    }

    private void setTitle(){setMenu[0] = title;} //record the title of the menu

    private void setMainDish(){
        System.out.print("Enter main dish:");
        setMenu[1] = (Scan.kb.nextLine());      //record the main dish input from user
    }   

    private void setSideDish(){
        SideDish sd = getSDList(); //create object reference to class SideDish
        setMenu[2] = MessageCreater.createMessage(sd.getSideDishName(),sd.getSDMark()) + ", " + title + " soup"; //record all side dish from relevant type of sidedish which user selected
    }

    private void setDrink(){
        Drink d = getDrinkList(); //create object reference to class Drink
        setMenu[3] = MessageCreater.createMessage(d.getDrinkName()," or ");//record all drink from relevant type of drink which user selected
    } 

    private void setPrice(){setMenu[4] = Checker.integerCheck("price");} //record the price input from user

    private void setCount(){setMenu[5] = Checker.integerCheck("available count");} //record the available count input from user

    private void setMenu() {//when all necessary reocrd was setted,store inside the map
        menu.put(key,setMenu);
        menuSize++;
    } 

    public abstract SideDish getSDList();  //abstract method for get all side dish belong to relevant menu

    public abstract Drink getDrinkList();  //abstract method for get all drink belong to relevant menu

    public static HashMap<String, String> getMenuName(){return menuName;} //return menu name and keyword
    //return the main dish of relevant menu
    public static String getMainDish(String type){
        String[] result = menu.get(type);
        return result[1];
    }
    //return the count of relevant menu
    public static int getCount(String type){
        String[] set = menu.get(type);
        return Integer.parseInt(set[5]);
    }
    //change the available count  of relevant menu when order was sold or cancel
    public static void changeCount(String type,int number){
        int count = getCount(type)+number ;
        String[] set = menu.get(type);
        set[5] = Integer.toString(count);
        menu.put(type,set);
    }
    //method use for undo function
    public static void removeMenu(){
        menuSize--;
    }
    //display all menu infromation
    public static void showMenu(){
        int i=0;
        System.out.println();
        for(String[] showMenu : menu.values()) {               
            if(i<menuSize){//show when menu is setted
                System.out.println(showMenu[0] + " style Business Set Lunch");
                System.out.println("main dish: " + showMenu[1]);
                System.out.println("side dish: " + showMenu[2]);
                System.out.println("drink: " + showMenu[3]);
                System.out.println("price: " + showMenu[4]);
                System.out.println("available count: " + showMenu[5]+"\n");
            }
            i++;
        }
    }
}