package Model.Classes.Metiers;

public class Club {

    private String id_club;
    private String libelle_club;
    private String adresse_club;
    //private String id_employe;
    //private String id_ligue_regionale;
    //private String id_centre_bowling;


    public Club() {
        this.id_club = "";
        this.libelle_club = "";
        this.adresse_club = "";
        //this.id_employe = "";
        //this.id_ligue_regionale = "";
        //this.id_centre_bowling = "";
    }

    public Club(String id_club, String libelle_club,
                String adresse_club) {
        this.id_club = id_club;
        this.libelle_club = libelle_club;
        this.adresse_club = adresse_club;
        //this.id_employe = id_employe;
        //this.id_ligue_regionale = id_ligue_regionale;
        //this.id_centre_bowling = id_centre_bowling;
    }

    public String getId_club() {
        return id_club;
    }

    public void setId_club(String id_club) {
        this.id_club = id_club;
    }

    public String getLibelle_club() {
        return libelle_club;
    }

    public void setLibelle_club(String libelle_club) {
        this.libelle_club = libelle_club;
    }

    public String getAdresse_club() {
        return adresse_club;
    }

    public void setAdresse_club(String adresse_club) {
        this.adresse_club = adresse_club;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id_club='" + id_club + '\'' +
                ", libelle_club='" + libelle_club + '\'' +
                ", adresse_club='" + adresse_club + '\'' +
                '}';
    }
}
