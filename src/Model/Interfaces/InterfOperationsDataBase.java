package Model.Interfaces;

import java.sql.SQLException;

import Model.Classes.Metiers.Utilisateur;
import Model.Classes.Systeme.ConfigurationDB;
import Model.Classes.Systeme.Menu;

public interface InterfOperationsDataBase {

	public boolean connect(ConfigurationDB config);
	public void disconnet();
	public boolean isConnected();
	public boolean exist(Utilisateur user) throws SQLException;
	public Menu getAllAcces(Utilisateur user) throws SQLException;
	
}
