package boeden;

/**
 * Write a description of class Boden here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Boden
{
    protected boolean walkable;
    
    public Boden(boolean pWalkable){
        walkable = pWalkable;
    }
    
    public Boden(){
        walkable = false;
    }
    
    public boolean isWalkable() {
    	return walkable;
    }
}
