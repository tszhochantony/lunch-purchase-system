import java.util.HashMap;
public class MakeOrder implements Command{
    private static HashMap<String, PlaceOrder> orderList = new HashMap<String, PlaceOrder>(); //store the short name of different menu as key and menu object reference 
    public MakeOrder(){
        //initialize
        orderList.put("c",new ChineseOrder());
        orderList.put("w",new WesternOrder());
    }

    public void excute(){
        if(Menu.getMenuName().size()>0){//comfirm the menu was setted already
            System.out.println("\nPlace Order:");
            MessageCreater mc = new MessageCreater(Menu.getMenuName()); //create the object reference to create message
            String key = Checker.commandCheck(mc.getMessage(" or "),Menu.getMenuName()); //check the input from user is correct or not 
            PlaceOrder o = orderList.get(key); //use input as key to find relevant object reference 
            o.placeOrder(key); //excute
        }        
        else{
            System.out.println("No menu is setted!");
        }
    }
    
    public boolean unExcute(){
        OrderRecord.removeLastOrder(); //remove the last order on the list
        System.out.println("make order reversed");
        System.out.println("");
        return true;//check this command can undo or not
    }
}