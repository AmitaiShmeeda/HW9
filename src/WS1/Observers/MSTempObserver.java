package WS1.Observers;

public class MSTempObserver implements Observer<Integer> {
    protected MonitoringScreen monitoringScreen;

    public MSTempObserver(MonitoringScreen ms) {
        System.out.println("MSTempObserver was created");
        this.monitoringScreen = ms;
    }

    @Override
    public void update(Integer data) {
        monitoringScreen.displayTemperature(data);
    }
}
