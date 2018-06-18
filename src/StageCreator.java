import java.io.FileInputStream;
import java.io.FileNotFoundException;

import boeden.Boden;
import boeden.Sand;
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
    
    Image iPlayer, iWand, iBoden;

    public StageCreator(Level pL) {
        level = pL;
        p = level.getPlayer();
        setHeight(level.getHoehe());
        setWidth(level.getBreite());

        views = new ImageView[level.getHoehe()][level.getBreite()];

        initPics();
        init();
    }
    public void initPics() {
    	try {
            iWand = new Image(new FileInputStream("src\\res\\img\\wand.png"));
            iBoden = new Image(new FileInputStream("src\\res\\img\\sand.png"));
            iPlayer = new Image(new FileInputStream("src\\res\\img\\player.png"));
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
                }else if(level.boden[i][j] instanceof Sand) {
                    ImageView imageView = new ImageView(iBoden);
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
        boolean find = false;
        int x = p.getX();
        int y = p.getY();
        
       
        switch (direction) {
        	case "up":
        		views[y-1][x].setImage(iPlayer);
        		views[y-1][x].setVisible(true);
            	views[y][x].setVisible(false);
            	p.setY(y-1);
        		break;
        	case "down":
        		views[y+1][x].setImage(iPlayer);
        		views[y+1][x].setVisible(true);
            	views[y][x].setVisible(false);
            	p.setY(y+1);
        		break;
        	case "left":
        		views[y][x-1].setImage(iPlayer);
        		views[y][x-1].setVisible(true);
            	views[y][x].setVisible(false);
            	p.setX(x-1);
        		break;
        	case "right":
        		views[y][x+1].setImage(iPlayer);
        		views[y][x+1].setVisible(true);
            	views[y][x].setVisible(false);
            	p.setX(x+1);
        		break;
        }
        /*
        while(!find) { //muss geloescht werden
            int i = 0;
            int j = 0;
            if(level.entities[i][j] instanceof Player) {
                find = true;
                if(direction.equals("up")) {
                    if(level.boden[i+1][j].isWalkable()) {
                        level.entities[i+1][j] = level.entities[i][j];
                        level.entities[i][j] = null;
                        views[i+1][j] = views[i][j];
                        views[i][j] = null;
                        views[i+1][j].setLayoutY(views[i+1][j].getLayoutY());

                    }
                }
                if(direction.equals("down")) {
                    System.out.println("down");
                }
                if(direction.equals("left")) {
                    System.out.println("left");
                }
                if(direction.equals("right")) {
                    System.out.println("right");
                }
                find = true;
            }else {
                if(j < level.getBreite()) {
                    j++;
                }else {
                    j = 0;
                    i++;
                }
            }
        }*/

    }
    public int getBreite() {
        return level.getBreite();
    }

    public int getHoehe() {
        return level.getHoehe();
    }

}