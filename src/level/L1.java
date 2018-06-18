package level;

import boeden.Sand;
import entities.Player;

public class L1 extends Level{
	
	
	public L1() {
		super(16, 32);
		
		boden[1][1] = new Sand();
		boden[1][2] = new Sand();
		boden[1][3] = new Sand();
		boden[2][3] = new Sand();
		boden[3][3] = new Sand();
		boden[3][4] = new Sand();
		
		entities[3][3] = new Player();
		
	}
}
