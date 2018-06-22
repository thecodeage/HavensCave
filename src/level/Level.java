package level;
import boeden.Boden;
import entities.Entity;
import entities.Player;

/**
 * Write a description of class Level here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Level
{
    protected int breite, hoehe;
    public Entity[][] entities;
    public Boden[][] boden;
    protected Player p;
    protected int id;

    public Level(int pHoehe, int pBreite, int pId){
        breite = pBreite;
        hoehe = pHoehe;
        id = pId;
        
        entities = new Entity[hoehe][breite];
        boden = new Boden[hoehe][breite];
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }
    
    public int getID() {
        return id;
    }
    
    public Player getPlayer(){
        return p;
    }
}