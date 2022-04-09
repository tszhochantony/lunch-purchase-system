import java.util.HashMap;
public class Client{
    public static void main(String[] args){
        Invoker i = new Invoker();
        HashMap<String, CommandFactory> map = new HashMap<String, CommandFactory>();//store the keywords and factory object reference 
        //initialize
        map.put("e",new CreateEditMenu());
        map.put("s",new CreateShowMenu());
        map.put("p",new CreateMakeOrder());
        map.put("c",new CreateCancelOrder());
        map.put("l",new CreateListOrders());
        map.put("d",new CreateCompletedOrder());
        //keep running before user enter command "q" to exit
        for(;;){
            //show all command and explain the function
            System.out.println("Please enter command:" +
                " [e | s | p | c | l | d | r | q]");
            System.out.println("e = Edit menu, s = Show menu, p = Place order, " +
                               "c = Cancel order,");
            System.out.println("l = List orders, d = order is Done,r = reverse command, q = Quit");
            String choice = Scan.kb.nextLine();
            //confirm user input is not empty
            if(map.get(choice)!= null){
                CommandFactory cf = map.get(choice);  //use input as key to find relevant object reference       
                i.setCommand(cf.createCommand());     //get command from connandFactory and set command in invoker 
                i.invoke();                           //invoke command
            }
            else if(choice.equals("q")){
                System.out.println("See you next time!");
                System.exit(0);
            }
            else if(choice.equals("r")){
                i.undo();  
            }
            else{
                System.out.println("Wrong command,input again");
            }
        }
    }
}