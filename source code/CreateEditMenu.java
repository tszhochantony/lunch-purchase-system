public class CreateEditMenu implements CommandFactory{
    public Command createCommand(){
        return new EditMenu();
    }
}

