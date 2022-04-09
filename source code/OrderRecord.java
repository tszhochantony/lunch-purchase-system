import java.util.LinkedList;
public class OrderRecord{
    private static LinkedList<String[]> orders = new LinkedList<String[]>(); //store all order
    private LinkedList<Integer> index = new LinkedList<Integer>();  //store all canceled or completed memento reference index
    public static Memento createMemento(String[] order){return new Memento(order);} //return memento object reference

    public static boolean checkMemento(String input,Memento m){ //check input is as same as the staff number saved at memento or not
        return input.equals(m.getStaffNumber());
    }

    public static LinkedList<String[]> getOrders(){return orders;}  //return all order

    public static void addOrder(String[] order){    //add new order when all necessary information was setted
        orders.add(new String[5]);
        orders.set(orders.size()-1,order); 
    }

    public static void reAddOrder(Memento m){ //restore order
        orders.add(new String[5]);
        orders.set(orders.size()-1,m.getOrder()); 
    }

    public static void clearOrders(){ //clear all order in the list
        orders.clear(); 
    }

    public static void removeLastOrder(){ //remove last order in the list
        String[] order = orders.removeLast();
        PlaceOrder.removeOrderRecord(); //remove last memento reference
        Menu.changeCount(order[0],+1);  //update available count
    }

    public static void removeFirstOrder(){ //remove first order in the list
        if(orders.size()>0){
            orders.removeFirst();
        }
        else{
            System.out.println("No any order!");
            System.out.println("");
        }
    }

    public LinkedList<Integer> getIndex(){  //get index
        return index;
    }

    public void addIndex(int number){   //add index
        index.add(number);
    }

    public int removeIndex(){   //remove last index store at the list
        return index.removeLast();
    }

    public static void showAllOrder(){//show all order
        System.out.println("\nOutstanding Orders");
        for(String[] showOrder : orders){
            showOrder(showOrder);
            System.out.println();
        }
        System.out.println();
    }

    public static void showDeleteOrder(Memento m,int count){ //show deleted order information
        Menu.changeCount(m.getType(),count);    //update available count
        showOrder(m.getOrder());
        System.out.println("");
    }

    public static void showOrder(String[] showOrder){//show one order include all information
        for(int i=0;i<6;i++){
            System.out.print(showOrder[i]);
            if(i==0){
                System.out.print(": ");
            }
            else if(i>0&&i<5){
                System.out.print(", ");
            }
        }
    }

    public static class Memento{ //memento class for store each order information
        private final String[] order;
        private Memento(String[] order){
            this.order = order;
        }

        private String[] getOrder(){
            return order;
        }

        private String getType(){
            return order[0];
        }

        private String getStaffNumber(){
            return order[1];
        }

        private String getLocation(){
            return order[2];
        }

        private String getMainDish(){
            return order[3];
        }

        private String getSideDish(){
            return order[4];
        }

        private String getDrink(){
            return order[5];
        }
    }
}