

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

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

	Media mainMenuMusic, bgMusic1, bgMusic2;
    MediaPlayer mediaPlayer;
	
    
	public static void main(String args[]) {
		launch();
	}
	
    @Override
    public void start(Stage stage) throws Exception
    {
    	try {
    		mainMenuMusic = new Media(new File("src\\res\\audio\\PushysCaveTitel.mp3").toURI().toString());
        	bgMusic1 = new Media(new File("src\\res\\audio\\PushysCaveAdventure.mp3").toURI().toString());
        	bgMusic2 = new Media(new File("src\\res\\audio\\PushysCaveAdventure2.mp3").toURI().toString());
        	mediaPlayer = new MediaPlayer(mainMenuMusic);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	


    	mm = new MainMenu();;
    	mm.setMediaPlayer(mediaPlayer);
    	Scene scene = new Scene(mm, 1024, 512);

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
}
