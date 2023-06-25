package WS1.Observers;

public class MSPressObserver implements Observer<Integer> {
    protected MonitoringScreen monitoringScreen;

    public MSPressObserver(MonitoringScreen ms) {
        System.out.println("MSPressObserver was created");
        this.monitoringScreen = ms;

    }

    @Override
    public void update(Integer data) {
        monitoringScreen.displayPressure(data);
    }
}
