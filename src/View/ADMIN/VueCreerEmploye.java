package View.ADMIN;


import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controler.Controleur;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import Model.Classes.Metiers.Utilisateur;
import View.Abstracts.AbstractVuePersonnalisable;
import View.VueMessage;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

/*
 * Interface qui prend en charge la création de compte pour les employes.
 * Herite de la classe abstract AbstractVuePersonnalisable.
 *
 * Possede un controler pour créer les employés avec les informations saisit
 * par l'administrateur.
 */

public class VueCreerEmploye extends AbstractVuePersonnalisable {

private JLabel lbl_id_utilisateur;
private JLabel lbl_nom_utilisateur;
private JLabel lbl_prenom_utilisateur;
private JLabel lbl_pseudo_utilisateur;
private JLabel lbl_mdp_utilisateur;
private JLabel lbl_mdp_confirmation_utilisateur;
private JLabel lbl_cell_utilisateur;
private JLabel lbl_mail_utilisateur;
private JLabel lbl_type_utilisateur;

private JTextField jtf_id_utilisateur;
private JTextField jtf_nom_utilisateur;
private JTextField jtf_prenom_utilisateur;
private JTextField jtf_pseudo_utilisateur;
private JTextField jtf_cell_utilisateur;
private JTextField jtf_mail_utilisateur;

private JPasswordField jpf_mdp_utilisateur;
private JPasswordField jpf_mdp_confirmation_utilisateur;

private JComboBox jcb_type_utilisateur;

private JButton btn_save;
private JButton btn_cancel;

private JPanel jp;

public VueCreerEmploye(JFrame parent,
                       Dimension dimension,
                       String title,
                       boolean modal,
                       Controleur controler) {
    super(parent, dimension, title, modal, controler);

    this.initComponents();

    this.setVisible(true);
}

public VueCreerEmploye(JFrame parent,
                       String title,
                       boolean modal,
                       Controleur controler) {
    super(parent, title, modal, controler);

    this.initComponents();

    this.setVisible(true);
}

@Override
public void initComponents() {

    this.lbl_id_utilisateur = new JLabel("N.S. : ");
    this.lbl_nom_utilisateur = new JLabel("Nom : ");
    this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
    this.lbl_pseudo_utilisateur = new JLabel("Pseudo : ");
    this.lbl_mdp_utilisateur = new JLabel("M. de passe : ");
    this.lbl_mdp_confirmation_utilisateur = new JLabel("Conf. Mdp : ");
    this.lbl_cell_utilisateur = new JLabel("Téléphone : ");
    this.lbl_mail_utilisateur = new JLabel("E-mail : ");
    this.lbl_type_utilisateur = new JLabel("Type empl : ");

    this.jtf_id_utilisateur = new JTextField();
    this.jtf_prenom_utilisateur = new JTextField();
    this.jtf_nom_utilisateur = new JTextField();
    this.jtf_pseudo_utilisateur = new JTextField();
    this.jpf_mdp_utilisateur = new JPasswordField();
    this.jpf_mdp_confirmation_utilisateur = new JPasswordField();
    this.jtf_cell_utilisateur = new JTextField();
    this.jtf_mail_utilisateur = new JTextField();
    this.jcb_type_utilisateur = new JComboBox<>();

    this.btn_save = new JButton("Enregistrer");
    this.btn_cancel = new JButton("Annuler");

    this.jtf_id_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jtf_prenom_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jtf_nom_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jtf_pseudo_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(175, 30));
    this.jpf_mdp_confirmation_utilisateur.setPreferredSize(new Dimension(175, 30));
    this.jtf_cell_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jtf_mail_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.jcb_type_utilisateur.setPreferredSize(new Dimension(200, 30));
    this.btn_save.setPreferredSize(new Dimension(120, 28));
    this.btn_cancel.setPreferredSize(new Dimension(120, 28));
    // this.controler.select(null); faire en sorte que la classe DAO ne puisse pas prendre de null ou autre
    Resultat resultat = this.controler.select(new TypeEmploye());
    if(resultat.isSucces()) {
        this.setValuesJCB(resultat.getReponse(), this.jcb_type_utilisateur, new TypeEmploye());
    } else {
        new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la récupération des types d'employer.", BLUE, true);
        return;
    }

    this.jp = new JPanel();

    this.btn_save.addActionListener(this);
    this.btn_cancel.addActionListener(this);

    this.jp.add(this.lbl_id_utilisateur);
    this.jp.add(this.jtf_id_utilisateur);

    this.jp.add(this.lbl_prenom_utilisateur);
    this.jp.add(this.jtf_prenom_utilisateur);

    this.jp.add(this.lbl_nom_utilisateur);
    this.jp.add(this.jtf_nom_utilisateur);

    this.jp.add(this.lbl_pseudo_utilisateur);
    this.jp.add(this.jtf_pseudo_utilisateur);

    this.jp.add(this.lbl_mdp_utilisateur);
    this.jp.add(this.jpf_mdp_utilisateur);

    this.jp.add(this.lbl_mdp_confirmation_utilisateur);
    this.jp.add(this.jpf_mdp_confirmation_utilisateur);

    this.jp.add(this.lbl_cell_utilisateur);
    this.jp.add(this.jtf_cell_utilisateur);

    this.jp.add(this.lbl_mail_utilisateur);
    this.jp.add(this.jtf_mail_utilisateur);

    this.jp.add(this.lbl_type_utilisateur);
    this.jp.add(this.jcb_type_utilisateur);

    this.jp.add(this.btn_save);
    this.jp.add(this.btn_cancel);

    this.setButtonSubmit(btn_save);

    this.getContentPane().add(this.jp, BorderLayout.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Si la source de l'evenement est le
         * bouton btn_enter
         */
        if (!event.getSource().equals(this.btn_save)) {
            dispose();
            return;
        }
        String nss = jtf_id_utilisateur.getText();
        String nom = jtf_nom_utilisateur.getText().toUpperCase();
        String prenom = jtf_prenom_utilisateur.getText().toUpperCase();
        String pseudo = jtf_pseudo_utilisateur.getText().toUpperCase();
        String mdp = new String(jpf_mdp_utilisateur.getPassword());
        String mdpConf = new String(jpf_mdp_confirmation_utilisateur.getPassword());
        String tel = jtf_cell_utilisateur.getText();
        String mail = jtf_mail_utilisateur.getText();
        TypeEmploye typeEmploye = (TypeEmploye) jcb_type_utilisateur.getSelectedItem();

        Utilisateur u = new Utilisateur();
        u.setPseudo_utilisateur(pseudo);
        // On demande au controleur si la connexion a la BD a été faite avec succès
        if (this.controler.connectionValid()) {
            // verification des divers champs si valide ou non null
            if (nss.isEmpty() || nom.isEmpty() || prenom.isEmpty() || pseudo.isEmpty() ||
                    mdp.isEmpty() || mdpConf.isEmpty() || tel.isEmpty() || mail.isEmpty()) {

                new VueMessage(null, new Dimension(320, 80), "Erreur", "Veuillez remplir tous les champs.", RED, true);
                return;
            }
            // verification si l'utilisateur déjà présent
            if (this.controler.exist(u)) {
                new VueMessage(null, new Dimension(320, 80), "Erreur", "Utilisateur déjà crée", RED, true);
                return;
            }
            // verification si mdp & mdpConf sont les mêmes
            if(!(mdp.equals(mdpConf))) {
                new VueMessage(null, new Dimension(320, 80), "Erreur", "Les mots de passes ne sont pas identiques", RED, true);
                return;
            }
            // création de l'utilisateur
            Resultat resultatUtilisateur = this.controler.insertinto(new Utilisateur(nss, nom, prenom, pseudo, mdp, tel, mail));
            // verification si la requête a fonctionné
            if (!resultatUtilisateur.isSucces()) {
                new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la création de l'utilisateur", RED, true);
                return;
            }
            // création de l'employé
            Resultat resultatEmploye = this.controler.insertinto(new Employe(nss, typeEmploye.getId_type_employe()));
            // verification si la requête a fonctionné
            if(resultatEmploye.isSucces()) {

                JOptionPane.showMessageDialog(this, "Création de l'utilisateur avec succès",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                // reset des champs
                this.jtf_id_utilisateur.setText("");
                this.jtf_nom_utilisateur.setText("");
                this.jtf_prenom_utilisateur.setText("");
                this.jtf_pseudo_utilisateur.setText("");
                this.jpf_mdp_utilisateur.setText("");
                this.jpf_mdp_confirmation_utilisateur.setText("");
                this.jtf_cell_utilisateur.setText("");
                this.jtf_mail_utilisateur.setText("");

            } else {
                new VueMessage(null, new Dimension(320, 80), "Erreur", resultatEmploye.getMessage(), RED, true);
            }

        }

    }
}
