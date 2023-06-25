package WS1.Observables;



public abstract class Sensor extends Observable<Integer> {
    protected final int interval;
    private final String type;

    private int lastReading;

    public Sensor(String type, int interval) {
        this.type = type;
        this.interval = interval;
        this.lastReading = 0;
        System.out.println(String.format("%s registered to clock", type));
    }

    protected abstract int read();

    public void checkReadingAndUpdate() {
        int currentReading = read();
        if (currentReading != lastReading) {
            notifyObservers(currentReading);
        }
        lastReading = currentReading;
    }
}
