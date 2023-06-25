package WS1.Observers;

public class Log {
    public Log() {
        System.out.println("Log was created");
        WeatherMonitoringSystem.theInstance().addPressureObserver(new LogPressObserver(this));
        WeatherMonitoringSystem.theInstance()
                .addPressureTrendObserver(new LogPressTrendObserver(this));
    }

    public void displayPressure(int data) {
        System.out.println("log: pressure = " + data + " millibars");
    }

    public void displayPressureTrend(Trend data) {
        System.out.println("log: pressure trend = " + data.toString());
    }

}
