package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A2 {
    public void wirter(String filepath,String content){
        File file = new File(filepath);
        System.out.println("文件增加前长度："+file.length());
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            //把要输出给文件的字符转换为字节流
            byte[] array = content.getBytes();
            //这种写入是覆盖的。
            fileOutputStream.write(array);
            System.out.println("文件增加后长度："+file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        String filePath = "D://a.txt" ;
        String contont = "这是从代码中写入给文件的，使用的是output流";
        A2 a2 = new A2();
        a2.wirter(filePath,contont);
    }
}
