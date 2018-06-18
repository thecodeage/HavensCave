package level;

import boeden.Bombenplatz;
import boeden.Sand;
import entities.Bombe;
import entities.Key;
import entities.Player;

public class L1 extends Level{

    public L1() {
        super(16, 32);

        boden[8][9] = new Sand();boden[8][10] = new Sand();boden[8][11] = new Sand();boden[8][12] = new Sand();boden[8][13] = new Sand();boden[8][14] = new Sand();entities[8][14] = new Bombe();boden[8][15] = new Sand();boden[8][16] = new Sand();boden[9][9] = new Sand();entities[9][9] = new Key();boden[9][10] = new Sand();boden[9][11] = new Sand();boden[9][12] = new Sand();boden[9][16] = new Sand();boden[10][9] = new Sand();boden[10][10] = new Sand();boden[10][11] = new Sand();boden[10][12] = new Bombenplatz();boden[10][16] = new Sand();boden[11][9] = new Sand();boden[11][10] = new Sand();entities[11][10] = new Player();Player pp = new Player();entities[11][10] = pp;pp.setX(10);pp.setY(11);p = pp;boden[11][11] = new Sand();boden[11][12] = new Sand();boden[11][13] = new Sand();boden[11][14] = new Sand();boden[11][15] = new Sand();boden[11][16] = new Sand();boden[12][9] = new Sand();boden[12][10] = new Sand();boden[12][11] = new Sand();boden[12][12] = new Sand();

        

    }
}