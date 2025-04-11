import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprunt {
    private int id_emprunt;
    private int id_client;
    private int id_Livre;
    private LocalDate date_emprunt;
    private LocalDate date_retour;

    public Emprunt() {
        this(0, 0, 0, LocalDate.now(), LocalDate.now().plusWeeks(2));
    }

    public Emprunt(int id_emprunt, int id_client, int id_Livre,
                   LocalDate date_emprunt, LocalDate date_retour) {
        this.id_emprunt = id_emprunt;
        this.id_client = id_client;
        this.id_Livre = id_Livre;
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
    }

    // Getters and setters
    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_Livre() {
        return id_Livre;
    }

    public void setId_Livre(int id_Livre) {
        this.id_Livre = id_Livre;
    }

    public LocalDate getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(LocalDate date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public LocalDate getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(LocalDate date_retour) {
        if (date_retour.isBefore(date_emprunt)) {
            throw new IllegalArgumentException("Return date must be after borrow date");
        }
        this.date_retour = date_retour;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(date_retour);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Emprunt [ID: %d, Client: %d, Livre: %d, Emprunté le: %s, Retour le: %s%s]",
                id_emprunt, id_client, id_Livre,
                date_emprunt.format(formatter),
                date_retour.format(formatter),
                isOverdue() ? " (EN RETARD)" : "");
    }
}
