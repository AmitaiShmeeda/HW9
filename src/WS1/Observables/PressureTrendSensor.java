package WS1.Observables;
import WS1.Observers.Observer;
import java.util.LinkedList;
import java.util.Queue;

public class PressureTrendSensor extends Observable<Trend> implements Observer<Integer> {
    private static final int MAX_READINGS = 3;

    private Queue<Integer> lastReadings;
    private Trend lastState;

    public PressureTrendSensor() {
        lastReadings = new LinkedList<>();
    }

    public Trend calculateTrend() {
        Integer[] readings = lastReadings.toArray(new Integer[0]);
        if (readings[0] < readings[1] && readings[1] < readings[2]) {
            return Trend.FALLING;
        } else if (readings[0] > readings[1] && readings[1] > readings[2]) {
            return Trend.RISING;
        } else {
            return Trend.STABLE;
        }
    }

    public void checkAndNotify() {
        Trend currentPressureState = calculateTrend();
        if (currentPressureState != lastState) {
            notifyObservers(currentPressureState);
        }
        lastState = currentPressureState;
    }

    @Override
    public void update(Integer temperature) {
        if (lastReadings.size() == MAX_READINGS) {
            lastReadings.poll(); // remove the oldest reading
        }
        lastReadings.offer(temperature); // add the new reading
        if (lastReadings.size() == MAX_READINGS) {
            checkAndNotify();
        }
    }
}
