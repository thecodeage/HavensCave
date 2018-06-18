package entities;

/**
 * Write a description of class Entities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Entity
{
    protected boolean moveable;
    
    public Entity(boolean pMoveable){
        moveable = pMoveable;
    }
    
    public Entity() {
    	moveable = false;
    }
}
