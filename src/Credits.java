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
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Credits extends GridPane {

	Text tTitel = new Text("Credits");
	Text tSteven = new Text("Steven - Composer, Designer, Developer / Konzeptarbeit");
	Text tMax = new Text("Max - Executive Developer / Konzeptarbeit");
	Text tDane = new Text("Dane - Graphics Artist, Designer, Leveldesigner");
	Text tTom = new Text("Tom D. - Leveldesigner");
	Button bZurueck = new Button("Zurueck");
	DropShadow ds = new DropShadow();
	Image hintergrundbild;
	Stage s;
	MediaPlayer mPlayer;
	
	public Credits() {
		
		try {
			hintergrundbild = new Image(new FileInputStream("src\\res\\img\\mainmenu.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BackgroundSize backgroundSize = new BackgroundSize(1024, 512, false, false, true, false);
		BackgroundImage backgroundImage = new BackgroundImage (hintergrundbild, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		
		//setGridLinesVisible(true);
		setPadding(new Insets(5,5,5,5));
				
		setBackground(background);
		setHeight(512);
		setWidth(1024);
		setVgap(15.0);
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
		
		tMax.setEffect(ds);
		tMax.setCache(true);
		tMax.setX(10.0f);
		tMax.setY(270.0f);
		tMax.setFill(Color.WHITE);;
		tMax.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		tSteven.setEffect(ds);
		tSteven.setCache(true);
		tSteven.setX(10.0f);
		tSteven.setY(270.0f);
		tSteven.setFill(Color.WHITE);;
		tSteven.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		tDane.setEffect(ds);
		tDane.setCache(true);
		tDane.setX(10.0f);
		tDane.setY(270.0f);
		tDane.setFill(Color.WHITE);;
		tDane.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		tTom.setEffect(ds);
		tTom.setCache(true);
		tTom.setX(10.0f);
		tTom.setY(270.0f);
		tTom.setFill(Color.WHITE);;
		tTom.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		style();
		
		add(tTitel, 0, 0);
		add(tMax, 0, 1);
		add(tSteven, 0, 2);
		add(tDane, 0, 3);
		add(tTom, 0 , 4);
		add(bZurueck, 0, 5);
	}
	
	private void style() { //Hier müssen die Buttons noch angepasst werden
		bZurueck.setStyle(""
				+ "-fx-background-radius: 20;"
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none");
	}
	
	public void setStage(Stage pS) {
		s = pS;
		
		bZurueck.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MainMenu mm = new MainMenu();
		        mm.setStage(s);
		        mm.setMediaPlayer(mPlayer);
		        Scene scene2 = new Scene(mm, 1024, 512);
		        s.setScene(scene2);
		        s.show();
			}
		});
	}
	
	public void setMediaPlayer(MediaPlayer mp) {
		mPlayer = mp;
	}
}
