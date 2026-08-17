import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {

    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        //启动服务器
        System.out.println("服务器启动......");

        //服务器需要不断地处理客户端发来的请求
        while (true){
            //每循环一次，就是处理一次请求

            //1、读取请求并且解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);//先开一块 1024 字节的缓冲区数组，用来临时存放客户端发来的原始数据。
            socket.receive(requestPacket);

                //为了处理请求方便，把里面的载荷数据获取出来，构造成一个String
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());

            //2、根据请求构造响应
            String response = process(request);

            //3、把响应返回客户端
            DatagramPacket responsePacket =
                    new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);

            //4、打印日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n",
                    requestPacket.getAddress().toString(),
                    responsePacket.getPort() , request, response);
        }

        }


    //回显服务器，逻辑简单，响应就和请求完全一样
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        // 端口号是一个整数, 我们可以随意指定.
        // 端口范围是 0-65535, < 1024 的端口一般也不使用
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}