package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Classes.Abstracts.AbstractCRUD;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConnectionDB;
import Model.Interfaces.InterfOperationsAdmin;

public class UtilisateurDAO extends AbstractCRUD 
                        implements InterfOperationsAdmin {

	public UtilisateurDAO(ConnectionDB conn_db, 
			          String requete, 
			          ArrayList<String> listValeurs,
			          ArrayList<String> listTypes) {
		super(conn_db, requete, listValeurs, listTypes);
		// TODO Auto-generated constructor stub
	}

	public UtilisateurDAO(ConnectionDB conn_db) {
		super(conn_db);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Resultat insertinto(Object obj) {
		if(obj instanceof Utilisateur) {

			Utilisateur utilisateur = (Utilisateur) obj;

			String requete = "INSERT INTO UTILISATEUR (id_utilisateur, nom_utilisateur, prenom_utilisateur, pseudo_utilisateur, mdp_utilisateur, tel_utilisateur, mail_utilisateur) VALUES (?, ?, ?, ?, ?, ?, ?)";

			this.setRequete(requete);

			// Liste pour initialiser les champs
			ArrayList<String> listValeurs = new ArrayList<String>();
			listValeurs.add(utilisateur.getNumero_securite_social_utilisateur());
			listValeurs.add(utilisateur.getNom_utilisateur());
			listValeurs.add(utilisateur.getPrenom_utilisateur());
			listValeurs.add(utilisateur.getPseudo_utilisateur());
			listValeurs.add(utilisateur.getMdp_utilisateur());
			listValeurs.add(utilisateur.getTel_utilisateur());
			listValeurs.add(utilisateur.getMail_utilisateur());

			this.setListValeurs(listValeurs);
			// Liste pour initialiser le type des champs
			ArrayList<String> listTypes = new ArrayList<>();
			listTypes.add("STRING");
			listTypes.add("STRING");
			listTypes.add("STRING");
			listTypes.add("STRING");
			listTypes.add("STRING");
			listTypes.add("STRING");
			listTypes.add("STRING");

			this.setListTypes(listTypes);

			this.prepare();

			return this.execute();
		}
		return new Resultat("Mauvais type objet", false, null);
	}
	@Override
	public Resultat deletefrom(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat update(Object newObj, Object oldObj) {
		// TODO Auto-generated method stub
		/*Employe newUtilisateur = (Employe) newObj;
		Employe oldUtilisateur = (Employe) oldObj;
		
		String requete = "update employe set ";
		
		if (!newUtilisateur.getNum_secu_employe().equals(""))
			requete += "num_secu_employe = '" + newUtilisateur.getNum_secu_employe() + "', ";
		
		if (!newUtilisateur.getNom().equals(""))
			requete += "nom_employe = '" + newUtilisateur.getNom() + "', ";
		
		if (!newUtilisateur.getPrenom().equals(""))
			requete += "prenom_employe = '" + newUtilisateur.getPrenom() + "', ";
		
		if (!newUtilisateur.getMobile_employe().equals(""))
			requete += "mobile_employe = '" + newUtilisateur.getMobile_employe() + "', ";
		
		if (!newUtilisateur.getPseudo().equals(""))
			requete += "pseudo = '" + newUtilisateur.getPseudo() + "', ";
		
		if (!newUtilisateur.getMot_de_passe().equals(""))
			requete += "mot_de_passe = '" + newUtilisateur.getMot_de_passe() + "', ";
		
		if (!newUtilisateur.getRue_adr_employe().equals(""))
			requete += "rue_adr_employe = '" + newUtilisateur.getRue_adr_employe() + "', ";
		
		if (!newUtilisateur.getNum_adr_employe().equals(""))
			requete += "num_adr_employe = '" + newUtilisateur.getNum_adr_employe() + "', ";
		
		if (!newUtilisateur.getDate_embauche_employe().equals(""))
			requete += "date_embauche_employe = '" + newUtilisateur.getDate_embauche_employe() + "', ";
		
		if (!newUtilisateur.getCp_adr_employe().equals(""))
			requete += "cp_adr_employe = '" + newUtilisateur.getCp_adr_employe() + "', ";
		
		if (newUtilisateur.getId_agence() != 0)
			requete += "id_agence = " + newUtilisateur.getCp_adr_employe() + ", ";
		
		if (!newUtilisateur.getNum_secu_employe().equals(""))
			requete += "where num_secu_employe = '" + newUtilisateur.getNum_secu_employe() + "'";
		else
			requete += "where pseudo = '" + newUtilisateur.getPseudo() + "'";
		
		requete = requete.replaceFirst(", w", " w");
		
		this.setRequete(requete);
		
		this.prepare();*/
		
		return this.execute();
	}

	@Override
	public Resultat select(Object obj) {
		// TODO Auto-generated method stub
		String requete = "select * from utilisateur";
		
		this.setRequete(requete);
		
		this.prepare();
		
		return this.execute();
	}

	@Override
	public Resultat setDroits(List LDroit, Utilisateur employe) {
		// TODO Auto-generated method stub
		/*
		 * Recuperer les droits actuels de l'utilisateur
		 */
		List<String> ldroits_anciens_utilisateur = this.getDroits(employe);
		int index;
		String requete;
		
		/*
		 * Si l'employe a des droits
		 */
		if (ldroits_anciens_utilisateur != null)
		{
			/*
			 * On se déplace dans la liste
			 */
			for (int i = 0; i < ldroits_anciens_utilisateur.size(); i++)
			{
				/*
				 * Si l'i-eme droit ancien n'est pas dans la nouvelle
				 * selection de droits, alors il faut le supprimer de la BD.
				 */
				index = LDroit.indexOf(ldroits_anciens_utilisateur.get(i));
				if (index == -1)
				{
					requete = getRequeteComplet("autoriser_option_commercial",
												ldroits_anciens_utilisateur.get(i).toString(),
												employe.getPseudo_utilisateur());
					this.setRequete(requete);
					this.prepare();
					this.execute();
					
					
					requete = getRequeteComplet("autoriser_option_demenagement",
												ldroits_anciens_utilisateur.get(i).toString(),
												employe.getPseudo_utilisateur());
					this.setRequete(requete);
					this.prepare();
					this.execute();
				}
				/*
				 * S'il est dans la liste nouvelle selection de droits
				 * alors on le supprime
				 */
				else
				{
					LDroit.remove(index);
				}
			}
		}
			
		/*
		 * 
		 * Ajouter que les nouveaux droits
		 * 
		 * Nouveaux		Ancien(BD)
		 * 2x			7x
		 * 1x			2
		 * 3s			1
		 * 4s			5x
		 * 
		 * A la fin les seuls droits qui resterons seront :
		 * 2, 1 (les anciens qui sont deja dans la BD) et 3 et 4 (les nouveaux)
		 * 
		 * 
		 */
		for (int i = 0; i < LDroit.size(); i++)
		{
			requete = "select f_octroyer_droit "
					+ "((select num_secu_employe "
					  + "from employe "
					  + "where pseudo = '" + employe.getPseudo_utilisateur() + "'), "
					 + "(select id_option "
					  + "from option "
					  + "where libelle_option = '" + LDroit.get(i) + "'))";
			
			this.setRequete(requete);
			this.prepare();
			this.execute();
		}
		
		return new Resultat("", true, null);
	}

	@Override
	public List<String> getDroits(Utilisateur employe) {
		// TODO Auto-generated method stub
		Resultat reponse = this.getDroits(employe.getPseudo_utilisateur());
		
		List<String> ldroits = new ArrayList<String>();
		
		ResultSet droits = reponse.getReponse();
		
		try {
			while (droits.next())
			{
				ldroits.add(droits.getString("libelle_option"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ldroits;
	}
	
	private String getRequeteComplet(String matable, 
			                         String libelle, 
			                         String pseudo)
	{
		String requete = "delete from " + matable + " "
				+ "where id_option = "
				+ "(select id_option "
				 + "from option "
				 + "where libelle_option = '" + libelle + "') "
				+ "and "
				+ "num_secu_employe = "
				+ "(select num_secu_employe "
								  + "from employe "
								  + "where pseudo = '" +  pseudo + "')";
		
		return requete;
	}
	
	private Resultat getDroits(String pseudo) {
		// TODO Auto-generated method stub
		String requete = "select libelle_option "
				       + "from employe e "
				       + "inner join autoriser_option_commercial aoc on aoc.num_secu_commercial = e.num_secu_employe "
				       + "inner join option o on o.id_option = aoc.id_option "
				       + "where pseudo = '" + pseudo + "' "
				       + "union "
				       + "select libelle_option "
				       + "from employe e "
				       + "inner join autoriser_option_demenageur aod on aod.num_secu_demenageur = e.num_secu_employe "
				       + "inner join option o on o.id_option = aod.id_option "
				       + "where pseudo = '" + pseudo + "' ";
		
		this.setRequete(requete);
		this.prepare();
		return this.execute();
	}

	@Override
	public Resultat selectAll(Object obj) {
		if(obj instanceof Utilisateur) {
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

}
