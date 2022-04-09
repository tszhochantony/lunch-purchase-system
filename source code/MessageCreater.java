import java.util.ArrayList;
import java.util.HashMap;
public class MessageCreater{
    //initialize
    private String message = "";
    private String messageName = "";
    private String messageKey = "(";
    private HashMap<String, String> map = new  HashMap<String, String>();    //store the key and name when different method pass in here.
    private HashMap<String, String> map2 = new  HashMap<String, String>();   //store the type of drink mainly(ice or hot)
    private ArrayList<String> typeName = new ArrayList<String>();            //store the name of type breaking from the map
    private ArrayList<String> typeKey = new ArrayList<String>();             //store the key of type breaking from the map  
    private ArrayList<String> names = new ArrayList<String>();               //store the name breaking from the map
    private ArrayList<String> keys = new ArrayList<String>();                //store the key breaking from the map
    //empty constructor
    public MessageCreater(){}
    //constructor with one argument
    public MessageCreater(HashMap<String, String> map){  
        this.map = map;  //initialize
    }
    //constructor with two argument(for drink message mainly)
    public MessageCreater(HashMap<String, String> map,HashMap<String, String> map2){  
        //initialize
        this.map = map;
        this.map2 = map2;
    }
    //a method return the message that need to show to user and let them know which command they can choose and the meaning of each command
    public String getMessage(String mark){ //mark mean & or | 
        //use to add the drink type name and key into relevant arraylist when exist
        if(map2.size()>0){
            setList(typeName,typeKey,map2);
        }
        setList(names,keys,map); //use to add the name and key into relevant list
        messageName += createMessage(names,mark); //get first part of the message for showing all the name
        messageKey  += createMessage(keys," | "); //get second part of the message for showing all the keys(command that user should input)
        if(map2.size()>0){      //show the drink type when exist
            messageName += " : " + createMessage(typeName," or ");
        }
        message = messageName +  messageKey + "): "; //combine the message
        return message;
    }

    //a method for create the message using the information inside the list
    public static String createMessage(ArrayList<String> list,String delimiter){//delimiter mean & or |
        String text=""; //initialize
        //combine all information inside the list
        for(int i=0;i<list.size();i++){
            text += list.get(i);
            if(i<list.size()-1){ //confirm that will not add the delimiter after last value
                text += delimiter;
            }
        }
        return text; //return combined list value in String
    }   
    //a method for add the name and key into relevant list
    private void setList(ArrayList<String> name,ArrayList<String> listKey,HashMap<String, String> targetMap){
        //keep run before reaching the last key inside the map
        for(String key : targetMap.keySet()) {
            name.add(targetMap.get(key)); //add values to names list
            if(names.size()>0&&map2.size()>0){
                for(int x=0;x<typeKey.size();x++){
                    listKey.add(typeKey.get(x)+key); //add the drink type keys before the drink keys
                }
            }
            else{
                listKey.add(key); //add keys to keys list
            }
        } 
    }
}