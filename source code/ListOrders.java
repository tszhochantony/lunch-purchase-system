public class ListOrders implements Command{
    public void excute(){
        OrderRecord.showAllOrder();  //excute
    }
    public boolean unExcute(){return false;}//check this command can undo or not
}