public class Main {
    private static int x = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                x = 1;
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                x = 2;
            }
        });
        firstThread.start();
        secondThread.start();
        Thread.sleep(3);
        if (x == 2) System.out.println("Первый поток был быстрее");
        else System.out.println("Второй поток был быстрее");
    }
}