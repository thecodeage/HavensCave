

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import level.L1;
import leveleditor.Leveleditor;

/**
 * Write a description of JavaFX class PushyIsland here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HavensCave extends Application
{
    
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

    	
        //Scene scene = new Scene(sc);
    	Scene scene = new Scene(mm);
    	sc.initKeyListener(scene);
    	
        stage.setTitle("Haven's Cave Adventure");
        stage.setScene(scene);
        //stage.setResizable(false);
        //stage.sizeToScene();
        stage.show();
        
        
        
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }
}
