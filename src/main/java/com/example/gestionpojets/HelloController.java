package com.example.gestionpojets;

import com.example.gestionpojets.entity.User;
import com.example.gestionpojets.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class HelloController {

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mpd;

    @FXML
    private Label message;

    @FXML
    void connexion(ActionEvent event){
        if(email.getText().isBlank()  &&  mpd.getText().isBlank()){
            message.setText("entrer L'identifiant et le mot de passe ");
        }
        else{
            User user =  UserRepository.connexion(email.getText(),mpd.getText(), message);
            HelloApplication.setUser(user);
            System.out.println(user.getId());
            if(user.getRole()==1){
                HelloApplication.changeScene("gestionUtilisateurs","Gestion utilisateurs");
            } else if (user.getRole()==2) {
                HelloApplication.changeScene("pageMecano","Page Mecano");
            } else if (user.getRole()==3) {
                HelloApplication.changeScene("pageCompta","Page Comptabilité");
            }

        }
    }
}