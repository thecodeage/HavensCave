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

public class L5 extends Level {
    public L5() {
        super(16,32, 5);
        
        boden[0][12] = new KeyLock();boden[0][16] = new Ladder();boden[1][12] = new Sand();boden[1][13] = new Sand();boden[1][14] = new Sand();boden[1][15] = new Sand();boden[1][16] = new Sand();boden[2][12] = new Sand();boden[2][13] = new Sand();boden[2][14] = new Sand();boden[2][15] = new Sand();boden[2][16] = new Sand();boden[3][14] = new Sand();boden[3][15] = new Bombenplatz();boden[4][14] = new Sand();boden[5][13] = new Sand();boden[5][14] = new Sand();boden[5][15] = new Sand();boden[6][12] = new Sand();entities[6][12] = new Bombe();boden[6][13] = new Sand();entities[6][13] = new Bombe();boden[6][14] = new Sand();boden[6][15] = new Sand();entities[6][15] = new Bombe();boden[6][16] = new Sand();entities[6][16] = new Bombe();boden[7][12] = new Sand();boden[7][13] = new Sand();entities[7][13] = new Bombe();boden[7][14] = new Sand();entities[7][14] = new Bombe();boden[7][15] = new Sand();entities[7][15] = new Bombe();boden[7][16] = new Sand();boden[8][12] = new Sand();entities[8][12] = new Bombe();boden[8][13] = new Sand();boden[8][14] = new Sand();boden[8][15] = new Sand();boden[8][16] = new Sand();entities[8][16] = new Bombe();boden[9][12] = new Sand();boden[9][13] = new Sand();entities[9][13] = new Bombe();boden[9][14] = new Sand();entities[9][14] = new Bombe();boden[9][15] = new Sand();entities[9][15] = new Bombe();boden[9][16] = new Sand();boden[10][12] = new Sand();boden[10][13] = new Sand();boden[10][14] = new Sand();boden[10][15] = new Sand();boden[10][16] = new Sand();boden[11][12] = new Sand();boden[11][13] = new Sand();boden[11][14] = new Sand();entities[11][14] = new Key();boden[11][15] = new Sand();boden[11][16] = new Sand();boden[12][12] = new Sand();boden[12][13] = new Sand();boden[12][14] = new Sand();boden[12][15] = new Sand();boden[12][16] = new Sand();boden[13][12] = new Sand();boden[13][13] = new Sand();boden[13][14] = new Sand();Player pp = new Player();p = pp;entities[13][14] = pp;pp.setX(14);pp.setY(13);boden[13][15] = new Sand();boden[13][16] = new Sand();
    }
}
