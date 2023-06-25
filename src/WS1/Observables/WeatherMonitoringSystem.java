package WS1.Observables;

import WS1.Nimbus1.Nimbus1Clock;
import WS1.Nimbus1.Nimbus1PressureSensor;
import WS1.Nimbus1.Nimbus1TemperatureSensor;
import WS1.Observers.*;

public class WeatherMonitoringSystem {
    private static WeatherMonitoringSystem instance;
    Observable<Integer> temperatureSensor;
    Observable<Integer> pressureSensor;
    PressureTrendSensor pressureTrendSensor;

    public WeatherMonitoringSystem() {
        System.out.println("WeatherMonitoringSystem was created");

        Nimbus1Clock.theInstance();
        pressureSensor = new Nimbus1PressureSensor("pressure");
        temperatureSensor = new Nimbus1TemperatureSensor("temperature");
        pressureTrendSensor = new PressureTrendSensor();
        this.registerPressureObserver("PressureTrendSensor", pressureTrendSensor);

    }

    public void registerTemperatureObserver(String type, Observer<Integer> observer) {
        System.out.println(type + " observes temperature");
        temperatureSensor.addObserver(observer);
    }

    public void registerPressureObserver(String type, Observer<Integer> observer) {
        System.out.println(type + " observes pressure");

        pressureSensor.addObserver(observer);
    }

    public void registerPressureTrendObserver(String type, Observer<Trend> observer) {
        System.out.println(type + " observes pressure trend");

        pressureTrendSensor.addObserver(observer);
    }


    public static WeatherMonitoringSystem theInstance() {
        if (instance == null) {
            instance = new WeatherMonitoringSystem();
        }
        return instance;
    }
}
