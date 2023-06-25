package WS1.Observers;

import WS1.Observables.Trend;
import WS1.Observables.WeatherMonitoringSystem;

public class MonitoringScreen {
    public MonitoringScreen() {
        System.out.println("MonitoringScreen was created");
        WeatherMonitoringSystem.theInstance().registerTemperatureObserver("MSTempObserver", new MSTempObserver(this));
        WeatherMonitoringSystem.theInstance().registerPressureObserver("MSPressObserver", new MSPressObserver(this));


    }

    public void displayPressure(int data) {
        System.out.println("MonitoringScreen: pressure = " + data + " millibars");
    }

    public void displayPressureTrend(Trend data) {
        System.out.println("MonitoringScreen: pressure trend = " + data.toString());
    }

    public void displayTemperature(int data) {
        System.out.println("MonitoringScreen: temperature = " + data + " Celsius");
    }
}
