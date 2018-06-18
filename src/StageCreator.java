import java.io.FileInputStream;
import java.io.FileNotFoundException;

import boeden.Boden;
import boeden.Bombenplatz;
import boeden.KeyLock;
import boeden.Ladder;
import boeden.Sand;
import boeden.Schlucht;
import boeden.Wandwall;
import entities.Bombe;
import entities.Key;
import entities.Player;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import level.L1;
import level.Level;
import javafx.scene.control.Button;

/**
 * Write a description of class StageCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StageCreator extends GridPane{

    private Level level;
    private ImageView[][] views;
    private Player p;
    
    Image iBombe, iBombenPlatz, iEmpty, iKey, iKeylock, iLadder, iPlayer, iSand, iSchlucht, iWand, iWandwall;

    public StageCreator(Level pL) {
        level = pL;
        p = level.getPlayer();
        setHeight(level.getHoehe());
        setWidth(level.getBreite());

        views = new ImageView[level.getHoehe()][level.getBreite()];

        initImages();
        init();
    }
    public void initImages() {
		try {
			iBombe = new Image(new FileInputStream("src\\res\\img\\bombe.png"));
			iBombenPlatz = new Image(new FileInputStream("src\\res\\img\\bombenplatz.png"));
			iKey = new Image(new FileInputStream("src\\res\\img\\key.png"));
			iKeylock = new Image(new FileInputStream("src\\res\\img\\keylock.png"));
			iLadder = new Image(new FileInputStream("src\\res\\img\\ladder.png"));
			iPlayer = new Image(new FileInputStream("src\\res\\img\\player.png"));
			iSand = new Image(new FileInputStream("src\\res\\img\\sand.png"));
			iSchlucht = new Image(new FileInputStream("src\\res\\img\\schlucht.png"));
			iWand = new Image(new FileInputStream("src\\res\\img\\wand.png"));
			iWandwall = new Image(new FileInputStream("src\\res\\img\\wandwall.png"));
			
			iEmpty = new Image(new FileInputStream("src\\res\\img\\empty.png"));

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}

    public void init() {
        for(int i = 0;i<level.getHoehe();i++) {
            for(int j = 0;j<level.getBreite();j++) {
                if(level.boden[i][j] == null) {
                    ImageView imageView = new ImageView(iWand);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Bombenplatz) {
                    ImageView imageView = new ImageView(iBombenPlatz);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof KeyLock) {
                    ImageView imageView = new ImageView(iKeylock);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Ladder) {
                    ImageView imageView = new ImageView(iLadder);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Sand) {
                    ImageView imageView = new ImageView(iSand);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Schlucht) {
                    ImageView imageView = new ImageView(iSchlucht);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Wandwall) {
                    ImageView imageView = new ImageView(iWandwall);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                }
                
                
            

                
                if(level.entities[i][j] == null) {
                	ImageView imageView = new ImageView();
                	imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Bombe) {
                    ImageView imageView = new ImageView(iBombe);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Key) {
                    ImageView imageView = new ImageView(iKey);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Player) {
                    ImageView imageView = new ImageView(iPlayer);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }
            }
        }
    }
    
    public void initKeyListener(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:    move("up"); break;
                        case DOWN:  move("down"); break;
                        case LEFT:  move("left"); break;
                        case RIGHT: move("right"); break;
                        //case SHIFT: move("up"); break;
                        default:
                        break;
                    }
                }
            });
    }

    public void move(String direction) {
        int x = p.getX();
        int y = p.getY();
        int yN, xN;
       
        switch (direction) {
        	default:
        		break;
        	case "up":
        		yN = y-1;
        		xN = x;
        		if(canWalk(yN, xN)) {
        			views[yN][xN].setImage(iPlayer);
            		views[yN][xN].setRotate(0);
            		views[yN][xN].setVisible(true);
                	views[y][x].setVisible(false);
                	p.setY(yN);
        		}else {
        			views[y][x].setRotate(0);
        		}
        		break;
        	case "down":
            	yN = y+1;
        		xN = x;
        		if(canWalk(yN, xN)) {
        			views[yN][xN].setImage(iPlayer);
            		views[yN][xN].setRotate(180);
            		views[yN][xN].setVisible(true);
                	views[y][x].setVisible(false);
                	p.setY(yN);
        		}else {
        			views[y][x].setRotate(180);
        		}
        		break;
        	case "left":
        		yN = y;
        		xN = x-1;
        		if(canWalk(yN, xN)) {
        			views[yN][xN].setImage(iPlayer);
            		views[yN][xN].setRotate(270);
            		views[yN][xN].setVisible(true);
                	views[y][x].setVisible(false);
                	p.setX(xN);
        		}else {
        			views[y][x].setRotate(270);
        		}
        		break;
        	case "right":
        		yN = y;
        		xN = x+1;
        		if(canWalk(yN, xN)) {
        			views[yN][xN].setImage(iPlayer);
            		views[yN][xN].setRotate(90);
            		views[yN][xN].setVisible(true);
                	views[y][x].setVisible(false);
                	p.setX(xN);
        		}else {
        			views[y][x].setRotate(90);
        		}
        		break;
        }
        
    }

    private boolean canWalk(int x, int y) {
    	if(level.boden[x][y] == null) {
    		return false;
    	}else if(level.boden[x][y].isWalkable()) {
    		return true;
		}else {
		    return false;
		}
    	
    }
    
    public int getBreite() {
        return level.getBreite();
    }

    public int getHoehe() {
        return level.getHoehe();
    }

}