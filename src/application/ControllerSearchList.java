package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerSearchList implements Initializable {

    ArrayList<String> strings = new ArrayList<>(
            Arrays.asList("salut", "hello","holla", "bonjour", "il fait beau aujourdhuit",
                    "test de recherche","ab cd")
    );

    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> listView;

    @FXML
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),strings));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().addAll(strings);
    }

    private List<String> searchList(String searchStrings, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchStrings.trim().split(" "));
       
        if(searchWordsArray.toString().length()>3) {
        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
        }
        else
        	return listOfStrings;
    }
}