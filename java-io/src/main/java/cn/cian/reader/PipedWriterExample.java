package cn.cian.reader;

/**
 * @author Cian
 * @version 1.0
 * @description: TODO
 */
import java.io.*;

public class PipedWriterExample {
    public static void main(String[] args) {
        try {
            // 创建一个PipedWriter和PipedReader，它们将连接在一起
            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader();

            // 将PipedReader与PipedWriter连接
            pipedWriter.connect(pipedReader);

            // 创建一个写线程
            Thread writerThread = new Thread(new WriterTask(pipedWriter));
            // 创建一个读线程
            Thread readerThread = new Thread(new ReaderTask(pipedReader));

            // 启动线程
            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class WriterTask implements Runnable {
        private final PipedWriter pipedWriter;

        public WriterTask(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            try {
                // 向PipedWriter写入字符数据
                String message = "Hello, PipedWriter!";
                int i = 0;
                while(i++ < 1000){
                    pipedWriter.write(message);
                    Thread.sleep(1000);
                }
                pipedWriter.close(); // 关闭PipedWriter，通知读线程结束
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReaderTask implements Runnable {
        private final PipedReader pipedReader;

        public ReaderTask(PipedReader pipedReader) {
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {
            try {
                // 从PipedReader读取字符数据
                int data;
                StringBuilder sb = new StringBuilder();
                while ((data = pipedReader.read()) != -1) {
                    System.out.println("Received: " + data);
                    sb.append((char) data);
                }
                pipedReader.close(); // 关闭PipedReader
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

