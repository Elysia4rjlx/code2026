public class question4_2 {
    static class DownloadTask extends Thread{
        private String fileName;

        public DownloadTask(String fileName){
            this.fileName = fileName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "下载" + fileName);
        }
    }

    public static void main(String[] args) {
        DownloadTask t1 = new DownloadTask("A.zip");
        DownloadTask t2 = new DownloadTask("A.zip");

        t1.start();
        t2.start();
    }
}