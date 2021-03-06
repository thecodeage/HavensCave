import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import level.L2;
import level.L3;
import level.L4;
import level.L5;
import level.Level;

public class LevelSelection extends GridPane {
	
	GridPane pHilfspane = new GridPane();
	Button bLevel1 = new Button("Level 1");
	Button bLevel2 = new Button("Level 2");
	Button bLevel3 = new Button("Level 3");
	Button bBack = new Button("Zurueck");
	Button bLevel4 = new Button("Level 4");
	Button bLevel5 = new Button("Level 5");
	Button bLevel6 = new Button("Level 6");
	Button bLevel7 = new Button("Level 7");
	Button bLevel8 = new Button("Level 8");
	Button bLevel9 = new Button("Level 9");
	Button bLevel10 = new Button("Level 10");
	Button bLevel11 = new Button("Level 11");
	Button bLevel12 = new Button("Level 12");
	Button bLevel13 = new Button("Level 13");
	Button bLevel14 = new Button("Level 14");
	Button bLevel15 = new Button("Level 15");
	
	Text tTitel = new Text("Levelauswahl");
	DropShadow ds = new DropShadow();
	Image hintergrundbild;
	
	MediaPlayer mPlayer;
	Media lsMusic;
	Stage s;
	
	public LevelSelection() {
		lsMusic = new Media(new File("src\\res\\audio\\PushysCaveLevelSelection.mp3").toURI().toString());
		try {
			hintergrundbild = new Image(new FileInputStream("src\\res\\img\\mainmenu.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(1024, 512, false, false, true, false);
		BackgroundImage backgroundImage = new BackgroundImage (hintergrundbild, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		
		style();
		initButtons();
		
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
		
		add(pHilfspane, 0, 1);
		pHilfspane.setVgap(5.0);
		pHilfspane.setHgap(5.0);
		
		
		add(tTitel, 0, 0);
		
		pHilfspane.add(bLevel1, 0, 0);
		pHilfspane.add(bLevel2, 0, 1);
		pHilfspane.add(bLevel3, 0, 2);
		pHilfspane.add(bBack, 0, 5);
		pHilfspane.add(bLevel4, 0, 3);
		pHilfspane.add(bLevel5, 0, 4);
		pHilfspane.add(bLevel6, 1, 0);
		pHilfspane.add(bLevel7, 1, 1);
		pHilfspane.add(bLevel8, 1, 2);
		pHilfspane.add(bLevel9, 1, 3);
		pHilfspane.add(bLevel10, 1, 4);
		pHilfspane.add(bLevel11, 2, 0);
		pHilfspane.add(bLevel12, 2, 1);
		pHilfspane.add(bLevel13, 2, 2);
		pHilfspane.add(bLevel14, 2, 3);
		pHilfspane.add(bLevel15, 2, 4);
		
		
		
	}
	
	public void style() {
		bLevel1.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
		        + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel2.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
		        + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel3.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
		        + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bBack.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
		        + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel4.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel5.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel6.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel7.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel8.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel9.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel10.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel11.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel12.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel13.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel14.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
		
		bLevel15.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 30;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
	}
	
	public void setStage(Stage pS) {
		s = pS;
	}
	
	public void setMediaPlayer(MediaPlayer mp) {
		mPlayer = mp;
		mPlayer.stop();
		mPlayer = new MediaPlayer(lsMusic);
		mPlayer.setVolume(0.2);
		mPlayer.play();
	}
	
	public void initButtons() {
		bBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				MainMenu mm = new MainMenu();
                mm.setStage(s);
                mm.setMediaPlayer(mPlayer);
                Scene scene2 = new Scene(mm, 1024, 512);
                s.setScene(scene2);
                s.show();
			}
		});
		bLevel1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startLevel(1);
			}
		});
		bLevel2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startLevel(2);
			}
		});
		bLevel3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startLevel(3);
			}
		});
		bLevel4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startLevel(4);
			}
		});
		bLevel5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startLevel(5);
			}
		});
	}

	public void startLevel(int lid) {
		StageCreator sc;
		switch (lid){
	        default: sc = new StageCreator(new L1()); break;
	        case 1: sc = new StageCreator(new L1()); break;
	        case 2: sc = new StageCreator(new L2()); break;
	        case 3: sc = new StageCreator(new L3()); break;
	        case 4: sc = new StageCreator(new L4()); break;
	        case 5: sc = new StageCreator(new L5()); break;
		}
		startsound();	
		sc.initMediaPlayer(mPlayer);
		sc.setStage(s);
		Scene scene = new Scene(sc);
		sc.initKeyListener(scene);
		s.setScene(scene);
	}
	
	public void startsound() {
		MediaPlayer mp2 = new MediaPlayer(new Media(new File("src\\res\\audio\\start.mp3").toURI().toString()));
		mp2.setVolume(0.5);
		mp2.play();
	}
}
