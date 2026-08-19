import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer3 {

    //先声明再构造（不好处理异常），同时端口应该由外部决定
    private ServerSocket serverSocket = null;

    public TcpEchoServer3(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动......");

        ExecutorService service =
                Executors.newCachedThreadPool();

        while (true){
            Socket socket = serverSocket.accept();

            //提交一个任务给线程池。
            service.submit(() ->{
                processConnection(socket);
            });
        }
    }

    private void processConnection(Socket socket) {
        // 一个连接中, 可能会涉及到多组请求/响应的交互
        System.out.printf("[%s:%d] 客户端上线!\n", socket.getInetAddress().toString(), socket.getPort());
        try {
            //从网络连接里面读取客户端发送过来的字节流。
            InputStream inputStream = socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);

            while (true){
                String request = scanner.next();
                String response = request;

                writer.println(response);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer3 server = new TcpEchoServer3(9092);
        server.start();
    }
}