package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;

import java.util.ArrayList;
import java.util.List;

public class EmployeDAO extends AbstractCRUD
        implements InterfOperationsAdmin {

    public EmployeDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs, ArrayList<String> listTypes) {
        super(conn_db, requete, listValeurs, listTypes);
    }

    public EmployeDAO(ConnectionDB conn_db) {
        super(conn_db);
    }

    @Override
    public Resultat insertinto(Object obj) {
        if(obj instanceof Employe) {
            String requete = "INSERT INTO EMPLOYE (id_employe, id_type_employe) VALUES (?, ?)";
            this.setRequete(requete);

            // Préparation des valeurs pour la requête
            ArrayList<String> listValeurs = new ArrayList<String>();
            listValeurs.add(((Employe) obj).getNumero_securite_social_utilisateur());
            listValeurs.add(((Employe) obj).getId_type_employe());

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
