package View;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controler.Controleur;
import Model.Classes.Metiers.Utilisateur;
import View.Abstracts.AbstractVuePersonnalisable;

import static java.awt.Color.RED;

/*
 * Interface qui prend en charge la connexion.
 * Herite de la classe abstract AbstractVuePersonnalisable.
 * 
 * Possede un controler pour mettre a jour la session avec les informations 
 * de l'utilisateur connecté.
 */

public class VueConnexion extends AbstractVuePersonnalisable
{
	// Composants graphiques
	private JLabel lbl_pseudo;
	private JLabel lbl_mdp;
	
	private JButton btn_entrer;
	private JButton btn_cancel;
	
	private JPanel jp_connexion;
	
	private JTextField pseudo;
	private JPasswordField mdp;
	
	public VueConnexion(JFrame parent, 
						Dimension dimension, 
						String title, 
						boolean modal, 
						Controleur controler)
	{
		super(parent, dimension, title, modal, controler);

		this.initComponents();
		
		this.setVisible(true);
	}
	
	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		this.jp_connexion = new JPanel();
		
		this.lbl_pseudo = new JLabel("Nom utilisateur : ");
		this.lbl_mdp = new JLabel("Mot de passe : ");
		this.btn_entrer = new JButton("Entrer");
		this.btn_cancel = new JButton("Fermer");
		/*
		 *  Une autre maniere d'ecouter une composante.
		 *  Une autre manière d'implementer la méthode actionPerformed
		 *  sans avoir besoin d'implementer l'interface ActionListener
		 */
		this.btn_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		
		this.pseudo = new JTextField("jcartigny");
		this.pseudo.setPreferredSize(new Dimension(150, 30));
		this.mdp = new JPasswordField("1234");
		this.mdp.setPreferredSize(new Dimension(150, 30));
		
		/*
		 * L'ecouteur de ce bouton se trouve dans cette classe.
		 * Cette classe implement l'interface ActionLister, donc
		 * la methode actionPerformed
		 */
		this.btn_entrer.addActionListener(this);
		
		/*
		 * Le "contenaire" de l'interface est un JPanel.
		 * On ajoute tous les composants
		 */
		this.jp_connexion.add(this.lbl_pseudo); 
		this.jp_connexion.add(this.pseudo);
		this.jp_connexion.add(this.lbl_mdp);
		this.jp_connexion.add(this.mdp);
		this.jp_connexion.add(this.btn_entrer);
		this.jp_connexion.add(this.btn_cancel);
		
		this.setButtonSubmit(btn_entrer);
		
		/*
		 * Le content pane (en rose) : c'est dans celui-ci que nous placerons nos composants.
		 * Dans notre cas la composant est un JPanel avec nos composantes.
		 * Tout cela placé au milieu.
		 */
		this.getContentPane().add(this.jp_connexion, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Utilisateur u = new Utilisateur();
		u.setPseudo_utilisateur(this.pseudo.getText());
		u.setMdp_utilisateur(new String(this.mdp.getPassword()));
		
		// On demande au controleur si la connexion a la BD a été faite avec succès
		if (this.controler.connectionValid())
		{
			/* On demande au controleur si l'utilisateur 
			 * qui veut entrer dans au système existe dans la BD
			 */
			if (!this.controler.exist(u))
			{
				// Cas : utilisateur n'existe pas.
				
				// Affichage d'un message d'erreur
				new VueMessage(null, new Dimension(320, 80), "Erreur", "Utilisateur ou mot de passe erronés", RED, true);
				
				this.pseudo.setText("");
				this.mdp.setText("");
			}
			else
			{
				// Cas : utilisateur existe
				
				/*
				 * Le controleur assigne a la session l'utilisateur en question
				 */
				this.controler.setUserSession(u);
				
				// Le controleur notifie à tous l'observateur
				this.controler.notifiyObserverModel();
				
				// Activer l'action du bouton cancel, pour fermer l'interface
				this.btn_cancel.doClick();
			}
		}
	}
	
}
