/**
 * Created by Clement0908 on 2016-7-15.
 */
public class UsingThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        boolean isExecute = false;
        for(int i=1;i<=10000;i++)
        {
            if(i>1000 && !isExecute)
            {
                System.out.print("执行一次");
                Thread thread = new MyThread();
                thread.start();//就绪
                thread.join();//强制执行
                isExecute = true;
            }
            System.out.println("主线程执行第"+i+"次");
        }
        System.out.println("开始休眠");
        Thread.sleep(3000);
        System.out.println("结束休眠");
    }
}
