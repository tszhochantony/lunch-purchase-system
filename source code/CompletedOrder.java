public class CompletedOrder implements Command{
    public void excute(){
        PlaceOrder.completeOrder(); //excute
    }
    public boolean unExcute(){
        PlaceOrder.restoreOrder(0); //restore the order which is mark as completed
        System.out.println("completed order reversed");
        System.out.println("");
        return true;//check this command can undo or not
    }
}