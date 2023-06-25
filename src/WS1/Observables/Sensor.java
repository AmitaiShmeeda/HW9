package WS1.Observables;

public class Sensor extends Observable<Integer> {

    private Integer lastReading;

    protected Sensor(int interval) {
        lastReading = null;
        System.out.println(getName() + " registered to clock");
        Nimbus1Clock.theInstance().register(interval, new SensorAlarmListener(this));
    }

    protected abstract int read();

    public void check() {
        int reading = read();
        if (lastReading == null || reading != lastReading)
            notifyObservers(reading);
        lastReading = reading;
    }

}
