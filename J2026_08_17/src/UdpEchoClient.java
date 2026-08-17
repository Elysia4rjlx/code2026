import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {

    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动......");

        //客户端我们也要让他持续运行
        //每循环一次，就要从控制台读取一个数据，把这个数据发送到服务器，读取服务器的反应
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1、从控制台获取用户输入
            System.out.print("请输入你想发送的信息： ");
            String request = scanner.next();

            //2、构造请求，发送到服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), this.serverPort);
            socket.send(requestPacket);

            //3、读取服务器响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());

            // 4. 打印出 response
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        //通过ipconfig获取192.168.0.105
//        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        UdpEchoClient client = new UdpEchoClient("192.168.0.105", 9091);
        client.start();
    }
}