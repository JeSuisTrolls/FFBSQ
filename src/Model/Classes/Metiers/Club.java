package Model.Classes.Metiers;

public class Club {

    private String id_club;
    private String libelle_club;
    private String adresse_club;
    private Employe employe;
    private LigueRegionale ligueRegionale;
    private CentreBowling centreBowling;


    public Club() {
        this.id_club = "";
        this.libelle_club = "";
        this.adresse_club = "";
        this.employe = new Employe();
        this.ligueRegionale = new LigueRegionale();
        this.centreBowling = new CentreBowling();
    }

    public Club(String id_club, String libelle_club,
                String adresse_club, Employe employe, LigueRegionale ligue_regionale,
                CentreBowling centreBowling) {
        this.id_club = id_club;
        this.libelle_club = libelle_club;
        this.adresse_club = adresse_club;
        this.employe = employe;
        this.ligueRegionale = ligue_regionale;
        this.centreBowling = centreBowling;
    }

    public Club(String id_club, String libelle_club) {
        this.id_club = id_club;
        this.libelle_club = libelle_club;
        this.adresse_club = "";
        this.employe = new Employe();
        this.ligueRegionale = new LigueRegionale();
        this.centreBowling = new CentreBowling();
    }

    public String getId_club() {
        return id_club;
    }

    public void setId_club(String id_club) {
        this.id_club = id_club;
    }

    public CentreBowling getCentreBowling() {
        return centreBowling;
    }

    public void setCentreBowling(CentreBowling centreBowling) {
        this.centreBowling = centreBowling;
    }

    public LigueRegionale getLigueRegionale() {
        return ligueRegionale;
    }

    public void setLigueRegionale(LigueRegionale ligueRegionale) {
        this.ligueRegionale = ligueRegionale;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getAdresse_club() {
        return adresse_club;
    }

    public void setAdresse_club(String adresse_club) {
        this.adresse_club = adresse_club;
    }

    public String getLibelle_club() {
        return libelle_club;
    }

    public void setLibelle_club(String libelle_club) {
        this.libelle_club = libelle_club;
    }

    @Override
    public String toString() {
        return libelle_club;
    }
}
