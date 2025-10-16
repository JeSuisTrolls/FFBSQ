package Model.Interfaces;

import java.util.ArrayList;

import Model.Classes.Metiers.Resultat;
/**
 * 
 * @author fabiancisnerosbridon
 *
 */
public interface InterfCRUD {
	
	/*
	 * M E T H O D E S   A B S T R A C T S
	 * 
	 * Create : insert into
	 * Read : select 
	 * Update : update
	 * Delete : delete
	 */
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Resultat insertinto(Object obj);
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Resultat deletefrom(Object obj);
	/**
	 * 
	 * @param newObj
	 * @param oldObj
	 * @return
	 */
	public abstract Resultat update(Object newObj, Object oldObj);
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Resultat select(Object obj);
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Resultat selectAll(Object obj);
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public abstract Resultat selectAllInfo(Object obj);

}
