

public class DemoDownload2 {
    public static void main(String[] args) {
        new Thread(() -> download("file1")).start();
        new Thread(() -> download("file2")).start();
        new Thread(() -> download("file3")).start();
    }


    public static void download(String fileName){
        System.out.println("开始下载：" + fileName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("下载完成：" + fileName);
    }
}