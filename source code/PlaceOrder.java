import java.util.LinkedList;
import java.util.HashMap;
public abstract class PlaceOrder{
    private boolean check; //use on checking command is correct or not
    private static LinkedList<OrderRecord.Memento> orderRecordList = new LinkedList<OrderRecord.Memento>();// store all memento reference
    private static OrderRecord or = new OrderRecord();  //object reference
    protected MessageCreater mc;    //object reference
    protected Menu m;   //object reference
    protected String[] order = new String[6];    //store each order infromation
    //excute those process when user place order
    public final void placeOrder(String type){
        if(setType(type)){ //check available count and record the type
            setMenu();
            setMainDish(type);
            setSideDish();
            setDrink();
            setStaffNumber();
            setLocation();
            setOrder();
            System.out.println("Order Placed\n");
            sell(type);
        }
    }
    //check available count and record the type
    private boolean setType(String type){
        check = false; //initialize
        if(Menu.getCount(type)>0){//record the type when that type of menu available count>0
            order[0] = type;
            check = true;
        }
        else{
            System.out.println("Sold Out!\n");
        }
        return check;
    }

    private void setMainDish(String type){order[3] = Menu.getMainDish(type);} //get main dish name and set in order

    protected abstract void setMenu();  //set relevant menu to find side dish and drink

    private void setSideDish(){
        SideDish sd = m.getSDList();
        HashMap<String, String> map = sd.getSideDish();
        mc = new MessageCreater(sd.getSideDish());//get side dish information from relevant class
        System.out.print("Select Side Dish: ");
        String message = mc.getMessage(sd.getSDMark());//create message for request user select one type of side dish
        order[4] = (sd.selectSideDish(Checker.commandCheck(message,map))) + " & " + sd.getSoup();//check user input correct or not and record
    }

    private void setDrink(){//get drink name and set in order
        check = false;  //initialize
        Drink d = m.getDrinkList(); //get Drink object reference from sub clsss
        mc = new MessageCreater(d.getDrinkList(),Drink.getDrinkType()); //create the object reference to MessageCreater
        System.out.print("Select Drink: ");
        String message = mc.getMessage(" or "); //create the message include command and meaning of each command
        while(!check){
            System.out.print(message);//show message
            check = d.checkKey(Scan.kb.nextLine()); //check input is correct command or not,if yes exit this loop
            if(!check){
                System.out.println("wrong command!input again");
            }
        }
        order[5] = d.getDrink(); //record the drink selected by user
    }

    private void setStaffNumber(){ 
        order[1] = Checker.integerCheck("Staff Number");//check staff nuber input from user is integer or not and record it if correct
    }

    private void setLocation(){order[2] = Checker.integerCheck("Office Location");} //check location input from user is integer or not and record it if correct

    private void setOrder(){ //when all necessary reocrd was setted,store inside the map
        orderRecordList.add(OrderRecord.createMemento(order));
        OrderRecord.addOrder(order);      
    }   

    private void sell(String type){Menu.changeCount(type,-1);}  //change available count when order was sold

    public static void cancelOrder(){ //cancel order by input staff number
        //initialize
        boolean state = true;   //use to check the staff number 
        boolean hasOrder = false; //check does the staff number input from user is in the list or not 
        LinkedList<Integer> index = or.getIndex();  //get the list that store all canceled or completed memento reference index
        OrderRecord.clearOrders();  //clear order list
        String input = Checker.integerCheck("Staff Number");  //request user input a staff number that they want to cancel
        for(int i=0;i<orderRecordList.size();i++){ //restore order from first memento
            for(int y=0;y<index.size();y++){ //check the index of orderRecord list is canceled or completed
                if(i==index.get(y)){//if yes,check next index again
                    i++;    
                    y=0;
                }
            }
            if(i<orderRecordList.size()){
                state = OrderRecord.checkMemento(input,orderRecordList.get(i)); //check staff number store in that memento is same as user input or not
                if(!state){ //restore in order list when not equal to user input
                    OrderRecord.reAddOrder(orderRecordList.get(i));
                }
                else{//do not restore in order list and remove that memento object when equal to user input
                    OrderRecord.showDeleteOrder(orderRecordList.get(i),+1);     //show which order had been deleted and +1 to available count of relevant menu
                    System.out.println("");
                    or.addIndex(i); //mark index as canceled
                    hasOrder = true;
                    System.out.println("Order Cancelled");
                }
            }
        }
        if(!hasOrder){
            System.out.println("Order not found!");
        }
        System.out.println("");
    }

    public static void completeOrder(){ //remove first order when order is complete
        LinkedList<Integer> index = or.getIndex(); //get the list that store all canceled or completed memento reference index
        if(OrderRecord.getOrders().size()>0){ //do when at least one order was placed
            int smallsetIndex = 0; 
            for(int i=0;i<index.size();i++){ //check the smallest index that is not canceled or completed
                if(smallsetIndex==index.get(i)){// if canceled or completed,smallest +1 and do it again
                    smallsetIndex++;
                    i=0;
                }
            }
            if(smallsetIndex<orderRecordList.size()){
                or.addIndex(smallsetIndex); //mark smallest index as completed
                OrderRecord.removeFirstOrder(); //remove first order on the list
                System.out.println("\nComplete Order");
                OrderRecord.showDeleteOrder(orderRecordList.get(smallsetIndex),0);  //show which order had been completed
                System.out.println("\nOrder marked as done\n");
            }
            else{
                System.out.println("No any order!");
                System.out.println("");
            }
        }
        else{
            System.out.println("\nNo any Order!\n");
        }
    }

    public static void restoreOrder(int number){    //restore order for reverse function
        int count = or.removeIndex();   //remove latest index which mark as completed or canceled
        OrderRecord.showDeleteOrder(orderRecordList.get(count),number);     //show which order had been retored
        LinkedList<Integer> index = or.getIndex();  //get the list that store all canceled or completed memento reference index
        OrderRecord.clearOrders();  //rearrange the order list
        for(int x=0;x<orderRecordList.size();x++){ //restore order from first memento
            for(int y=0;y<index.size();y++){    //check the index of orderRecord list is canceled or completed
                if(x==index.get(y)){
                    x++;
                    y=0;
                }
            }
            OrderRecord.reAddOrder(orderRecordList.get(x));
        }
    }

    public static void removeOrderRecord(){ //remove last memento reference when reverse place order function
        LinkedList<OrderRecord.Memento> od = orderRecordList;
        od.removeLast();
        orderRecordList = od;
    }
}