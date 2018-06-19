package leveleditor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Leveleditor extends GridPane {

	private int hoehe, breite;
    
    private ChoiceBox<String> akt;
    private ImageView showAkt;
    private ChoiceBox<String> akt2;
    private ImageView showAkt2;
    private Button bEbene;
    
    private ImageView[][] vBoden;
    private ImageView[][] vEntities;
    private GridPane pane0 = new GridPane();
	private GridPane pane1 = new GridPane();
    
    Image iBombe, iBombenPlatz, iEmpty, iKey, iKeylock, iLadder, iPlayer, iSand, iSchlucht, iWand, iWandwall;
	
	public Leveleditor() {
		hoehe = 16;
		breite = 32;

        vBoden = new ImageView[hoehe][breite];
        vEntities = new ImageView[hoehe][breite];

		setVgap(16);
		
		
		initImages();
		initButtons();
		initEditor();
	}
	
	public void initImages() {
		try {
			iBombe = new Image(new FileInputStream("src\\res\\img\\bombe.png"));
			iBombenPlatz = new Image(new FileInputStream("src\\res\\img\\bombenplatz.png"));
			iKey = new Image(new FileInputStream("src\\res\\img\\key.png"));
			iKeylock = new Image(new FileInputStream("src\\res\\img\\keylock.png"));
			iLadder = new Image(new FileInputStream("src\\res\\img\\ladder.png"));
			iPlayer = new Image(new FileInputStream("src\\res\\img\\player.png"));
			iSand = new Image(new FileInputStream("src\\res\\img\\sand.png"));
			iSchlucht = new Image(new FileInputStream("src\\res\\img\\schlucht.png"));
			iWand = new Image(new FileInputStream("src\\res\\img\\wand.png"));
			iWandwall = new Image(new FileInputStream("src\\res\\img\\wandwall.png"));
			
			iEmpty = new Image(new FileInputStream("src\\res\\img\\empty.png"));

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
	}
	
	public void initButtons() {
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
				vBoden[i][j] = feld;
				pane0.add(feld, j, i);
				
				//################
				ImageView feld1 = new ImageView(iEmpty);
				feld1.setFitHeight(32);
				feld1.setFitWidth(32);
				feld1.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						buttonClicked2(e);
					}
					
				});
				vEntities[i][j] = feld1;
				pane1.add(feld1, j, i);
			}
		}
		
		add(pane0, 0, 0);
		add(pane1, 0, 0);
		pane1.toBack();
	}

	public void initEditor() {
		GridPane editor = new GridPane();
		
			bEbene = new Button("Akt: Boden");
			bEbene.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					if(bEbene.getText().equals("Akt: Boden")) {
						bEbene.setText("Akt: Entities");
						pane1.toFront();
					}else {
						bEbene.setText("Akt: Boden");
						pane1.toBack();
					}
				}
			});
			editor.add(bEbene, 0, 0);
			editor.setHgap(8);
			
			//###################
			
			showAkt = new ImageView(iSand);
			showAkt.setFitHeight(32);
			showAkt.setFitWidth(32);
			editor.add(showAkt, 2, 0);
			ObservableList<String> elementliste //
	        = FXCollections.observableArrayList("Bombenplatz", "Keylock", "Ladder", "Sand", "Schlucht", "Wand", "Wandwall");
			akt = new ChoiceBox<String>(elementliste);
			akt.setValue("Sand");
			akt.autosize();
			akt.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        String item = akt.getItems().get((Integer) number2);
	
			        changeImage(showAkt, item);
			      }});
			
			editor.add(akt, 1, 0);
			
			//#########################
			showAkt2 = new ImageView(iBombe);
			showAkt2.setFitHeight(32);
			showAkt2.setFitWidth(32);
			editor.add(showAkt2, 4, 0);
			ObservableList<String> elementliste2 //
	        = FXCollections.observableArrayList("Bombe", "Key", "Player", "Empty");
			akt2 = new ChoiceBox<String>(elementliste2);
			akt2.setValue("Bombe");
			akt2.autosize();
			akt2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			      @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
			        String item = akt2.getItems().get((Integer) number2);
	
			        changeImage(showAkt2, item);
			      }});
			
			editor.add(akt2, 5, 0);
			
			Button bSave = new Button("Save");
			bSave.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					getCode();
					
				}
				
			});
			editor.add(bSave, 3, 0);

			
		add(editor, 0, 1);
		
		
		
	}
	
	public void getCode() {
		String s = "";
		for(int i = 0;i<hoehe;i++) {
			for(int j = 0;j<breite;j++) {
				
				if(vBoden[i][j] == null) {
					
				}else {
					if(vBoden[i][j].getImage() == iBombenPlatz) {
						s = s+"boden["+i+"]["+j+"] = new Bombenplatz();";
					}
					if(vBoden[i][j].getImage() == iKeylock) {
						s = s+"boden["+i+"]["+j+"] = new KeyLock();";
					}
					if(vBoden[i][j].getImage() == iLadder) {
						s = s+"boden["+i+"]["+j+"] = new Ladder();";
					}
					if(vBoden[i][j].getImage() == iSand) {
						s = s+"boden["+i+"]["+j+"] = new Sand();";
					}
					if(vBoden[i][j].getImage() == iSchlucht) {
						s = s+"boden["+i+"]["+j+"] = new Schlucht();";
					}
				}
				//##################
				if(vEntities[i][j] == null) {
					
				}else {
					if(vEntities[i][j].getImage() == iEmpty) {
						//koente theoretisch auch weg
					}
					if(vEntities[i][j].getImage() == iBombe) {
						s = s+"entities["+i+"]["+j+"] = new Bombe();";
					}
					if(vEntities[i][j].getImage() == iKey) {
						s = s+"entities["+i+"]["+j+"] = new Key();";
					}
					if(vEntities[i][j].getImage() == iPlayer) {
						s = s+"entities["+i+"]["+j+"] = new Player();";
						s = s+"Player pp = new Player();entities["+i+"]["+j+"] = pp;pp.setX("+j+");pp.setY("+i+");p = pp;";
					}
				}
			}
		}
		System.out.println(s);
	}
	
	public void buttonClicked(MouseEvent e) {
		ImageView feld = (ImageView) e.getSource();
		changeImage(feld, akt.getValue());
	}	
	
	public void buttonClicked2(MouseEvent e) {
		ImageView feld = (ImageView) e.getSource();
		changeImage(feld, akt2.getValue());
	}	
	
	public void changeImage(ImageView iv, String s) {
		switch (s) {
			default:
				break;
			case "Bombe":
				iv.setImage(iBombe);
				break;
			case "Bombenplatz":
				iv.setImage(iBombenPlatz);
				break;
			case "Empty":
				iv.setImage(iEmpty);
				break;
			case "Key":
				iv.setImage(iKey);
				break;
			case "Keylock":
				iv.setImage(iKeylock);
				break;
			case "Ladder":
				iv.setImage(iLadder);
				break;
			case "Player":
				iv.setImage(iPlayer);
				break;
			case "Sand":
				iv.setImage(iSand);
				break;
			case "Schlucht":
				iv.setImage(iSchlucht);
				break;
			case "Wand":
				iv.setImage(iWand);
				break;
			case "Wandwall":
				iv.setImage(iWandwall);
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
