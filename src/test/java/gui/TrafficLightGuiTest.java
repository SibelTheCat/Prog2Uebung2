package gui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLightGui;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightGuiTest {

    @Test
    @DisplayName("is light green")
    public void testLightGreen(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getGreenState());
        assertTrue(test.getGreen().isOn());
    }
    public void testLightGreen1(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getYellowState().getNextState());
        assertFalse(test.getGreen().isOn());
    }

    @Test
    @DisplayName("is light red")
    public void testLightREd(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getRedState());
        assertTrue(test.getRed().isOn());
    }
    public void testLightREd1(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getYellowState());
        assertFalse(test.getRed().isOn());
    }
    @Test
    @DisplayName("is light yellow")
    public void testLightYellow(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getYellowState());
        assertTrue(test.getYellow().isOn());
    }
    public void testLightYellow1(){

        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        TrafficLightGui test = new TrafficLightGui(ctrl);
        test.update(ctrl.getRedState());
        assertFalse(test.getYellow().isOn());
    }

}
