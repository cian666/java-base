package cn.cian.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    @Test
    public void testConstruct() {
        //File(String pathname)：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        File f1 = new File("E:\\io\\java.txt");
        System.out.println(f1);
        //File(String parent, String child)：从父路径名字符串和子路径名字符串创建新的File实例。
        File f2 = new File("E:\\io","java.txt");
        System.out.println(f2);
        //File(File parent, String child)：从父抽象路径名和子路径名字符串创建新的 File实例。
        File f3 = new File("E:\\itcast");
        File f4 = new File(f3,"io.txt");
        System.out.println(f4);
    }

    /*
    File类创建功能：
    public boolean createNewFile()：当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件
    如果文件不存在，就创建文件，并返回true
    如果文件存在，就不创建文件，并返回false

    public boolean mkdir()：创建由此抽象路径名命名的目录
    如果目录不存在，就创建目录，并返回true
    如果目录存在，就不创建目录，并返回false

    public boolean mkdirs()：创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录
            自己补齐
    */
    @Test
    public void testCreate() throws IOException {
        //需求1：我要在E:\\io目录下创建一个文件java.txt
        File f1 = new File("E:\\io\\java.txt");
        System.out.println(f1.createNewFile());
        System.out.println("--------");

        //需求2：我要在E:\\io目录下创建一个目录JavaSE
        File f2 = new File("E:\\io\\JavaSE");
        System.out.println(f2.mkdir());
        System.out.println("--------");

        //需求3：我要在E:\\io目录下创建一个多级目录JavaWEB\\HTML
        File f3 = new File("E:\\io\\JavaWEB\\HTML");
        System.out.println(f3.mkdir());
        System.out.println(f3.mkdirs());
        System.out.println("--------");

        //需求4：我要在E:\\io目录下创建一个文件javase.txt
        File f4 = new File("E:\\io\\javase.txt");
//        System.out.println(f4.mkdir());
        System.out.println(f4.createNewFile());
    }

    @Test
    public void testDelete() throws IOException {
//        File f1 = new File("E:\\io\\java.txt");
        //需求1：在当前模块目录下创建java.txt文件
        File f0 = new File("myfile");
        System.out.println(f0.mkdir());

        File f1 = new File("myfile\\java.txt");
        System.out.println(f1.createNewFile());
        //需求2：删除当前模块目录下的java.txt文件
        System.out.println(f1.delete());
        System.out.println("--------");

        //需求3：在当前模块目录下创建io目录
        File f2 = new File("myFile\\io");
        System.out.println(f2.mkdir());

        //需求4：删除当前模块目录下的io目录
        System.out.println(f2.delete());
        System.out.println("--------");

        //需求5：在当前模块下创建一个目录io,然后在该目录下创建一个文件java.txt
        File f3 = new File("myFile\\io");
        System.out.println(f3.mkdir());
        File f4 = new File("myFile\\io\\java.txt");
        System.out.println(f4.createNewFile());

        //需求6：删除当前模块下的目录io
        System.out.println(f4.delete());
        System.out.println(f3.delete());
    }

    /*
    File类的判断和获取功能：
        public boolean isDirectory()：测试此抽象路径名表示的File是否为目录
        public boolean isFile()：测试此抽象路径名表示的File是否为文件
        public boolean exists()：测试此抽象路径名表示的File是否存在

        public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串
        public String getPath()：将此抽象路径名转换为路径名字符串
        public String getName()：返回由此抽象路径名表示的文件或目录的名称

        public String[] list()：返回此抽象路径名表示的目录中的文件和目录的名称字符串数组
        public File[] listFiles()：返回此抽象路径名表示的目录中的文件和目录的File对象数组
 */

    @Test
    public void test04() throws IOException {
        //创建一个File对象
        File f = new File("myFile\\java.txt");

        f.createNewFile();
        System.out.println("文件夹？->"+f.isDirectory());
        System.out.println("文件？->"+f.isFile());
        System.out.println("存在否？->"+f.exists());

        System.out.println("绝对路径->"+f.getAbsolutePath());
        System.out.println("相对路径->"+f.getPath());
        System.out.println("文件名->"+f.getName());
        System.out.println("--------");

        File f2 = new File("E:\\io");

        String[] strArray = f2.list();
        for(String str : strArray) {
            System.out.println(str);
        }
        System.out.println("--------");

        File[] fileArray = f2.listFiles();
        for(File file : fileArray) {
            if(file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
