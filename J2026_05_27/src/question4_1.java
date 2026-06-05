public class question4_1 {
    static class DownloadThead extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在下载文件...");
        }
    }

    public static void main(String[] args) {
        DownloadThead t1 = new DownloadThead();
        DownloadThead t2 = new DownloadThead();

        t1.start();
        t2.start();
    }
}