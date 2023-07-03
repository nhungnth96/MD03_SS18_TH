package th02;


import static th02.Main.DISTANCE;
import static th02.Main.STEP;

public class Car implements Runnable {
    // Khai báo Tên của xe đua
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() {
        // Khởi tạo điểm start(hay km ban đầu)
        int startGrid = 0;
        // Khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();

        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (startGrid < DISTANCE) {
            try {

                // Calculate traveled distance
                startGrid += speed;
                // Build result graphic
                String log = "▶";
                int percentTravel = (startGrid * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        log += "⊱";
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        log += "🏎";
                    } else {
                        log += "=";
                    }
                }
                log += "🏁";
                System.out.println(this.name + ": " + log + " " + Math.min(DISTANCE, startGrid) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
