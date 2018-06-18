package entities;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Entity
{
    private int x,y;
    
    public Player() {
        
    }
    
    public void setX(int pX){
        x = pX;
    }
    
    public void setY(int pY){
        y = pY;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}