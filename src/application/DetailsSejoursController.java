package application;




import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import Connexion.dbConnexion;
import Model.Sejour;
import Model.SejourDisco;
import Model.SejoursDetails;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Model.SejoursDetails;
public class DetailsSejoursController {
	
	 @FXML
	    private Text personne;

	    @FXML
	    private Text nbJours;

	    @FXML
	    private Text restauration;

	    @FXML
	    private Text dates;

	    @FXML
	    private Text description;

	    @FXML
	    private Text nomHote;

	    @FXML
	    private ImageView imageSejour;

	    @FXML
	    private Text nomSejour;
	     
	    
	    
	   
	    @FXML
	    private javafx.scene.control.Button retour;
	    /*

	    @FXML
	    private Button Profil;

	    @FXML
	    private Button Voyage;
	    

	    @FXML
	    void DeconnecterAction(ActionEvent event) {
	    	 try {
					
					
		 			Parent root  = FXMLLoader.load(getClass().getResource("/Vue/SejoursDisco.fxml"));
		 			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 			Scene scene = new Scene(root);
		 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 			stage.setScene(scene);
		 			stage.setTitle("Profil");
		 			stage.show();
		 			} catch(Exception e) {
		 				e.printStackTrace();
		 			}

	    }

	    @FXML
	    void VoirProfilAction(ActionEvent event) {
	    	 try {
					
					
		 			Parent root  = FXMLLoader.load(getClass().getResource("/Vue/Profil.fxml"));
		 			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 			Scene scene = new Scene(root);
		 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 			stage.setScene(scene);
		 			stage.setTitle("Profil");
		 			stage.show();
		 			} catch(Exception e) {
		 				e.printStackTrace();
		 			}

	    }

	    @FXML
	    void VoirVoyageAction(ActionEvent event) {
	    	 try {
					
					
		 			Parent root  = FXMLLoader.load(getClass().getResource("/Vue/Sejours.fxml"));
		 			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 			Scene scene = new Scene(root);
		 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		 			stage.setScene(scene);
		 			stage.setTitle("Profil");
		 			stage.show();
		 			} catch(Exception e) {
		 				e.printStackTrace();
		 			}

	    }
	    
	    */
	    @FXML
	    void retourAction(ActionEvent event) {
	    	try {
				Parent root  = FXMLLoader.load(getClass().getResource("/Vue/SejoursDisco.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Choix");
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}

	    }

	  


	    int show = 0;
	    List<String> myList = new ArrayList<String>();
	    SejoursDetails a = new SejoursDetails(myList);
	    Random r = new Random();

	    @FXML
	    void backPicture(ActionEvent event) {
	    	int n = r.nextInt(myList.size());
	    	imageSejour.setImage(new Image(myList.get(n)));  	
	    }

	    @FXML
	    void nextPicture(ActionEvent event) {  	
	    	int n = r.nextInt(myList.size());
	    	imageSejour.setImage(new Image(myList.get(n)));  
	    }

	    @FXML
	    void startConversation(ActionEvent event) {
	    	try {
				Parent root  = FXMLLoader.load(getClass().getResource("/Vue/QuestionSejours.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Conversation");
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	    	
	    

	    }
	    

	    @FXML
	    void validerAction(ActionEvent event) {
	    	try {
				Parent root  = FXMLLoader.load(getClass().getResource("/Vue/ValiderSejours.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Valider Sejour");
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}

	    }
	    
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		    List<String> myList = new ArrayList<String>();
		    myList.add("/home/edissyum/Documents/images/1.jpeg");
		    myList.add("/home/edissyum/Documents/images/2.jpeg");
		    myList.add("/home/edissyum/Documents/images/3.jpg");
			
			nomSejour.setText("Palavas les flots");
			nbJours.setText("7 jours");
			personne.setText("3 personnes");
			restauration.setText("Matin - Midi");
			dates.setText("01/03/2022 - 07/03/2022");


			nomHote.setText("Killian");
			description.setText("Si tu ne comprends pas, ou ne maîtrises pas, la notion de coefficient binomial, inutile de chercher à calculer toi-même les nombres de Catalan, que tu découvris dans cette obscure revue américaine d'algèbre, croyant qu'il s'agissait de “nombres catalans” (l'anglais Catalan numbers est équivoque), avant de faire le chemin historique et de découvrir qu'ils auraient tout aussi bien pu se nommer suite d'Euler, entiers de Seger, ou nombres de Ming Antu.");
			
			
		}


}
