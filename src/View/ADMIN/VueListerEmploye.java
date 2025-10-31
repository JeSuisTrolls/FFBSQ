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
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import View.Abstracts.AbstractVuePersonnalisable;
import View.VueMessage;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

public class VueListerEmploye extends AbstractVuePersonnalisable {

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

    private JTextField jtf_filtre;
    private JTextField jtf_id_utilisateur;
    private JTextField jtf_nom_utilisateur;
    private JTextField jtf_prenom_utilisateur;
    private JTextField jtf_pseudo_utilisateur;
    private JPasswordField jpf_mdp_utilisateur;
    private JPasswordField jpf_mdp_confirmation_utilisateur;
    private JTextField jtf_cell_utilisateur;
    private JTextField jtf_mail_utilisateur;

    private JComboBox<TypeEmploye> jcb_type_utilisateur;

    private JButton btn_update;
    private JButton btn_delete;
    private JButton btn_cancel;

    private JList<String> jlist_employes;
    private DefaultListModel<String> listModel;
    private JScrollPane scrollPane;

    private JPanel jp_info_employe;
    private JPanel jp_lister_employe;
    private JPanel jp_filtre;
    private JPanel jp_buttons;
    private JPanel jp_center;

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
        this.getContentPane().setBackground(Color.WHITE);

        // Panel pour le filtrage de la recherche de l'employé
        this.lbl_filtre = new JLabel("Filtrer : ");
        this.jtf_filtre = new JTextField();
        this.jtf_filtre.setPreferredSize(new Dimension(300, 30));

        this.jp_filtre = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.jp_filtre.add(this.lbl_filtre);
        this.jp_filtre.add(this.jtf_filtre);

        this.jtf_filtre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtrerListe();
            }
        });

        // Panel info employé ( gauchec )
        this.lbl_id_utilisateur = new JLabel("N.S. : ");
        this.lbl_prenom_utilisateur = new JLabel("Prénom : ");
        this.lbl_nom_utilisateur = new JLabel("Nom : ");
        this.lbl_pseudo_utilisateur = new JLabel("Pseudo : ");
        this.lbl_mdp_utilisateur = new JLabel("M. de passe : ");
        this.lbl_mdp_confirmation_utilisateur = new JLabel("Conf. Mdp : ");
        this.lbl_cell_utilisateur = new JLabel("Téléphone : ");
        this.lbl_mail_utilisateur = new JLabel("E-mail : ");
        this.lbl_type_utilisateur = new JLabel("Type empl. : ");

        this.jtf_id_utilisateur = new JTextField();
        this.jtf_id_utilisateur.setPreferredSize(new Dimension(150, 25));
        this.jtf_id_utilisateur.setEnabled(false);

        this.jtf_prenom_utilisateur = new JTextField();
        this.jtf_prenom_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jtf_nom_utilisateur = new JTextField();
        this.jtf_nom_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jtf_pseudo_utilisateur = new JTextField();
        this.jtf_pseudo_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jpf_mdp_utilisateur = new JPasswordField();
        this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jpf_mdp_confirmation_utilisateur = new JPasswordField();
        this.jpf_mdp_confirmation_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jtf_cell_utilisateur = new JTextField();
        this.jtf_cell_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jtf_mail_utilisateur = new JTextField();
        this.jtf_mail_utilisateur.setPreferredSize(new Dimension(150, 25));

        this.jcb_type_utilisateur = new JComboBox<>();
        this.jcb_type_utilisateur.setPreferredSize(new Dimension(150, 25));

        Resultat resultat = this.controler.select(new TypeEmploye());
        if(resultat.isSucces()) {
            this.setValuesJCB(resultat.getReponse(), this.jcb_type_utilisateur, new TypeEmploye());
        }

        this.jp_info_employe = new JPanel();
        this.jp_info_employe.setLayout(new GridLayout(9, 2, 5, 5));
        this.jp_info_employe.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

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

        // Panel lister employes ( droite )
        this.lbl_liste_employes = new JLabel("Liste d'employés :");
        this.listModel = new DefaultListModel<>();
        this.jlist_employes = new JList<>(this.listModel);
        this.jlist_employes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jlist_employes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        this.jlist_employes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    chargerEmployeSelectionne();
                }
            }
        });

        this.scrollPane = new JScrollPane(this.jlist_employes);

        this.jp_lister_employe = new JPanel(new BorderLayout(5, 5));
        this.jp_lister_employe.add(this.lbl_liste_employes, BorderLayout.NORTH);
        this.jp_lister_employe.add(this.scrollPane, BorderLayout.CENTER);

        // Panel qui contient les deux autres (info et lister)
        this.jp_center = new JPanel(new BorderLayout(10, 10));
        this.jp_center.add(this.jp_info_employe, BorderLayout.WEST);
        this.jp_center.add(this.jp_lister_employe, BorderLayout.CENTER);

        // Boutons
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
        this.btn_cancel.addActionListener(this);

        this.jp_buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.jp_buttons.add(this.btn_update);
        this.jp_buttons.add(this.btn_delete);
        this.jp_buttons.add(this.btn_cancel);

        // Ajout des 3 Jp, au jp principale
        this.add(this.jp_filtre, BorderLayout.NORTH);
        this.add(this.jp_center, BorderLayout.CENTER);
        this.add(this.jp_buttons, BorderLayout.SOUTH);

        this.setButtonSubmit(btn_update);
    }
    // Méthode pour charger la liste d'employés
    private void chargerEmployes() {
        // Appel au contrôleur pour faire un selectAll sur les employés (requête BD)
        Resultat resultat = this.controler.selectAll(new Employe());
        //Vérification si la requête a réussi
        if (resultat == null || !resultat.isSucces()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Impossible de charger les employés", RED, true);
            return;
        }
        // Stockage du résultat dans resultSetEmployes
        this.resultSetEmployes = resultat.getReponse();
        // Vider la liste et le formulaire
        this.listModel.clear();
        viderFormulaire();
        //Désactiver les boutons M.A.J. et Supprimer (inutile vu qu'aucun employé n'est selectionné)
        this.btn_update.setEnabled(false);
        this.btn_delete.setEnabled(false);
        // Parcourir tous les employés et les ajouter à la liste
        try {
            while (this.resultSetEmployes.next()) {
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");

                String ligne = String.format("%s %s", nom, prenom);
                this.listModel.addElement(ligne);
            }

            if (this.resultSetEmployes.first()) {
                this.resultSetEmployes.beforeFirst();
            }

        } catch (SQLException e) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Erreur lors du chargement : " + e.getMessage(), RED, true);
            e.printStackTrace();
        }
    }
    // Méthode qui permet de filtrer la recherche de l'employé avec un filtre
    private void filtrerListe() {
        // Récupérer le texte du filtre
        String filtre = this.jtf_filtre.getText().toLowerCase().trim();

        this.listModel.clear();
        viderFormulaire();
        this.btn_update.setEnabled(false);
        this.btn_delete.setEnabled(false);

        // Si le filtre est vide, recharger la liste complète
        if (filtre.isEmpty()) {
            chargerEmployes();
            return;
        }
        // Sinon, parcourir tous les employés de la BD
        try {
            this.resultSetEmployes.beforeFirst();
            // Pour chaque employé, vérifier si le filtre correspond
            while (this.resultSetEmployes.next()) {
                String nss = this.resultSetEmployes.getString("id_utilisateur");
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");

                String recherche = (nss + " " + nom + " " + prenom + " " + pseudo).toLowerCase();
                // Si ça correspond, ajouter l'employé à la liste affichée
                if (recherche.contains(filtre)) {
                    // affichage du prenom et nom dans la liste d'employé)
                    String ligne = String.format("%s %s", prenom, nom);
                    this.listModel.addElement(ligne);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void chargerEmployeSelectionne() {
        // Récupérer l'index de l'employé sélectionné
        int index = this.jlist_employes.getSelectedIndex();
        // Si aucun employé sélectionné vider le formulaire d'information supplémentaire et désactiver les boutons
        if (index == -1) {
            viderFormulaire();
            this.btn_update.setEnabled(false);
            this.btn_delete.setEnabled(false);
            return;
        }
        // Sinon, parcourir la BD et trouver l'employé à la position 'index'
        try {
            String filtre = this.jtf_filtre.getText().toLowerCase().trim();
            this.resultSetEmployes.beforeFirst();
            int currentIndex = 0;
            // Remplir tous les champs du formulaire avec ses données
            while (this.resultSetEmployes.next()) {
                String nss = this.resultSetEmployes.getString("id_utilisateur");
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");
                String recherche = (nss + " " + nom + " " + prenom + " " + pseudo).toLowerCase();

                if (!filtre.isEmpty() && !recherche.contains(filtre)) {
                    continue;
                }

                if (currentIndex == index) {
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

                    for (int i = 0; i < this.jcb_type_utilisateur.getItemCount(); i++) {
                        TypeEmploye te = this.jcb_type_utilisateur.getItemAt(i);
                        // Sélectionner le bon type d'employé dans la combobox
                        if (te.getId_type_employe().equals(idTypeEmploye)) {
                            this.jcb_type_utilisateur.setSelectedIndex(i);
                            break;
                        }
                    }
                    // Stocker cet employé dans employeSelectionne ( permet de récupérer les informations en cas de modification, suppression)
                    this.employeSelectionne = new Employe(nss, nom, prenom, pseudo, mdp, tel, mail, idTypeEmploye);
                    // Activé les boutons
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
        // Vider tout les JTF
        this.jtf_id_utilisateur.setText("");
        this.jtf_nom_utilisateur.setText("");
        this.jtf_prenom_utilisateur.setText("");
        this.jtf_pseudo_utilisateur.setText("");
        this.jpf_mdp_utilisateur.setText("");
        this.jpf_mdp_confirmation_utilisateur.setText("");
        this.jtf_cell_utilisateur.setText("");
        this.jtf_mail_utilisateur.setText("");
        // Mets la première valeur de la JCB
        this.jcb_type_utilisateur.setSelectedIndex(0);
        // Supprime la valeur de l'employé selectionner
        this.employeSelectionne = null;
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
        // Vérifier qu'un employé est bien sélectionné
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
            return;
        }
        // Récupérer les valeurs modifiées du formulaire
        String nom = this.jtf_nom_utilisateur.getText().toUpperCase().trim();
        String prenom = this.jtf_prenom_utilisateur.getText().toUpperCase().trim();
        String pseudo = this.jtf_pseudo_utilisateur.getText().toUpperCase().trim();
        String mdp = new String(this.jpf_mdp_utilisateur.getPassword());
        String mdpConf = new String(this.jpf_mdp_confirmation_utilisateur.getPassword());
        String tel = this.jtf_cell_utilisateur.getText().trim();
        String mail = this.jtf_mail_utilisateur.getText().trim();
        TypeEmploye typeEmploye = (TypeEmploye) this.jcb_type_utilisateur.getSelectedItem();
        // Valider les champs, pour éviter qu'ils soit vides
        if (nom.isEmpty() || prenom.isEmpty() || pseudo.isEmpty() ||
                mdp.isEmpty() || mdpConf.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Veuillez remplir tous les champs.", RED, true);
            return;
        }
        // Validation des mots de passes pour qu'ils soient identiques
        if (!mdp.equals(mdpConf)) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Les mots de passe ne sont pas identiques", RED, true);
            return;
        }
        // création d'un nouveau Objet employé, avec les valeurs des champs
        Employe nouvelEmploye = new Employe(
                this.employeSelectionne.getNumero_securite_social_utilisateur(),
                nom, prenom, pseudo, mdp, tel, mail,
                typeEmploye.getId_type_employe()
        );
        // Appel au contrôleur pour mettre à jour l'employé
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

        // Vérifier qu'un employé est bien sélectionné
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
            return;
        }
        // Affiche d'une boite de dialogue avec un sytème de confirmation
        int reponse = JOptionPane.showConfirmDialog(
                this,
                "Êtes-vous sûr de vouloir supprimer cet employé ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        // si la réponse de l'utisateur !=  oui, on annule la suppression
        if (reponse != JOptionPane.YES_OPTION) {
            return;
        }
        // Appel au contrôleur pour supprimer l'employé
        Resultat resultat = this.controler.deletefrom(this.employeSelectionne);

        // Résultat de la requête
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