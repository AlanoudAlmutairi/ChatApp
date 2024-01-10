public class Main {

    public static void main(String[] args) {

        //create msg buffer
        Channel msgList = new MSG_Queue();
        //create samphore
        Semaphore sem = new Semaphore(1);
        //create 2 users
        User user1 = new User("User1" , 01,msgList , sem );
        User user2 = new User("User2" , 02,msgList , sem );
        //create GUI
        GUI gui = new GUI( user1 ,  user2);

        //run as threads
        Thread U1 = new Thread(user1);
        Thread U2 = new Thread(user2);

        //start
        U1.start();
        U2.start();

    }



}