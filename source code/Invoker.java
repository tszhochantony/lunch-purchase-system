//stores a Command object and invoke the execution upon request by the Client
import java.util.LinkedList;
public class Invoker{
    private Command command;    //store the command object and invoke
    private LinkedList<Command> cList = new LinkedList<Command>();//store allthe command object selected by client
    public void setCommand(Command command){
        this.command = command;
        cList.add(command); //record the command input from user
    }

    public void invoke(){
        command.excute();   //excute relevant command 
    } 

    public void undo(){ 
        if(cList.size()>0){ //check when user was input command already
            command = cList.removeLast();   //remove recent command input from user
            while(!command.unExcute()){     //check that command can undo or not
                command = cList.removeLast();
            }
        }
        else{
            System.out.println("No command can reverse!");
            System.out.println("");
        }
    }
}