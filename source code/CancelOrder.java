public class CancelOrder implements Command{
    public void excute(){
        PlaceOrder.cancelOrder();  //excute
    }
    public boolean unExcute(){
        PlaceOrder.restoreOrder(-1); //restore the order which is canceled and count of that type of menu +1
        System.out.println("cancel order reversed");
        System.out.println("");
        return true;//check this command can undo or not
    }
}