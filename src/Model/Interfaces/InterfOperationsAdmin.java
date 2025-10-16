package Model.Interfaces;

import java.util.List;

import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.Utilisateur;

public interface InterfOperationsAdmin {
	
	/*
	 * M E T H O D E S   
	 * F O N C T I O N S   
	 * D ' A D M I N I S T R A T I O N
	 */
	
	public abstract Resultat setDroits(List<String> LDroit, Utilisateur utilisateur);
	public abstract List<String> getDroits(Utilisateur utilisateur);
	
}
