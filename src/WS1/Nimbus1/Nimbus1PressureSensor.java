package WS1.Nimbus1;

public class Nimbus1PressureSensor extends Sensor {
    private Random random;

    public PressureSensor(int interval) {
        super(interval);
        random = new Random();
    }

    @Override
    protected int read() {
        return random.nextInt(101) + 950;
    }

    @Override
    public String getName() {
        return "pressure";
    }
}
