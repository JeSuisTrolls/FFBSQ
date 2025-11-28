package Model.Classes.Metiers;

import java.sql.Date;

public class Competition {
    private String id_competition;
    private String libelle_competition;
    private String categorie;
    private String discipline;
    private String club;
    private String centre_bowling;
    private Float tarif;
    private String date_competition;

    public Competition() {
        this.id_competition = "";
        this.libelle_competition = "";
        this.categorie = "";
        this.discipline = "";
        this.club = "";
        this.centre_bowling = "";
        this.tarif = 0.0F;
        this.date_competition = "";
    }

    public Competition(String id_competition, String libelle_competition, String categorie,
                       String discipline, String club, String centre_bowling, Float tarif, String date_competition) {
        this.id_competition = id_competition;
        this.libelle_competition = libelle_competition;
        this.categorie = categorie;
        this.discipline = discipline;
        this.club = club;
        this.centre_bowling = centre_bowling;
        this.tarif = tarif;
        this.date_competition = date_competition;
    }

    public Competition(String libelle_competition, String discipline, String club, String categorie,
                       String centre_bowling, String date_competition) {
        this.id_competition = "";
        this.libelle_competition = libelle_competition;
        this.discipline = discipline;
        this.club = club;
        this.categorie = categorie;
        this.centre_bowling = centre_bowling;
        this.tarif = 0.0F;
        this.date_competition = date_competition;
    }

    public String getId_competition() {
        return id_competition;
    }

    public void setId_competition(String id_competition) {
        this.id_competition = id_competition;
    }

    public String getLibelle_competition() {
        return libelle_competition;
    }

    public void setLibelle_competition(String libelle_competition) {
        this.libelle_competition = libelle_competition;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCentre_bowling() {
        return centre_bowling;
    }

    public void setCentre_bowling(String centre_bowling) {
        this.centre_bowling = centre_bowling;
    }

    public Float getTarif() {
        return tarif;
    }

    public void setTarif(Float tarif) {
        this.tarif = tarif;
    }

    public String getDate_competition() {
        return date_competition;
    }

    public void setDate_competition(String date_competition) {
        this.date_competition = date_competition;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id_competition='" + id_competition + '\'' +
                ", libelle_competition='" + libelle_competition + '\'' +
                ", categorie=" + categorie +
                ", discipline=" + discipline +
                ", club=" + club +
                ", centre_bowling=" + centre_bowling +
                ", tarif=" + tarif +
                ", date_competition=" + date_competition +
                '}';
    }
}