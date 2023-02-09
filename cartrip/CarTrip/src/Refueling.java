import java.util.ArrayList;

public class Refueling {
    private final int kmToDrive = 500;
    private ArrayList kmAmount = new ArrayList(kmToDrive);
    public boolean isEmpty() {
        if (kmAmount.size() == 500)
            return true;
        return false;
    }
    public void addKilometre() {
        kmAmount.add(new Kilometre());
    }
    public void reFuel() {
        kmAmount.clear();
    }
}
