package trafficlight.ctrl;

import trafficlight.Observer.Subject;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

public class TrafficLightCtrl extends Subject {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    private TrafficLightCtrl(){
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        // Info an alle Observer, was jetzt der current State ist
        notifyObservers(currentState);
    }

    private static TrafficLightCtrl instance = null;

    public static TrafficLightCtrl getInstance() {
        if (instance == null) {
            instance = new TrafficLightCtrl();
        }
        return instance;
    }
    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                notifyObservers(currentState);
                previousState = currentState;
                //TODO useful to update the current state and the old one

                return yellowState;
            }
            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                notifyObservers(currentState);
                previousState = currentState;
                //TODO useful to update the current state and the old one

                //
                return yellowState;
            }
            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    notifyObservers(currentState);
                    previousState = currentState;
                    //TODO useful to update the current state and the old one

                    //

                    return redState;
                }else {
                    notifyObservers(currentState);
                    previousState = currentState;
                    //TODO useful to update the current state and the old one

                    return greenState;
                }
            }
            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getCurrentState(){
        return currentState;
    }

    public State getPreviousState(){
        return previousState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run()  {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();

    }

    public void stop() {
        doRun = false;
        notifyObservers(null);


    }
}