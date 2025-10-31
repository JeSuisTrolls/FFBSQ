package View.ADMIN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controler.Controleur;
import Model.Classes.Autres.MonDefaultTableModel;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import Model.Classes.Metiers.Utilisateur;
import View.Abstracts.AbstractVuePersonnalisable;
import View.VueMessage;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

public class VueListerEmploye extends AbstractVuePersonnalisable {

    // Labels
    private JLabel lbl_filtre;
    private JLabel lbl_id_utilisateur;
    private JLabel lbl_nom_utilisateur;
    private JLabel lbl_prenom_utilisateur;
    private JLabel lbl_pseudo_utilisateur;
    private JLabel lbl_mdp_utilisateur;
    private JLabel lbl_mdp_confirmation_utilisateur;
    private JLabel lbl_cell_utilisateur;
    private JLabel lbl_mail_utilisateur;
    private JLabel lbl_type_utilisateur;
    private JLabel lbl_liste_employes;

    // Champs de texte
    private JTextField jtf_filtre;
    private JTextField jtf_id_utilisateur;
    private JTextField jtf_nom_utilisateur;
    private JTextField jtf_prenom_utilisateur;
    private JTextField jtf_pseudo_utilisateur;
    private JPasswordField jpf_mdp_utilisateur;
    private JPasswordField jpf_mdp_confirmation_utilisateur;
    private JTextField jtf_cell_utilisateur;
    private JTextField jtf_mail_utilisateur;

    // ComboBox
    private JComboBox<TypeEmploye> jcb_type_utilisateur;

    // Boutons
    private JButton btn_update;
    private JButton btn_delete;
    private JButton btn_cancel;

    // Liste et Table
    private JList<String> jlist_employes;
    private DefaultListModel<String> listModel;
    private MonDefaultTableModel tableModel;
    private JTable jtable_employes;
    private JScrollPane scrollPane;

    // Panels
    private JPanel jp_info_employe;
    private JPanel jp_lister_employe;
    private JPanel jp_filtre;
    private JPanel jp_buttons;

    // Données
    private ResultSet resultSetEmployes;
    private Employe employeSelectionne;

    public VueListerEmploye(JFrame parent,
                            Dimension dimension,
                            String title,
                            boolean modal,
                            Controleur controler) {
        super(parent, dimension, title, modal, controler);
        this.initComponents();
        this.chargerEmployes();
        this.setVisible(true);
    }

    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout(10, 10));

        // Initialisation des labels
        this.lbl_filtre = new JLabel("Filtrer : ");
        this.lbl_id_utilisateur = new JLabel("N.S. : ");
<<<<<<< HEAD
        this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
        this.lbl_nom_utilisateur = new JLabel("Nom : ");
=======
        this.lbl_nom_utilisateur = new JLabel("Nom : ");
        this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
>>>>>>> 73dac4ce5f9e9fb57811b56bb21c948959f4e3a0
        this.lbl_pseudo_utilisateur = new JLabel("Pseudo : ");
        this.lbl_mdp_utilisateur = new JLabel("M. de passe : ");
        this.lbl_mdp_confirmation_utilisateur = new JLabel("Conf. Mdp : ");
        this.lbl_cell_utilisateur = new JLabel("Téléphone : ");
        this.lbl_mail_utilisateur = new JLabel("E-mail : ");
<<<<<<< HEAD
        this.lbl_type_utilisateur = new JLabel("Type empl. : ");
        this.lbl_liste_employes = new JLabel("Liste d'employés :");

        // Initialisation des champs de texte
        this.jtf_filtre = new JTextField();
        this.jtf_filtre.setPreferredSize(new Dimension(350, 30));

        this.jtf_id_utilisateur = new JTextField();
        this.jtf_id_utilisateur.setPreferredSize(new Dimension(200, 30));
        this.jtf_id_utilisateur.setEnabled(false); // NSS non modifiable

        this.jtf_prenom_utilisateur = new JTextField();
        this.jtf_prenom_utilisateur.setPreferredSize(new Dimension(200, 30));

        this.jtf_nom_utilisateur = new JTextField();
        this.jtf_nom_utilisateur.setPreferredSize(new Dimension(200, 30));

        this.jtf_pseudo_utilisateur = new JTextField();
        this.jtf_pseudo_utilisateur.setPreferredSize(new Dimension(200, 30));

        this.jpf_mdp_utilisateur = new JPasswordField();
        this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(175, 30));

        this.jpf_mdp_confirmation_utilisateur = new JPasswordField();
        this.jpf_mdp_confirmation_utilisateur.setPreferredSize(new Dimension(175, 30));

        this.jtf_cell_utilisateur = new JTextField();
        this.jtf_cell_utilisateur.setPreferredSize(new Dimension(200, 30));

        this.jtf_mail_utilisateur = new JTextField();
        this.jtf_mail_utilisateur.setPreferredSize(new Dimension(200, 30));

        // Initialisation du ComboBox
        this.jcb_type_utilisateur = new JComboBox<>();
        this.jcb_type_utilisateur.setPreferredSize(new Dimension(200, 30));

        // Charger les types d'employés
        Resultat resultat = this.controler.select(new TypeEmploye());
        if(resultat.isSucces()) {
            this.setValuesJCB(resultat.getReponse(), this.jcb_type_utilisateur, new TypeEmploye());
        }

        // Initialisation des boutons
        this.btn_update = new JButton("M.A.J.");
        this.btn_update.setPreferredSize(new Dimension(120, 28));
        this.btn_update.addActionListener(this);
        this.btn_update.setEnabled(false);

        this.btn_delete = new JButton("Supprimer");
        this.btn_delete.setPreferredSize(new Dimension(120, 28));
        this.btn_delete.addActionListener(this);
        this.btn_delete.setEnabled(false);

        this.btn_cancel = new JButton("Annuler");
        this.btn_cancel.setPreferredSize(new Dimension(120, 28));
=======
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

        this.lbl_lister_employe = new JLabel("Liste d'employés");

        Resultat r = this.controler.select(new TypeEmploye());

        this.setValuesJCB(r.getReponse(), this.jcb_type_utilisateur, new TypeEmploye());
        this.jp_info_employe = new JPanel();
        this.jp_lister_employer = new JPanel();

        this.btn_save.addActionListener(this);
>>>>>>> 73dac4ce5f9e9fb57811b56bb21c948959f4e3a0
        this.btn_cancel.addActionListener(this);

        // Panel de filtre
        this.jp_filtre = new JPanel();
        this.jp_filtre.add(this.lbl_filtre);
        this.jp_filtre.add(this.jtf_filtre);

        // Ajouter listener pour le filtre
        this.jtf_filtre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrerListe();
            }
        });

        // Panel de la liste des employés
        this.jp_lister_employe = new JPanel();
        this.jp_lister_employe.setLayout(new BorderLayout(5, 5));
        this.jp_lister_employe.setPreferredSize(new Dimension(450, 600));

        this.listModel = new DefaultListModel<>();
        this.jlist_employes = new JList<>(this.listModel);
        this.jlist_employes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jlist_employes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Ajouter listener pour la sélection
        this.jlist_employes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    chargerEmployeSelectionne();
                }
            }
        });

        this.scrollPane = new JScrollPane(this.jlist_employes);
        this.scrollPane.setPreferredSize(new Dimension(430, 550));

        this.jp_lister_employe.add(this.lbl_liste_employes, BorderLayout.NORTH);
        this.jp_lister_employe.add(this.scrollPane, BorderLayout.CENTER);

        // Panel des informations de l'employé
        this.jp_info_employe = new JPanel();
        this.jp_info_employe.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.jp_info_employe.setPreferredSize(new Dimension(400, 600));

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

        // Panel des boutons
        this.jp_buttons = new JPanel();
        this.jp_buttons.add(this.btn_update);
        this.jp_buttons.add(this.btn_delete);
        this.jp_buttons.add(this.btn_cancel);

        // Assemblage final
        this.add(this.jp_filtre, BorderLayout.NORTH);
        this.add(this.jp_lister_employe, BorderLayout.WEST);
        this.add(this.jp_info_employe, BorderLayout.CENTER);
        this.add(this.jp_buttons, BorderLayout.SOUTH);

<<<<<<< HEAD
        this.setButtonSubmit(btn_update);
    }
=======
        this.getContentPane().add(this.jp_info_employe);
>>>>>>> 73dac4ce5f9e9fb57811b56bb21c948959f4e3a0

    private void chargerEmployes() {
        Resultat resultat = this.controler.selectAll(new Employe());

        if (resultat == null || !resultat.isSucces()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Impossible de charger les employés", RED, true);
            return;
        }

<<<<<<< HEAD
        this.resultSetEmployes = resultat.getReponse();
        this.listModel.clear();

        try {
            while (this.resultSetEmployes.next()) {
                String nss = this.resultSetEmployes.getString("id_utilisateur");
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");

                String ligne = String.format("%-15s %s %s", nss, prenom, nom);
                this.listModel.addElement(ligne);
            }

            // Repositionner le curseur au début
            if (this.resultSetEmployes.first()) {
                this.resultSetEmployes.beforeFirst();
            }

        } catch (SQLException e) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Erreur lors du chargement : " + e.getMessage(), RED, true);
            e.printStackTrace();
        }
    }

    private void filtrerListe() {
        String filtre = this.jtf_filtre.getText().toLowerCase().trim();

        if (filtre.isEmpty()) {
            chargerEmployes();
            return;
        }

        this.listModel.clear();

        try {
            this.resultSetEmployes.beforeFirst();

            while (this.resultSetEmployes.next()) {
                String nss = this.resultSetEmployes.getString("id_utilisateur");
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");

                String recherche = (nss + " " + nom + " " + prenom + " " + pseudo).toLowerCase();

                if (recherche.contains(filtre)) {
                    String ligne = String.format("%-15s %s %s", nss, prenom, nom);
                    this.listModel.addElement(ligne);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void chargerEmployeSelectionne() {
        int index = this.jlist_employes.getSelectedIndex();

        if (index == -1) {
            viderFormulaire();
            this.btn_update.setEnabled(false);
            this.btn_delete.setEnabled(false);
            return;
        }

        try {
            this.resultSetEmployes.beforeFirst();
            int currentIndex = 0;

            while (this.resultSetEmployes.next()) {
                String filtre = this.jtf_filtre.getText().toLowerCase().trim();

                if (!filtre.isEmpty()) {
                    String nss = this.resultSetEmployes.getString("id_utilisateur");
                    String nom = this.resultSetEmployes.getString("nom_utilisateur");
                    String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                    String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");
                    String recherche = (nss + " " + nom + " " + prenom + " " + pseudo).toLowerCase();

                    if (!recherche.contains(filtre)) {
                        continue;
                    }
                }

                if (currentIndex == index) {
                    String nss = this.resultSetEmployes.getString("id_utilisateur");
                    String nom = this.resultSetEmployes.getString("nom_utilisateur");
                    String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                    String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");
                    String mdp = this.resultSetEmployes.getString("mdp_utilisateur");
                    String tel = this.resultSetEmployes.getString("tel_utilisateur");
                    String mail = this.resultSetEmployes.getString("mail_utilisateur");
                    String idTypeEmploye = this.resultSetEmployes.getString("id_type_employe");

                    this.jtf_id_utilisateur.setText(nss);
                    this.jtf_nom_utilisateur.setText(nom);
                    this.jtf_prenom_utilisateur.setText(prenom);
                    this.jtf_pseudo_utilisateur.setText(pseudo);
                    this.jpf_mdp_utilisateur.setText(mdp);
                    this.jpf_mdp_confirmation_utilisateur.setText(mdp);
                    this.jtf_cell_utilisateur.setText(tel);
                    this.jtf_mail_utilisateur.setText(mail);

                    // Sélectionner le type d'employé
                    for (int i = 0; i < this.jcb_type_utilisateur.getItemCount(); i++) {
                        TypeEmploye te = this.jcb_type_utilisateur.getItemAt(i);
                        if (te.getId_type_employe().equals(idTypeEmploye)) {
                            this.jcb_type_utilisateur.setSelectedIndex(i);
                            break;
                        }
                    }

                    this.employeSelectionne = new Employe(nss, nom, prenom, pseudo, mdp, tel, mail, idTypeEmploye);

                    this.btn_update.setEnabled(true);
                    this.btn_delete.setEnabled(true);

                    break;
                }

                currentIndex++;
            }

        } catch (SQLException e) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Erreur lors du chargement : " + e.getMessage(), RED, true);
            e.printStackTrace();
        }
    }

    private void viderFormulaire() {
        this.jtf_id_utilisateur.setText("");
        this.jtf_nom_utilisateur.setText("");
        this.jtf_prenom_utilisateur.setText("");
        this.jtf_pseudo_utilisateur.setText("");
        this.jpf_mdp_utilisateur.setText("");
        this.jpf_mdp_confirmation_utilisateur.setText("");
        this.jtf_cell_utilisateur.setText("");
        this.jtf_mail_utilisateur.setText("");
        this.jcb_type_utilisateur.setSelectedIndex(0);
        this.employeSelectionne = null;
=======
        this.getContentPane().add(this.jp, BorderLayout.CENTER);


>>>>>>> 73dac4ce5f9e9fb57811b56bb21c948959f4e3a0
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.btn_cancel)) {
            dispose();
            return;
        }

        if (event.getSource().equals(this.btn_update)) {
            mettreAJourEmploye();
        }
        else if (event.getSource().equals(this.btn_delete)) {
            supprimerEmploye();
        }
    }

    private void mettreAJourEmploye() {
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
            return;
        }

        String nom = this.jtf_nom_utilisateur.getText().toUpperCase().trim();
        String prenom = this.jtf_prenom_utilisateur.getText().toUpperCase().trim();
        String pseudo = this.jtf_pseudo_utilisateur.getText().toUpperCase().trim();
        String mdp = new String(this.jpf_mdp_utilisateur.getPassword());
        String mdpConf = new String(this.jpf_mdp_confirmation_utilisateur.getPassword());
        String tel = this.jtf_cell_utilisateur.getText().trim();
        String mail = this.jtf_mail_utilisateur.getText().trim();
        TypeEmploye typeEmploye = (TypeEmploye) this.jcb_type_utilisateur.getSelectedItem();

        if (nom.isEmpty() || prenom.isEmpty() || pseudo.isEmpty() ||
                mdp.isEmpty() || mdpConf.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Veuillez remplir tous les champs.", RED, true);
            return;
        }

        if (!mdp.equals(mdpConf)) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Les mots de passe ne sont pas identiques", RED, true);
            return;
        }

        Employe nouvelEmploye = new Employe(
                this.employeSelectionne.getNumero_securite_social_utilisateur(),
                nom, prenom, pseudo, mdp, tel, mail,
                typeEmploye.getId_type_employe()
        );

        Resultat resultat = this.controler.update(nouvelEmploye, this.employeSelectionne);

        if (resultat == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Impossible de mettre à jour l'employé", RED, true);
            return;
        }

        if (resultat.isSucces()) {
            new VueMessage(null, new Dimension(320, 80), "Succès",
                    "Employé mis à jour avec succès", BLUE, true);
            chargerEmployes();
            viderFormulaire();
            this.btn_update.setEnabled(false);
            this.btn_delete.setEnabled(false);
        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    resultat.getMessage(), RED, true);
        }
    }

    private void supprimerEmploye() {
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
            return;
        }

        int reponse = JOptionPane.showConfirmDialog(
                this,
                "Êtes-vous sûr de vouloir supprimer cet employé ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (reponse != JOptionPane.YES_OPTION) {
            return;
        }

        Resultat resultat = this.controler.deletefrom(this.employeSelectionne);

        if (resultat == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Impossible de supprimer l'employé", RED, true);
            return;
        }

        if (resultat.isSucces()) {
            new VueMessage(null, new Dimension(320, 80), "Succès",
                    "Employé supprimé avec succès", BLUE, true);
            chargerEmployes();
            viderFormulaire();
            this.btn_update.setEnabled(false);
            this.btn_delete.setEnabled(false);
        } else {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    resultat.getMessage(), RED, true);
        }
    }
}