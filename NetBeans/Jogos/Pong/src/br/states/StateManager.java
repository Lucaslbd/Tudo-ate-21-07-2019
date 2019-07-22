package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener{

    public static final int NUMBER_STATES = 2;
    public static State[] states = new State[NUMBER_STATES];
    public static int currentState;   
    public static final int MENU = 0;
    public static final int LEVEL1 = 1;      

    public StateManager() {       
        states[0] =  new MenuState();
        states[1] = new LevelOneState();      
    }
    
    public static void setState(int state) {
        currentState = state;
        states[currentState].init();
    }
    
    public static State getState() {
        return states[currentState];
    }


    public void update() {
        states[currentState].update();
    }

    public void render(Graphics g) {
        states[currentState].render(g);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        states[currentState].KeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
         states[currentState].KeyReleased(e.getKeyCode());
    }
}
