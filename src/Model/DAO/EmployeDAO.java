package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
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
        if(obj instanceof Employe employe) {

            String requete = "INSERT INTO EMPLOYE (id_employe, id_type_employe) VALUES (?, ?)";
            this.setRequete(requete);

            // Préparation des valeurs pour la requête
            ArrayList<String> listValeurs = new ArrayList<String>();
            listValeurs.add(employe.getNumero_securite_social_utilisateur());
            listValeurs.add(employe.getId_type_employe());

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
        if(obj instanceof Employe employe) {
            // D'abord supprimer de la table EMPLOYE
            String requete = "DELETE FROM EMPLOYE WHERE id_employe = ?";
            this.setRequete(requete);

            ArrayList<String> listValeurs = new ArrayList<String>();
            listValeurs.add(employe.getNumero_securite_social_utilisateur());

            ArrayList<String> listTypes = new ArrayList<>();
            listTypes.add("STRING");

            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            Resultat resultatEmploye = this.execute();

            if (!resultatEmploye.isSucces()) {
                return resultatEmploye;
            }

            // Ensuite supprimer de la table UTILISATEUR
            requete = "DELETE FROM UTILISATEUR WHERE id_utilisateur = ?";
            this.setRequete(requete);
            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            return this.execute();
        }
        return new Resultat("Mauvais type objet", false, null);
    }

    @Override
    public Resultat update(Object newObj, Object oldObj) {
        if(newObj instanceof Employe && oldObj instanceof Employe) {
            Employe newEmploye = (Employe) newObj;
            Employe oldEmploye = (Employe) oldObj;

            // Mise à jour de l'utilisateur
            String requete = "UPDATE UTILISATEUR SET " +
                    "nom_utilisateur = ?, " +
                    "prenom_utilisateur = ?, " +
                    "pseudo_utilisateur = ?, " +
                    "mdp_utilisateur = ?, " +
                    "tel_utilisateur = ?, " +
                    "mail_utilisateur = ? " +
                    "WHERE id_utilisateur = ?";

            this.setRequete(requete);

            ArrayList<String> listValeurs = new ArrayList<String>();
            listValeurs.add(newEmploye.getNom_utilisateur());
            listValeurs.add(newEmploye.getPrenom_utilisateur());
            listValeurs.add(newEmploye.getPseudo_utilisateur());
            listValeurs.add(newEmploye.getMdp_utilisateur());
            listValeurs.add(newEmploye.getTel_utilisateur());
            listValeurs.add(newEmploye.getMail_utilisateur());
            listValeurs.add(oldEmploye.getNumero_securite_social_utilisateur());

            ArrayList<String> listTypes = new ArrayList<>();
            listTypes.add("STRING");
            listTypes.add("STRING");
            listTypes.add("STRING");
            listTypes.add("STRING");
            listTypes.add("STRING");
            listTypes.add("STRING");
            listTypes.add("STRING");

            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            Resultat resultatUtilisateur = this.execute();

            if (!resultatUtilisateur.isSucces()) {
                return resultatUtilisateur;
            }

            // Mise à jour de l'employé
            requete = "UPDATE EMPLOYE SET id_type_employe = ? WHERE id_employe = ?";

            this.setRequete(requete);

            listValeurs = new ArrayList<String>();
            listValeurs.add(newEmploye.getId_type_employe());
            listValeurs.add(oldEmploye.getNumero_securite_social_utilisateur());

            listTypes = new ArrayList<>();
            listTypes.add("STRING");
            listTypes.add("STRING");

            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            return this.execute();
        }
        return new Resultat("Mauvais type objet", false, null);
    }

    @Override
    public Resultat select(Object obj) {
        return null;
    }

    @Override
    public Resultat selectAll(Object obj) {
        if(obj instanceof Employe) {
            String requete = "SELECT U.id_utilisateur, U.nom_utilisateur, U.prenom_utilisateur, " +
                    "U.pseudo_utilisateur, U.mdp_utilisateur, U.tel_utilisateur, " +
                    "U.mail_utilisateur, E.id_type_employe, T.libelle_type_employe " +
                    "FROM UTILISATEUR U " +
                    "INNER JOIN EMPLOYE E ON U.id_utilisateur = E.id_employe " +
                    "INNER JOIN TYPE_EMPLOYE T ON E.id_type_employe = T.id_type_employe " +
                    "ORDER BY U.nom_utilisateur, U.prenom_utilisateur";

            this.setRequete(requete);
            this.prepare();
            return this.execute();
        }
        return new Resultat("Mauvais type objet", false, null);
    }

    @Override
    public Resultat selectAllInfo(Object obj) {
        return selectAll(obj);
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
