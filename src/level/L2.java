package level;

import boeden.Bombenplatz;
import boeden.KeyLock;
import boeden.Ladder;
import boeden.Sand;
import boeden.Schlucht;
import entities.Bombe;
import entities.Bruchstein;
import entities.Key;
import entities.Player;


public class L2 extends Level{
	public L2() {
		super(16,32);
		boden[3][18] = new Sand();boden[3][19] = new Sand();boden[3][20] = new Sand();boden[3][21] = new Sand();boden[3][22] = new Sand();boden[4][15] = new Sand();boden[4][16] = new Sand();boden[4][17] = new Sand();boden[4][18] = new Sand();boden[4][19] = new Sand();boden[4][22] = new Sand();boden[5][11] = new Sand();boden[5][12] = new Sand();boden[5][13] = new Sand();boden[5][14] = new Sand();entities[5][14] = new Key();boden[5][15] = new Sand();boden[5][16] = new Sand();boden[5][18] = new Schlucht();boden[5][19] = new Sand();boden[5][22] = new Sand();boden[6][11] = new Sand();boden[6][15] = new Sand();boden[6][16] = new Sand();boden[6][19] = new Sand();entities[6][19] = new Bruchstein();boden[6][22] = new Sand();boden[7][5] = new Sand();boden[7][6] = new Sand();boden[7][7] = new Sand();boden[7][8] = new Sand();boden[7][9] = new Sand();boden[7][10] = new Sand();boden[7][11] = new Sand();boden[7][19] = new Sand();boden[7][22] = new Sand();boden[8][5] = new Sand();boden[8][6] = new Sand();boden[8][7] = new Sand();boden[8][8] = new Sand();boden[8][9] = new Sand();boden[8][10] = new Sand();boden[8][11] = new Sand();boden[8][12] = new KeyLock();boden[8][13] = new Sand();boden[8][14] = new Sand();boden[8][15] = new Sand();entities[8][15] = new Bombe();boden[8][16] = new Sand();boden[8][17] = new Sand();boden[8][18] = new Sand();boden[8][19] = new Sand();boden[8][20] = new Sand();boden[8][21] = new Sand();boden[8][22] = new Sand();boden[9][5] = new Ladder();boden[9][6] = new Sand();boden[9][7] = new Sand();boden[9][8] = new Sand();boden[9][9] = new Sand();boden[9][10] = new Sand();boden[9][11] = new Sand();boden[9][12] = new Sand();boden[9][13] = new Sand();boden[9][18] = new Sand();boden[9][19] = new Sand();boden[10][5] = new Sand();boden[10][6] = new Sand();boden[10][7] = new Sand();boden[10][8] = new Sand();boden[10][9] = new Sand();boden[10][10] = new Sand();boden[10][11] = new Bombenplatz();
		
		entities[8][7] = new Player();Player pp = new Player();entities[8][7] = pp;pp.setX(7);pp.setY(8);p = pp;
	}
}
