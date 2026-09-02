import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo3_server {

    public static void main(String[] args) throws IOException {

        //1.创建DatagramSocket
        DatagramSocket socket = new DatagramSocket(9090);
        System.out.println("服务全部启动，正在监听9090端口...");

        while (true) {
            //2.创建数组缓存区
            byte[] buffer = new byte[1024];

            //3.创建DatagramPacket用于接收客户端发来的数据
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

            //4.接收客户端消息，阻塞等待，直到收到数据
            socket.receive(packet);

            //5、将收到的数据转换成字符串
            String message = new String(packet.getData(),0, packet.getLength());

            System.out.println("收到：" + message);

            //6.准备响应
            byte[] responseData = message.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseData,
                                            responseData.length,
                                            packet.getAddress(),
                                            packet.getPort());

            //7.发送
            socket.send(responsePacket);
        }
    }
}