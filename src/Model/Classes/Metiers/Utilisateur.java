package Model.Classes.Metiers;

public class Utilisateur {

	private String numero_securite_social_utilisateur;
	private String pseudo_utilisateur;
	private String nom_utilisateur;
	private String prenom_utilisateur;
	private String tel_utilisateur;
	private String mdp_utilisateur;
	private String mail_utilisateur;
	
	
	public Utilisateur() {
		super();
		this.numero_securite_social_utilisateur = "";
		this.nom_utilisateur = "";
		this.prenom_utilisateur = "";
		this.pseudo_utilisateur = "";
		this.mdp_utilisateur = "";
		this.tel_utilisateur = "";
		this.mail_utilisateur = "";
	}

	public Utilisateur(String nss,
					   String nom,
					   String prenom,
					   String pseudo,
					   String mdp,
					   String tel,
					   String mail) {
		super();
		this.numero_securite_social_utilisateur = nss;
		this.pseudo_utilisateur = pseudo;
		this.nom_utilisateur = nom;
		this.prenom_utilisateur = prenom;
		this.tel_utilisateur = tel;
		this.mdp_utilisateur = mdp;
		this.mail_utilisateur = mail;
	}
	
	public Utilisateur(String nom, 
			   	   String prenom) {
		super();
		this.numero_securite_social_utilisateur = "";
		this.pseudo_utilisateur = "";
		this.nom_utilisateur = nom;
		this.prenom_utilisateur = prenom;
		this.tel_utilisateur = "";
		this.mdp_utilisateur = "";
		this.mail_utilisateur = "";
	}

	public Utilisateur(String nss) {
		super();
		this.numero_securite_social_utilisateur = nss;
	}

	public String getNumero_securite_social_utilisateur() {
		return numero_securite_social_utilisateur;
	}

	public void setNumero_securite_social_utilisateur(String numero_securite_social_utilisateur) {
		this.numero_securite_social_utilisateur = numero_securite_social_utilisateur;
	}

	public String getPseudo_utilisateur() {
		return pseudo_utilisateur;
	}

	public void setPseudo_utilisateur(String pseudo_utilisateur) {
		this.pseudo_utilisateur = pseudo_utilisateur;
	}

	public String getNom_utilisateur() {
		return nom_utilisateur;
	}

	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}

	public String getPrenom_utilisateur() {
		return prenom_utilisateur;
	}

	public void setPrenom_utilisateur(String prenom_utilisateur) {
		this.prenom_utilisateur = prenom_utilisateur;
	}

	public String getTel_utilisateur() {
		return tel_utilisateur;
	}

	public void setTel_utilisateur(String tel_utilisateur) {
		this.tel_utilisateur = tel_utilisateur;
	}

	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}

	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}

	public String getMail_utilisateur() {
		return mail_utilisateur;
	}

	public void setMail_utilisateur(String mail_utilisateur) {
		this.mail_utilisateur = mail_utilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [" +
				"pseudo='" + pseudo_utilisateur + '\'' +
				", nom_utilisateur='" + nom_utilisateur + '\'' +
				", prenom_utilisateur='" + prenom_utilisateur + '\'' +
				", tel_utilisateur='" + tel_utilisateur + '\'' +
				", mdp_utilisateur='" + mdp_utilisateur + '\'' +
				", mail_utilisateur='" + mail_utilisateur + '\'' +
				']';
	}
}
