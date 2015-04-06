package thread;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;

/**
 * Created by gural on 22/03/15.
 */
public class ThreadTest implements Runnable {

    public final static ThreadGroup GROUP = new ThreadGroup("Daemon deom");

    private int start;

    public ThreadTest(int i) {
        start = (i % 2 == 0) ? i : i+1;
        new Thread(GROUP, this, "Thead:" + start).start();
    }

    @Override
    public void run() {
        try {
            for (int i = start; i>0; i--){
                out.println("sleeping" + currentThread().getName() + "|" + currentThread().getId());
                Thread.sleep(300);
                out.println("awakaning" + currentThread().getName() + "|" + currentThread().getId());
                if (start > 2 && i == start/2) {
                    out.println("Creating new ThreadTest at " + start + " with i=" + i);
                    new ThreadTest(i);
                }
            }
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new ThreadTest(16);
        out.println("Starting daemon");
        new Daemon();
    }
}
