package WS1.Observers;

public class MonitoringScreen {
    public MonitoringScreen() {
        System.out.println("MonitoringScreen was created");
        WeatherMonitoringSystem.theInstance().addTemperatureObserver(new MSTempObserver(this));
        WeatherMonitoringSystem.theInstance().addPressureObserver(new MSPressObserver(this));
    }

    public void displayPressure(int data) {
        System.out.println("monitoring screen: pressure = " + data + " millibars");
    }

    public void displayTemperature(int data) {
        System.out.println("monitoring screen: temperature = " + data + " celsius");
    }
}
