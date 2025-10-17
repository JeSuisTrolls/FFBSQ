package View.ADMIN;


import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controler.Controleur;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import View.Abstracts.AbstractVuePersonnalisable;

/*
 * Interface qui prend en charge la création de compte pour les employes.
 * Herite de la classe abstract AbstractVuePersonnalisable.
 *
 * Possede un controler pour créer les employés avec les informations saisit
 * par l'administrateur.
 */

public class VueListerEmploye extends AbstractVuePersonnalisable {

    private JLabel lbl_id_utilisateur;
    private JTextField jtf_id_utilisateur;
    private JLabel lbl_nom_utilisateur;
    private JTextField jtf_nom_utilisateur;
    private JLabel lbl_prenom_utilisateur;
    private JTextField jtf_prenom_utilisateur;
    private JLabel lbl_pseudo_utilisateur;
    private JTextField jtf_pseudo_utilisateur;
    private JLabel lbl_mdp_utilisateur;
    private JPasswordField jpf_mdp_utilisateur;
    private JLabel lbl_mdp_confirmation_utilisateur;
    private JPasswordField jpf_mdp_confirmation_utilisateur;
    private JLabel lbl_cell_utilisateur;
    private JTextField jtf_cell_utilisateur;
    private JLabel lbl_mail_utilisateur;
    private JTextField jtf_mail_utilisateur;
    private JLabel lbl_type_utilisateur;
    private JComboBox jcb_type_utilisateur;
    private JLabel lbl_lister_employe;

    private JButton btn_save;
    private JButton btn_cancel;


    private JPanel jp_info_employe;
    private JPanel jp_lister_employer;
    private JPanel jp;

    public VueListerEmploye(JFrame parent,
                           Dimension dimension,
                           String title,
                           boolean modal,
                           Controleur controler) {
        super(parent, dimension, title, modal, controler);

        this.initComponents();

        this.setVisible(true);
    }

    public VueListerEmploye(JFrame parent,
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
        this.jtf_id_utilisateur = new JTextField();
        this.jtf_id_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
        this.jtf_prenom_utilisateur = new JTextField();
        this.jtf_prenom_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_nom_utilisateur = new JLabel("Nom : ");
        this.jtf_nom_utilisateur = new JTextField();
        this.jtf_nom_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_pseudo_utilisateur = new JLabel("Pseudo : ");
        this.jtf_pseudo_utilisateur = new JTextField();
        this.jtf_pseudo_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_mdp_utilisateur = new JLabel("M. de passe : ");
        this.jpf_mdp_utilisateur = new JPasswordField();
        this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(175, 30));
        this.lbl_mdp_confirmation_utilisateur = new JLabel("Conf. Mdp : ");
        this.jpf_mdp_confirmation_utilisateur = new JPasswordField();
        this.jpf_mdp_confirmation_utilisateur.setPreferredSize(new Dimension(175, 30));
        this.lbl_cell_utilisateur = new JLabel("Téléphone : ");
        this.jtf_cell_utilisateur = new JTextField();
        this.jtf_cell_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_mail_utilisateur = new JLabel("E-mail : ");
        this.jtf_mail_utilisateur = new JTextField();
        this.jtf_mail_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.lbl_type_utilisateur = new JLabel("Type empl : ");
        this.jcb_type_utilisateur = new JComboBox<>();
        this.jcb_type_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.btn_save = new JButton("Enregistrer");
        this.btn_cancel = new JButton("Annuler");
        this.btn_save.setPreferredSize(new Dimension(120, 28));
        this.btn_cancel.setPreferredSize(new Dimension(120, 28));

        this.lbl_lister_employe = new JLabel("Liste d'employés test");

        Resultat r = this.controler.select(new TypeEmploye());

        this.setValuesJCB(r.getReponse(), this.jcb_type_utilisateur, new TypeEmploye());
        this.jp_info_employe = new JPanel();

        this.btn_save.addActionListener(this);
        this.btn_cancel.addActionListener(this);

        this.jp_info_employe.add(this.lbl_id_utilisateur);
        this.jp_info_employe.add(this.jtf_id_utilisateur);

        this.jp_info_employe.add(this.lbl_prenom_utilisateur);
        this.jp_info_employe.add(this.jtf_prenom_utilisateur);

        this.jp_info_employe.add(this.lbl_nom_utilisateur);
        this.jp_info_employe.add(this.jtf_nom_utilisateur);

        this.jp_info_employe.add(this.lbl_pseudo_utilisateur);
        this.jp_info_employe.add(this.jtf_pseudo_utilisateur);

        this.jp_info_employe.add(this.lbl_mdp_utilisateur);
        this.jp_info_employe.add(this.jpf_mdp_utilisateur);

        this.jp_info_employe.add(this.lbl_mdp_confirmation_utilisateur);
        this.jp_info_employe.add(this.jpf_mdp_confirmation_utilisateur);

        this.jp_info_employe.add(this.lbl_cell_utilisateur);
        this.jp_info_employe.add(this.jtf_cell_utilisateur);

        this.jp_info_employe.add(this.lbl_mail_utilisateur);
        this.jp_info_employe.add(this.jtf_mail_utilisateur);

        this.jp_info_employe.add(this.lbl_type_utilisateur);
        this.jp_info_employe.add(this.jcb_type_utilisateur);

        this.jp_info_employe.add(this.btn_save);
        this.jp_info_employe.add(this.btn_cancel);

        this.setButtonSubmit(btn_save);

        this.getContentPane().add(this.jp_info_employe, BorderLayout.CENTER);

        this.jp = new JPanel();
        this.jp.add(this.jp_info_employe);
        this.jp.add(this.jp_lister_employer);


    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
