package WS1.Observers;

import WS1.Observables.Trend;
import WS1.Observables.WeatherMonitoringSystem;



public class LogPressTrendObserver implements Observer<Trend> {
    private Log log;

    public LogPressTrendObserver(Log log) {
        System.out.println("LogPressTrendObserver was created");
        this.log = log;
        WeatherMonitoringSystem.theInstance().registerPressureTrendObserver("LogPressTrendObserver", this);
    }

    @Override
    public void update(Trend trend) {
        log.displayPressureTrend(trend);
    } // TODO CHECK
}
