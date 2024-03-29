package WS1.Nimbus1;

import WS1.Observables.AlarmClock;
import WS1.Observables.Sensor;
import WS1.Observables.SensorAlarmListener;

import java.util.Random;



public class Nimbus1PressureSensor extends Sensor {
    private static final int BASE_PRESSURE = 950;
    private static final int RANDOM_PRESSURE_RANGE = 100;

    private final Random rnd;

    public Nimbus1PressureSensor(String type) {
        super(type, 1_100);
        rnd = RandomSupplier.getRnd();
        addSensorAlarmListener();
    }

    private void addSensorAlarmListener() {
        AlarmClock.theInstance().register(interval, new SensorAlarmListener(this));
    }

    @Override
    public int read() {
        return BASE_PRESSURE + rnd.nextInt(RANDOM_PRESSURE_RANGE);
    }
}

