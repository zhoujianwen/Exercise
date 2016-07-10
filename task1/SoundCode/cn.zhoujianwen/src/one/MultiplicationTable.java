package one;

/**
 * Created by Clement0908 on 2016-4-25.
 * 1.在控制台打印出九九乘法表
 * 在控制台打印出九九乘法表
 */
public class MultiplicationTable {

    public static void Show()
    {
        for(int row=1;row<=9;row++)
        {
            for(int col=1;col<=row;col++)
            {
                System.out.print(String.format("%s * %s  = %s%s",col,row,row*col,(col==2&&row*col<10?"   ":"  ")));
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args)
    {
        MultiplicationTable.Show();
    }
}
