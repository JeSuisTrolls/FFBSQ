package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Classes.Abstracts.AbstractModel;
import Model.Classes.Metiers.*;
import Model.Classes.Systeme.ConfigurationDB;
import Model.Classes.Systeme.Option;
import Model.Classes.Systeme.Session;
import Model.DAO.EmployeDAO;
import Model.DAO.OptionsDAO;
import Model.DAO.TypeEmployeDAO;
import Model.DAO.UtilisateurDAO;
import Model.Interfaces.Observer.InterfObservateur;


/*
 * Classe qui sera "observée" car elle herite de la classe
 * abstracte AbstractModel qui implemente l'interface "Observable".
 * 
 * Dans cette classe on implement toutes les méthodes abstractes défnies dans la 
 * classe mére, ainsi que les méthodes abstract de l'interface "Observable".
 */

public class Modele extends AbstractModel {

	@Override
	public boolean connectionValid() {
		// TODO Auto-generated method stub
		return this.session.isConnected();
	}

	@Override
	public boolean exist(Utilisateur user) {
		return this.session.exist(user);
	}

	@Override
	public boolean remplirMenu(Utilisateur u) {
		// TODO Auto-generated method stub
		try 
		{
			if (this.session.setMenu(u))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int getSizeMenu() {
		// TODO Auto-generated method stub
		return this.session.getMenu().getMenuCount();
	}

	@Override
	public Option getOptionsMenu(int index) {
		// TODO Auto-generated method stub
		return this.session.getMenu().getMenu(index);
	}

	@Override
	public int getOptionsCountMenu(int index) {
		// TODO Auto-generated method stub
		return this.session.getMenu().getOptionsCountMenu(index);
	}

	@Override
	public String getLibelleMenu(int index) {
		// TODO Auto-generated method stub
		return this.session.getMenu().getLibelleMenu(index);
	}

	@Override
	public String getLibelleOption(int op, int m) {
		// TODO Auto-generated method stub
		return this.session.getMenu().getLibelleOption(op, m);
	}

	@Override
	public boolean connect(ConfigurationDB config) {
		// TODO Auto-generated method stub
		return this.session.connect(config);
	}

	@Override
	public void setSessionDefaut() {
		// TODO Auto-generated method stub
		this.session = new Session();
	}

	@Override
	public Utilisateur getUserSession() {
		// TODO Auto-generated method stub
		return this.session.getUser();
	}

	@Override
	public String getPseudoSession() {
		// TODO Auto-generated method stub
		return this.session.getUser().getPseudo_utilisateur().toUpperCase();
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		this.session.disconnect();
	}

	@Override
	public void setUserSession(Utilisateur user) {
		// TODO Auto-generated method stub
		this.session.setUser(user);
	}

	//Implémentation du pattern observable
	@Override
	public void addObserver(InterfObservateur obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		this.listObserver = new ArrayList<InterfObservateur>();
	}

	@Override
	public void removeObserver(int i) {
		// TODO Auto-generated method stub
		this.listObserver.remove(i);
	}

	@Override
	public void notifyObserver(Session session) {
		// TODO Auto-generated method stub
		for(InterfObservateur obs : this.listObserver) 
			// chaque observateur a une methode update.
			obs.update(session);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		this.notifyObserver(this.session);
	}

	@Override
	public Resultat insertinto(Object obj) {
		// TODO Auto-generated method stub
		// Definir quel managerDAO on va utiliser
		this.setManagerDAOCorresponds(obj);
		// Ajouter l'objet en fonction du manager defini
		return this.managerDAO.insertinto(obj);
	}

	@Override
	public Resultat deletefrom(Object obj) {
		// TODO Auto-generated method stub
			return null;
	}

	@Override
	public Resultat update(Object newObj, Object oldObj) {
		// TODO Auto-generated method stub
		this.setManagerDAOCorresponds(newObj);
		return this.managerDAO.update(newObj, oldObj);
	}

	@Override
	public Resultat select(Object obj) {
		// TODO Auto-generated method stub
		if(obj != null){
			this.setManagerDAOCorresponds(obj);
			return this.managerDAO.select(obj);
		}
		return new Resultat("Type d'objet inconnu", false, null);
	}
	
	private void setManagerDAOCorresponds(Object obj)
	{   if (obj instanceof Employe)
			this.managerDAO = new EmployeDAO(this.session.getConnDBSession());
		else if (obj instanceof Utilisateur)
			this.managerDAO = new UtilisateurDAO(this.session.getConnDBSession());
		else if (obj instanceof Options)
			this.managerDAO = new OptionsDAO(this.session.getConnDBSession());
		else if (obj instanceof TypeEmploye)
			this.managerDAO = new TypeEmployeDAO(this.session.getConnDBSession());

	}

	@Override
	public Resultat setDroits(List<String> LDroit, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		this.setManagerDAOCorresponds(utilisateur); 
		return ((UtilisateurDAO) this.managerDAO).setDroits(LDroit, utilisateur);
	}

	@Override
	public List<String> getDroits(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		this.setManagerDAOCorresponds(utilisateur); 
		return ((UtilisateurDAO) this.managerDAO).getDroits(utilisateur);
	}

	@Override
	public Resultat selectAll(Object obj) {
		// TODO Auto-generated method stub
		this.setManagerDAOCorresponds(obj);
		return this.managerDAO.selectAll(obj);
	}

	@Override
	public Resultat selectAllInfo(Object obj) {
		// TODO Auto-generated method stub
		this.setManagerDAOCorresponds(obj);
		return this.managerDAO.selectAllInfo(obj);
	}
	
}