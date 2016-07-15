/**
 * Created by zhoujianwen.cn on 2016-7-15.
 *
 */
public class UsingThread {

    public static void main(String[] args) {

//        Thread thread  = new MyThread();
//        thread.run();
//
//        //效果同上
//        Thread thread2 = new Thread(thread);
//        thread2.run();
        MyThread2 myThread2 = new MyThread2();
        Thread thread2 = new Thread(myThread2);
        thread2.start();
    }
}
