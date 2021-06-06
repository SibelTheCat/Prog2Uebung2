package trafficlight.gui;

import trafficlight.Observer.Observer;
import trafficlight.Observer.Subject;
import trafficlight.ctrl.TrafficLightCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import trafficlight.states.State;

public class TrafficLightGui extends JFrame implements ActionListener, Observer {

    public static final String ACTION_COMMAND_STOP = "stop";

    public static final String NAME_OF_THE_GAME = "Traffic Light";

    private JButton buttonStop;

    private TrafficLight green = null;
    private TrafficLight yellow = null;
    private TrafficLight red = null;

    private TrafficLightCtrl trafficLightCtrl = null;

    private TrafficLight previosLight = null;


    public TrafficLightGui(TrafficLightCtrl ctrl){
        super(NAME_OF_THE_GAME);
        trafficLightCtrl = ctrl;
        initLights(ctrl);
        init();
    }

    public TrafficLight getGreen() {
        return green;
    }

    public TrafficLight getYellow() {
        return yellow;
    }

    public TrafficLight getRed() {
        return red;
    }

    @Override
    public void update(State current){
// if stop button is pressed - this Trafficlight unsubscribes from the CTR Subject
        if (current == null){
            trafficLightCtrl.removeObserver(this);
        }
else {
        switch (current.getColor()){
            case "green":
                green.turnOn(true);
                if(previosLight != null){
                previosLight.turnOn(false);}
                previosLight = green;
                break;

            case "yellow":
                yellow.turnOn(true);
                if(previosLight != null){
                previosLight.turnOn(false);}
                previosLight = yellow;
                break;

            case "red":
                red.turnOn(true);
                if(previosLight != null){
                previosLight.turnOn(false);}
                previosLight = red;
                break;

        }


    }}
    private void initLights(TrafficLightCtrl ctrl) {
        //TODO implement a part of the pattern here
        //create the TrafficLight
        //connect subject and observer
//
        // neue Lichter wurden erstellt und auf "aus" geschalten
        green = new TrafficLight(Color.green);
        green.turnOn(false);
        red = new TrafficLight(Color.red);
        red.turnOn(false);
        yellow = new TrafficLight(Color.yellow);
        yellow.turnOn(false);

       // previosLight = yellow;

        //das TrafficlightObjekt wurde in die Liste der zu benarichtigenden Objekte eingefügt
        ctrl.addObserver(this);

    }

    private void init() {
        getContentPane().setLayout(new GridLayout(2, 1));
        buttonStop = new JButton("Stop");
        buttonStop.setActionCommand(ACTION_COMMAND_STOP);
        buttonStop.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(3,1));
        p1.add(red);
        p1.add(yellow);
        p1.add(green);


        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(buttonStop);

        getContentPane().add(p1);
        getContentPane().add(p2);
        pack();
    }


    public void showErrorMessage(Exception e) {
        JOptionPane pane = new JOptionPane();
        JDialog dialog = pane.createDialog(this, "Traffic Light Problem");
        JOptionPane.showMessageDialog(dialog, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void actionPerformed(ActionEvent e){
        if (ACTION_COMMAND_STOP.equals(e.getActionCommand())){
           trafficLightCtrl.stop();
        }
    }
}
