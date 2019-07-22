package br.display;

import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Display {
    
    private final JFrame jFrame;
    private final Canvas canvas;
    
    public Display(String titulo, int width, int height) {
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setFocusable(false);
        jFrame = new JFrame(titulo);
        jFrame.add(canvas);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
    
    public BufferStrategy getBufferStrategy() {
        return canvas.getBufferStrategy();
    }
    
    public void createBufferStrategy() {
        canvas.createBufferStrategy(3);
    }
    
    public void setKeyListener(KeyListener kl) {
        jFrame.addKeyListener(kl);
    }
}
