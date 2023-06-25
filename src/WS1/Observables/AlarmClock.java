package WS1.Observables;

import java.util.ArrayList;

public abstract class AlarmClock {
    public final int CLOCK_INTERVAL_MILLIS = 100;
    protected static AlarmClock instance = null;
    private ArrayList<AlarmListenerRecord> itsAlarmListenerRecords = new ArrayList();

    protected AlarmClock() {
    }

    public static AlarmClock theInstance() {
        assert instance != null;
        return instance;
    }

    protected void tic() {
        for (AlarmListenerRecord alr : itsAlarmListenerRecords) {
            int remainingTime = alr.getRemainingTime();

            if (remainingTime <= CLOCK_INTERVAL_MILLIS) {
                handleZeroRemainingTime(alr);
            } else {
                alr.decrementReamingTime(CLOCK_INTERVAL_MILLIS);
            }
        }
    }

    private void handleZeroRemainingTime(AlarmListenerRecord alr) {
        alr.getListener().wakeUp();
        alr.setRemainingTime(alr.getInterval());
    }


    public void register(int interval, AlarmListener al) {
        itsAlarmListenerRecords.add(new AlarmListenerRecord(interval, al));
    }
}


