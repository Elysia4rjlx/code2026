import java.io.*;
import java.util.*;

public class Main {
    // 1. 定义静态变量，全局通用
    static StreamTokenizer st =
            new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static PrintWriter out =
            new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 使用示例：读两个整数 a, b，输出 a+b
        int a = nextInt();
        int b = nextInt();
        
        // 千万别用 System.out.println，用这个
        out.println(a + b); 
        
        // 程序结束必须加这一句，否则没输出！
        out.flush(); 
    }

    // 2. 背下来这个读取整数的方法
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    
    // 3. 读取字符串的方法（如果题目需要读单词）
    public static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }
}