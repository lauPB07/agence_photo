package com.example.gestionpojets.repository;

import com.example.gestionpojets.entity.User;
import com.example.gestionpojets.sql.ConnectorSql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static void ajoutUtilisateur(String nom,String prenom,int role,String email,String tel,String password,ObservableList<User>list, TableView<User> tableau) {
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "INSERT INTO personne (nom,prenom,email,password,role,telephone) VALUES (?,?,?,?,?,?)";

        try{
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            requetePrepare.setString(1,nom);
            requetePrepare.setString(2,prenom);
            requetePrepare.setString(3,email);
            requetePrepare.setString(4,password);
            requetePrepare.setInt(5,role);
            requetePrepare.setString(6,tel);
            requetePrepare.executeUpdate();
            list = UserRepository.recupererUtilisateur();
            tableau.setItems(list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ObservableList<User> recupererUtilisateur() {
        ObservableList<User> liste = FXCollections.observableArrayList();
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT * FROM personne ";
        try {
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            ResultSet resultatRequette = requetePrepare.executeQuery();
            while (resultatRequette.next()) {
                liste.add(new User(Integer.parseInt(resultatRequette.getString("id")),resultatRequette.getString("nom"),resultatRequette.getString("prenom"),resultatRequette.getString("email"),resultatRequette.getString("password"),resultatRequette.getString("telephone"),Integer.parseInt(resultatRequette.getString("role"))));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return liste;
    }


    public static void supprimer(int id, ObservableList<User>liste, TableView<User> tableau){
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "DELETE FROM personne where id =?";
        try{
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            System.out.println(id);
            requetePrepare.setInt(1, id);
            requetePrepare.executeUpdate();
            liste = UserRepository.recupererUtilisateur();
            tableau.setItems(liste);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void modifier(String nom,String prenom,int role,String email,String tel,String password, int id,ObservableList<User>list, TableView<User> tableau){
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "UPDATE personne  SET  nom = ?, prenom = ?, email = ?, password = ? , role = ?,telephone =?  where id =?";

        try{
            PreparedStatement requetePrepare = connection.prepareStatement(sql);
            requetePrepare.setString(1,nom);
            requetePrepare.setString(2,prenom);
            requetePrepare.setString(3,email);
            requetePrepare.setString(4,password);
            requetePrepare.setInt(5,role);
            requetePrepare.setString(6,tel);
            requetePrepare.setInt(7, id );
            requetePrepare.executeUpdate();
            list = UserRepository.recupererUtilisateur();
            tableau.setItems(list);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getNbPersonnes(){
        int nbPersonne = 0;
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT COUNT(*) FROM personne ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultatRequette = preparedStatement.executeQuery();
            while(resultatRequette.next()){
                nbPersonne = (resultatRequette.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nbPersonne;
    }

    public static int getNbPersonnesAdmin(){
        int nbPersonne = 0;
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT COUNT(*) FROM personne WHERE role = 1 ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultatRequette = preparedStatement.executeQuery();
            while(resultatRequette.next()){
                nbPersonne = (resultatRequette.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nbPersonne;
    }

    public static int getNbPersonnesChefProjet(){
        int nbPersonne = 0;
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT COUNT(*) FROM personne WHERE role = 2 ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultatRequette = preparedStatement.executeQuery();
            while(resultatRequette.next()){
                nbPersonne = (resultatRequette.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nbPersonne;
    }

    public static int getNbPersonnesPersonnel(){
        int nbPersonne = 0;
        ConnectorSql connexionBdd = new ConnectorSql();
        Connection connection = connexionBdd.getBdd();
        String sql = "SELECT COUNT(*) FROM personne WHERE role = 3 ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultatRequette = preparedStatement.executeQuery();
            while(resultatRequette.next()){
                nbPersonne = (resultatRequette.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nbPersonne;
    }
}
