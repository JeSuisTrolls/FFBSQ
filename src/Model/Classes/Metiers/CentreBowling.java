package Model.Classes.Metiers;

public class CentreBowling {
    private String id_centre_bowling;
    private String libelle_centre_bowling;

    public CentreBowling(){
        this.id_centre_bowling = "";
        this.libelle_centre_bowling = "";
    }

    public CentreBowling(String id_centre_bowling, String libelle_centre_bowling){
        this.id_centre_bowling = id_centre_bowling;
        this.libelle_centre_bowling = libelle_centre_bowling;
    }

    public CentreBowling(String libelle_centre_bowling){
        this.id_centre_bowling = "";
        this.libelle_centre_bowling = libelle_centre_bowling;
    }

    public String getId_centre_bowling() {
        return id_centre_bowling;
    }

    public void setId_centre_bowling(String id_centre_bowling) {
        this.id_centre_bowling = id_centre_bowling;
    }

    public String getLibelle_centre_bowling() {
        return libelle_centre_bowling;
    }

    public void setLibelle_centre_bowling(String libelle_centre_bowling) {
        this.libelle_centre_bowling = libelle_centre_bowling;
    }

    @Override
    public String toString() {
        return libelle_centre_bowling;
    }
}
