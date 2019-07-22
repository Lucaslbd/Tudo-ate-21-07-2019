package br.states;

import br.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class LevelOneState implements State {

    private final ArrayList<Rectangle> cobra = new ArrayList<>();
    private Rectangle comida;
    private final int LEFT = -2, RIGTH = 2, UP = -2, DOWN = 2;
    private int direcao = 2;
    private int ultimaDirecao = 2;
    private boolean runing = true;

    public LevelOneState() {
        Rectangle peca = new Rectangle(Game.WIDTH / 2, Game.HEIGTH / 2, 10, 10);
        cobra.add(peca);
        botarComida();
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        if (runing) {
            limits();
            atualizaCobra();
        }
    }

    private void atualizaCobra() {
        for (int i = 0; i < cobra.size(); i++) {
            int posicaoAnterior;
            if (i == 0) {
                posicaoAnterior = 0;
            } else {
                posicaoAnterior = i - 1;
            }
            switch (direcao) {
                case 1:
                    if (cobra.get(i).y == cobra.get(posicaoAnterior).y) {
                        cobra.get(i).setLocation(cobra.get(i).x += RIGTH, cobra.get(posicaoAnterior).y);
                    } else {
                        if (ultimaDirecao == 3) {
                            cobra.get(i).y += UP;
                        } else {
                            cobra.get(i).y += DOWN;
                        }
                    }
                    break;
                case 2:
                    if (cobra.get(i).y == cobra.get(posicaoAnterior).y) {
                        cobra.get(i).setLocation(cobra.get(i).x += LEFT, cobra.get(posicaoAnterior).y);
                    } else {
                        if (ultimaDirecao == 4) {
                            cobra.get(i).y += DOWN;
                        } else {
                            cobra.get(i).y += UP;
                        }
                    }
                    break;
                case 3:
                    if (cobra.get(i).x == cobra.get(posicaoAnterior).x) {
                        cobra.get(i).setLocation(cobra.get(posicaoAnterior).x, cobra.get(i).y += UP);
                    } else {
                        if (ultimaDirecao == 2) {
                            cobra.get(i).x += LEFT;
                        } else {
                            cobra.get(i).x += RIGTH;
                        }
                    }
                    break;
                case 4:
                    if (cobra.get(i).x == cobra.get(posicaoAnterior).x) {
                        cobra.get(i).setLocation(cobra.get(posicaoAnterior).x, cobra.get(i).y += DOWN);
                    } else {
                        if (ultimaDirecao == 2) {
                            cobra.get(i).x += LEFT;
                        } else {
                            cobra.get(i).x += RIGTH;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void limits() {
        if (cobra.get(0).intersects(comida)) {
            botarComida();
            aumentarCobra();
        }
    }

    @Override
    public void render(Graphics g) {
        Random cor =  new Random();
        g.setColor(Color.BLACK);
        g.fillRect(10, 0, Game.WIDTH - 10, Game.HEIGTH);        
        g.setColor(new Color(cor.nextInt(255),cor.nextInt(255),cor.nextInt(255)));
        g.fillOval(comida.x, comida.y, comida.width, comida.height);
        for (Rectangle r : cobra) {
            g.fillOval(r.x, r.y, r.width, r.height);
        }
    }

    @Override
    public void KeyPressed(int cod) {
        switch (cod) {
            case KeyEvent.VK_LEFT:
                if (direcao == 3 || direcao == 4) {
                    ultimaDirecao = direcao;
                    direcao = 2;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direcao == 3 || direcao == 4) {
                    ultimaDirecao = direcao;
                    direcao = 1;
                }
                break;
            case KeyEvent.VK_UP:
                if (direcao == 2 || direcao == 1) {
                    ultimaDirecao = direcao;
                    direcao = 3;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direcao == 2 || direcao == 1) {
                    ultimaDirecao = direcao;
                    direcao = 4;
                }
                break;
            case KeyEvent.VK_ENTER:
                runing = !runing;
                break;
            default:
                break;
        }
    }

    @Override
    public void KeyReleased(int cod) {

    }

    private void aumentarCobra() {
        Rectangle ultimaPeca = cobra.get(cobra.size() - 1);
        switch (direcao) {
            case 1:
                cobra.add(new Rectangle(ultimaPeca.x - 10, ultimaPeca.y, 10, 10));
                arrumar();
                break;
            case 2:
                cobra.add(new Rectangle(ultimaPeca.x + 10, ultimaPeca.y, 10, 10));
                arrumar();
                break;
            case 3:
                cobra.add(new Rectangle(ultimaPeca.x, ultimaPeca.y + 10, 10, 10));
                arrumar();
                break;
            case 4:
                cobra.add(new Rectangle(ultimaPeca.x, ultimaPeca.y - 10, 10, 10));
                arrumar();
                break;
            default:
                break;
        }
    }

    private void arrumar() {
        for (int i = 0; i < cobra.size(); i++) {
            int posicaoAnterior;
            if (i == 0) {
                posicaoAnterior = 0;
            } else {
                posicaoAnterior = i - 1;
            }
            switch (direcao) {
                case 1:
                    cobra.get(i).setLocation(cobra.get(posicaoAnterior).x - 10, cobra.get(posicaoAnterior).y);
                    break;
                case 2:
                    cobra.get(i).setLocation(cobra.get(posicaoAnterior).x + 10, cobra.get(posicaoAnterior).y);
                    break;
                case 3:
                    cobra.get(i).setLocation(cobra.get(posicaoAnterior).x, cobra.get(posicaoAnterior).y + 10);
                    break;
                case 4:
                    cobra.get(i).setLocation(cobra.get(posicaoAnterior).x, cobra.get(posicaoAnterior).y - 10);
                    break;
                default:
                    break;
            }
        }
    }

    private void botarComida() {
        Random r = new Random();
        comida = new Rectangle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGTH), 10, 10);
    }
}
