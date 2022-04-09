import java.util.HashMap;
public class Checker{
    //initialize
    private static String input="";
    private static int number;  
    private static boolean check;
    //method for checking the input is integer number or not
    public static String integerCheck(String name){        
        check = false;
        while(!check){
            try{
                System.out.print("Enter " + name + ": ");
                input = Scan.kb.nextLine();
                number = Integer.parseInt(input);  //check input             
                check = true;  //exit the while loop when correct
            }catch(NumberFormatException e){ //catch when input can not parse to integer
                System.out.println("Wrong " + name +  "! please input number");
            }
        }
        return input; //return when user input is integer number
    }
    //method for checking the input have relevant command or not
    public static String commandCheck(String message,HashMap<String,String> map){ 
        check = false;
        while(!check){
            System.out.print(message);
            input = Scan.kb.nextLine();
            if(map.get(input)!=null){               
                check = true; //exit the while loop when correct
            }
            else {
                System.out.println("Wrong command! input in small letter again");
            }
        }
        return input; //return when user input is correct command
    }
    
}
