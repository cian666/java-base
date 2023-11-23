package cn.cian.bytestream;

import org.junit.Test;

import java.io.*;

public class OutputStreamDemo {

    @Test
    public void testWriteOne() throws IOException {
        //创建字节输出流对象
        //FileOutputStream​(String name)：创建文件输出流以指定的名称写入文件
        /*
            做了三件事情：
                A:调用系统功能创建了文件
                B:创建了字节输出流对象
                C:让字节输出流对象指向创建好的文件
         */
        File f = new File("myByteStream");
        f.mkdir();
        //第二个参数代表新打开的流是否再文件的末尾添加。 true添加 false清空重写
        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt",false);
        fos.write(97);
        fos.write(57);
        fos.write(55);
        //最后都要释放资源
        fos.close();
    }

    @Test
    public void testWriteBytes() throws IOException {
        //FileOutputStream​(String name)：创建文件输出流以指定的名称写入文件
        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
        byte[] bys = "abcde".getBytes();
        fos.write(bys);
//        fos.write(bys,1,3);
        //释放资源
        fos.close();
    }

    @Test
    public void testPrintStream() throws IOException {
        PrintStream stream = new PrintStream("myByteStream\\print.txt");
        stream.write(97);
        stream.close();
    }
}
