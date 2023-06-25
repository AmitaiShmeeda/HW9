package WS1.Observers;


import WS1.Observables.WeatherMonitoringSystem;

public class LogPressObserver implements Observer<Integer> {
    protected Log itsLog;

    public LogPressObserver(Log log) {
        System.out.println("LogPressObserver was created");
        this.itsLog = log;
        WeatherMonitoringSystem.theInstance().registerPressureObserver("LogPressObserver", this);
    }

    @Override
    public void update(Integer data) {
        this.itsLog.displayPressure(data);
    }
}
