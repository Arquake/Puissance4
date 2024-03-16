package Modele.Exception;

public class invalidColumException extends Exception {
    public invalidColumException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Erreur : Entier numéro de colonne incorrect (hors 1-7)";
    }
}
