package util;

/**
 * Created by Sadiqur Rahman on 6/7/2016.
 */
public class TurnReaderThread implements Runnable {
    public Turn turn;
    public NetworkUtil connection;
    Thread t;

    public TurnReaderThread(Turn turn, NetworkUtil nc) {
        this.turn = turn;
        connection = nc;
        this.t=new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        while (true) {
            try {

                Object o=connection.read();
                if(o instanceof String){
                    //turn.setTurn(true);
                    String s=(String)o;
                    System.out.println(s);
                }
            } catch (Exception e) {

            }
        }
    }
}
