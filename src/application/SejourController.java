package application;

import java.io.Serializable;

import Model.Sejour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SejourController implements Serializable {
	
	 	@FXML
	    private Button AfficherSejourbtn;

	    @FXML
	    private Button RechercherBtn;

	    @FXML
	    private Button RetourBtn;

	    
	    
	    
	    @FXML
	    private TableView<Sejour> table;
	    
	    @FXML
	    private TableColumn<Sejour, String> Competances;

	    @FXML
	    private TableColumn<Sejour, String> Dates;

	    @FXML
	    private TableColumn<Sejour, String> Hote;

	    @FXML
	    private TableColumn<Sejour, String> NbrJours;

	    @FXML
	    private TableColumn<Sejour, String> PersonneRecherchees;

	    @FXML
	    private TableColumn<Sejour, String> Restauration;
	    
	    public ObservableList<Sejour> data = FXCollections.observableArrayList() ;
	    
	    
	    @FXML
	    void ActionAfficherSejour(ActionEvent event) {

	    }

	    @FXML
	    void ActionRechercherBtn(ActionEvent event) {

	    }

	    @FXML
	    void ActionRetourBtn(ActionEvent event) {

	    }

}
