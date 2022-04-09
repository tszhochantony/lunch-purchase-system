public class CreateCompletedOrder implements CommandFactory{
    public Command createCommand(){
        return new CompletedOrder();
    }
}