package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ych0112xzz on 2017/4/18.
 */
public class Printabc extends Thread{
    private final String str[] = { "A", "B", "C" };
    private final static AtomicInteger atomI = new AtomicInteger();

    public Printabc(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            // 满10次退出打印
            if (atomI.get() / 3 == 10) {
                break;
            }
            synchronized (atomI) {
                // 顺序打印A、B、C,通过当前线程名来判断
                if (str[atomI.get() % 3].equals(getName())) {
                    atomI.getAndIncrement();
                    System.out.println(getName());
                    // 当前线程打印打印完成后唤醒其它线程
                    atomI.notifyAll();
                } else {
                    // 非顺序线程wait()
                    try {
                        atomI.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Printabc a = new Printabc("A");
        try {
            a.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // new Printabc("A").start();
        a.start();
        new Printabc("B").start();
        new Printabc("C").start();
    }
}
