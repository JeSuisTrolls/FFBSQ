package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;
import View.VueMessage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.RED;

public class TypeEmployeDAO extends AbstractCRUD
        implements InterfOperationsAdmin {
    public TypeEmployeDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs, ArrayList<String> listTypes) {
        super(conn_db, requete, listValeurs, listTypes);
    }

    public TypeEmployeDAO(ConnectionDB conn_db) {
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
        if(obj instanceof TypeEmploye) {

            String requete = "select * from TYPE_EMPLOYE";
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