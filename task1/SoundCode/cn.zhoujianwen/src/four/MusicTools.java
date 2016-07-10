package four;

import java.io.File;

/**
 * Created by Clement0908 on 2016-4-25.
 * 4.音乐文件读取工具
 * 1.读取指定目录的所有mp3文件，包括所有子目录。
 * 2.将所读取的文件名呈现在控制台。
 */
public class MusicTools {

    public MusicTools(){}

    public static void scanMusicFile(String filePath) {

        String fileName;
        String suf;
        File dir = new File(filePath);
        //String[] files = dir.list();
        File[] files = dir.listFiles();
        if (filePath == "") {
            filePath = "src/four/mp3";
        }
        if (files == null)
        {
            return;
        }
        String[] spiltPath = null;
        for(int i=0;i<files.length;i++)
        {
            if(files[i].isDirectory()&& files[i].list().length > 0)
            {
                 spiltPath = files[i].getAbsolutePath().split("\\\\");

                System.out.println(spiltPath[spiltPath.length-1]+"文件夹");
                scanMusicFile(files[i].getAbsolutePath());//递归
            }
            else
            {
                fileName = files[i].getName();
                suf = fileName.substring(fileName.lastIndexOf(".")+1);
                if(suf.equalsIgnoreCase("mp3"))
                {
                    System.out.println(String.format("%s%s",spiltPath==null?"--":"",fileName));
                }
            }
        }
    }

    public static void main(String[] args)
    {
        MusicTools.scanMusicFile("src/four/mp3");
    }
}
