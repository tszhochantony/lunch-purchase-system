public class CreateCancelOrder implements CommandFactory{
    public Command createCommand(){
        return new CancelOrder();
    }
}

