import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Refueling refueling = new Refueling();
        Car car = new Car(refueling);
        GasStation gasStation = new GasStation(refueling);

        Thread watek1 = new Thread(car, "car");
        Thread watek2 = new Thread(gasStation, "Gas Station");



        watek1.start();
        watek2.start();
    }
}