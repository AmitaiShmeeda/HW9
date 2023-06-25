package WS1.Nimbus1;

import WS1.Observables.AlarmClock;
import WS1.Observables.Sensor;
import WS1.Observables.SensorAlarmListener;

import java.util.Random;


public class Nimbus1TemperatureSensor extends Sensor {
    private static final int MAX_TEMPERATURE = 40;

    private final Random rnd;

    public Nimbus1TemperatureSensor(String type) {
        super(type, 700);
        rnd = RandomSupplier.getRnd();
        addSensorAlarmListener();
    }

    private void addSensorAlarmListener() {
        AlarmClock.theInstance().register(interval, new SensorAlarmListener(this));
    }

    @Override
    public int read() {
        return rnd.nextInt(MAX_TEMPERATURE);
    }
}
