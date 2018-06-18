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
	
	
	
	public MainMenu() {
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
		tTitel.setFont(Font.font(null, FontWeight.BOLD, 32));
		
		add(tTitel, 0, 0);
		add(bStart, 0, 1);
		add(bCredits, 0, 3);
		add(bLevelEditor, 0, 2);
		
	}
	private void style() {
		bStart.setStyle(""
				+ "-fx-font-size: 15;"
                + "-fx-font-weight: bold;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ "-fx-border: none"); 
		
		bLevelEditor.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;");
		
		bCredits.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;");
		
	}

}
