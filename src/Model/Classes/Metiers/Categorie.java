package Model.Classes.Metiers;

public class Categorie {
    private String id_categorie;
    private String libelle_categorie;

    public Categorie(){
        this.id_categorie = "";
        this.libelle_categorie = "";
    }

    public Categorie(String id_categorie, String libelle_categorie){
        this.id_categorie = id_categorie;
        this.libelle_categorie = libelle_categorie;
    }

    public Categorie(String libelle_categorie){
        this.id_categorie = "";
        this.libelle_categorie = libelle_categorie;
    }

    public String getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(String id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLibelle_categorie() {
        return libelle_categorie;
    }

    public void setLibelle_categorie(String libelle_categorie) {
        this.libelle_categorie = libelle_categorie;
    }

    @Override
    public String toString() {
        return libelle_categorie;
    }
}
