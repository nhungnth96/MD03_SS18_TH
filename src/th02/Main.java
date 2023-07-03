package th02;

public class Main {
    public static int DISTANCE = 100;
    public static int STEP = 10;

    public static void main(String[] args) {
        Car carA = new Car("Ferrari",15);
        Car carB = new Car("Porsche",18);
        Car carC = new Car("Lamborghini",25);

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100KM");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
