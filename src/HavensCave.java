

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import level.L1;
import leveleditor.Leveleditor;

/**
 * Write a description of JavaFX class PushyIsland here.
 *
 * @author Steven, Dane, Max
 * @version 1.0
 */
public class HavensCave extends Application
{
    
	Stage s;
	Scene startlevel;
	
	private StageCreator sc = new StageCreator(new L1());
	private Leveleditor le = new Leveleditor();
	private MainMenu mm = new MainMenu();
	
	String musicFile = "src\\res\\audio\\PushysCaveAdventure.mp3";     // For example
	Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	
    
	public static void main(String args[]) {
		launch();
	}
	
    @Override
    public void start(Stage stage) throws Exception
    {

    	

    	Scene scene = new Scene(mm);

    	//Scene scene = new Scene(sc);

    	
    	
        stage.setTitle("Haven's Cave Adventure");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        //stage.getIcons().add(new Image(HavensCave.class.getResourceAsStream("src\\res\\img\\player.png")));
        stage.getIcons().add(new Image("file:src\\res\\img\\player.png"));
        stage.show();
        
        s = stage;
        startlevel = new Scene(sc);
        
        mm.bStart.setOnAction(this::startLevel);
        
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }
    
    private void startLevel(ActionEvent e){
        s.setScene(startlevel);
        sc.initKeyListener(startlevel);
        s.show();
    }
}
