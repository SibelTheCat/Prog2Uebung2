package trafficlight.gui;


import trafficlight.Observer.Observer;

import java.awt.*;

public class TrafficLight extends Light  {

    TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }

    //


    //TODO implement a part of the pattern here
}
