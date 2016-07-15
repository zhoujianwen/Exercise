/**
 * Created by zhoujianwen.cn on 2016-7-15.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=100;i++) {
            System.out.println("自定义线程执行第"+i+"次");
        }
    }
}
