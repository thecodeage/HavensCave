

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import level.L1;
import level.L2;
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
	MainMenu mm;
	
<<<<<<< HEAD
	private StageCreator sc = new StageCreator(new L1());
	private Leveleditor le = new Leveleditor();
	private MainMenu mm = new MainMenu();
	private LevelSelection ls = new LevelSelection();
	
	String musicFile = "src\\res\\audio\\PushysCaveTitel.mp3";     // For example
	Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);
=======
	Media mainMenuMusic, bgMusic1, bgMusic2;
    MediaPlayer mediaPlayer;
>>>>>>> 2128a39c329d65e115657732653fae9b679c2935
	
    
	public static void main(String args[]) {
		launch();
	}
	
    @Override
    public void start(Stage stage) throws Exception
    {
<<<<<<< HEAD
    	

    	Scene scene = new Scene(ls); //mm
=======
    	mainMenuMusic = new Media(new File("src\\res\\audio\\PushysCaveTitel.mp3").toURI().toString());
    	bgMusic1 = new Media(new File("src\\res\\audio\\PushysCaveAdventure.mp3").toURI().toString());
    	bgMusic2 = new Media(new File("src\\res\\audio\\PushysCaveAdventure2.mp3").toURI().toString());
    	mediaPlayer = new MediaPlayer(mainMenuMusic);
>>>>>>> 2128a39c329d65e115657732653fae9b679c2935

    	mm = new MainMenu();;
    	Scene scene = new Scene(mm);

        stage.setTitle("Haven's Cave Adventure");
        stage.getIcons().add(new Image("file:src\\res\\img\\player.png")); //stage.getIcons().add(new Image(HavensCave.class.getResourceAsStream("src\\res\\img\\player.png")));
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        
        stage.show();
        s = stage;
        mm.setStage(s);

        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }
    
    private void startLevel(ActionEvent e){
        //s.setScene(startlevel);
        //sc.initKeyListener(startlevel);
        s.show();
    }
    
    private void startEditor(ActionEvent e){
        //s.setScene(editor);
        //sc.initKeyListener(startlevel);
        s.show();
    }
}
