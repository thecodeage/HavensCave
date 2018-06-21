import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
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

public class LevelSelection extends GridPane {
	Button bLevel1 = new Button("Level 1");
	Button bLevel2 = new Button("Level 2");
	Button bLevel3 = new Button("Level 3");
	Button bCustom = new Button("Custom Level");
	Button bLevel4 = new Button("Level 4");
	Button bLevel5 = new Button("Level 5");
	Button bLevel6 = new Button("Level 6");
	Button bLevel7 = new Button("Level 7");
	Button bLevel8 = new Button("Level 8");
	Button bLevel9 = new Button("Level 9");
	Button bLevel10 = new Button("Level 10");
	Button bLevel11 = new Button("Level 11");
	Button bLevel12 = new Button("Level 12");
	Text tTitel = new Text("Levelauswahl");
	DropShadow ds = new DropShadow();
	Image hintergrundbild;
	
	
	
	public LevelSelection() {
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
		add(bLevel1, 0, 1);
		add(bLevel3, 0, 3);
		add(bLevel2, 0, 2);
		add(bCustom, 0, 6);
		add(bLevel4, 0, 4);
		add(bLevel5, 0, 5);
		add(bLevel6, 1, 1);
		add(bLevel7, 1, 2);
		add(bLevel8, 1, 3);
		add(bLevel9, 1, 4);
		add(bLevel10, 1, 5);
		add(bLevel11, 2, 1);
		add(bLevel12, 2, 2);
		
		
	}
	
	public void style() {
		bLevel1.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;"
				+ "-fx-border-radius: 20px;"
				+ ""); 
		
		bLevel2.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;");
		
		bLevel3.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;");
		
		bCustom.setStyle(""
				+ "-fx-font-size: 15;"
				+ "-fx-border-style: solid;"
                + "-fx-border-color: black;");
	}
	
}
