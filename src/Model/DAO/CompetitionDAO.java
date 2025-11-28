package Model.DAO;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Competition;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;
import java.util.ArrayList;
import java.util.List;

public class CompetitionDAO extends AbstractCRUD implements InterfOperationsAdmin {

    public CompetitionDAO(ConnectionDB conn_db, String requete, ArrayList<String> listValeurs, ArrayList<String> listTypes) {
        super(conn_db, requete, listValeurs, listTypes);
    }

    public CompetitionDAO(ConnectionDB conn_db) {
        super(conn_db);
    }

    @Override
    public Resultat insertinto(Object obj) {
        if (obj instanceof Competition) {
            Competition competition = (Competition) obj;

            String requete = "INSERT INTO COMPETITION (libelle_competition, id_discipline, id_club, id_categorie, id_centre_bowling, date_competition) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            this.setRequete(requete);

            ArrayList<String> listValeurs = new ArrayList<>();
            listValeurs.add(competition.getLibelle_competition());
            listValeurs.add(String.valueOf(competition.getDiscipline()));
            listValeurs.add(String.valueOf(competition.getClub()));
            listValeurs.add(String.valueOf(competition.getCategorie()));
            listValeurs.add(String.valueOf(competition.getCentre_bowling()));
            listValeurs.add(competition.getDate_competition());


            ArrayList<String> listTypes = new ArrayList<>();
            listTypes.add("STRING");
            listTypes.add("INTEGER");
            listTypes.add("INTEGER");
            listTypes.add("INTEGER");
            listTypes.add("INTEGER");
            listTypes.add("DATE");

            this.setListValeurs(listValeurs);
            this.setListTypes(listTypes);

            this.prepare();
            return this.execute();
        }
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