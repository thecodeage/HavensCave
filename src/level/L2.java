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


public class L2 extends Level{
	public L2() {
		super(16,32);
		boden[3][19] = new Wandwall();boden[3][20] = new Wandwall();boden[3][21] = new Wandwall();boden[3][22] = new Wandwall();boden[3][23] = new Wandwall();boden[4][16] = new Wandwall();boden[4][17] = new Wandwall();boden[4][18] = new Wandwall();boden[4][19] = new Sand();boden[4][20] = new Sand();boden[4][21] = new Sand();boden[4][22] = new Sand();boden[4][23] = new Sand();boden[5][11] = new Wandwall();boden[5][12] = new Wandwall();boden[5][13] = new Wandwall();boden[5][14] = new Wandwall();boden[5][15] = new Wandwall();boden[5][16] = new Sand();boden[5][17] = new Sand();boden[5][18] = new Sand();boden[5][19] = new Sand();boden[5][20] = new Sand();boden[5][23] = new Sand();boden[6][11] = new Sand();boden[6][12] = new Sand();boden[6][13] = new Sand();boden[6][14] = new Sand();boden[6][15] = new Sand();entities[6][15] = new Key();boden[6][16] = new Sand();boden[6][17] = new Sand();boden[6][19] = new Schlucht();boden[6][20] = new Sand();boden[6][23] = new Sand();boden[7][5] = new Wandwall();boden[7][6] = new Wandwall();boden[7][7] = new Wandwall();boden[7][8] = new Wandwall();boden[7][9] = new Wandwall();boden[7][10] = new Wandwall();boden[7][11] = new Sand();boden[7][16] = new Sand();boden[7][17] = new Sand();boden[7][20] = new Sand();entities[7][20] = new Bruchstein();boden[7][23] = new Sand();boden[8][5] = new Sand();boden[8][6] = new Sand();boden[8][7] = new Sand();boden[8][8] = new Sand();boden[8][9] = new Sand();boden[8][10] = new Sand();boden[8][11] = new Sand();boden[8][12] = new Wandwall();boden[8][13] = new Wandwall();boden[8][14] = new Wandwall();boden[8][15] = new Wandwall();boden[8][16] = new Wandwall();boden[8][17] = new Wandwall();boden[8][18] = new Wandwall();boden[8][19] = new Wandwall();boden[8][20] = new Sand();boden[8][21] = new Wandwall();boden[8][22] = new Wandwall();boden[8][23] = new Sand();boden[9][5] = new Sand();boden[9][6] = new Sand();boden[9][7] = new Sand();boden[9][8] = new Sand();entities[9][8] = new Player();Player pp = new Player();entities[9][8] = pp;pp.setX(8);pp.setY(9);p = pp;boden[9][9] = new Sand();boden[9][10] = new Sand();boden[9][11] = new Sand();boden[9][12] = new KeyLock();boden[9][13] = new Sand();boden[9][14] = new Sand();boden[9][15] = new Sand();boden[9][16] = new Sand();entities[9][16] = new Bombe();boden[9][17] = new Sand();boden[9][18] = new Sand();boden[9][19] = new Sand();boden[9][20] = new Sand();boden[9][21] = new Sand();boden[9][22] = new Sand();boden[9][23] = new Sand();boden[10][5] = new Ladder();boden[10][6] = new Sand();boden[10][7] = new Sand();boden[10][8] = new Sand();boden[10][9] = new Sand();boden[10][10] = new Sand();boden[10][11] = new Sand();boden[10][12] = new Sand();boden[10][13] = new Sand();boden[10][19] = new Sand();boden[10][20] = new Sand();boden[11][5] = new Sand();boden[11][6] = new Sand();boden[11][7] = new Sand();boden[11][8] = new Sand();boden[11][9] = new Sand();boden[11][10] = new Sand();boden[11][11] = new Bombenplatz();

	}
}
