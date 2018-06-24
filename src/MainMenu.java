import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import level.L1;

public class MainMenu extends GridPane{
	
	Button bStart = new Button("Play");
	Button bCredits = new Button("Credits");
	Button bLevelEditor = new Button("Level Editor");
	Text tTitel = new Text("Haven's Cave Adventure");
	DropShadow ds = new DropShadow();
	Image hintergrundbild;
	
	Stage s;
	MediaPlayer mPlayer;
	
	
	public MainMenu() {
		initButtons();
		
		
		try {
			hintergrundbild = new Image(new FileInputStream("src\\res\\img\\mainmenu.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(1024, 512, false, false, true, false);
		BackgroundImage backgroundImage = new BackgroundImage (hintergrundbild, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		
		style();
		
		//setGridLinesVisible(true);
		setPadding(new Insets(5,5,5,5));
		
		setBackground(background);
		setHeight(512);
		setWidth(1024);
		setVgap(8.0);
		//general ds settings
		ds.setOffsetY(3.0f);
		ds.setColor(Color.BLACK);
		
		//Title Style
		tTitel.setEffect(ds);
		tTitel.setCache(true);
		tTitel.setX(10.0f);
		tTitel.setY(270.0f);
		tTitel.setFill(Color.WHITE);;
		tTitel.setFont(Font.font(null, FontWeight.BOLD, 50));
		
		add(tTitel, 0, 0);
		add(bStart, 0, 1);
		add(bCredits, 0, 3);
		add(bLevelEditor, 0, 2);
		
	}
	private void style() { //Hier müssen die Buttons noch angepasst werden
		bStart.setStyle(""
				+ "-fx-background-radius: 40;"
				+ "-fx-font-size: 30;"
                + "-fx-font-weight: bold;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 40px;"
				+ "-fx-border: none");
		
		bLevelEditor.setStyle(""
				+ "-fx-background-radius: 40;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 40px;"
				+ "-fx-border: none");
		
		bCredits.setStyle(""
				+ "-fx-background-radius: 40;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 40px;"
				+ "-fx-border: none");
		
	}

	public void setStage(Stage pS) {
		s = pS;
	}
	
	public void setMediaPlayer(MediaPlayer mp) {
		mPlayer = mp;
	}
	
	public void initButtons() {
		bStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LevelSelection ls = new LevelSelection();
				ls.setStage(s);
				ls.setMediaPlayer(mPlayer);
				Scene scene = new Scene(ls, 1024, 512);
				s.setScene(scene);
			}
			
		});
		bCredits.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
			
		});
		bLevelEditor.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Leveleditor le = new Leveleditor();
				le.setStage(s);
				le.setMediaPlayer(mPlayer);
				Scene scene = new Scene(le);
				s.setScene(scene);
			}
			
		});
	}
}
