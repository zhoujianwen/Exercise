package two;

import java.util.Random;

/**
 * Created by Clement0908 on 2016-4-25.
 * 2.写一个函数用于求出整数数组中的最大值
 * 写一个函数用于求出整数数组中的最大值，要求：
 1、数组长度为10
 2、随机生成并填充数组中的整数值
 3、把查找算法封装到方法中，传入参数为数组，返回最大值
 4、把结果输出到屏幕
 */
public class ArrayDemo{


    public static boolean deleIf(int a, int b)
    {
        return a>b?true:false;
    }

    //返回数组最大值
    public static int findArrayEle(int[] array)
    {
        int Max = array[0];
        for(int n=1;n<array.length;n++)
        {
            if(deleIf(array[n],Max))
            {
                Max = array[n];
            }
        }
        return Max;
    }

    //在数据组中生成n个随机数
    public static int[] randomData(int[] array,int offset,int length)
    {
        while(offset<length)
        {
            array[offset++] = (int)(Math.random()*10);
        }
        return array;
    }

    //显示数组的数据
    public static String Show(int[] array)
    {
        StringBuffer sb = new StringBuffer();
        for(int n=0;n<array.length-1;n++)
        {
            sb.append(array[n]+",");
        }
        sb.append(array[array.length-1]);
        return sb.toString();
    }

    //程序入口
    public static void main(String[] args)
    {
        int[] data = ArrayDemo.randomData(new int[10],0,10);//随机生成并填充数组中的整数值
        System.out.println("数组初始数据："+ArrayDemo.Show(data));//把查找算法封装到方法中，传入参数为数组，返回最大值
        System.out.println("数组最大值："+ArrayDemo.findArrayEle(data));
    }
}
