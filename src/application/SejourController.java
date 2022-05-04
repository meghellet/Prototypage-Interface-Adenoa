package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Connexion.dbConnexion;
import Model.Sejour;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SejourController implements Initializable {
	
	 	@FXML
	    private Button AfficherSejourbtn;

	    @FXML
	    private Button RechercherBtn;

	    @FXML
	    private Button RetourBtn;

	    
	    
	    
	    @FXML
	    private TableView<Sejour> table;
	    
	    @FXML
	    private TableColumn<Sejour, StringProperty> CompetancesColumn;

	    @FXML
	    private TableColumn<Sejour, StringProperty> DatesColumn;

	    @FXML
	    private TableColumn<Sejour, StringProperty> HoteColumn;

	    @FXML
	    private TableColumn<Sejour, IntegerProperty> NbrJoursColumn;

	    @FXML
	    private TableColumn<Sejour, IntegerProperty> NbrPersonnesRechercheesColumn;

	    @FXML
	    private TableColumn<Sejour, StringProperty> RestaurationColumn;
	    
	    @FXML
	    private TableColumn<Sejour, ImageView> PhotoColumn;
	    
	    
	    
	    @FXML
	    void ActionAfficherSejour(ActionEvent event) {
	    	
	    	
	    	
	    	
		    ObservableList<Sejour> data = FXCollections.observableArrayList() ;

	    	try {
	    	
	    		//faire appel a mon class dbConnexion
	    		
				Connection conn = dbConnexion.Connect();
				String sql = "SELECT * FROM Sejours" ;
				
				PreparedStatement statement = conn.prepareStatement(sql) ;
				 // inside Observablelist and then set these inside tableview
		        ImageView emp1photo = new ImageView(new Image(this.getClass().getResourceAsStream("image1.png")));
		        //ImageView emp2photo = new ImageView(new Image(this.getClass().getResourceAsStream("image2.png")));
				
				//Executer la requête SQL
				ResultSet rs = statement.executeQuery() ;
				while(rs.next()) {
					data.add(new Sejour( "hote: "+rs.getString(1), "Personnes Recherchées:"+ rs.getInt(2), "Nmbr Jours: " + rs.getInt(3), "Restauration: " + rs.getString(4), "Compétance(s): "+rs.getString(5), "Dates: "+ rs.getString(6), emp1photo));
				}
				
				//Ajout dee valeurs récupéres dans less colonnes 
				//PhotoColumn.setCellValueFactory(new PropertyValueFactory<Sejour, ImageView>("PhotoColumn"));

				PhotoColumn.setCellValueFactory(new PropertyValueFactory<>("PhotoColumn"));
				
				//Ajout des valeurs récupéres dans les colonnes 
		    	//HoteColumn.setCellValueFactory(new PropertyValueFactory<Sejour, StringProperty>("HoteColumn"));
				
				HoteColumn.setCellFactory(col -> {
			            TableCell<Sejour, StringProperty> cell = new TableCell<>();
			            ImageView emp1photo2 = new ImageView(new Image(this.getClass().getResourceAsStream("images/profile_picture.png")));
			            
			            Sejour sejour1 = new Sejour("edissyum", "3","3", "edissyum", "edissyum","edisysum", emp1photo2);
			            Node graphic = createDriverGraphic(sejour1.getHote());
	                    cell.graphicProperty().bind(Bindings.when(cell.emptyProperty()).then((Node) null).otherwise(graphic));
			            /*
			            cell.itemProperty().addListener((observableValue, o, newValue) -> {
			            
			                if (newValue != null) {
			                	System.out.println("jes uis la WWWWWWWWWWWWWWWWWWWWWWWWWW");
			                    Node graphic = createDriverGraphic(newValue);
			                    cell.graphicProperty().bind(Bindings.when(cell.emptyProperty()).then((Node) null).otherwise(graphic));
			                }
			                
			            });*/
			           
			            return cell;
			        });
				
				
				
				
		    	
		    	
		    	
		    	
		    	
		    	//HoteColumn.setStyle( "-fx-alignment: CENTER;");
		    	NbrPersonnesRechercheesColumn.setCellValueFactory(new PropertyValueFactory<Sejour, IntegerProperty>("NbrPersonnesRechercheesColumn"));
		    	//NbrPersonnesRechercheesColumn.setStyle( "-fx-alignment: CENTER;");
		    	NbrJoursColumn.setCellValueFactory(new PropertyValueFactory<Sejour, IntegerProperty>("NbrJoursColumn"));
		    	//NbrJoursColumn.setStyle( "-fx-alignment: CENTER;");
		    	CompetancesColumn.setCellValueFactory(new PropertyValueFactory<Sejour,StringProperty>("CompetancesColumn"));
		    	RestaurationColumn.setCellValueFactory(new PropertyValueFactory<Sejour,StringProperty>("RestaurationColumn"));
		    	DatesColumn.setCellValueFactory(new PropertyValueFactory<Sejour,StringProperty>("DatesColumn"));
		    	
		    	
		    	table.getItems().addAll(data);
		    	

				//Fermer la connexion 
				conn.close(); 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
	    


	    }

	    private Node createDriverGraphic(String newValue) {
	    	 //Driver driver = getDriver(driverID);

	         GridPane trackingDetailsHolder = new GridPane();
	         trackingDetailsHolder.setHgap(5);
	         ImageView driverPicture = new ImageView(new Image(getClass().getResourceAsStream("images/profile_picture.png")));
	         driverPicture.setPreserveRatio(true);
	         driverPicture.setFitHeight(30d);
	         GridPane.setRowSpan(driverPicture, 2);
	         trackingDetailsHolder.getChildren().add(driverPicture);

	         Label driverStatus = new Label();
	         driverStatus.setText("Edissyum");
	         GridPane.setColumnIndex(driverStatus, 1);
	         trackingDetailsHolder.getChildren().add(driverStatus);

	         HBox rating = new HBox();
	         
	         for (int i = 0; i < 3; i++) {
	 	        rating.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("images/star_yellow.png"))));

	         }

	         for (int i = 0; i < 2; i++) {
	        	 rating.getChildren().add(
	                     new ImageView(new Image(getClass().getResourceAsStream("images/star_black.png")))
	             );
	         }
	        
	       

	        
	        
	        
	         GridPane.setConstraints(rating, 1, 1);
	         trackingDetailsHolder.getChildren().add(rating);

	         return trackingDetailsHolder;
		}

	    
	    
	    
	    
	    
		@FXML
	    void ActionRechercherBtn(ActionEvent event) {
	    	System.out.println("vous avez cliquer sur le bouton Rechercher ");
	    	
	    	

	    }

	    @FXML
	    void ActionRetourBtn(ActionEvent event) {
	    	System.out.println("vous avez cliquer sur le bouton Retour");
	    	try {
				Parent root  = FXMLLoader.load(getClass().getResource("/Vue/FenetreChoix.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

				Scene scene = new Scene(root);

				stage.setScene(scene);
				stage.setTitle("Choix");
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}


	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

}
