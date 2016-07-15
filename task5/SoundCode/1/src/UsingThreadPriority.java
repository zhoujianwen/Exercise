/**
 * Created by zhoujianwen.cn on 2016-7-15.
 */
public class UsingThreadPriority{
    public static void main(String[] args)
    {
        Runnaable1 runnaable1 = new Runnaable1();
        Runnaable2 runnaable2 = new Runnaable2();
        Thread  thread1 = new Thread(runnaable1);
        Thread  thread2 = new Thread(runnaable2);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}

class Runnaable1 implements Runnable
{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("线程 1 执行了第"+ i +"次");
        }
    }
}

class Runnaable2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("线程 2 执行了第"+ i +"次");
        }
    }
}