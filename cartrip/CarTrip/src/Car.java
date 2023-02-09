public class Car implements Runnable{
    private int kmDriven = 0;
    Refueling kmToDrive;
    public Car(Refueling kmToDrive) {
        this.kmToDrive = kmToDrive;
    }
    @Override
    public void run() {
        synchronized (kmToDrive) {

        while (true) {
            while (!kmToDrive.isEmpty()) {
                kmToDrive.addKilometre();
                System.out.println(Thread.currentThread().getName() + " has driven " + (++kmDriven));
                kmToDrive.notifyAll();
            }
            try {
                Thread.sleep(1000);
                System.out.println("Car needs fuel");
                kmToDrive.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }

        }
    }
}
