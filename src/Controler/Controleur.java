package Controler;


import java.util.ArrayList;
import java.util.List;

/*
 * Clase qui herite de la clase Abstract "AbstractControler" 
 * et implemente toutes les méthodes de la classe mere.
 * 
 * Pour la création reçoit un MODELE
 */

import Controler.Abstracts.AbstractControler;
import Model.Modele;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConfigurationDB;
import Model.Classes.Systeme.Session;
import Model.Interfaces.InterfCRUD;
import Model.Interfaces.InterfOperationsAdmin;
import Model.Interfaces.InterfOperationsVuePrincipale;
import Model.Interfaces.Observer.InterfObservateur;
/**
 * 
 * @author fabiancisnerosbridon
 *
 */
public class Controleur extends AbstractControler implements InterfOperationsVuePrincipale, 
															 InterfOperationsAdmin {
	/**
	 * 
	 * @param model
	 */
	public Controleur(Modele model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean remplirMenu(Utilisateur user) {
		// TODO Auto-generated method stub
		return this.monModel.remplirMenu(user);
	}

	@Override
	public Utilisateur getUserSession() {
		// TODO Auto-generated method stub
		return this.monModel.getUserSession();
	}

	@Override
	public int getSizeMenu() {
		// TODO Auto-generated method stub
		return this.monModel.getSizeMenu();
	}

	@Override
	public String getPseudoUserSession() {
		// TODO Auto-generated method stub
		return this.monModel.getPseudoSession();
	}

	@Override
	public String getLibelleMenu(int index) {
		// TODO Auto-generated method stub
		return this.monModel.getLibelleMenu(index);
	}

	@Override
	public int getOptionsCountMenu(int index) {
		// TODO Auto-generated method stub
		return this.monModel.getOptionsCountMenu(index);
	}

	@Override
	public String getLibelleOption(int op, int m) {
		// TODO Auto-generated method stub
		return this.monModel.getLibelleOption(op, m);
	}

	@Override
	public void addObserverModel(InterfObservateur obs) {
		// TODO Auto-generated method stub
		this.monModel.addObserver(obs);
	}

	@Override
	public void notifiyObserverModel() {
		// TODO Auto-generated method stub
		this.monModel.notifyObserver();
	}

	@Override
	public void setSessionDefaut() {
		// TODO Auto-generated method stub
		this.monModel.setSessionDefaut();
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		this.monModel.disconnect();
	}

	@Override
	public void setSessionModel(Session session) {
		// TODO Auto-generated method stub
		this.monModel.setSession(session);
	}

	@Override
	public boolean connect(ConfigurationDB config) {
		// TODO Auto-generated method stub
		return this.monModel.connect(config);
	}

	@Override
	public void removeObserverModel(int index) {
		// TODO Auto-generated method stub
		this.monModel.removeObserver(index);
	}

	@Override
	public boolean connectionValid() {
		// TODO Auto-generated method stub
		return this.monModel.connectionValid();
	}

	@Override
	public boolean exist(Utilisateur user) {
		// TODO Auto-generated method stub
		return this.monModel.exist(user);
	}

	@Override
	public void setUserSession(Utilisateur user) {
		// TODO Auto-generated method stub
		this.monModel.setUserSession(user);
	}

	@Override
	public Resultat insertinto(Object obj) {
		// TODO Auto-generated method stub
		return this.monModel.insertinto(obj);
	}

	@Override
	public Resultat deletefrom(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat update(Object newObj, Object oldObj) {
		// TODO Auto-generated method stub
		return this.monModel.update(newObj, oldObj);
	}

	@Override
	public Resultat select(Object obj) {
		// TODO Auto-generated method stub
		return this.monModel.select(obj);
	}

	@Override
	public Resultat setDroits(List<String> LDroit, Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return this.monModel.setDroits(LDroit, utilisateur);
	}

	@Override
	public List<String> getDroits(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return this.monModel.getDroits(utilisateur);
	}

	@Override
	public Resultat selectAll(Object obj) {
		// TODO Auto-generated method stub
		return this.monModel.selectAll(obj);
	}

	@Override
	public Resultat selectAllInfo(Object obj) {
		// TODO Auto-generated method stub
		return this.monModel.selectAllInfo(obj);
	}

}
