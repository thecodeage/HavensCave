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
    
    
    public Level(int pHoehe, int pBreite){
    	breite = pBreite;
    	hoehe = pHoehe;

    	
        entities = new Entity[hoehe][breite];
        boden = new Boden[hoehe][breite];
    }


	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}


    
}
