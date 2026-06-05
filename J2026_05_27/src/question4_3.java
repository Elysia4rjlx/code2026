public class question4_3 {
    static class DownloadTask implements Runnable{
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
        DownloadTask task = new DownloadTask("A.zip");


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
