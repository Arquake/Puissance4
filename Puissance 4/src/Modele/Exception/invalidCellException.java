package Modele.Exception;

public class invalidCellException extends Exception{
    public invalidCellException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Erreur : Entier numéro de colonne incorrect (hors 1-7)";
    }
}
