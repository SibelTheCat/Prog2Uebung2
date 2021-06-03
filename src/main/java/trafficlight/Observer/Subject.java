package trafficlight.Observer;

import java.util.ArrayList;
import java.util.List;
import trafficlight.states.State;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();


    public void addObserver(Observer obs){
        observerList.add(obs);
    }

    public void removeObserver(Observer obs){
        observerList.remove(obs);
     }


     public void notifyObservers(State current){
        for(Observer e : observerList){
            e.update(current);
        }
     }

}
