import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
    }

    public void start(){
        System.out.println("客户端启动......");

        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwort = new Scanner(inputStream);

            PrintWriter writer = new PrintWriter(outputStream);

            while (true){
                System.out.print("-> ");

                String request = scannerConsole.next();

                writer.println(request);
                writer.flush();

                String response = scannerNetwort.next();

                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9091);
        client.start();
    }
}