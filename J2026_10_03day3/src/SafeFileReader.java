
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Day 03: 安全文件读取器
 *
 * 练习目标:
 *   1. 自定义异常类 (extends Exception)
 *   2. try / catch / finally 三段式
 *   3. try-with-resources 自动关流
 *   4. 多 catch 分支
 *
 * 运行方式:
 *   javac -encoding UTF-8 -d out src/com/learn/day03/SafeFileReader.java
 *   java -cp out com.learn.day03.SafeFileReader  (不带参数 = 正常路径)
 *   java -cp out com.learn.day03.SafeFileReader missing.txt  (测试文件不存在)
 *   java -cp out com.learn.day03.SafeFileReader empty.txt  (测试空文件)
 */
public class SafeFileReader {

    /**
     * 自定义的"业务异常", 表示读文件出了问题
     * (extends Exception 表示它是"受检异常", 必须在方法签名上 throws)
     */
    static class BusinessException extends Exception {
        // 用一个"错误码"区分不同的错误类型, 比看字符串方便
        private String errorCode;

        BusinessException(String errorCode, String message) {
            super(message);   // super 就是调用父类 Exception 的构造方法
            this.errorCode = errorCode;
        }

        String getErrorCode() {
            return errorCode;
        }
    }

    public static void main(String[] args) {
        // 根据命令行参数决定要读哪个文件
        // 没有参数就读 sample.txt, 有参数就读参数指定的文件 (用来测试异常)
        String fileName;
        if (args.length == 0) {
            fileName = "sample.txt";
        } else {
            fileName = args[0];
        }

        try {
            // 试着读文件
            String content = readFile(fileName);

            // 读成功了, 把内容打印出来
            System.out.println("=== 文件内容 ===");
            System.out.println(content);

        } catch (BusinessException e) {
            // 业务异常: 根据错误码显示不同的提示
            if (e.getErrorCode().equals("FILE_NOT_FOUND")) {
                System.out.println("[错误] 文件不存在: " + e.getMessage());
            } else if (e.getErrorCode().equals("EMPTY_FILE")) {
                System.out.println("[错误] 文件是空的: " + e.getMessage());
            } else {
                System.out.println("[错误] 读文件失败: " + e.getMessage());
            }
        }
    }

    /**
     * 读文件, 把所有问题统一包装成 BusinessException 抛出去
     */
    static String readFile(String fileName) throws BusinessException {
        BufferedReader reader = null;   // 先声明成 null, finally 里要用

        try {
            // 1. 打开文件 (可能抛 FileNotFoundException)
            reader = new BufferedReader(new FileReader(fileName));

            // 2. 读第一行, 看是不是空文件
            String firstLine = reader.readLine();
            if (firstLine == null) {
                // 第一行就是 null, 说明文件是空的
                throw new BusinessException("EMPTY_FILE", "文件 " + fileName + " 是空的");
            }

            // 3. 不是空文件, 把第一行 + 剩下的拼起来
            StringBuilder sb = new StringBuilder();
            sb.append(firstLine);

            // 4. 继续读剩下的行
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append("\n");
                sb.append(line);
            }

            return sb.toString();

        } catch (FileNotFoundException e) {
            // 文件不存在, 包装成我们自己的异常抛出去
            throw new BusinessException("FILE_NOT_FOUND", "找不到文件: " + fileName);

        } catch (IOException e) {
            // 其他 IO 出错 (读着读着磁盘坏了之类)
            throw new BusinessException("IO_ERROR", "读文件失败: " + e.getMessage());

        } finally {
            // 不管前面发生了什么, 这里都会执行
            // 用来关掉文件, 释放资源
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // 关文件失败, 这里通常只是打印一下, 不抛了
                    System.out.println("[警告] 关闭文件失败: " + e.getMessage());
                }
            }
        }
    }

    /* ===========================================================
     * 企业中通常这么写 (你现在不用学, 先看个眼熟):
     *
     * // try-with-resources: 不用手动 close, 自动关
     * static String readFile(String fileName) throws BusinessException {
     *     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
     *         String firstLine = reader.readLine();
     *         if (firstLine == null) {
     *             throw new BusinessException("EMPTY_FILE", "...");
     *         }
     *         StringBuilder sb = new StringBuilder(firstLine);
     *         String line;
     *         while ((line = reader.readLine()) != null) {
     *             sb.append("\n").append(line);
     *         }
     *         return sb.toString();
     *     } catch (FileNotFoundException e) {
     *         throw new BusinessException("FILE_NOT_FOUND", "找不到文件: " + fileName);
     *     } catch (IOException e) {
     *         throw new BusinessException("IO_ERROR", "读文件失败: " + e.getMessage());
     *     }
     * }
     * =========================================================== */
}
