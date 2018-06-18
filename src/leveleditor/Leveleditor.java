package leveleditor;



import java.io.FileInputStream;
import java.io.FileNotFoundException;

import boeden.Boden;
import entities.Entity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Leveleditor extends GridPane {

	private int hoehe, breite;
	public Entity[][] entities;
    public Boden[][] boden;
    private ChoiceBox<String> akt;
    private ImageView showAkt;
    
    Image iPlayer, iWand, iBoden, iSand;
	
	public Leveleditor() {
		hoehe = 16;
		breite = 32;
		
		
		entities = new Entity[hoehe][breite];
        boden = new Boden[hoehe][breite];

		setVgap(16);
		
		initImages();
		initButtons();
		initEditor();
	}
	
	public void initImages() {
		try {
            iWand = new Image(new FileInputStream("src\\res\\img\\wand.png"));
            iBoden = new Image(new FileInputStream("src\\res\\img\\sand.png"));
            iPlayer = new Image(new FileInputStream("src\\res\\img\\player.png"));
            iSand = new Image(new FileInputStream("src\\res\\img\\sand.png"));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}
	
	public void initButtons() {
		GridPane pane = new GridPane();
		
		for(int i = 0;i<hoehe;i++) {
			for(int j = 0;j<breite;j++) {
				
				ImageView feld = new ImageView(iWand);
				feld.setFitHeight(32);
				feld.setFitWidth(32);
				feld.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						buttonClicked(e);
					}
					
				});
				pane.add(feld, j, i);
			}
		}
		
		add(pane, 0, 0);
	}

	public void initEditor() {
		GridPane editor = new GridPane();
		
			showAkt = new ImageView(iSand);
			showAkt.setFitHeight(32);
			showAkt.setFitWidth(32);
			editor.add(showAkt, 1, 0);
			ObservableList<String> elementliste //
	        = FXCollections.observableArrayList("Sand", "Wand", "c");
			akt = new ChoiceBox<String>(elementliste);
			akt.setValue("Sand");
			akt.autosize();
			akt.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        String item = akt.getItems().get((Integer) number2);
			        
			        
			        
			        if(item.equals("Sand")) {
			        	showAkt.setImage(iSand);
			        }
			        if(item.equals("Wand")) {
			        	showAkt.setImage(iWand);
			        }
			        
			      }
			    });
			
			editor.add(akt, 0, 0);

			
		add(editor, 0, 1);
	}
	
	
	public void buttonClicked(MouseEvent e) {
		ImageView feld = (ImageView) e.getSource();

		switch (akt.getValue()) {
			case "Sand":
				feld.setImage(iSand);
				break;
			case "Wand":
				feld.setImage(iWand);
				break;
		}
	}	
	
	public int getBreite() {
		return breite;
	}
	
	public int getHoehe() {
		return hoehe;
	}
	
}
