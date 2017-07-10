
package util;
/**
 * Created by Sadiqur Rahman on 6/4/2016.
 */

public class WriteThread implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String name;
    Controller c;

    public WriteThread(NetworkUtil nc, String name, Controller c) {
        this.c=c;
        this.nc = nc;
        this.name=name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            //Scanner input=new Scanner(System.in);
            while(true) {
                nc.write(c.clone());
            }
        } catch(Exception e) {
            System.out.println (e);
        }
//        nc.closeConnection();
    }
}



