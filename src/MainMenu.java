
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainMenu extends GridPane{
	
	Button b1 = new Button("Jooo Steven!");

	public MainMenu() {
		setHeight(400);
		setWidth(700);
		
		add(b1, 0, 0);
	}
}
