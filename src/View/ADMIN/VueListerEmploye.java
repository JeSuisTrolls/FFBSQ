package View.ADMIN;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controler.Controleur;
import Model.Classes.Metiers.Employe;
import Model.Classes.Metiers.Resultat;
import Model.Classes.Metiers.TypeEmploye;
import View.Abstracts.AbstractVuePersonnalisable;
import View.VueMessage;
import java.util.List;

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


    private ResultSet resultSetEmployes;
    private Employe employeSelectionne;

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

    private List<Employe> listeEmployesComplete;



    public VueListerEmploye(JFrame parent,
                            Dimension dimension,
                            String title,
                            boolean modal,
                            Controleur controler) {
        super(parent, dimension, title, modal, controler);
        this.initComponents();
        this.setVisible(true);
    }

    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(Color.WHITE);

        // panel pour le filtrage de la recherche de l'employé
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

        // panel info employé ( gauchec )
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
        this.jtf_pseudo_utilisateur.setEnabled(false);

        this.jpf_mdp_utilisateur = new JPasswordField();
        this.jpf_mdp_utilisateur.setPreferredSize(new Dimension(150, 25));
        this.jpf_mdp_utilisateur.setEnabled(false);

        this.jpf_mdp_confirmation_utilisateur = new JPasswordField();
        this.jpf_mdp_confirmation_utilisateur.setPreferredSize(new Dimension(150, 25));
        this.jpf_mdp_confirmation_utilisateur.setEnabled(false);

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

        // panel lister employes ( droite )
        this.lbl_liste_employes = new JLabel("Liste d'employés :");
        this.listModel = new DefaultListModel<>();
        this.jlist_employes = new JList<>(this.listModel);
        this.jlist_employes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jlist_employes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Ajouter le listener pour détecter quand un employé est sélectionné
        this.jlist_employes.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                chargerEmployeSelectionne();
            }
        });

        this.scrollPane = new JScrollPane(this.jlist_employes);

        this.jp_lister_employe = new JPanel(new BorderLayout(5, 5));
        this.jp_lister_employe.add(this.lbl_liste_employes, BorderLayout.NORTH);
        this.jp_lister_employe.add(this.scrollPane, BorderLayout.CENTER);

        // panel qui contient les deux autres (info et lister)
        this.jp_center = new JPanel(new BorderLayout(10, 10));
        this.jp_center.add(this.jp_info_employe, BorderLayout.WEST);
        this.jp_center.add(this.jp_lister_employe, BorderLayout.CENTER);

        // boutons
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

        // ajout des 3 Jp, au jp principale
        this.add(this.jp_filtre, BorderLayout.NORTH);
        this.add(this.jp_center, BorderLayout.CENTER);
        this.add(this.jp_buttons, BorderLayout.SOUTH);

        this.setButtonSubmit(btn_update);

        this.chargerEmployes();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.btn_cancel)) {
            dispose();
            return;
        }

        else if (event.getSource().equals(this.btn_update)) {
            mettreAJourEmploye();
        }
        else if (event.getSource().equals(this.btn_delete)) {
            supprimerEmploye();
        }
    }

    // méthode pour charger la liste d'employés
    private void chargerEmployes() {
        Resultat resultat = this.controler.selectAll(new Employe());

        if (resultat == null || !resultat.isSucces()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Impossible de charger les employés", RED, true);
            return;
        }

        this.resultSetEmployes = resultat.getReponse();
        this.listeEmployesComplete = new ArrayList<>(); // Initialiser la liste

        this.listModel.clear();
        viderFormulaire();
        this.btn_update.setEnabled(false);
        this.btn_delete.setEnabled(false);

        try {
            while (this.resultSetEmployes.next()) {
                String nss = this.resultSetEmployes.getString("id_utilisateur");
                String nom = this.resultSetEmployes.getString("nom_utilisateur");
                String prenom = this.resultSetEmployes.getString("prenom_utilisateur");
                String pseudo = this.resultSetEmployes.getString("pseudo_utilisateur");
                String mdp = this.resultSetEmployes.getString("mdp_utilisateur");
                String tel = this.resultSetEmployes.getString("tel_utilisateur");
                String mail = this.resultSetEmployes.getString("mail_utilisateur");
                String idTypeEmploye = this.resultSetEmployes.getString("id_type_employe");

                // Créer un objet Employe et l'ajouter à la liste
                Employe employe = new Employe(nss, nom, prenom, pseudo, mdp, tel, mail, idTypeEmploye);
                this.listeEmployesComplete.add(employe);

                // Ajouter au modèle de la JList
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
    // méthode qui permet de filtrer la recherche de l'employé avec un filtre
    private void filtrerListe() {
        String filtre = this.jtf_filtre.getText().toUpperCase().trim();

        this.listModel.clear();
        viderFormulaire();
        this.btn_update.setEnabled(false);
        this.btn_delete.setEnabled(false);

        // Utiliser les streams pour filtrer la liste (comme dans l'exemple)
        List<Employe> filteredItems = this.listeEmployesComplete.stream()
                .filter(employe -> {
                    String nss = employe.getNumero_securite_social_utilisateur();
                    String nom = employe.getNom_utilisateur();
                    String prenom = employe.getPrenom_utilisateur();
                    String pseudo = employe.getPseudo_utilisateur();
                    String nomPrenom = nom + " " + prenom;
                    // retourne uniquement les informations qui commence par le filtre
                    return nom.startsWith(filtre) ||
                            prenom.startsWith(filtre) ||
                            nomPrenom.startsWith(filtre) ||
                            pseudo.startsWith(filtre) ||
                            nss.startsWith(filtre);
                })
                .collect(Collectors.toList());

        // Ajouter les éléments filtrés au modèle
        filteredItems.forEach(employe -> {
            String ligne = String.format("%s %s", employe.getNom_utilisateur(),
                    employe.getPrenom_utilisateur());
            this.listModel.addElement(ligne);
        });
    }

    private void chargerEmployeSelectionne() {
        int index = this.jlist_employes.getSelectedIndex();

        if (index == -1) {
            viderFormulaire();
            this.btn_update.setEnabled(false);
            this.btn_delete.setEnabled(false);
            return;
        }

        String filtre = this.jtf_filtre.getText().toLowerCase().trim();
        int currentIndex = 0;

        for (Employe employe : this.listeEmployesComplete) {
            String nss = employe.getNumero_securite_social_utilisateur();
            String nom = employe.getNom_utilisateur();
            String prenom = employe.getPrenom_utilisateur();
            String pseudo = employe.getPseudo_utilisateur();
            String recherche = (nss + " " + nom + " " + prenom + " " + pseudo).toLowerCase();

            // Appliquer le même filtre
            if (!recherche.contains(filtre)) {
                continue;
            }

            if (currentIndex == index) {
                this.jtf_id_utilisateur.setText(nss);
                this.jtf_nom_utilisateur.setText(nom);
                this.jtf_prenom_utilisateur.setText(prenom);
                this.jtf_pseudo_utilisateur.setText(pseudo);
                this.jpf_mdp_utilisateur.setText(employe.getMdp_utilisateur());
                this.jpf_mdp_confirmation_utilisateur.setText(employe.getMdp_utilisateur());
                this.jtf_cell_utilisateur.setText(employe.getTel_utilisateur());
                this.jtf_mail_utilisateur.setText(employe.getMail_utilisateur());

                for (int i = 0; i < this.jcb_type_utilisateur.getItemCount(); i++) {
                    TypeEmploye te = this.jcb_type_utilisateur.getItemAt(i);
                    if (te.getId_type_employe().equals(employe.getId_type_employe())) {
                        this.jcb_type_utilisateur.setSelectedIndex(i);
                        break;
                    }
                }

                this.employeSelectionne = employe;
                this.btn_update.setEnabled(true);
                this.btn_delete.setEnabled(true);
                break;
            }

            currentIndex++;
        }
    }

    private void viderFormulaire() {
        // vider tous les JTF (saisi du formulaire)
        this.jtf_id_utilisateur.setText("");
        this.jtf_nom_utilisateur.setText("");
        this.jtf_prenom_utilisateur.setText("");
        this.jtf_pseudo_utilisateur.setText("");
        this.jpf_mdp_utilisateur.setText("");
        this.jpf_mdp_confirmation_utilisateur.setText("");
        this.jtf_cell_utilisateur.setText("");
        this.jtf_mail_utilisateur.setText("");
        // mets la première valeur de la JCB
        this.jcb_type_utilisateur.setSelectedIndex(0);
        // supprime la valeur de l'employé selectionner
        this.employeSelectionne = null;
    }

    // méthode pour mettre à jour les données de l'employé selectionné
    private void mettreAJourEmploye() {
        // vérifier qu'un employé est bien sélectionné
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
            return;
        }
        // récupérer les valeurs modifiées du formulaire
        String nom = this.jtf_nom_utilisateur.getText().toUpperCase().trim();
        String prenom = this.jtf_prenom_utilisateur.getText().toUpperCase().trim();
        String tel = this.jtf_cell_utilisateur.getText().trim();
        String mail = this.jtf_mail_utilisateur.getText().trim();
        TypeEmploye typeEmploye = (TypeEmploye) this.jcb_type_utilisateur.getSelectedItem();
        // valider les champs, pour éviter qu'ils soit vides
        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty() || mail.isEmpty()) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Veuillez remplir tous les champs.", RED, true);
            return;
        }

        // verification si tel possède uniquement des chiffres
        if(!(tel.matches("\\d+"))){
            new VueMessage(null, new Dimension(320, 80), "Erreur", "Le tel doit posséder uniquement des nombres de 0 à 9", RED, true);
            return;
        }

        // création d'un nouvel Objet employé, avec les valeurs des champs
        Employe nouvelEmploye = new Employe(
                this.employeSelectionne.getNumero_securite_social_utilisateur(),
                nom, prenom, this.employeSelectionne.getPseudo_utilisateur(), this.employeSelectionne.getMdp_utilisateur(), tel, mail,
                typeEmploye.getId_type_employe()
        );
        // appel au contrôleur pour mettre à jour l'employé
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
            new VueMessage(null, new Dimension(700, 80), "Erreur",
                    resultat.getMessage(), RED, true);
        }
    }
    // methode pour supprimer un employe
    private void supprimerEmploye()
    {

        // Vérifier qu'un employé est bien sélectionné
        if (this.employeSelectionne == null) {
            new VueMessage(null, new Dimension(320, 80), "Erreur",
                    "Aucun employé sélectionné", RED, true);
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