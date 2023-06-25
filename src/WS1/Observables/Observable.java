package WS1.Observables;
import WS1.Observers.Observer;
import java.util.ArrayList;
import java.util.List;


public class Observable<T> {
    private List<Observer<T>> itsObservers = new ArrayList<>();
    public void addObserver(Observer<T> observer) {
        itsObservers.add(observer);
    }


    public void notifyObservers(T data) {
        for (Observer<T> observer : itsObservers) {
            observer.update(data);
        }
    }
}
