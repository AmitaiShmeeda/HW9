package WS1.Observables;

public class SensorAlarmListener implements AlarmListener {
    private final Sensor sensor;

    public SensorAlarmListener(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void wakeUp() {
        sensor.checkReadingAndUpdate();
    }
}
