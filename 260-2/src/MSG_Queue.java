import java.util.ArrayList;

public class MSG_Queue implements Channel{
ArrayList<Object> msglist;
public static String state = "read";
    public MSG_Queue(){
    msglist = new ArrayList<Object>(); }

    public  String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("Queue state " + state);
    }

    @Override
    public void send(Object msg ) {
        setState("write");
        msglist.add(msg);

    }

    @Override
    public Object receive() {

      if(msglist.size() == 0 ){
        return null;}
      else{
          setState("read");
          return msglist.remove(0);

      }
    }
}
