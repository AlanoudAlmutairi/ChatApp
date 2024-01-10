public interface Channel {
    public abstract  void send(Object msg );

    public abstract Object receive();

    public String getState();


}
