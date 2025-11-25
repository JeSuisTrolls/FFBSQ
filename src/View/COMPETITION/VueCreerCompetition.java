package View.COMPETITION;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controler.Controleur;
import Model.Classes.Metiers.Resultat;
import View.Abstracts.AbstractVuePersonnalisable;

public class VueCreerCompetition extends AbstractVuePersonnalisable {

    private JLabel jlbl_libelle_competition;
    private JLabel jlbl_club;
    private JLabel jlbl_discipline;
    private JLabel jlbl_centre_bowling;
    private JLabel jlbl_categorie;
    private JLabel jlbl_date_competition;
    private JLabel jlbl_tarif;

    private JTextField jtf_libelle_competition;
    private JComboBox jcb_club;
    private JComboBox jcb_discipline;
    private JComboBox jcb_centre_bowling;
    private JComboBox jcb_categorie;
    private JTextField jtf_date_competition;
    private JTextField jtf_tarif;

    private JButton jbtn_creer;
    private JButton jbtn_annuler;

    private JPanel jp;

    private Resultat resultat;

    public VueCreerCompetition(JFrame parent, String title, boolean modal, Controleur controleur) {
        super(parent, title, modal, controleur);
        // TODO Auto-generated constructor stub

        this.initComponents();

        this.setVisible(true);
    }

    public VueCreerCompetition(JFrame parent, Dimension dimension, String title, boolean modal, Controleur controleur) {
        super(parent, dimension, title, modal, controleur);
        // TODO Auto-generated constructor stub

        this.initComponents();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initComponents() {
        // TODO Auto-generated method stub
        this.jlbl_libelle_competition = new JLabel("Nom comp. : ");
        this.jlbl_club = new JLabel("Club : ");
        this.jlbl_discipline = new JLabel("Discipline : ");
        this.jlbl_centre_bowling = new JLabel("C. Bowling : ");
        this.jlbl_categorie = new JLabel("Catégorie : ");
        this.jlbl_date_competition = new JLabel("Date compét. :");
        this.jlbl_tarif = new JLabel("Tarif : ");

        this.jtf_libelle_competition = new JTextField();
        this.jtf_libelle_competition.setPreferredSize(new Dimension(200, 30));
        this.jcb_club = new JComboBox<String>();
        this.jcb_discipline = new JComboBox<String>();
        this.jcb_centre_bowling = new JComboBox<String>();;
        this.jcb_categorie = new JComboBox<String>();;
        this.jtf_date_competition = new JTextField();
        this.jtf_date_competition.setPreferredSize(new Dimension(200, 30));
        this.jtf_tarif = new JTextField("100");
        this.jtf_tarif.setPreferredSize(new Dimension(200, 30));

        this.jbtn_annuler = new JButton("Annuler");
        this.jbtn_creer = new JButton("Créer");

        this.jp = new JPanel();

        this.jp.add(this.jlbl_libelle_competition);
        this.jp.add(this.jtf_libelle_competition);
        this.jp.add(this.jlbl_club);
        this.jp.add(this.jcb_club);
        this.jp.add(this.jlbl_discipline);
        this.jp.add(this.jcb_discipline);
        this.jp.add(this.jlbl_centre_bowling);
        this.jp.add(this.jcb_centre_bowling);
        this.jp.add(this.jlbl_categorie);
        this.jp.add(this.jcb_categorie);
        this.jp.add(this.jlbl_date_competition);
        this.jp.add(this.jtf_date_competition);
        this.jp.add(this.jlbl_date_competition);
        this.jp.add(this.jtf_date_competition);

        this.jp.add(this.jbtn_annuler);
        this.jp.add(this.jbtn_creer);

        this.jbtn_annuler.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                dispose();
            }
        });
        this.jbtn_creer.addActionListener(this);

        this.setButtonSubmit(jbtn_creer);

        this.getContentPane().add(this.jp, BorderLayout.CENTER);
    }

}
