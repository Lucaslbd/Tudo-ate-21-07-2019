package jogo;

import jplay.GameObject;
import jplay.TileInfo;


public class Controle {
    
    public boolean colisao(GameObject obj, TileInfo tile){
        if((tile.id >10 && tile.id != 38 && tile.id != 39 && tile.id != 40 && tile.id != 41 && tile.id != 14 && tile.id != 15) && obj.collided(tile)){
            return true;
        }
        return false;
        
    }
    
}