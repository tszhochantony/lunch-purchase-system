import java.util.HashMap;
public class EditMenu implements Command{
    private HashMap<String, Menu> menuList = new HashMap<String, Menu>();  //store the short name of different menu as key and menu object reference 
    public EditMenu(){
        //initialize
        menuList.put("c",new ChineseMenu());
        menuList.put("w",new WesternMenu());
    }

    public void excute(){
        System.out.println("\nEdit Menu:"); //request user select type of menu  
        MessageCreater mc = new MessageCreater(Menu.getMenuName()); //create the object reference to MessageCreater
        String key = Checker.commandCheck(mc.getMessage(" or "),Menu.getMenuName()); //check the input from user is correct or not 
        Menu m = menuList.get(key);  //use input as key to find relevant object reference  
        m.editMenu();   //excute 
    }
    
    public boolean unExcute(){
        Menu.removeMenu(); //clear the menu edit recently.
        System.out.println("edit menu reversed");
        System.out.println("");
        return true;    //check this command can undo or not
    }
}