import java.io.IOException;
import java.net.SocketException;

public class UdpCalculatorServer extends UdpEchoServer{

    public UdpCalculatorServer(int port) throws SocketException {
        super(port);
    }

    @Override
    public String process(String request) {
        //按空格分割
        String[] parts = request.split("");

        if (parts.length != 3 ){
            return "格式错误！请按照 数字 运算符 数字 的格式输入";
        }

        try{
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result;

            switch (operator){
                case "+":
                    result =num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;

                default:
                    return "不支持该运算符：" + operator;
            }
            return String.valueOf(result);
        }catch (NumberFormatException e){
            return "错误，请输入正确的数字！";
        }
    }

    public static void main(String[] args) throws IOException {
        UdpCalculatorServer server = new UdpCalculatorServer(9091);
        server.start();
    }
}