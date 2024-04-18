import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;
    private ArrayList<Livre> livresRetournes;

    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
        this.livresRetournes = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        listeLivres.remove(livre);
    }

    public Livre rechercherLivre(String critere) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().toLowerCase().contains(critere.toLowerCase()) ||
                    livre.getAuteur().toLowerCase().contains(critere.toLowerCase()) ||
                    livre.getISBN().toLowerCase().contains(critere.toLowerCase())) {
                return livre;
            }
        }
        return null;
    }

    public void modifierLivre(Livre livre, String nouveauTitre, String nouvelAuteur, int nouvelleAnneePublication, String nouveauISBN) {
        livre.setTitre(nouveauTitre);
        livre.setAuteur(nouvelAuteur);
        livre.setAnneePublication(nouvelleAnneePublication);
        livre.setISBN(nouveauISBN);
    }

    public void afficherLivres() {
        System.out.println("Livres dans la bibliothèque :");
        for (Livre livre : listeLivres) {
            System.out.println(livre);
        }
    }

    public void emprunterLivre(Utilisateur utilisateur, Livre livre) {
        if (!empruntsUtilisateurs.containsKey(utilisateur) || empruntsUtilisateurs.get(utilisateur).size() < 2) {
            if (!empruntsUtilisateurs.containsKey(utilisateur)) {
                empruntsUtilisateurs.put(utilisateur, new ArrayList<>());
            }
            empruntsUtilisateurs.get(utilisateur).add(livre);
            System.out.println("Livre emprunté par " + utilisateur.getNom() + " : " + livre.getTitre());
        } else {
            System.out.println("Emprunt impossible pour " + utilisateur.getNom() + ", vous avez déjà emprunté 2 livres.");
        }
    }

    public void retournerLivre(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.get(utilisateur).remove(livre);
            livresRetournes.add(livre);
            utilisateur.retournerLivre(livre); // Ajout de cette ligne pour gérer le retour du livre par l'utilisateur
            System.out.println("Livre retourné par " + utilisateur.getNom() + " : " + livre.getTitre());
        }
    }

    public boolean verifierEligibilite(Utilisateur utilisateur) {
        return true; // Placeholder, à remplacer par la logique réelle
    }

    public void afficherStatistiques() {
        // Implémentez ici l'affichage des statistiques
    }

    public void afficherLivresRetournes() {
        System.out.println("Tous les livres retournés :");
        for (Livre livre : livresRetournes) {
            System.out.println(livre);
        }
    }

    public void afficherLivresEmpruntes(Utilisateur utilisateur) {
        if (empruntsUtilisateurs.containsKey(utilisateur)) {
            ArrayList<Livre> livresEmpruntes = empruntsUtilisateurs.get(utilisateur);
            System.out.println("Livres empruntés par " + utilisateur.getNom() + ":");
            for (Livre livre : livresEmpruntes) {
                System.out.println(livre.getTitre());
            }
        } else {
            System.out.println("Aucun livre emprunté par " + utilisateur.getNom());
        }
    }
}
