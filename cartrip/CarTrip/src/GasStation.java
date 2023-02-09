/**
 * GasStation class is supposed to refuel our car if needed ( with Refueling class's methods)
 * @see Refueling
 */

public class GasStation implements Runnable{
    Refueling kmToDrive;

    public GasStation(Refueling kmToDrive) {
        this.kmToDrive = kmToDrive;
    }

    @Override
    public void run() {
        synchronized (kmToDrive) {
        while (true) {
            while (!kmToDrive.isEmpty()) {
                try {
                    Thread.sleep(100);
                    kmToDrive.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            kmToDrive.reFuel();
            System.out.println("Car is ready to go");
            kmToDrive.notifyAll();
        }

        }
    }
}
