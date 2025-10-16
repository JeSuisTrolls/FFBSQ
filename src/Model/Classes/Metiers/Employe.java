package Model.Classes.Metiers;

public class Employe extends Utilisateur{

    private String id_type_employe;


    public Employe() {
        super();
        this.id_type_employe = "";

    }

    public Employe(String nss,
                   String nom,
                   String prenom,
                   String pseudo,
                   String mdp,
                   String tel,
                   String mail,
                   String id_type_employe ) {
        super(nss, nom, prenom, pseudo, mdp, tel, mail);
        this.id_type_employe = id_type_employe;
    }

    public Employe(String nss, String id_type_employe) {
        super(nss);
        this.id_type_employe = id_type_employe;
    }

    public String getId_type_employe() {
        return id_type_employe;
    }

    public void setId_type_employe(String id_type_employe) {
        this.id_type_employe = id_type_employe;
    }

    @Override
    public String  toString() {
        return super.toString() + " " + "Employe{" +
                "id_type_employe='" + id_type_employe + '\'' +
                '}';
    }
}
