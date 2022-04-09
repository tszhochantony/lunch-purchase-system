public class CreateListOrders implements CommandFactory{
    public Command createCommand(){
        return new ListOrders();
    }
}

