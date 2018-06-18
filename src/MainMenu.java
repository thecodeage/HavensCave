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

public class MainMenu extends GridPane{
	
	Button bStart = new Button("Play");
	Button bCredits = new Button("Credits");
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
		
		//setGridLinesVisible(true);
		setPadding(new Insets(10,10,10,10));
		
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
		add(bCredits, 0, 2);
		
	}
}
