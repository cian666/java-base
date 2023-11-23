package cn.cian.buffer;

/**
 * @author Cian
 * @version 1.0
 * @description: TODO
 */
import java.nio.ByteBuffer;

public class BufferExample {
    public static void main(String[] args) {
        // 创建一个ByteBuffer，容量为10字节
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 写入数据到ByteBuffer
        buffer.put((byte) 'H');
        buffer.put((byte) 'e');
        buffer.put((byte) 'l');
        buffer.put((byte) 'l');
        buffer.put((byte) 'o');

        // 切换为读模式，准备读取数据
        buffer.flip();

        // 从ByteBuffer读取并打印数据
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        // 清空缓冲区，准备重新写入
        buffer.clear();
    }
}

