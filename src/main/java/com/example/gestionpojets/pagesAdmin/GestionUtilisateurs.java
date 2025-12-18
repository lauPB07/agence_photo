package com.example.gestionpojets.pagesAdmin;
import com.example.gestionpojets.HelloApplication;
import com.example.gestionpojets.entity.Role;
import com.example.gestionpojets.entity.User;
import com.example.gestionpojets.repository.UserRepository;
import com.example.gestionpojets.sql.ConnectorSql;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

public class GestionUtilisateurs implements Initializable {
    @FXML
    private AnchorPane mainPage;
    @FXML
    private Button addPersonne;

    @FXML
    private Button clearInfo;

    @FXML
    private TextField email;

    @FXML
    private TableColumn<User,String> emailColumn;

    @FXML
    private Button homeButton;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<User,Integer> idColumn;

    @FXML
    private Button logoutButton;

    @FXML
    private Button modifyPersonne;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<User,String> nameColumn;

    @FXML
    private Label nbChefProjet;

    @FXML
    private Label nbPersonnel;

    @FXML
    private Label nbPersonnesTotal;

    @FXML
    private TextField password;

    @FXML
    private TableColumn<User,String> passwordColumn;

    @FXML
    private TextField prenom;

    @FXML
    private TableColumn<User,String> prenomColumn;

    @FXML
    private ChoiceBox<Role> role;

    @FXML
    private TableColumn<User,Integer> roleColumn;

    @FXML
    private TextField search;

    @FXML
    private Button supPersonne;

    @FXML
    private TableView<User> table;

    @FXML
    private TextField tel;

    @FXML
    private TableColumn<User,String> telColumn;

    @FXML
    private Button userButton;

    @FXML
    private Label username;

    @FXML
    private AnchorPane homeForm;
    @FXML
    private AnchorPane userForm;

    ObservableList<User> list;
    ObservableList<User> dataList;
    int index = -1;

    @FXML
    void deconnexion(ActionEvent event) {
        Alert dialogW = new Alert(Alert.AlertType.WARNING);
        dialogW.setTitle("Voulez vous vous déconnectez ?");
        dialogW.setHeaderText(null); // No header
        dialogW.setContentText("Attention vous êtes sur le point de vous déconnecter êtes vous sur ?");
        Optional<ButtonType> answer = dialogW.showAndWait();
        if (answer.get() == ButtonType.OK) {
            HelloApplication.changeScene("hello-view","Agence photo !");
        }
        else {
            System.out.println("User chose Cancel or closed the dialog-box");
        }
    }

    @FXML
    void switchForm(ActionEvent event){
        if(event.getSource() == homeButton) {
            homeForm.setVisible(true);
            userForm.setVisible(false);
        } else if (event.getSource() == userButton) {
            homeForm.setVisible(false);
            userForm.setVisible(true);
        }
    }

    @FXML
    void addUser(ActionEvent event){
        UserRepository.ajoutUtilisateur(name.getText(),prenom.getText(),role.getValue().getId(),email.getText(),tel.getText(),password.getText(),list,table);
        vider();

    }
    @FXML
    void updateUser(ActionEvent event){
        UserRepository.modifier(name.getText(),prenom.getText(),role.getValue().getId(),email.getText(),tel.getText(),password.getText(), Integer.parseInt(id.getText()),list,table);
        vider();
    }

    @FXML
    void deleteUser(ActionEvent event){
        UserRepository.supprimer(Integer.parseInt(id.getText()),list,table);
        vider();
    }

    @FXML
    public void initialiser(){
        idColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User,String>("mdp"));
        telColumn.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("role"));

        list = UserRepository.recupererUtilisateur();
        table.setItems(list);
        rechercher();

    }

    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        index = table.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        id.setText(idColumn.getCellData(index).toString());
        name.setText(nameColumn.getCellData(index).toString());
        prenom.setText(prenomColumn.getCellData(index).toString());
        email.setText(emailColumn.getCellData(index).toString());
        password.setText(passwordColumn.getCellData(index).toString());
        tel.setText(telColumn.getCellData(index).toString());
        for (Role r : role.getItems()
        ) {
            if (r.getId() == Integer.valueOf(roleColumn.getCellData(index).toString())){
                role.setValue(r);
                break;
            }
        }

    }

    void rechercher(){
        idColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<User,String>("prenom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User,String>("mdp"));
        telColumn.setCellValueFactory(new PropertyValueFactory<User,String>("tel"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("role"));

        dataList = UserRepository.recupererUtilisateur();
        table.setItems(dataList);
        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);
        search.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filteredData.setPredicate(utilisateur -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if(utilisateur.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (utilisateur.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }           });
        } );
        SortedList<User> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    void vider(){
        id.setText("");
        prenom.setText("");
        name.setText("");
        email.setText("");
        password.setText("");
        tel.setText("");
        role.setValue(null);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(HelloApplication.getUser().getNom() +" "+ HelloApplication.getUser().getPrenom());
        nbPersonnesTotal.setText(String.valueOf(UserRepository.getNbPersonnes()));
        nbPersonnel.setText(String.valueOf(UserRepository.getNbPersonnesPersonnel()));
        nbChefProjet.setText(String.valueOf(UserRepository.getNbPersonnesChefProjet()));
        initialiser();
        rechercher();
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT * FROM role";

        try{
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            ResultSet resultatRequette = requetePrepare.executeQuery();
            while (resultatRequette.next()){
                String nom = resultatRequette.getString("nom");
                int idRole = resultatRequette.getInt("id");
                role.getItems().add(new Role(idRole,nom));
                //MenuItem menuItem = new MenuItem(nom);
                //role.getItems().add(menuItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
