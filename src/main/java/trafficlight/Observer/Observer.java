package trafficlight.Observer;

import trafficlight.gui.TrafficLight;

import java.util.ArrayList;
import java.util.List;
import trafficlight.states.State;

public interface Observer {

    public void update(State current);
}

// Observer wird von TrafficLightCTrl implementiert