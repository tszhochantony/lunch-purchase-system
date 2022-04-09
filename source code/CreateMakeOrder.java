public class CreateMakeOrder implements CommandFactory{
    public Command createCommand(){
        return new MakeOrder();
    }
}

