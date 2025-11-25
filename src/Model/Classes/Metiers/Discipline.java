package Model.Classes.Metiers;

public class Discipline {

    private String id_discipline;
    private String libelle_discipline;


    public Discipline() {
        this.id_discipline = "";
        this.libelle_discipline = "";
    }

    public Discipline(String id_discipline, String libelle_discipline) {
        this.id_discipline = id_discipline;
        this.libelle_discipline = libelle_discipline;
    }

    public Discipline(String libelle_discipline) {
        this.id_discipline = "";
        this.libelle_discipline = libelle_discipline;
    }

    public String getId_discipline() {
        return id_discipline;
    }

    public void setId_discipline(String id_discipline) {
        this.id_discipline = id_discipline;
    }

    public String getLibelle_discipline() {
        return libelle_discipline;
    }

    public void setLibelle_discipline(String libelle_discipline) {
        this.libelle_discipline = libelle_discipline;
    }

    @Override
    public String toString() {
        return libelle_discipline;
    }
}
