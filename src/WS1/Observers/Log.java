package WS1.Observers;

import WS1.Observables.Trend;
import WS1.Observables.WeatherMonitoringSystem;

public class Log {
    public Log() {
        System.out.println("Log was created");
        new LogPressObserver(this);
        new LogPressTrendObserver(this);
    }

    public void displayPressure(int p) {
        System.out.println("Log: pressure = " + p + " millibars");
    }

    public void displayPressureTrend(Trend pt) {
        System.out.println("Log: pressure trend = " + pt);
    }
}
