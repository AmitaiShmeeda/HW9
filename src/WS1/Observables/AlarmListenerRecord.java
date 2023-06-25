package WS1.Observables;

public class AlarmListenerRecord {
    protected int interval;
    protected int remainingTime;
    protected AlarmListener itsAlarmListener;

    public AlarmListenerRecord(int interval, AlarmListener al) {
        this.interval = interval;
        this.remainingTime = interval;
        this.itsAlarmListener = al;
    }

    public AlarmListener getListener() {
        return itsAlarmListener;
    }

    public int getInterval() {
        return interval;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void decrementReamingTime(int decrement) {
        this.remainingTime -= decrement;
    }
}
