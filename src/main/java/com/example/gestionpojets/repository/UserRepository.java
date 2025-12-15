package com.example.gestionpojets.repository;

import com.example.gestionpojets.entity.User;
import com.example.gestionpojets.sql.ConnectorSql;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    public static User connexion(String email, String mdp, Label label){
        User user = new User();
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT * FROM personne WHERE email ='"+email+ "' AND password ='"+mdp+"'";

        try{
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            ResultSet resultatRequette = requetePrepare.executeQuery();
            if(resultatRequette.next()){
                int id = resultatRequette.getInt(1);
                String nom = resultatRequette.getString(2);
                String prenom = resultatRequette.getString(3);
                String emailtable = resultatRequette.getString(5);
                String mdP = resultatRequette.getString(6);
                String tel = resultatRequette.getString(7);
                int role = resultatRequette.getInt(4);
                user = new User(id,nom, prenom,emailtable,mdP,tel,role);
                return user;
            }else {
                label.setText("Erreur veuillez re essayer");

            }
        }catch (Exception e ){
            System.out.println(e.getMessage());

        }
        return user;
    }
}
