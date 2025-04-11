import java.util.ArrayList;
import java.util.List;

public class LivreService implements IDao<Livre> {
    private List<Livre> livres = new ArrayList<>();

    @Override
    public boolean create(Livre l) {
        if (findById(l.getId_livre()) != null) {
            return false; // Book with this ID already exists
        }
        return livres.add(l);
    }

    @Override
    public boolean delete(Livre l) {
        return livres.remove(l);
    }

    @Override
    public Livre findById(int id) {
        return livres.stream()
                .filter(l -> l.getId_livre() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Livre> findAll() {
        return new ArrayList<>(livres); // Return a copy to protect internal list
    }

    // Additional helper method
    public boolean isLivreAvailable(int livreId) {
        return findById(livreId) != null;
    }
}
