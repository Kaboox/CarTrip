/**
 * CarTrip app works with multithreading, first thread is the car which adds new kilometres ( Kilometre objects), second one is GasStation which refuels the car if needed.
 * We assume that we are driving on a highway with constant speed and refuel the car every 500 kilometres.
 */


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