package trafficlight.states;

//TODO implement a part of the pattern here

import trafficlight.Observer.Observer;
import trafficlight.Observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class State  {

    public abstract State getNextState();

    public abstract String getColor();

    public String getSting(){
        return getColor();
    }

}