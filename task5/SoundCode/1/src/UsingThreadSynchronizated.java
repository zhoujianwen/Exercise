/**
 * Created by zhoujianwen.cn on 2016-7-15.
 */
public class UsingThreadSynchronizated extends Thread{

    private String threadNo;

    private Object object;

    public UsingThreadSynchronizated(Object object , String threadNo)
    {
        this.object = object;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        synchronized(object) {
            for (int i = 1; i <= 100; i++) {
                System.out.println("线程" + threadNo + "执行了第" + i + "次");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        for(int i=1;i<=5;i++)
        {
            new UsingThreadSynchronizated(object,i+"").start();
            Thread.sleep(1);
        }
    }
}
