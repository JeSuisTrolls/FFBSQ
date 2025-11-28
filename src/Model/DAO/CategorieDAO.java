package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Categorie;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;

import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends AbstractCRUD
        implements InterfOperationsAdmin {
    public CategorieDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs, ArrayList<String> listTypes) {
        super(conn_db, requete, listValeurs, listTypes);
    }

    public CategorieDAO(ConnectionDB conn_db) {
        super(conn_db);
    }

    @Override
    public Resultat insertinto(Object obj) {
        return null;
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
        if(obj instanceof Categorie) {

            String requete = "select * from CATEGORIE";
            this.setRequete(requete);

            this.prepare();

            return this.execute();
        }

        return new Resultat("Mauvais type objet", false, null);
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