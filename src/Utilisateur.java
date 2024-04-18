import java.util.ArrayList;

public class Utilisateur {
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private ArrayList<Livre> livresRetournes;

    public Utilisateur(String nom, int numeroIdentification) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
        this.livresRetournes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void emprunterLivre(Livre livre) {
        if (livresEmpruntes.size() < 2) {
            livresEmpruntes.add(livre);
            System.out.println("Livre emprunté par " + nom + " : " + livre.getTitre());
        } else {
            System.out.println("Emprunt impossible pour " + nom + ", vous avez déjà emprunté 2 livres.");
        }
    }

    public void retournerLivre(Livre livre) {
        if (livresEmpruntes.contains(livre)) {
            livresEmpruntes.remove(livre);
            livresRetournes.add(livre);
            System.out.println("Livre retourné avec succès par " + nom + " : " + livre.getTitre());
        } else {
            System.out.println("Le livre n'a pas été emprunté par " + nom + ".");
        }
    }

    public void afficherLivresEmpruntes() {
        System.out.println("Livres empruntés par " + nom + ":");
        for (Livre livre : livresEmpruntes) {
            System.out.println(livre);
        }
    }

    public void afficherLivresRetournes() {
        System.out.println("Livres retournés par " + nom + ":");
        for (Livre livre : livresRetournes) {
            System.out.println(livre);
        }
    }
}
