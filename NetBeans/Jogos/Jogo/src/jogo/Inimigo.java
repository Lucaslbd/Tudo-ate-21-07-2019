package jogo;


import java.util.Random;
import jplay.Window;


public class Inimigo extends ator {
    private final double ataque=1;
    
    
    public Inimigo(int x, int y,String caminho) {        
        super((caminho),16);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this. velocidade = 0.8;
    }
    public void perseguir(double x , double y){
        if(this.x > x && this.y <=y +50 && this.y >= y -30){
            moveTo(x, y, velocidade);
            if(direcao!=1){
                setSequence(5,8);
                direcao =1;
            }
            movendo = true;
        }else if(this.x <x && this.y <= y +50 && this.y >= -20){
            moveTo(x, y, velocidade);
            if(direcao!=2){
            setSequence(9,12);
            direcao =2;
            }
            movendo =true;
        }else if(this.y >y){
            moveTo(x, y, velocidade);
            if(direcao!=4){
                setSequence(13,16);
                direcao =4;
            }
            movendo = true;
        }else if(this.y <y){
            moveTo(x, y, velocidade);
            if(direcao!=5){
                setSequence(1,4);
                direcao =5;
            }
             movendo = true;
        }
        if(movendo){
            update();
            movendo = false;
        }            
    }    
    public  void morrer(){       
       Random ran = new Random();
       int posicao =-1000 + ran.nextInt(2000);
       int posicao2 =-1000 +  ran.nextInt(2000);
           if(Inimigo.energia <=0){
           Inimigo.energia = 1000;
          this.x =posicao;
          this.y =posicao2;  
          velocidade+=0.5;
       }          
           }     
     
   public void morrer2(Window janela){
      if(Inimigo.energia <=0){
          this.velocidade =0;
         // this.ataque =0;
          this.direcao =0;
          this.movendo = false;
          Inimigo.energia = 1000;
          this.x =100000;
          
               
        }
    }  
    
    public void atacar(Jogador jogador){
        if(this.collided(jogador)){
            Jogador.energiab -= this.ataque;            
        }
        if(Jogador.energiab <=0){
         System.exit(0);
        }
    }
     
    
     
  

}
