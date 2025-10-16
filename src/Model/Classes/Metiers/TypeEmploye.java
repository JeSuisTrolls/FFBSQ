package Model.Classes.Metiers;

public class TypeEmploye {

    private String id_type_employe;
    private String libelle_type_employe;


    public TypeEmploye() {
        this.id_type_employe = "";
        this.libelle_type_employe = "";
    }

    public TypeEmploye(String id_type_employe, String libelle_type_employe) {
        this.id_type_employe = id_type_employe;
        this.libelle_type_employe = libelle_type_employe;
    }

    public TypeEmploye(String libelle_type_employe) {
        this.id_type_employe = "";
        this.libelle_type_employe = libelle_type_employe;
    }

    public String getId_type_employe() {
        return id_type_employe;
    }

    public void setId_type_employe(String id_type_employe) {
        this.id_type_employe = id_type_employe;
    }

    public String getLibelle_type_employe() {
        return libelle_type_employe;
    }

    public void setLibelle_type_employe(String libelle_type_employe) {
        this.libelle_type_employe = libelle_type_employe;
    }

    @Override
    public String toString() {
        return libelle_type_employe;
    }
}
