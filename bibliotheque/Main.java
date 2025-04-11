import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        LivreService livreService = new LivreService();
        EmpruntService empruntService = new EmpruntService();

        // Add sample books
        livreService.create(new Livre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        livreService.create(new Livre(2, "1984", "George Orwell", 1949));
        livreService.create(new Livre(3, "L'Étranger", "Albert Camus", 1942));
        livreService.create(new Livre(4, "Madame Bovary", "Gustave Flaubert", 1856));

        // Test emprunts
        testEmpruntScenario(livreService, empruntService);

        // Display final states
        displayLibraryStatus(livreService, empruntService);
    }

    private static void testEmpruntScenario(LivreService livreService, EmpruntService empruntService) {
        // Client 101 borrows books
        createEmprunt(empruntService, 1, 101, 1, LocalDate.now().minusDays(5));
        createEmprunt(empruntService, 2, 101, 2, LocalDate.now().minusDays(3));

        // Try to borrow same book again (should fail)
        System.out.println("\nTentative de ré-emprunt du même livre:");
        createEmprunt(empruntService, 3, 102, 1, LocalDate.now());

        // Client 102 borrows a book
        createEmprunt(empruntService, 4, 102, 3, LocalDate.now().minusWeeks(3)); // This will be overdue

        // Try to exceed emprunt limit (should fail)
        System.out.println("\nTentative de dépassement de limite d'emprunt:");
        createEmprunt(empruntService, 5, 101, 4, LocalDate.now());
    }

    private static void createEmprunt(EmpruntService service, int idEmprunt, int idClient,
                                      int idLivre, LocalDate dateEmprunt) {
        Emprunt e = new Emprunt();
        e.setId_emprunt(idEmprunt);
        e.setId_client(idClient);
        e.setId_Livre(idLivre);
        e.setDate_emprunt(dateEmprunt);
        e.setDate_retour(dateEmprunt.plusWeeks(2)); // 2 weeks loan period

        if (service.create(e)) {
            System.out.println("Emprunt créé avec succès: " + e);
        } else {
            System.out.println("Échec de création d'emprunt");
        }
    }

    private static void displayLibraryStatus(LivreService livreService, EmpruntService empruntService) {
        System.out.println("\n=== ÉTAT DE LA BIBLIOTHÈQUE ===");

        // Display all books with availability status
        System.out.println("\nLivres:");
        livreService.findAll().forEach(livre -> {
            boolean available = !empruntService.isLivreEmprunte(livre.getId_livre());
            System.out.println(livre + " - " + (available ? "DISPONIBLE" : "EMPRUNTÉ"));
        });

        // Display current emprunts
        System.out.println("\nEmprunts en cours:");
        empruntService.findAll().forEach(System.out::println);

        // Display overdue emprunts
        System.out.println("\nEmprunts en retard:");
        empruntService.findOverdueEmprunts().forEach(System.out::println);
    }
}
