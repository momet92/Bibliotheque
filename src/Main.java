import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();
        Utilisateur utilisateur = null;

        bibliotheque.ajouterLivre(new Livre("Harry Potter", "J.K. Rowling", 1997, "9780545010221"));
        bibliotheque.ajouterLivre(new Livre("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "978-2-07-061281-6"));
        bibliotheque.ajouterLivre(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "9782070368228"));
        bibliotheque.ajouterLivre(new Livre("1984", "George Orwell", 1949, "978-2070368228"));
        bibliotheque.ajouterLivre(new Livre("To Kill a Mockingbird", "Harper Lee", 1960, "978-0061120084"));
        bibliotheque.ajouterLivre(new Livre("Pride and Prejudice", "Jane Austen", 1813, "978-1613823730"));
        bibliotheque.ajouterLivre(new Livre("The Catcher in the Rye", "J.D. Salinger", 1951, "978-0316769488"));

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Rechercher un livre");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre");
            System.out.println("4. Ajouter un nouveau livre");
            System.out.println("5. Modifier un livre");
            System.out.println("6. Supprimer un livre");
            System.out.println("7. Afficher les livres dans la bibliothèque");
            System.out.println("8. Afficher les livres empruntés par un utilisateur");
            System.out.println("9. Afficher les livres retournés à la bibliothèque");
            System.out.println("10. Enregistrer un nouvel utilisateur");
            System.out.println("11. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre : ");
                    String critere = scanner.nextLine();
                    Livre livreTrouve = bibliotheque.rechercherLivre(critere);
                    if (livreTrouve != null) {
                        System.out.println("Livre trouvé : " + livreTrouve);
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 2:
                    if (bibliotheque.verifierEligibilite(utilisateur)) {
                        System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre que vous souhaitez emprunter : ");
                        String critereEmprunt = scanner.nextLine();
                        Livre livreEmprunt = bibliotheque.rechercherLivre(critereEmprunt);
                        if (livreEmprunt != null) {
                            bibliotheque.emprunterLivre(utilisateur, livreEmprunt);
                        } else {
                            System.out.println("Livre non trouvé.");
                        }
                    } else {
                        System.out.println("Vous n'êtes pas éligible à emprunter des livres pour le moment.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre que vous souhaitez retourner : ");
                    String critereRetour = scanner.nextLine();
                    Livre livreRetour = bibliotheque.rechercherLivre(critereRetour);
                    if (livreRetour != null) {
                        bibliotheque.retournerLivre(utilisateur, livreRetour);
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez le titre du nouveau livre : ");
                    String titreNouveauLivre = scanner.nextLine();
                    System.out.print("Entrez l'auteur du nouveau livre : ");
                    String auteurNouveauLivre = scanner.nextLine();
                    System.out.print("Entrez l'année de publication du nouveau livre : ");
                    int anneePublicationNouveauLivre = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le numéro ISBN du nouveau livre : ");
                    String isbnNouveauLivre = scanner.nextLine();

                    bibliotheque.ajouterLivre(new Livre(titreNouveauLivre, auteurNouveauLivre, anneePublicationNouveauLivre, isbnNouveauLivre));
                    System.out.println("Nouveau livre ajouté avec succès.");
                    break;
                case 5:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre que vous souhaitez modifier : ");
                    String critereModification = scanner.nextLine();
                    Livre livreAModifier = bibliotheque.rechercherLivre(critereModification);
                    if (livreAModifier != null) {
                        System.out.println("Détails du livre à modifier :");
                        System.out.println(livreAModifier);
                        System.out.println("Entrez les nouveaux détails du livre :");
                        System.out.print("Nouveau titre : ");
                        String nouveauTitre = scanner.nextLine();
                        System.out.print("Nouvel auteur : ");
                        String nouvelAuteur = scanner.nextLine();
                        System.out.print("Nouvelle année de publication : ");
                        int nouvelleAnneePublication = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nouveau numéro ISBN : ");
                        String nouveauISBN = scanner.nextLine();
                        bibliotheque.modifierLivre(livreAModifier, nouveauTitre, nouvelAuteur, nouvelleAnneePublication, nouveauISBN);
                        System.out.println("Livre modifié avec succès.");
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 6:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre que vous souhaitez supprimer : ");
                    String critereSuppression = scanner.nextLine();
                    Livre livreASupprimer = bibliotheque.rechercherLivre(critereSuppression);
                    if (livreASupprimer != null) {
                        bibliotheque.supprimerLivre(livreASupprimer);
                        System.out.println("Livre supprimé avec succès.");
                    } else {
                        System.out.println("Livre non trouvé.");
                    }
                    break;
                case 7:
                    bibliotheque.afficherLivres();
                    break;
                case 8:
                    if (utilisateur != null) {
                        bibliotheque.afficherLivresEmpruntes(utilisateur);
                    } else {
                        System.out.println("Aucun utilisateur n'est actuellement connecté.");
                    }
                    break;
                case 9:
                    bibliotheque.afficherLivresRetournes();
                    break;
                case 10:
                    System.out.print("Entrez le nom du nouvel utilisateur : ");
                    String nomNouvelUtilisateur = scanner.nextLine();
                    System.out.print("Entrez le numéro d'identification du nouvel utilisateur : ");
                    int idNouvelUtilisateur = scanner.nextInt();
                    scanner.nextLine();
                    utilisateur = new Utilisateur(nomNouvelUtilisateur, idNouvelUtilisateur);
                    System.out.println("Nouvel utilisateur enregistré avec succès.");
                    break;
                case 11:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }

        System.out.println("Merci d'avoir utilisé le gestionnaire de bibliothèque.");
        scanner.close();
    }
}
