import java.io.File;
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
import entities.Bruchstein;
import entities.Key;
import entities.Player;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import level.L1;
import level.Level;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

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
    private GridPane game;
    
    Image iBombe, iBombenPlatz, iBruchstein, iEmpty, iKey, iKeylock, iKeylockopen, iLadder, iPlayer, iSand, iSchlucht, iWand, iWandwall;

    Media bgMusic1, bgMusic2, winSound, loseSound;
    MediaPlayer mPlayer;
    Stage s;
    
    public StageCreator(Level pL) {
    	bgMusic1 = new Media(new File("src\\res\\audio\\PushysCaveAdventure.mp3").toURI().toString());
    	bgMusic2 = new Media(new File("src\\res\\audio\\PushysCaveAdventure2.mp3").toURI().toString());
    	winSound = new Media(new File("src\\res\\audio\\win.mp3").toURI().toString());
    	loseSound = new Media(new File("src\\res\\audio\\lose.mp3").toURI().toString());
    	
        level = pL;
        p = level.getPlayer();
        setHeight(level.getHoehe());
        setWidth(level.getBreite());
        
        game = new GridPane();

        views = new ImageView[level.getHoehe()][level.getBreite()];

        initImages();
        init();
    }
    
    public void initMediaPlayer(MediaPlayer mp) {
    	
    	mPlayer = mp;
    	mPlayer.stop();
    	int i = (int) Math.random()*2;
    	if(i == 1) {
    		mPlayer = new MediaPlayer(bgMusic1);
    	}else {
    		mPlayer = new MediaPlayer(bgMusic2);
    	}
    	mPlayer.setVolume(0.2);
    	mPlayer.play();
    }
    
    public void setStage(Stage pS) {
    	s = pS;
    }
    
    public void initImages() {
		try {
			iBombe = new Image(new FileInputStream("src\\res\\img\\bombe.png"));
			iBombenPlatz = new Image(new FileInputStream("src\\res\\img\\bombenplatz.png"));
			iBruchstein = new Image(new FileInputStream("src\\res\\img\\bruchstein.png"));
			iKey = new Image(new FileInputStream("src\\res\\img\\key.png"));
			iKeylock = new Image(new FileInputStream("src\\res\\img\\keylock.png"));
			iKeylockopen = new Image(new FileInputStream("src\\res\\img\\keylockopen.png"));
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
    	// Create MenuBar
        MenuBar menuBar = new MenuBar();
        
        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        
        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        MenuItem openFileItem = new MenuItem("Open File");
        MenuItem exitItem = new MenuItem("Exit");
        
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        
        // Add menuItems to the Menus
        fileMenu.getItems().addAll(newItem, openFileItem, exitItem);
        editMenu.getItems().addAll(copyItem, pasteItem);
        
        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        add(menuBar, 0, 0);
    	
        for(int i = 0;i<level.getHoehe();i++) {
            for(int j = 0;j<level.getBreite();j++) {
                if(level.boden[i][j] == null) {
                    ImageView imageView = new ImageView(iWand);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Bombenplatz) {
                    ImageView imageView = new ImageView(iBombenPlatz);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof KeyLock) {
                    ImageView imageView = new ImageView(iKeylock);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Ladder) {
                    ImageView imageView = new ImageView(iLadder);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Sand) {
                    ImageView imageView = new ImageView(iSand);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Schlucht) {
                    ImageView imageView = new ImageView(iSchlucht);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }else if(level.boden[i][j] instanceof Wandwall) {
                    ImageView imageView = new ImageView(iWandwall);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                }
                
                
            

                
                if(level.entities[i][j] == null) {
                	ImageView imageView = new ImageView();
                	imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Bombe) {
                    ImageView imageView = new ImageView(iBombe);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Bruchstein) {
                    ImageView imageView = new ImageView(iBruchstein);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Key) {
                    ImageView imageView = new ImageView(iKey);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }else if(level.entities[i][j] instanceof Player) {
                    ImageView imageView = new ImageView(iPlayer);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    game.add(imageView, j*32, i*32);
                    imageView.toFront();
                    views[i][j] = imageView;
                }
            }
        }
        
        add(game, 0, 1);
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
        int xN = x;
        int yN = y;
        int xE = x;
        int yE = y;
        switch (direction) {
        	default: break;
        	case "up": yN = y-1; yE = yN-1; break;
        	case "down": yN = y+1; yE = yN+1; break;
        	case "right": xN = x+1; xE = xN+1; break;
        	case "left": xN = x-1; xE = xN-1; break;
        }
        
        if(xN >= 0 && yN >= 0 && xN < level.getBreite() && yN < level.getHoehe()) {
        	if(level.boden[yN][xN] == null) { //Mauer
        		dreh(direction, y, x);
	       	}else if(level.boden[yN][xN].isWalkable()) { // Untergrund ist begehbar
	       		if(level.entities[yN][xN] == null) { // Nichts im Weg -> Einfach laufen
	       			level.entities[yN][xN] = p;
	       			level.entities[y][x] = null;
	       			views[yN][xN].setImage(iPlayer);
            		dreh(direction, yN, xN);
            		views[yN][xN].setVisible(true);
                	views[y][x].setVisible(false);
                	p.setY(yN); p.setX(xN);
                	checkForAction();
	       		}else if(level.entities[yN][xN].isMoveable()) {
	       			if(!(xE >= 0 && yE >= 0 && xE < level.getBreite() && yE < level.getHoehe())) {
	       				dreh(direction, y, x);
	       			}else if(level.boden[yE][xE] == null) {
	       				dreh(direction, y, x);
	       			}else if(level.boden[yE][xE] instanceof KeyLock) {
	       				if(level.entities[yN][xN] instanceof Key) {
	       					level.entities[yE][xE] = level.entities[yN][xN];
		       				level.entities[yN][xN] = level.entities[y][x];
		       				level.entities[y][x] = null;
		       				
		       				if(views[yN][xN].getImage() == iBombe){ views[yE][xE].setImage(iBombe); }
		       				if(views[yN][xN].getImage() == iKey){ views[yE][xE].setImage(iKey);	}
		       				views[yN][xN].setImage(iPlayer);
		       				dreh(direction, yN, xN);
		       				
		       				views[yE][xE].setVisible(true);
		       				views[yN][xN].setVisible(true);
		                	views[y][x].setVisible(false);
		       				
		                	p.setY(yN); p.setX(xN);
		                	
		                	//KEY INTERACTION
	                			level.entities[yE][xE] = null;
	                			views[yE][xE].setImage(iKeylockopen);
	                		
		       				
		       				checkForAction();
	       				}else {
	       					dreh(direction, y, x);
	       				}
	       			}else if(level.boden[yE][xE].isWalkable()) {
	       				if(level.entities[yE][xE] == null) {
	       					level.entities[yE][xE] = level.entities[yN][xN];
		       				level.entities[yN][xN] = level.entities[y][x];
		       				level.entities[y][x] = null;
		       				
		       				if(views[yN][xN].getImage() == iBombe){ views[yE][xE].setImage(iBombe); }
		       				if(views[yN][xN].getImage() == iKey){ views[yE][xE].setImage(iKey);	}
		       				views[yN][xN].setImage(iPlayer);
		       				dreh(direction, yN, xN);
		       				
		       				views[yE][xE].setVisible(true);
		       				views[yN][xN].setVisible(true);
		                	views[y][x].setVisible(false);
		       				
		                	p.setY(yN); p.setX(xN);
	
		                	checkForAction();
	       				}else {
	       					dreh(direction, y, x);
	       				}
	       			}else {
	       				dreh(direction, y, x);
	       			}
	       		}
	   		}else { //nicht Walkable
	   			dreh(direction, y, x);
	   		}
        }else { //wuerde rauslaufen
        	dreh(direction, y, x);
        }  
    }
    
    private void dreh(String dir, int y, int x) {
    	switch (dir) {
	    	default: break;
	    	case "up": views[y][x].setRotate(0); break;
	    	case "down": views[y][x].setRotate(180); break;
	    	case "right": views[y][x].setRotate(90); break;
	    	case "left": views[y][x].setRotate(270); break;
    	}
    	
    }
    
    private void checkForAction() {
    	int x = p.getX();
    	int y = p.getY();
    	if(level.boden[y][x] instanceof Ladder) {
    		boolean finish = true;
    		for(int i = 0;i<level.getHoehe();i++) {
                for(int j = 0;j<level.getBreite();j++) {
                	if(level.entities[i][j] instanceof Key) {              		
                		finish = false;
                	}
                }
    		}
    		if(finish) {
    			MediaPlayer mp2 = new MediaPlayer(winSound);
    			mp2.setVolume(0.6);
    			mp2.play();
    			LevelSelection ls = new LevelSelection();
				ls.setStage(s);
				ls.setMediaPlayer(mPlayer);
				Scene scene = new Scene(ls);
				s.setScene(scene);
    		}
    	}
    	if(level.boden[y][x] instanceof Bombenplatz) {
    		for(int i = 0;i<level.getHoehe();i++) {
                for(int j = 0;j<level.getBreite();j++) {
                	if(level.entities[i][j] instanceof Bombe) {              		
                		views[i][j].setVisible(false);
                		level.entities[i][j] = null;
                		
                		if(level.entities[i-1][j] instanceof Bruchstein) { views[i-1][j].setVisible(false); level.entities[i-1][j] = null; } //up
                		if(level.entities[i+1][j] instanceof Bruchstein) { views[i+1][j].setVisible(false); level.entities[i+1][j] = null; } //down
                		if(level.entities[i][j+1] instanceof Bruchstein) { views[i][j+1].setVisible(false); level.entities[i][j+1] = null; } //right
                		if(level.entities[i][j-1] instanceof Bruchstein) { views[i][j-1].setVisible(false); level.entities[i][j-1] = null; } //left
                		
                		if(level.entities[i-1][j] instanceof Player) { verloren(); } //up
                		if(level.entities[i+1][j] instanceof Player) { verloren(); } //down
                		if(level.entities[i][j+1] instanceof Player) { verloren(); } //right
                		if(level.entities[i][j-1] instanceof Player) { verloren(); } //left
                	}
                }
    		}
    	}
    	if(level.boden[y][x] instanceof Schlucht) {
    		verloren();
    	}
    	
    	
    }
    
    private void verloren() {
    	mPlayer.stop();
    	MediaPlayer mp2 = new MediaPlayer(loseSound);
		mp2.setVolume(0.6);
		mp2.play();
		
		LevelSelection ls = new LevelSelection();
		ls.setStage(s);
		ls.setMediaPlayer(mPlayer);
		Scene scene = new Scene(ls);
		s.setScene(scene);
    }
    
    //####### GET & SET ###########################################################################################################
    
    public int getBreite() {
        return level.getBreite();
    }

    public int getHoehe() {
        return level.getHoehe();
    }

}