package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

public class ProfilController {
	 	
	@FXML
    private Button EnregistrerModifs;

    @FXML
    private Button ModifierProfil;

    @FXML
    void ActionEnregistrerModifs(ActionEvent event) {

    }
    private FileChooser fileChooser ;
    private File filePath ;
    
    
    /*
     * Cette methode permet de changer la photo de profile d'un utiliseur
     */
    @FXML
    void ActionModifierProfil(ActionEvent event) {

    }
}
