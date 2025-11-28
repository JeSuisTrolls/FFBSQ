package View.COMPETITION;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Controler.Controleur;
import Model.Classes.Autres.DateChecker;
import Model.Classes.Metiers.*;
import View.Abstracts.AbstractVuePersonnalisable;
import View.VueMessage;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

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
    public void initComponents() {
        this.jlbl_libelle_competition = new JLabel("Nom comp. : ");
        this.jlbl_club = new JLabel("Club : ");
        this.jlbl_discipline = new JLabel("Discipline : ");
        this.jlbl_centre_bowling = new JLabel("C. Bowling : ");
        this.jlbl_categorie = new JLabel("Catégorie : ");
        this.jlbl_date_competition = new JLabel("Date compét. :");
        this.jlbl_tarif = new JLabel("Tarif : ");

        this.jtf_libelle_competition = new JTextField();
        this.jtf_libelle_competition.setPreferredSize(new Dimension(230, 30));
        this.jcb_club = new JComboBox<String>();
        this.jcb_club.setPreferredSize(new Dimension(230, 30));
        this.jcb_discipline = new JComboBox<String>();
        this.jcb_discipline.setPreferredSize(new Dimension(230, 30));
        this.jcb_centre_bowling = new JComboBox<String>();;
        this.jcb_centre_bowling.setPreferredSize(new Dimension(230, 30));
        this.jcb_categorie = new JComboBox<String>();;
        this.jcb_categorie.setPreferredSize(new Dimension(230, 30));
        this.jtf_date_competition = new JTextField();
        this.jtf_date_competition.setPreferredSize(new Dimension(230, 30));
        this.jtf_tarif = new JTextField("100");
        this.jtf_tarif.setPreferredSize(new Dimension(230, 30));

        Resultat resultatCategorie = this.controler.select(new Categorie());
        if(resultatCategorie.isSucces()) {
            this.setValuesJCB(resultatCategorie.getReponse(), this.jcb_categorie, new Categorie());
        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la récupération des catégorie.", BLUE, true);
            return;
        }

        Resultat resultatClub = this.controler.select(new Club());
        if(resultatClub.isSucces()) {
            this.setValuesJCB(resultatClub.getReponse(), this.jcb_club, new Club());
        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la récupération des clubs.", BLUE, true);
            return;
        }

        Resultat resultatDiscipline = this.controler.select(new Discipline());
        if(resultatDiscipline.isSucces()) {
            this.setValuesJCB(resultatDiscipline.getReponse(), this.jcb_discipline, new Discipline());

        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la récupération des disciplines.", BLUE, true);
            return;
        }

        Resultat resultatCentreBowling = this.controler.select(new CentreBowling());
        if(resultatCentreBowling.isSucces()) {
            this.setValuesJCB(resultatCentreBowling.getReponse(), this.jcb_centre_bowling, new CentreBowling());
        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur", "Soucis pendant la récupération des centres bowling.", BLUE, true);
            return;
        }

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

        this.jbtn_annuler.addActionListener(this);
        this.jbtn_creer.addActionListener(this);

        this.setButtonSubmit(jbtn_creer);

        this.getContentPane().add(this.jp, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Si la source de l'evenement est le
         * bouton btn_enter
         */
        if (event.getSource().equals(this.jbtn_annuler)) {
            dispose();
            return;
        }

        String libelleCompetition = jtf_libelle_competition.getText();
        Categorie categorie = (Categorie) jcb_categorie.getSelectedItem();
        Club club = (Club) jcb_club.getSelectedItem();
        CentreBowling centreBowling = (CentreBowling) jcb_centre_bowling.getSelectedItem();
        Discipline discipline = (Discipline) jcb_discipline.getSelectedItem();
        Competition competition = new Competition();

        String date = jtf_date_competition.getText();
        // On demande au controleur si la connexion a la BD a été faite avec succès
        if (this.controler.connectionValid()) {
            // verification des divers champs si valide ou non null
            if (libelleCompetition.isEmpty() || date.isEmpty()) {

                new VueMessage(null, new Dimension(320, 80), "Erreur", "Veuillez remplir tous les champs.", RED, true);
                return;
            }

            // verification si NSS est des chiffres

            if (!DateChecker.isValid(date)) {

                new VueMessage(null, new Dimension(320, 80), "Erreur", "Veuillez donner une date avec le format yyyy-MM-dd.", RED, true);
                return;
            }


            // création de la competition (sans tarif)
            Resultat resultatCompetition = this.controler.insertinto(new Competition(libelleCompetition, discipline.getId_discipline(), club.getId_club(), categorie.getId_categorie(), centreBowling.getId_centre_bowling() ,date));
            // verification si la requête a fonctionné
            if(resultatCompetition.isSucces()) {

                JOptionPane.showMessageDialog(this, "Création de l'utilisateur avec succès",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                // reset des champs
                // vider tout les JTF (saisi du formulaire)
                this.jtf_date_competition.setText("");
                this.jtf_libelle_competition.setText("");
            } else {
                new VueMessage(null, new Dimension(320, 80), "Erreur", resultatCompetition.getMessage(), RED, true);
            }

        }
    }
}
