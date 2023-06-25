package WS1.Observers;

import WS1.Observables.Trend;
import WS1.Observables.WeatherMonitoringSystem;

public class MSPressTrendObserver implements Observer<Trend> {
    protected MonitoringScreen monitoringScreen;

    public MSPressTrendObserver(MonitoringScreen ms) {
        this.monitoringScreen = ms;
        WeatherMonitoringSystem.theInstance().registerPressureTrendObserver("MSPressTrendObserver", this);
    }

    @Override
    public void update(Trend data) {
        monitoringScreen.displayPressureTrend(data);
    }
}
