package WS1.System;

import WS1.Observables.WeatherMonitoringSystem;
import WS1.Observers.Log;
import WS1.Observers.MonitoringScreen;

public class MainClassWS1 {

    public static void main(String[] args) {

        WeatherMonitoringSystem ws = WeatherMonitoringSystem.theInstance();
        MonitoringScreen monitoringScreen = new MonitoringScreen();
        Log log = new Log();

    }

}
