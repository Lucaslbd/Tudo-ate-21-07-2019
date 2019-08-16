package br.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateManager implements KeyListener{

    public static final int NUMBER_STATES = 3;
    public static State[] states = new State[NUMBER_STATES];
    public static int currentState = 0;
    public static final int FPS = 0;
    public static final int MENU = 1;
    public static final int LEVEL1 = 2;

    public static void setState(int state) {
        currentState = state;
        states[currentState].init();
    }

    public StateManager() {
        states[0] = new FPState();
        states[1] =  new MenuState();
        states[2] = new LevelOneState();
    }

    public void update() {
        states[currentState].update();
    }

    public void render(Graphics g) {
        states[currentState].render(g);
    }

    public static State getState() {
        return states[currentState];
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