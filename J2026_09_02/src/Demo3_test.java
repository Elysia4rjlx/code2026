import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Demo3_test {

    public  static class UdpEchoServer {

        public static void main(String[] args) throws IOException {


            // 1. 创建 DatagramSocket
            DatagramSocket socket = new DatagramSocket(9091);

            // 2. while循环
            while (true){

                // 3. 创建接收buffer
                byte[] buffer = new byte[1024];

                // 4. 创建DatagramPacket
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

                // 5. receive接收数据
                socket.receive(packet);

                // 6. 转String
                String message = new String(packet.getData(),0,packet.getLength());

                // 7. 打印
                System.out.println("收到：" + message);

                // 8. 创建响应Packet
                byte[] responseData = message.getBytes();
                DatagramPacket response = new DatagramPacket(responseData,responseData.length,packet.getAddress(),packet.getPort());


                // 9. send发送
                socket.send(response);
            }



        }
    }
}