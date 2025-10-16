package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConfigurationDB;
import Model.Classes.Systeme.ConnectionDB;
import Model.Classes.Systeme.Menu;
import Model.Classes.Systeme.Option;
import Model.Interfaces.InterfOperationsDataBase;

/*
 * Classe qui gere les opérations sur la BD
 */

public class SystemeDAO implements InterfOperationsDataBase {
	
	private ConnectionDB conn_db;

	public SystemeDAO() {
		super();
		this.conn_db = new ConnectionDB();
	}
	
	public boolean connect(ConfigurationDB config)
	{
		this.conn_db.setConfiguration(config);
		return this.conn_db.connectDB();
	}
	
	public void disconnet()
	{
		this.conn_db.disconnectDB();
	}
	
	public boolean isConnected()
	{
		return this.conn_db.isConnected();
	}
	
	public boolean exist(Utilisateur user) throws SQLException
	{
		String requete = "select pseudo_utilisateur "
				   + "from UTILISATEUR "
				   + "where pseudo_utilisateur = '" + user.getPseudo_utilisateur().toUpperCase() + "' and "
				   + "mdp_utilisateur = '" + user.getMdp_utilisateur() + "'";
		
		PreparedStatement prepare = null;
		
		try {
			prepare = this.conn_db
											.getConnexion_db()
											.prepareStatement(requete,
															  ResultSet.TYPE_SCROLL_INSENSITIVE, 
															  ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ResultSet reponse = prepare.executeQuery();
	
		if (reponse.first())
			return reponse.getString(1).trim().equals(user.getPseudo_utilisateur().toUpperCase());
		
		return false;
	}

	public Menu getAllAcces(Utilisateur user) throws SQLException
	{
		/*
		 * Obtenir toutes les options pour lesquelles l'utilisateur "user"
		 * a accès.
		 * 
		 * select O1.libelle_option as libelle_menu, IDMIDOPLOPP.libelle_option 
		 * from (select C.id_option as id_menu, OPTIONS_PSEUDO.id_option as id_option, 
		 * 		 OPTIONS_PSEUDO.libelle as libelle_option, OPTIONS_PSEUDO.pseudo as pseudo 
		 * 		 from (select A.id_option, libelle_option as libelle, pseudo 
		 * 			   from autorisation A 
		 * 			   inner join utilisateur U on U.id_utilisateur = A.id_utilisateur 
		 * 			   inner join options O on O.id_option = A.id_option where pseudo = 'FABIO') as OPTIONS_PSEUDO 
		 *       inner join comporte C on C.id_option_OPTIONS = OPTIONS_PSEUDO.id_option 
		 *       order by id_menu) as IDMIDOPLOPP 
		 * inner join options O1 on O1.id_option = IDMIDOPLOPP.id_menu
		 * 
		 * On obtient premierement (OPTIONS_PSEUDO) : id de l'option, le libelle et le pseudo
		 * des options auxquel l'utilisateur qui a ce pseudo.
		 * 
		 * IDMIDOPLOPP : On ajoute l'id du menu pour chacune de ces options.
		 * 
		 * On ajoute le libelle du menu de la vue précédente
		 */
		String requete = "select O1.libelle_option as libelle_menu, IDMIDOPLOPP.libelle_option "
					   + "from "
					   		+ "(select C.id_option_m as id_menu, OPTIONS_PSEUDO.id_option as id_option, "
					   		+ "OPTIONS_PSEUDO.libelle as libelle_option, OPTIONS_PSEUDO.pseudo_utilisateur as pseudo "
					   		+ "from (select A.id_option, libelle_option as libelle, pseudo_utilisateur " 
					   				+ "from avoir_acces A "
					   				+ "inner join UTILISATEUR U on U.id_utilisateur = A.id_utilisateur "
					   				+ "inner join OPTION O on O.id_option = A.id_option "
					   				+ "where pseudo_utilisateur = '" + user.getPseudo_utilisateur() + "') as OPTIONS_PSEUDO "
					   		+ "inner join comporte C on C.id_option_o = OPTIONS_PSEUDO.id_option "
					   		+ "order by id_menu) as IDMIDOPLOPP "
					   + "inner join OPTION O1 on O1.id_option = IDMIDOPLOPP.id_menu";
				
		PreparedStatement prepare = this.conn_db
												.getConnexion_db()
												.prepareStatement(requete,
																  ResultSet.TYPE_SCROLL_INSENSITIVE, 
																  ResultSet.CONCUR_UPDATABLE);
		
		ResultSet reponse = prepare.executeQuery();
		
		String nommenu;
		LinkedList<Option> menu = new LinkedList<Option>();
		LinkedList<Option> options = new LinkedList<Option>();
		
		
		/* 
		 * tant qu'il y a de registres
		 */
		while ( reponse.next() )
		{
			nommenu =  new String(reponse.getString(1));
			
			// ajouter l'option
			options.add(new Option(new String(reponse.getString(2)), null));
			
			// s'il y a encore des registres
			if (reponse.next())
			{
				// si le nom du menu du registre prochain change
				if (!nommenu.equals(reponse.getString(1)))
				{
					// ajouter la liste d'options à ce menu
					menu.add(new Option(new String(nommenu), options));
					// mettre à zéro la liste d'options
					options = new LinkedList<Option>();
				}
				
				/*
				 * comme on avait avancé pour savoir le nom du menu suivant,
				 * il faut faire marche arriere
				 */
				reponse.previous();
			}
			else // si on est arrivé à la fin
			{
				// avec les derniers options
				
				// ajouter la liste d'options à ce menu
				menu.add(new Option(new String(nommenu), options));
				// mettre à zéro la liste d'options
				options = new LinkedList<Option>();
			}
		}
		
		return (menu.isEmpty() ? null : new Menu(menu)) ;
	}
	
	public ConnectionDB getConn_db() {
		return conn_db;
	}

	public String getSGBDR()
	{
		return this.conn_db.getSGBDR();
	}
	
	public String getHost()
	{
		return this.conn_db.getHost();
	}
	
	public String getDbName()
	{
		return this.conn_db.getDbName();
	}
	
	public String getUserDB()
	{
		return this.conn_db.getUserDB();
	}
	
	public String getPasswordDB()
	{
		return this.conn_db.getPasswordDB();
	}
	
	public String getPort() 
	{
		return this.conn_db.getPort();
	}
}
