package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import jplay.Keyboard;
import jplay.Scene;

import jplay.Window;

public class Jogador extends ator {
    static double energiab = 2000;
       
    public Jogador(int x, int y,String caminho) {
        super((caminho),20);
        this.x=x;
        this.y=y;
        this.setTotalDuration(2000);
    }
    
    ContoleTiros tiros = new ContoleTiros();
    int i=0;
    public void Atirar(Window janela, Scene cena, Keyboard teclado, ator inimigo){
        if(teclado.keyDown(KeyEvent.VK_A)){
            tiros.adicionaTiro(x, y +10, direcao, cena);
        }
        tiros.rum(inimigo,janela);
       
        
    }
    
    public void Controle(Window Janela,Keyboard teclado){
       
        if(teclado.keyDown(Keyboard.LEFT_KEY) == true){
            if(this.x >0)
                this.x -= velocidade;
            if(direcao != 1){
              setSequence(4,8);
              direcao =1;
            }
            movendo =true;            
        }else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
             if(this.x <Janela.getWidth()-40)
                this.x += velocidade;
            if(direcao != 2){
              setSequence(8,12);
              direcao =2;
            }
            movendo =true;
        }else if(teclado.keyDown(Keyboard.UP_KEY)){
             if(this.y >0)
                this.y -= velocidade;
            if(direcao != 4){
              setSequence(12,16);
              direcao =4;
            }
            movendo =true;
        }else if(teclado.keyDown(Keyboard.DOWN_KEY)){
             if(this.y <Janela.getHeight()-60 )
                this.y += velocidade;
            if(direcao != 5){
              setSequence(0,4);
              direcao =5;
            }
            movendo =true;
        }
         if(movendo){
             update();
             movendo = false;
         }
    }
    Font f = new Font("arial",Font.BOLD,30);
    public void energia(Window janela){
        janela.drawText("Vida: " + Jogador.energiab, 30, 30, Color.yellow,f );
    }
    
}
