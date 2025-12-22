package com.example.gestionpojets.repository;

import com.example.gestionpojets.entity.Projet;
import com.example.gestionpojets.entity.User;
import com.example.gestionpojets.sql.ConnectorSql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;

public class ProjetsReository {

        public static void ajouterProjet(String titre, String nomClient, String description, Date dateDebut, Date dateFin, int statut, int chefProjet, ObservableList<Projet> liste,TableView<Projet> tableau){
            ConnectorSql connexionBdd = new ConnectorSql();
            Connection connection = connexionBdd.getBdd();
            String sql = "INSERT INTO `projet`(`titre`, `nom_client`, `description`, `date_debut`, `date_fin`, `statut_id`, `chefProjetId`) VALUES (?,?,?,?,?,?,?)";

            try{

                PreparedStatement requetePrepare = connection.prepareStatement(sql);
                requetePrepare.setString(1,titre);
                requetePrepare.setString(2,nomClient);
                requetePrepare.setString(3,description);
                requetePrepare.setDate(4,dateDebut);
                requetePrepare.setDate(5,dateFin);
                requetePrepare.setInt(6,statut);
                requetePrepare.setInt(7,chefProjet);
                requetePrepare.executeUpdate();
                liste = ProjetsReository.recupererProjets();
                tableau.setItems(liste);
            }catch (Exception e ){
                System.out.println(e.getMessage());

            }
        }

        public static ObservableList<Projet> recupererProjets() {
            ObservableList<Projet> liste = FXCollections.observableArrayList();
            ConnectorSql connexionBdd = new ConnectorSql();
            Connection connection = connexionBdd.getBdd();
            String sql = "SELECT * FROM projet ";
            try {
                PreparedStatement requetePrepare = connection.prepareStatement(sql);
                ResultSet resultatRequette = requetePrepare.executeQuery();
                while (resultatRequette.next()) {
                    liste.add(new Projet(Integer.parseInt(resultatRequette.getString("id")),resultatRequette.getString("titre"),resultatRequette.getString("nomClient"),resultatRequette.getString("description"),resultatRequette.getDate("dateDebut"),resultatRequette.getDate("dateFin"),Integer.parseInt(resultatRequette.getString("statutId")),Integer.parseInt(resultatRequette.getString("chefProjetId"))));
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            return liste;
        }

        public static void supprimerProjet(int idProjet, ObservableList<Projet> liste, TableView<Projet> tableau){
            ConnectorSql connexionBdd = new ConnectorSql();
            Connection connection = connexionBdd.getBdd();
            String sql = "DELETE FROM `projet` WHERE `id`=?";
            try{
                PreparedStatement requetePrepare = connection.prepareStatement(sql);
                requetePrepare.setInt(1, idProjet);
                requetePrepare.executeUpdate();
                liste = ProjetsReository.recupererProjets();
                tableau.setItems(liste);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static void modifierProjet(String titre, String nomClient, String description, Date dateDebut, Date dateFin, int statut, int chefProjet,int idProjet, ObservableList<Projet> liste,TableView<Projet> tableau){
            ConnectorSql connexionBdd = new ConnectorSql();
            Connection connection = connexionBdd.getBdd();
            String sql = "UPDATE `projet` SET `titre`=?,`nom_client`=?,`description`=?,`date_debut`=?,`date_fin`=?,`statut_id`=?,`chefProjetId`=? WHERE id = ?";
            try{
                PreparedStatement requetePrepare = connection.prepareStatement(sql);
                requetePrepare.setString(1,titre);
                requetePrepare.setString(2,nomClient);
                requetePrepare.setString(3,description);
                requetePrepare.setDate(4,dateDebut);
                requetePrepare.setDate(5,dateFin);
                requetePrepare.setInt(6,statut);
                requetePrepare.setInt(7,chefProjet);
                requetePrepare.setInt(8,idProjet);
                requetePrepare.executeUpdate();
                liste = ProjetsReository.recupererProjets();
                tableau.setItems(liste);



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


}
