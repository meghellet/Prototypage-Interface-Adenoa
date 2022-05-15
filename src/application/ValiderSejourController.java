package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ValiderSejourController {
	
	  @FXML
	    void refuserAction(ActionEvent event) {
		  try {
				Parent root  = FXMLLoader.load(getClass().getResource("/Vue/DetailsSejours.fxml"));
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Details Sejour");
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}

	    }

}
