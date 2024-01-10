
public class User implements Runnable{
    public String name ;
    public int ID ;
    private Channel msglist ;
    private Semaphore sem ;
    public static String mode  ;

    public User(String name , int id , Channel msgList , Semaphore sem ) {
        this.name=name;
        this.ID =id ;
        this.msglist = msgList;
        this.sem = sem ;
        this.mode =  "reader"; }
public Channel getQueue(){
        return  msglist;
}
public void setMode(String s ){
        this.mode = s;
    System.out.println("user Mode : " + mode);
}
public void run(){
        while (true) {
            sem.acquire();
            MutualExclusionUtilities.criticalSection();
            sem.release();
            MutualExclusionUtilities.nonCriticalSection(); }
    }



}
