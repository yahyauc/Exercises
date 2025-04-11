
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpruntService implements IDao<Emprunt> {
    private List<Emprunt> emprunts = new ArrayList<>();
    private static final int MAX_EMPRUNTS_PER_CLIENT = 3;

    @Override
    public boolean create(Emprunt e) {
        if (findById(e.getId_emprunt()) != null) {
            return false; // Emprunt with this ID already exists
        }

        // Check if client has too many emprunts
        if (countEmpruntsByClient(e.getId_client()) >= MAX_EMPRUNTS_PER_CLIENT) {
            System.out.println("Client a atteint la limite d'emprunts");
            return false;
        }

        // Check if book is already borrowed
        if (isLivreEmprunte(e.getId_Livre())) {
            System.out.println("Livre déjà emprunté");
            return false;
        }

        return emprunts.add(e);
    }

    @Override
    public boolean delete(Emprunt e) {
        return emprunts.remove(e);
    }

    @Override
    public Emprunt findById(int id) {
        return emprunts.stream()
                .filter(e -> e.getId_emprunt() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Emprunt> findAll() {
        return new ArrayList<>(emprunts);
    }

    // Additional helper methods
    public boolean isLivreEmprunte(int livreId) {
        return emprunts.stream()
                .anyMatch(e -> e.getId_Livre() == livreId);
    }

    public int countEmpruntsByClient(int clientId) {
        return (int) emprunts.stream()
                .filter(e -> e.getId_client() == clientId)
                .count();
    }

    public List<Emprunt> findOverdueEmprunts() {
        return emprunts.stream()
                .filter(Emprunt::isOverdue)
                .collect(Collectors.toList());
    }
}
