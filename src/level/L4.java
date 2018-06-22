package level;

import boeden.Bombenplatz;
import boeden.KeyLock;
import boeden.Ladder;
import boeden.Sand;
import boeden.Schlucht;
import boeden.Wandwall;
import entities.Bombe;
import entities.Bruchstein;
import entities.Key;
import entities.Player;

public class L4 extends Level {
	public L4() {
		super(16,32, 4);
		
		boden[1][5] = new KeyLock();boden[2][5] = new Sand();boden[2][10] = new Sand();boden[2][11] = new Sand();boden[2][12] = new Sand();boden[2][13] = new Sand();boden[2][14] = new Sand();boden[2][15] = new Sand();boden[2][16] = new Sand();boden[2][17] = new Sand();boden[3][5] = new Sand();boden[3][10] = new Sand();boden[3][17] = new Sand();boden[3][18] = new Sand();boden[3][19] = new Sand();boden[4][5] = new Sand();boden[4][6] = new Sand();boden[4][7] = new Sand();entities[4][7] = new Bruchstein();boden[4][8] = new Sand();boden[4][9] = new Sand();entities[4][9] = new Bruchstein();boden[4][10] = new Sand();boden[4][19] = new Sand();boden[4][21] = new Sand();boden[4][22] = new Bombenplatz();boden[4][23] = new Sand();boden[5][5] = new Sand();boden[5][6] = new Sand();boden[5][8] = new Sand();entities[5][8] = new Bombe();boden[5][9] = new Sand();boden[5][10] = new Sand();boden[5][16] = new Sand();boden[5][17] = new Sand();boden[5][18] = new Sand();boden[5][19] = new Sand();entities[5][19] = new Bombe();boden[5][20] = new Sand();boden[5][21] = new Sand();boden[5][22] = new Sand();boden[5][23] = new Sand();boden[6][5] = new Sand();boden[6][8] = new Sand();boden[6][15] = new Sand();boden[6][16] = new Sand();boden[6][17] = new Sand();boden[6][18] = new Sand();entities[6][18] = new Bruchstein();boden[6][21] = new Sand();boden[6][22] = new Sand();boden[6][23] = new Sand();boden[7][4] = new Sand();boden[7][5] = new Sand();boden[7][6] = new Sand();boden[7][8] = new Sand();boden[7][9] = new Sand();boden[7][10] = new Sand();boden[7][11] = new Sand();boden[7][12] = new Sand();boden[7][13] = new Sand();boden[7][14] = new Schlucht();boden[7][15] = new Sand();boden[7][18] = new Ladder();boden[8][4] = new Sand();boden[8][5] = new Sand();entities[8][5] = new Key();boden[8][6] = new Sand();boden[8][8] = new Sand();boden[8][13] = new Sand();boden[8][14] = new Sand();boden[8][15] = new Sand();entities[8][15] = new Bombe();boden[8][16] = new Sand();boden[8][18] = new Ladder();boden[9][4] = new Sand();boden[9][5] = new Sand();boden[9][6] = new Sand();boden[9][8] = new Sand();boden[10][8] = new Sand();boden[10][9] = new Sand();boden[11][8] = new Sand();boden[11][9] = new Sand();entities[11][9] = new Player();Player pp = new Player();entities[11][9] = pp;pp.setX(9);pp.setY(11);p = pp;
	}
}
