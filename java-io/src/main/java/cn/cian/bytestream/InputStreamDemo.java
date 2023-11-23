package cn.cian.bytestream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo {

    @Test
    public void testRead() throws IOException {
        //创建字节输入流对象
        //FileInputStream(String name)
        FileInputStream fis = new FileInputStream("myByteStream\\fos.txt");
        int by;
        /*
            fis.read()：读数据
            by=fis.read()：把读取到的数据赋值给by
            by != -1：判断读取到的数据是否是-1
         */
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }
        //释放资源
        fis.close();
    }

    public static void testReadBuf(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fis = new FileInputStream("myByteStream\\fos.txt");

        byte[] bys = new byte[1024]; //1024及其整数倍
        int len;
        //read(byte[] bys)返回的是读取到了多少
        while ((len = fis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }

        //释放资源
        fis.close();
    }
}
