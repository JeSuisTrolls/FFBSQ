package Controler.Abstracts;

import Model.Modele;
import Model.Interfaces.InterfCRUD;
import Model.Interfaces.InterfOperationsVuePrincipale;

/**
 * 
 * @author fabiancisnerosbridon
 *
 */
public abstract class AbstractControler implements InterfCRUD {
	
	protected Modele monModel;
	
	/**
	 * 
	 * @param model
	 */
	public AbstractControler(Modele model)
	{ 
		this.monModel = model;
	}
	
}
