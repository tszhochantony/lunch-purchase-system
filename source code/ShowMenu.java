public class ShowMenu implements Command{
    public void excute(){
        Menu.showMenu(); //excute
    }
    public boolean unExcute(){
        return false;//check this command can undo or not
    }
}