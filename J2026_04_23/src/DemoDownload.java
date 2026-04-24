

public class DemoDownload {
    public static void main(String[] args) throws InterruptedException {
        download("file1");
        download("file2");
        download("file3");
    }

    public static void download(String fileName) throws InterruptedException {
        System.out.println("开始下载：" + fileName);

        Thread.sleep(3000);//模拟下载时间

        System.out.println("下载完成：" + fileName);

    }
}