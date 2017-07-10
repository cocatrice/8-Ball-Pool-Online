package util;

/**
 * Created by Sadiqur Rahman on 6/4/2016.
 */

public class ReadThread implements Runnable {

    double v;
    private Thread thr;
    private NetworkUtil nc;
    Controller con;
    Controller c;
    Turn turn;
    public ReadThread(NetworkUtil nc,Controller c,Turn myturn) {
        con=new Controller();
        this.c=c;
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
        turn=myturn;
    }

    public void run() {
        try {
            while(true) {

                Object o=nc.read();

                if(o instanceof  Controller){
                    con=(Controller)o;
                    // String s=(String)nc.read();
                    if(con==null){
                        System.out.println("failed to read ");
                    }
                    else{
                        c.setValue(con.getValue());
                        c.setAngle(con.getAngle());
                        c.setLayoutx(con.getLayoutx());
                        c.setLayouty(con.getLayouty());
                        c.setInitial_v(con.getInitial_v());
                        c.setLineEnlarge(con.getLineEnlarge());
                    //    c.setLayoutx(con.getLayoutx());
                       // c.setLayouty(con.getLayouty());

                    }

                    }


            }
        } catch(Exception e) {
            System.out.println (e);
        }
      //  nc.closeConnection();
    }
}






