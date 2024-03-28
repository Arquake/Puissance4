package Modele.Exception;

public class invalidColumException extends Exception {
    /**
     * Generate an Exception if the column entered is invalid
     */
    public invalidColumException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Erreur : Entier numéro de colonne incorrect (hors 1-7)";
    }
}
