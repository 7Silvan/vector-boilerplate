package thread;

import static thread.ThreadTest.GROUP;

/**
 * Created by gural on 22/03/15.
 */
public class Daemon extends Thread {
    public Daemon() {
        super("Daemon thread");
        setDaemon(true);
        start();
    }

    public void run() {
        Thread threads[] = new Thread[10];
        try {
            while (true) {
                int count = GROUP.activeCount();
                if (threads.length < count)
                    threads = new Thread[count + 10];

                count = GROUP.enumerate(threads);

//                for (Thread t : threads) {
//                    System.out.print(t.getName() + ",");
//                }

                for (int i=0; i<count; i++)
                    System.out.print(threads[i].getName() + ",");
                System.out.println();

                Thread.sleep(300);
            }
        } catch (InterruptedException e) {}
    }
}
