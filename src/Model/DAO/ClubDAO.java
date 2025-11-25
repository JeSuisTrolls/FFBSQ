package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Club;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;

import java.util.ArrayList;
import java.util.List;

public class ClubDAO extends AbstractCRUD
        implements InterfOperationsAdmin {

    public ClubDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs, ArrayList<String> listTypes) {
        super(conn_db, requete, listValeurs, listTypes);
    }

    public ClubDAO(ConnectionDB conn_db) {
        super(conn_db);
    }

    @Override
    public Resultat insertinto(Object obj) {
        if(obj instanceof Club club) {

            String requete = "INSERT INTO CLUB (id_club, libelle_club, adresse_club) VALUES (?, ?, ?)";
            this.setRequete(requete);

            // Préparation des valeurs pour la requête
            ArrayList<String> listValeurs = new ArrayList<String>();
            listValeurs.add(club.getId_club());
            listValeurs.add(club.getLibelle_club());
            listValeurs.add(club.getAdresse_club());

            ArrayList<String> listTypes = new ArrayList<>();
            listTypes.add("STRING");
            listTypes.add("INTEGER");

            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            return this.execute();
        }
        else
            return new Resultat("Mauvais type objet", false, null);
    }


    @Override
    public Resultat deletefrom(Object obj) {
        return null;
    }

    @Override
    public Resultat update(Object newObj, Object oldObj) {
        return null;
    }

    @Override
    public Resultat select(Object obj) {
        return null;
    }

    @Override
    public Resultat selectAll(Object obj) {
        return null;
    }

    @Override
    public Resultat selectAllInfo(Object obj) {
        return null;
    }

    @Override
    public Resultat setDroits(List<String> LDroit, Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<String> getDroits(Utilisateur utilisateur) {
        return List.of();
    }
}